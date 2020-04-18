package com.litchi.pocketcommunity.service.impl;

import com.litchi.pocketcommunity.bean.WorkOrder;
import com.litchi.pocketcommunity.bean.WorkOrderExample;
import com.litchi.pocketcommunity.bean.WorkOrderItem;
import com.litchi.pocketcommunity.bean.WorkOrderItemExample;
import com.litchi.pocketcommunity.dao.WorkOrderItemMapper;
import com.litchi.pocketcommunity.dao.WorkOrderMapper;
import com.litchi.pocketcommunity.service.IWorkOrderService;
import com.litchi.pocketcommunity.util.ErrorMessage;
import com.litchi.pocketcommunity.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: WorkOrderService
 * @Description: TODO
 * @author: litchi
 */
@Service
public class WorkOrderService implements IWorkOrderService {

    @Autowired
    private WorkOrderMapper workOrderMapper;
    @Autowired
    private WorkOrderItemMapper workOrderItemMapper;

    /**
    * @description: get work orders by user id
    * TODO
    * @param: userId
    * @return: ResultMessage
    * @author: litchi
    */
    @Override
    public ResultMessage getWorkOrders(Integer userId) {
        WorkOrderExample workOrderExample = new WorkOrderExample();
        WorkOrderExample.Criteria criteria = workOrderExample.createCriteria();
        criteria.andProposerIdEqualTo(userId);
        List<WorkOrder> workOrders = workOrderMapper.selectByExample(workOrderExample);
        return checkEmpty(workOrders);
    }

    /**
    * @description: get work orders in certain state by user id
    * TODO
    * @param: userId, state
    * @return: ResultMessage
    * @author: litchi
    */
    @Override
    public ResultMessage getWorkOrdersByState(Integer userId, Integer state) {
        WorkOrderExample workOrderExample = new WorkOrderExample();
        WorkOrderExample.Criteria criteria = workOrderExample.createCriteria();
        criteria.andProposerIdEqualTo(userId).andStateEqualTo(state);
        List<WorkOrder> workOrders = workOrderMapper.selectByExample(workOrderExample);
        return checkEmpty(workOrders);
    }

    /**
    * @description: get detail of work order by work order id 
    * TODO 
    * @param: workOrderId
    * @return: ResultMessage
    * @author: litchi
    */
    @Override
    public ResultMessage getWorkOrderDetail(Integer workOrderId) {
        WorkOrderItemExample workOrderItemExample = new WorkOrderItemExample();
        workOrderItemExample.createCriteria().andWorkOrderIdEqualTo(workOrderId);
        List<WorkOrderItem> workOrderItems = workOrderItemMapper.selectByExample(workOrderItemExample);
        return checkEmpty(workOrderItems);
    }

    /**
    * @description: add a work order
    * TODO
    * @param: workOrder
    * @return: ResultMessage
    * @author: litchi
    */
    @Override
    public ResultMessage addWorkOrder(WorkOrder workOrder) {
        workOrderMapper.insert(workOrder);
        return ResultMessage.getInstance().result(ResultMessage.SUCCESS_RESULT);
    }

    /**
    * @description: transfer the work order to a certain processor: change the work order state and add a work order detail record
    * TODO 
    * @param: workOrderItem
    * @return: ResultMessage
    * @author: litchi
    */
    @Override
    public ResultMessage transferWorkOrder(WorkOrderItem workOrderItem) {
        Integer type = workOrderItem.getType();
        int state;
        switch (type){
            case WorkOrderItem.TYPE_SUBMIT:
                state = WorkOrder.STATE_TO_BE_CONFIRMED;
                break;
            case WorkOrderItem.TYPE_FINISH:
                state = WorkOrder.STATE_FINISH;
                break;
            default:
                state = WorkOrder.STATE_PROCESSING;
                break;
        }
        changeWorkOrderState(workOrderItem.getWorkOrderId(), workOrderItem.getNextProcessorId(), state);
        addWorkOrderItem(workOrderItem);
        return ResultMessage.getInstance().result(ResultMessage.SUCCESS_RESULT);
    }

    /**
    * @description: add a work order detail record
    * TODO
    * @param: workOrderItem
    * @return:
    * @author: litchi
    */
    private void addWorkOrderItem(WorkOrderItem workOrderItem) {
        workOrderItemMapper.insert(workOrderItem);
    }

    /**
    * @description: change the work order state
    * TODO
    * @param: workOrderId, state
    * @return:
    * @author: litchi
    */
    private void changeWorkOrderState(Integer workOrderId, Integer nextProcessorId, Integer state){
        WorkOrderExample workOrderExample = new WorkOrderExample();
        workOrderExample.createCriteria().andIdEqualTo(workOrderId);
        WorkOrder workOrder = new WorkOrder();
        workOrder.setState(state);
        workOrder.setProposerId(nextProcessorId);
        workOrderMapper.updateByExampleSelective(workOrder, workOrderExample);
    }

    /**
    * @description: check whether the query result is empty
    * TODO 
    * @param: list
    * @return: ResultMessage
    * @author: litchi
    */
    private ResultMessage checkEmpty(List list){
        if (list.size() > 0) {
            return ResultMessage.getInstance().result(ResultMessage.SUCCESS_RESULT)
                    .putData("workOrderResult", list);
        } else {
            return ResultMessage.getInstance().result(ResultMessage.ERROR_RESULT)
                    .msg(ErrorMessage.WORK_ORDER_RESULT_IS_NULL);
        }

    }
}

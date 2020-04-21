package com.litchi.pocketcommunity.service.impl;

import com.litchi.pocketcommunity.bean.*;
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
    * @description: get work orders by user id and it is finished
    * TODO
    * @param: userId
    * @return: ResultMessage
    * @author: litchi
    */
    @Override
    public ResultMessage getDoneWorkOrders(Integer userId, String condition) {
        List<WorkOrder> doneList = getWorkOrdersByCondition(userId, condition, true);
        return checkEmpty(doneList, "doneList");
    }

    /**
    * @description:  get work orders by user id and it is not finished
    * TODO
    * @param: userId
    * @return: ResultMessage
    * @author: litchi
    */
    @Override
    public ResultMessage getNotDoneWorkOrders(Integer userId, String condition) {
        List<WorkOrder> notDoneList = getWorkOrdersByCondition(userId, condition, false);
        return checkEmpty(notDoneList, "notDoneList");
    }

    @Override
    public int getProposerId(Integer workOrderId) {
        WorkOrderKey workOrderKey = new WorkOrderKey();
        workOrderKey.setId(workOrderId);
        WorkOrder workOrder = workOrderMapper.selectByPrimaryKey(workOrderKey);
        return workOrder.getProposerId();
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
        return checkEmpty(workOrders, "workOrders");
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
        List<WorkOrderItem> workOrderItems = workOrderItemMapper.selectByExampleWithName(workOrderItemExample);
        return checkEmpty(workOrderItems, "workOrderItems");
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

    private List<WorkOrder> getWorkOrdersByCondition(Integer userId, String condition, boolean isDone) {
        condition = new StringBuilder().append("%").append(condition).append("%").toString();
        WorkOrderExample workOrderExample = new WorkOrderExample();
        WorkOrderExample.Criteria criteria1 = workOrderExample.createCriteria();
        WorkOrderExample.Criteria criteria2 = workOrderExample.createCriteria();
        WorkOrderExample.Criteria criteria3 = workOrderExample.createCriteria();
        WorkOrderExample.Criteria criteria4 = workOrderExample.createCriteria();
        criteria1.andProposerIdEqualTo(userId).andTitleLike(condition);
        criteria3.andProposerIdEqualTo(userId).andContentLike(condition);
        criteria2.andCurrentProcessorIdEqualTo(userId).andTitleLike(condition);
        criteria4.andCurrentProcessorIdEqualTo(userId).andContentLike(condition);
        if (isDone){
            criteria1.andStateEqualTo(WorkOrder.STATE_FINISH);
            criteria2.andStateEqualTo(WorkOrder.STATE_FINISH);
            criteria3.andStateEqualTo(WorkOrder.STATE_FINISH);
            criteria4.andStateEqualTo(WorkOrder.STATE_FINISH);
        }else{
            criteria1.andStateLessThan(WorkOrder.STATE_FINISH);
            criteria2.andStateLessThan(WorkOrder.STATE_FINISH);
            criteria3.andStateLessThan(WorkOrder.STATE_FINISH);
            criteria4.andStateLessThan(WorkOrder.STATE_FINISH);
        }
        workOrderExample.or(criteria2);
        workOrderExample.or(criteria3);
        workOrderExample.or(criteria4);
        List<WorkOrderExample.Criteria> oredCriteria = workOrderExample.getOredCriteria();
        workOrderExample.setDistinct(true);
        workOrderExample.setOrderByClause("state, id");
        return workOrderMapper.selectByExample(workOrderExample);
    }

    /**
    * @description: check whether the query result is null
    * TODO
    * @param: list, key
    * @return: ResultMessage
    * @author: litchi
    */
    private ResultMessage checkEmpty(List list, String key){
        if (list.size() > 0 ){
            return ResultMessage.getInstance().result(ResultMessage.SUCCESS_RESULT).putData(key, list);
        } else {
            return ResultMessage.getInstance().result(ResultMessage.ERROR_RESULT).msg(ErrorMessage.QUERY_RESULT_IS_EMPTY);
        }
    }
}

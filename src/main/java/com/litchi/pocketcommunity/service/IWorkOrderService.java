package com.litchi.pocketcommunity.service;

import com.litchi.pocketcommunity.bean.WorkOrder;
import com.litchi.pocketcommunity.bean.WorkOrderItem;
import com.litchi.pocketcommunity.util.ResultMessage;

public interface IWorkOrderService {

    ResultMessage getWorkOrdersByState(Integer userId, Integer state);

    ResultMessage getWorkOrderDetail(Integer workOrderId);

    ResultMessage addWorkOrder(WorkOrder workOrder);

    ResultMessage transferWorkOrder(WorkOrderItem workOrderItem);

    ResultMessage getDoneWorkOrders(Integer userId, String condition);

    ResultMessage getNotDoneWorkOrders(Integer userId, String condition);

    int getProposerId(Integer workOrderId);
}

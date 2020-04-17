package com.litchi.pocketcommunity.web.controller;

import com.litchi.pocketcommunity.bean.WorkOrder;
import com.litchi.pocketcommunity.bean.WorkOrderItem;
import com.litchi.pocketcommunity.service.IWorkOrderService;
import com.litchi.pocketcommunity.util.ResultMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: WorkOrderController
 * @Description: TODO
 * @author: litchi
 */
@RestController
public class WorkOrderController {

    @Autowired
    private IWorkOrderService workOrderService;

    @ApiOperation(value = "get work orders by user id")
    @GetMapping("/work-orders")
    public ResultMessage getWorkOrders(@RequestParam Integer currentUserId){
        return workOrderService.getWorkOrders(currentUserId);
    }

    @ApiOperation(value = "get work orders by user id")
    @GetMapping("/work-orders/{state:[0-2]]}")
    public ResultMessage getWorkOrdersByState(@RequestParam Integer currentUserId, @PathVariable Integer state){
        return workOrderService.getWorkOrdersByState(currentUserId, state);
    }

    @ApiOperation(value = "add a work order")
    @PostMapping("/work-order/add")
    public ResultMessage addWorkOrders(@RequestBody WorkOrder workOrder){
        return workOrderService.addWorkOrder(workOrder);
    }

    @ApiOperation(value = "transfer the work order to a certain processor")
    @GetMapping("/work-order/transfer")
    public ResultMessage transferWorkOrder(@RequestBody WorkOrderItem workOrderItem, @RequestParam Integer workOrderId){
        return workOrderService.transferWorkOrder(workOrderItem);
    }

    @ApiOperation(value = "get work order details")
    @GetMapping("/work-order")
    public ResultMessage getWorkOrderDetail(@RequestParam Integer workOrderId){
        return workOrderService.getWorkOrderDetail(workOrderId);
    }
}

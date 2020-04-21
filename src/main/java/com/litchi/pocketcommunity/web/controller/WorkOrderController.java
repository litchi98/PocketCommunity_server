package com.litchi.pocketcommunity.web.controller;

import com.litchi.pocketcommunity.bean.User;
import com.litchi.pocketcommunity.bean.WorkOrder;
import com.litchi.pocketcommunity.bean.WorkOrderItem;
import com.litchi.pocketcommunity.service.IAccountService;
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
    @Autowired
    private IAccountService accountService;

    @ApiOperation(value = "get work orders")
    @GetMapping("/work-orders/done")
    public ResultMessage getDoneWorkOrders(@RequestAttribute Integer currentUserId, @RequestParam String condition){
        return workOrderService.getDoneWorkOrders(currentUserId, condition);
    }

    @ApiOperation(value = "get work orders")
    @GetMapping("/work-orders/undone")
    public ResultMessage getNotDoneWorkOrders(@RequestAttribute Integer currentUserId, @RequestParam String condition){
        return workOrderService.getNotDoneWorkOrders(currentUserId, condition);
    }

    @ApiOperation(value = "get work orders state")
    @GetMapping("/work-orders/{state:[0-3]]}")
    public ResultMessage getWorkOrdersByState(@RequestAttribute Integer currentUserId, @PathVariable Integer state){
        return workOrderService.getWorkOrdersByState(currentUserId, state);
    }

    @ApiOperation(value = "add a work order")
    @PostMapping("/work-order")
    public ResultMessage addWorkOrders(@RequestBody WorkOrder workOrder){
        return workOrderService.addWorkOrder(workOrder);
    }

    @ApiOperation(value = "transfer the work order to a certain processor")
    @GetMapping("/work-order/transfer")
    public ResultMessage transferWorkOrder(@RequestBody WorkOrderItem workOrderItem, @RequestParam Integer workOrderId){
        return workOrderService.transferWorkOrder(workOrderItem);
    }

    @ApiOperation(value = "get work order details")
    @GetMapping("/work-order/detail")
    public ResultMessage getWorkOrderDetail(@RequestParam Integer workOrderId){
        int id = workOrderService.getProposerId(workOrderId);
        User user = accountService.getNameAndAvatarId(id);

        return workOrderService.getWorkOrderDetail(workOrderId).putData("name", user.getName()).putData("avatarId", user.getAvatarImageId());
    }
}

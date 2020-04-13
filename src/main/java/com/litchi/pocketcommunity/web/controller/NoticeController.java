package com.litchi.pocketcommunity.web.controller;

import com.litchi.pocketcommunity.bean.Notice;
import com.litchi.pocketcommunity.service.INoticeService;
import com.litchi.pocketcommunity.util.ResultMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: NoticeController
 * @Description: TODO
 * @author: litchi
 */
@RestController
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    @ApiOperation(value = "get recent notices")
    @GetMapping("/notices")
    public ResultMessage getNotices(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize){
        ResultMessage resultMessage = noticeService.getNotices(pageNum, pageSize);
        return resultMessage;
    }

    @ApiOperation(value = "push a notice")
    @PostMapping("/notice")
    public ResultMessage addNotice(@RequestBody Notice notice){
        ResultMessage resultMessage = noticeService.addNotice(notice);
        return resultMessage;
    }

}

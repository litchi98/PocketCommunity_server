package com.litchi.pocketcommunity.web.controller;

import com.litchi.pocketcommunity.service.IToolService;
import com.litchi.pocketcommunity.util.ErrorMessage;
import com.litchi.pocketcommunity.util.ResultMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: ToolController
 * @Description: TODO
 * @author: litchi
 */
@RestController
public class ToolController {

    @Autowired
    private IToolService toolService;

    @ApiOperation(value = "upload a image file")
    @PutMapping("/uploadImage/{type}")
    public ResultMessage uploadImage(@PathVariable Integer type, MultipartFile uploadFile){
        String fileName = uploadFile.getOriginalFilename().toLowerCase();
        if (!fileName.endsWith(".bmp") && !fileName.endsWith(".jpg")
                && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png")) {
            return ResultMessage.getInstance().result(ResultMessage.ERROR_RESULT).msg(ErrorMessage.UPLOAD_FILE_FORMAT_NOT_SUPPORT);
        }
        return toolService.uploadImage(type, uploadFile);
    }

    @ApiOperation(value = "get a picture of the day")
    @GetMapping("/dailyImage")
    public ResultMessage dailyImage(){
        ResultMessage resultMessage = toolService.dailyImage();
        return resultMessage;
    }
}

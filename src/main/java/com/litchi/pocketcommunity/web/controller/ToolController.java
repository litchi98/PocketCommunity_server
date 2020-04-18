package com.litchi.pocketcommunity.web.controller;

import com.litchi.pocketcommunity.service.IToolService;
import com.litchi.pocketcommunity.util.ErrorMessage;
import com.litchi.pocketcommunity.util.ResultMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @ClassName: ToolController
 * @Description: TODO
 * @author: litchi
 */
@Controller
public class ToolController {

    @Autowired
    private IToolService toolService;

    @ApiOperation(value = "upload a image file")
    @PostMapping("/image")
    @ResponseBody
    public ResultMessage uploadImage(@RequestParam Integer type, MultipartFile uploadFile){
        String fileName = uploadFile.getOriginalFilename().toLowerCase();
        if (!fileName.endsWith(".bmp") && !fileName.endsWith(".jpg")
                && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png")) {
            return ResultMessage.getInstance().result(ResultMessage.ERROR_RESULT).msg(ErrorMessage.UPLOAD_FILE_FORMAT_NOT_SUPPORT);
        }
        return toolService.uploadImage(type, uploadFile);
    }

    @ApiOperation(value = "get a picture of the day")
    @GetMapping("/dailyImage")
    @ResponseBody
    public ResultMessage dailyImage(){
        ResultMessage resultMessage = toolService.dailyImage();
        return resultMessage;
    }

    @ApiOperation(value="get image by id")
    @GetMapping("/image/{id}")
    public String getImage(@PathVariable Integer id){
        File image = toolService.getImage(id);
        String url = new StringBuilder().append("forward:../").append(image.getParentFile().getName())
                .append("/").append(image.getName()).toString();
        return url;
    }
}

package com.litchi.pocketcommunity.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.litchi.pocketcommunity.bean.ImageFile;
import com.litchi.pocketcommunity.bean.ImageFileKey;
import com.litchi.pocketcommunity.dao.ImageFileMapper;
import com.litchi.pocketcommunity.service.IToolService;
import com.litchi.pocketcommunity.util.ErrorMessage;
import com.litchi.pocketcommunity.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName: ToolService
 * @Description: TODO
 * @author: litchi
 */
@Service
public class ToolService implements IToolService {

    @Autowired
    private ImageFileMapper imageFileMapper;

    private String uploadDir = "src/main/resources/static/upload_file/";

    @Override
    public ResultMessage uploadImage(Integer type, MultipartFile uploadFile) {
        ResultMessage resultMessage = ResultMessage.getInstance();
        String originalFilename = uploadFile.getOriginalFilename();
        if (!originalFilename.endsWith(".jpg") && !originalFilename.endsWith(".png") &&
        !originalFilename.endsWith(".jpeg")){
            return resultMessage.result(ResultMessage.ERROR_RESULT).msg(ErrorMessage.UPLOAD_FILE_FORMAT_NOT_SUPPORT);
        }
        String uuid = UUID.randomUUID().toString().replace("-","");
        String format = originalFilename.substring(originalFilename.lastIndexOf("."));
        File parentDir = new File(uploadDir);
        if (!parentDir.exists()) {
            parentDir.mkdir();
        }
        StringBuilder stringBuilder = new StringBuilder().append(parentDir.getAbsolutePath()).append("/").append(uuid).append(format);
        File file = new File(stringBuilder.toString());
        if (!file.exists()){
            try {
                file.createNewFile();
                uploadFile.transferTo(file);
                ImageFile imageFile = new ImageFile();
                imageFile.setType(type);
                imageFile.setName(uuid+format);
                int id = imageFileMapper.insertSelective(imageFile);
                return resultMessage.result(ResultMessage.SUCCESS_RESULT).putData("id", imageFile.getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultMessage.result(ResultMessage.ERROR_RESULT).msg(ErrorMessage.UPLOAD_FILE_ERROR);
    }

    @Override
    public ResultMessage dailyImage() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> entity = restTemplate.getForEntity("https://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1", String.class);
        String entityBody = entity.getBody();
        JSONObject jsonObject = JSONObject.parseObject(entityBody);
        JSONObject images = jsonObject.getJSONArray("images").getJSONObject(0);
        Object url = images.get("url");
        StringBuilder dailyImageUrl = new StringBuilder().append("https://cn.bing.com").append(url.toString());
        return ResultMessage.getInstance().result(ResultMessage.SUCCESS_RESULT).putData("url", dailyImageUrl);
    }

    @Override
    public File getImage(Integer id) {
        ImageFileKey imageFileKey = new ImageFileKey();
        imageFileKey.setId(id);
        ImageFile imageFile = imageFileMapper.selectByPrimaryKey(imageFileKey);
        String fileName = imageFile.getName();
        File uploadDir = new File(this.uploadDir);
        File file = new File(uploadDir.getAbsolutePath()+"/"+fileName);
        if (file.exists()){
            return file;
        }
        return null;
    }
}

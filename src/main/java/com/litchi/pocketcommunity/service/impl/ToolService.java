package com.litchi.pocketcommunity.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.litchi.pocketcommunity.bean.ImageFileWithBLOBs;
import com.litchi.pocketcommunity.dao.ImageFileMapper;
import com.litchi.pocketcommunity.service.IToolService;
import com.litchi.pocketcommunity.util.ErrorMessage;
import com.litchi.pocketcommunity.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

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

    @Override
    public ResultMessage uploadImage(Integer type, MultipartFile uploadFile) {
        ResultMessage resultMessage = ResultMessage.getInstance();
        try {
            ImageFileWithBLOBs imageFileWithBLOBs = new ImageFileWithBLOBs();
            String uuid = UUID.randomUUID().toString();
            imageFileWithBLOBs.setType(type);
            imageFileWithBLOBs.setName(uuid.replace("-",""));
            imageFileWithBLOBs.setFile(uploadFile.getBytes());
            imageFileMapper.insertSelective(imageFileWithBLOBs);
            return resultMessage.result(ResultMessage.SUCCESS_RESULT).putData("uuid", uuid.replace("-",""));
        } catch (IOException e) {
            e.printStackTrace();
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
}

package com.litchi.pocketcommunity.service;

import com.litchi.pocketcommunity.util.ResultMessage;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: IToolService
 * @Description: TODO
 * @author: litchi
 */
public interface IToolService {
    ResultMessage uploadImage(Integer type, MultipartFile uploadFile);

    ResultMessage dailyImage();
}

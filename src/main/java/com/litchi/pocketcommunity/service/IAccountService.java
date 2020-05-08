package com.litchi.pocketcommunity.service;

import com.litchi.pocketcommunity.bean.User;
import com.litchi.pocketcommunity.util.ResultMessage;

public interface IAccountService {

    ResultMessage login(String telNumber, String password);

    ResultMessage certification(String telNumber, String identificationId);

    ResultMessage updateUser(Integer id, User user);

    ResultMessage getUser(Integer id);

    ResultMessage deleteUser(Integer id);

    ResultMessage addUser(User user);

    ResultMessage getAllUser();

    User getNameAndAvatarId(int id);

    ResultMessage getUserByOrderId(Integer roleId, Integer currentUserId);

    ResultMessage getUserByCondition(String condition);
}

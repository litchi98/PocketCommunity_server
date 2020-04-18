package com.litchi.pocketcommunity.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.litchi.pocketcommunity.bean.User;
import com.litchi.pocketcommunity.bean.UserExample;
import com.litchi.pocketcommunity.bean.Verify;
import com.litchi.pocketcommunity.bean.VerifyExample;
import com.litchi.pocketcommunity.dao.UserMapper;
import com.litchi.pocketcommunity.dao.VerifyMapper;
import com.litchi.pocketcommunity.service.IAccountService;
import com.litchi.pocketcommunity.util.ErrorMessage;
import com.litchi.pocketcommunity.util.JWTUtils;
import com.litchi.pocketcommunity.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private VerifyMapper verifyMapper;

    @Autowired
    private JWTUtils jwtUtils;

    @Override
    /**
    * @description: register
    * TODO
    * @param: [user]
    * @return: ResultMessage
    * @author: litchi
    */
    public ResultMessage register(User user) {
        ResultMessage resultMessage = ResultMessage.getInstance();
        Integer userId = isExist(user.getTelNumber());
        if (userId > 0) {
            return resultMessage.result(ResultMessage.ERROR_RESULT).msg(ErrorMessage.REGISTER_ACCOUNT_ALREADY_EXIST);
        }
        //新用户注册
        user.setAvatarImageId(11);
        userMapper.insert(user);
        Integer id = isExist(user.getTelNumber());
        Verify verify = new Verify(id, Verify.VERIFY_PROCESSING, "");
        verifyMapper.insert(verify);
        resultMessage.result(ResultMessage.SUCCESS_RESULT);
        return resultMessage;
    }

    @Override
    /**
    * @description: login
    * TODO
    * @param: [telNumber, password]
    * @return: ResultMessage
    * @author: litchi
    */
    public ResultMessage login(String telNumber, String password) {
        ResultMessage resultMessage = isAccountNormal(telNumber);
        if (!resultMessage.getResult().equals(ResultMessage.SUCCESS_RESULT)) {
            return resultMessage;
        }
        Integer userId = (Integer) resultMessage.getData("userId");
        User user = getUserById(userId);
        if (telNumber.equals(user.getTelNumber()) && password.equals(user.getPassword())) {
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("userId",userId);
            JSONObject jsonObject = jwtUtils.generateToken(claims);
            resultMessage.removeAllData();
            return resultMessage.result(ResultMessage.SUCCESS_RESULT).putData("roleId", user.getRoleId())
                    .putData("avatarId", user.getAvatarImageId()).putData("name", user.getName())
                    .putData("authorization", jsonObject);
        }
        return resultMessage.result(ResultMessage.ERROR_RESULT).msg(ErrorMessage.LOGIN_INCORRECT_ERROR);
    }

    @Override
    /**
    * @description: when forgot password, call this method to certification
    * TODO
    * @param: [telNumber, identificationId]
    * @return: ResultMessage
    * @author: litchi
    */
    public ResultMessage certification(String telNumber, String identificationId) {
        ResultMessage resultMessage = isAccountNormal(telNumber);
        if (resultMessage.getData("userId") == null) {
            return resultMessage;
        } else {
            User user = getUserById((Integer) resultMessage.getData("userId"));
            resultMessage.clear();
            if (telNumber.equals(user.getTelNumber()) && identificationId.equals(user.getIdentificationId())) {
                return resultMessage.result(ResultMessage.SUCCESS_RESULT).putData("userId", user.getId());
            }
            return resultMessage.result(ResultMessage.ERROR_RESULT).msg(ErrorMessage.CERTIFICATION_ACCOUNT_ERROR);
        }
    }

    @Override
    /**
    * @description: update user
    * TODO
    * @param: [id, user]
    * @return: ResultMessage
    * @author: litchi
    */
    public ResultMessage updateUser(Integer id, User user) {
        user.setId(id);
        userMapper.updateByPrimaryKeySelective(user);
        return ResultMessage.getInstance().result(ResultMessage.SUCCESS_RESULT);
    }

    @Override
    /**
    * @description: get user by id
    * TODO
    * @param: [id]
    * @return: ResultMessage
    * @author: litchi
    */
    public ResultMessage getUser(Integer id) {
        User user = getUserById(id);
        if (user != null) {
            return ResultMessage.getInstance().result(ResultMessage.SUCCESS_RESULT).putData("user", user);
        }
        return ResultMessage.getInstance().result(ResultMessage.ERROR_RESULT).msg(ErrorMessage.ACCOUNT_NOT_EXIST_ERROR);
    }

    @Override
    /**
    * @description: delete user by id
    * TODO
    * @param: [id]
    * @return: ResultMessage
    * @author: litchi
    */
    public ResultMessage deleteUser(Integer id) {
        int count = userMapper.deleteByPrimaryKey(id);
        if (count == 0) {
            return ResultMessage.getInstance().result(ResultMessage.ERROR_RESULT).msg(ErrorMessage.ACCOUNT_NOT_EXIST_ERROR);
        }
        return ResultMessage.getInstance().result(ResultMessage.SUCCESS_RESULT);
    }

    @Override
    /**
    * @description: insert to user
    * TODO
    * @param: [user]
    * @return: ResultMessage
    * @author: litchi
    */
    public ResultMessage addUser(User user) {
        Integer exist = isExist(user.getTelNumber());
        if (exist > 0) {
            return ResultMessage.getInstance().result(ResultMessage.ERROR_RESULT).msg(ErrorMessage.REGISTER_ACCOUNT_ALREADY_EXIST);
        }
        userMapper.insert(user);
        verifyMapper.insert(new Verify(user.getId(), Verify.VERIFY_COMPLETE, ""));
        return ResultMessage.getInstance().result(ResultMessage.SUCCESS_RESULT);
    }

    @Override
    /**
    * @description: get all user
    * TODO
    * @param: []
    * @return: ResultMessage
    * @author: litchi
    */
    public ResultMessage getAllUser() {
        List<User> users = userMapper.selectByExample(new UserExample());
        return ResultMessage.getInstance().result(ResultMessage.SUCCESS_RESULT).putData("users", users);
    }


    /**
    * @description: check whether the user status is normal, if account is normal then return a ResultMessage with userId
    * TODO 
    * @param: telNumber
    * @return: ResultMessage
    * @author: litchi
    */
    private ResultMessage isAccountNormal(String telNumber) {
        ResultMessage resultMessage = ResultMessage.getInstance();
        //判断账号是否存在
        Integer userId = isExist(telNumber);
        if (userId < 0) {
            return resultMessage.result(ResultMessage.ERROR_RESULT).result(ErrorMessage.ACCOUNT_NOT_EXIST_ERROR);
        }
        //检查是否有在途审核
        Verify processing = getVerifyState(userId);
        if ((resultMessage = isVerifyProcessing(userId)) != null) {
            return resultMessage;
        }
        //正常账号则返回该用户的Id和success的结果
        return ResultMessage.getInstance().result(ResultMessage.SUCCESS_RESULT).putData("userId", userId);
    }

    /**
    * @description: check whether the account is exist, if exist then return userId, else return -1
    * TODO
    * @param: telNumber
    * @return: Ineger
    * @author: litchi
    */
    private Integer isExist(String telNumber) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andTelNumberEqualTo(telNumber);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0) {
            return users.get(0).getId();
        }
        return -1;
    }

    /**
    * @description: check whether the account is already verify, if true then return null, else return msg
    * TODO 
    * @param: userID
    * @return: ResultMessage
    * @author: litchi
    */
    private ResultMessage isVerifyProcessing(Integer userId) {
        ResultMessage resultMessage = ResultMessage.getInstance();
        Verify verify = getVerifyState(userId);
        if (Verify.VERIFY_PROCESSING.equals(verify.getVerifyResult())) {
            return resultMessage.result(ResultMessage.ERROR_RESULT).msg(ErrorMessage.ACCOUNT_VERIFY_PROCESSING);
        } else if (Verify.VERIFY_REFUSAL.equals(verify.getVerifyResult())) {
            return resultMessage.result(ResultMessage.ERROR_RESULT).msg(ErrorMessage.LOGIN_VERIFY_REFUSAL).putData("reason", verify.getMsg());
        }
        return null;
    }

    /**
    * @description: get the verify state, if not exist return null
    * TODO
    * @param: userId
    * @return: Verify
    * @author: litchi
    */
    private Verify getVerifyState(Integer userId) {
        VerifyExample verifyExample = new VerifyExample();
        verifyExample.createCriteria()
                .andUserIdEqualTo(userId);
        List<Verify> verifies = verifyMapper.selectByExample(verifyExample);
        if (verifies.size() > 0) {
            return verifies.get(0);
        } else {
            return null;
        }
    }

    /**
    * @description: get user by id
    * TODO
    * @param: userId
    * @return: user
    * @author: litchi
    */
    private User getUserById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}

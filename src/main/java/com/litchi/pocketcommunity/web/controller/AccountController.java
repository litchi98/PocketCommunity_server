package com.litchi.pocketcommunity.web.controller;

import com.litchi.pocketcommunity.bean.User;
import com.litchi.pocketcommunity.service.IAccountService;
import com.litchi.pocketcommunity.util.ResultMessage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @ApiOperation(value = "user login")
    @PostMapping("/login")
    public ResultMessage login(@RequestParam String telNumber, @RequestParam String password){
        return accountService.login(telNumber, password);
    }

    @ApiOperation(value = "certification")
    @GetMapping("/certification")
    public ResultMessage certification(@RequestParam String telNumber, @RequestParam String identificationId){
        return accountService.certification(telNumber, identificationId);
    }

    @ApiOperation(value = "update user")
    @PutMapping("/{id:[0-9]*}")
    public ResultMessage updateUser(@PathVariable Integer id, @RequestBody User user){
        return accountService.updateUser(id, user);
    }


    @ApiOperation(value = "get user by id")
    @GetMapping("/{id:[0-9]*}")
    public ResultMessage getUser(@PathVariable Integer id, HttpServletRequest request){
        return accountService.getUser(id);
    }


    @ApiOperation(value = "delete user by id")
    @DeleteMapping("/{id:[0-9]*}")
    public ResultMessage deleteUser(@PathVariable Integer id){
        return accountService.deleteUser(id);
    }


    @ApiOperation(value = "add a user")
    @PostMapping("/add")
    public ResultMessage addUser(@RequestBody User user){
        return accountService.addUser(user);
    }

    @ApiOperation(value = "get users by order id")
    @GetMapping("/users/{roleId:[1-2]}")
    public ResultMessage getUserByOrderId(@PathVariable Integer roleId, @RequestAttribute Integer currentUserId){
        return accountService.getUserByOrderId(roleId, currentUserId);
    }

    @ApiOperation(value = "get users by condition")
    @ApiImplicitParam(value = "condition", required = false)
    @GetMapping(value = "/users")
    public ResultMessage getUserByCondition(@RequestParam(required = false) String condition){
        if (condition == null){
            return accountService.getAllUser();
        }
        return accountService.getUserByCondition(condition);
    }

}

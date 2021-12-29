package com.dailu.methodenhance.controller;

import com.dailu.methodenhance.annotation.ValidAuth;
import com.dailu.methodenhance.entity.BankEntity;
import com.dailu.methodenhance.entity.UserEntity;
import com.dailu.methodenhance.service.BankService;
import com.dailu.methodenhance.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    UserService userService;
    @Resource
    BankService bankService;

    @ValidAuth(hasRole = 5)
    @GetMapping("/getUser")
    public UserEntity getUser(String id) {
        return userService.getUser(id);
    }


    @GetMapping("/getBank")
    public BankEntity getBank(String id) {
        return bankService.getBank(id);
    }

}

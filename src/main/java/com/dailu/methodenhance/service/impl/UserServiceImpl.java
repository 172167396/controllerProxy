package com.dailu.methodenhance.service.impl;

import com.dailu.methodenhance.entity.UserEntity;
import com.dailu.methodenhance.service.BankService;
import com.dailu.methodenhance.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    BankService bankService;

    @Override
    public UserEntity getUser(String id) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setName("派大星");
        userEntity.setBank(bankService.getBank(id));
        return userEntity;
    }
}

package com.dailu.methodenhance.controller;

import com.dailu.methodenhance.annotation.ValidAuth;
import com.dailu.methodenhance.config.ApplicationContextHolder;
import com.dailu.methodenhance.config.BeanFactoryHelper;
import com.dailu.methodenhance.entity.BankEntity;
import com.dailu.methodenhance.entity.UserEntity;
import com.dailu.methodenhance.proxy.UserServiceProxy;
import com.dailu.methodenhance.service.BankService;
import com.dailu.methodenhance.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

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

    @GetMapping("/registryBean")
    public String registryBean(String id) {
        BankEntity bank = new BankEntity("徽商银行", "蜀山区108号", new BigDecimal(Integer.MAX_VALUE));
        BeanFactoryHelper.registryBean(id, bank);
        return "success";
    }

    @GetMapping("/getBean")
    public BankEntity getBean(String id) {
        return ApplicationContextHolder.getBean(id,BankEntity.class);
    }


    @GetMapping("/testProxy")
    public UserEntity testProxy(String id){
        UserService proxy = (UserService)new UserServiceProxy().getProxy(userService);
        return proxy.getUser(id);
    }
}

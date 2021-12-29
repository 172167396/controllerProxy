package com.dailu.methodenhance.service.impl;

import com.dailu.methodenhance.entity.BankEntity;
import com.dailu.methodenhance.service.BankService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankServiceImpl implements BankService {

    @Override
    public BankEntity getBank(String userId) {
        BankEntity bankEntity = new BankEntity();
        bankEntity.setBalance(new BigDecimal(1880000));
        bankEntity.setName("汇丰银行");
        bankEntity.setLocation("合肥蜀山区");
        return bankEntity;
    }
}

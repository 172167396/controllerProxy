package com.dailu.methodenhance.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BankEntity {
    private String name;
    private String location;
    private BigDecimal balance;
}

package com.dailu.methodenhance.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {
    private String id;
    private String name;
    private BankEntity bank;
}

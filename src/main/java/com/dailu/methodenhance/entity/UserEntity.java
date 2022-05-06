package com.dailu.methodenhance.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserEntity {
    private String id;
    private String name;
    private BankEntity bank;
}

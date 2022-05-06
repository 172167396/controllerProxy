package com.dailu.methodenhance.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BankEntity {
    private String name;
    private String location;
    private BigDecimal balance;
}

package com.present.streams.model;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
public class Account {

    @Getter
    @Setter
    private String bankType;

    @Getter
    @Setter
    private int accountNo;

    @Getter
    @Setter
    private double accountBalance;

    @Getter
    @Setter
    private String accountName;



}

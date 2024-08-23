package com.example.testing.model;

import lombok.*;

import java.time.LocalDate;

@Builder
@EqualsAndHashCode
@ToString
public class Transaction {

    @Getter
    @Setter
    private LocalDate transactionDate;

    @Getter
    @Setter
    private String vendor;

    @Getter
    @Setter
    private String transactionType;

    @Getter
    @Setter
    private double amt;

    @Getter
    @Setter
    private String category;

}

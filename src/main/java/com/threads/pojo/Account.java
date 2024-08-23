package com.threads.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
public class Account {

    @Getter
    @Setter
    private String number;
    @Getter
    @Setter
    private String type;
}

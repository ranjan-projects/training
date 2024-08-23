package com.threads.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Customer {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String name;

}

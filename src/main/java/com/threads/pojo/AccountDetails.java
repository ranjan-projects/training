package com.threads.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class AccountDetails {

    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private List<Account> accounts;
}

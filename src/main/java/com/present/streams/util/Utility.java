package com.present.streams.util;

import com.present.streams.model.Account;

import java.util.function.Predicate;

public class Utility {


    public static final Predicate<Account> savingsGreaterThan10000 = account -> account.getAccountBalance() > 10000;
    public static final Predicate<Account> bankIsVM = account -> account.getBankType().equalsIgnoreCase("VM");

}

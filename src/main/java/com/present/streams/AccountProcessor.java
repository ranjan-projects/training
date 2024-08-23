package com.present.streams;

import com.present.streams.model.Account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.present.streams.util.Utility.*;

public class AccountProcessor {

    /*
    from a given list of accounts return only those whose savings balance is greater than 10000
     */

    public List<Account> getAccountsWithBalanceGreaterThan10000(List<Account> accountList) {

        List<Account> accountsWithBalanceGreaterThan10000 = new ArrayList<>();

        if(null == accountList) {
           return  accountsWithBalanceGreaterThan10000;

        } else {
            for (Account account : accountList) {

                if (account.getAccountBalance() > 10000) {

                    accountsWithBalanceGreaterThan10000.add(account);
                }

            }
        }


        return accountsWithBalanceGreaterThan10000;
    }


    public List<Account> getAccountsWithBalanceGreaterThan10000WithStreams(List<Account> accountList) {
        return Optional.ofNullable(accountList).orElseGet(Collections::emptyList).stream().filter(savingsGreaterThan10000.and(bankIsVM)).collect(Collectors.toList());
    }


}

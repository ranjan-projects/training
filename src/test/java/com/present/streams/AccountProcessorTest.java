package com.present.streams;

import com.present.streams.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Test Account Processor")
public class AccountProcessorTest {

    private List<Account> accounts = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        addAcountData();
    }


    @Test
    public void TestGetAccountsWithBalanceGreaterThan10000() {

        AccountProcessor ap = new AccountProcessor();
        List<Account> accountList = ap.getAccountsWithBalanceGreaterThan10000WithStreams(accounts);
        List<Account> accountListEmpty = ap.getAccountsWithBalanceGreaterThan10000WithStreams(null);

        Assertions.assertAll(
                        () -> Assertions.assertEquals(2, accountList.size()),
                        () -> Assertions.assertEquals(0, accountListEmpty.size())
        );

    }

    private void addAcountData() {

        accounts.add(Account.builder().accountBalance(9999).bankType("VM").accountNo(01).build());
        accounts.add(Account.builder().accountBalance(10001).bankType("VM").accountNo(02).build());
        accounts.add(Account.builder().accountBalance(9999.50).bankType("YB").accountNo(03).build());
        accounts.add(Account.builder().accountBalance(10000.50).bankType("CB").accountNo(04).build());
        accounts.add(Account.builder().accountBalance(10000).bankType("VM").accountNo(05).build());

    }

}

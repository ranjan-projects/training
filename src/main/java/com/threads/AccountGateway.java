package com.threads;

import java.util.Arrays;
import java.util.List;

public class AccountGateway {

    public List<Integer> getAccount(int Id) throws InterruptedException {

        System.out.println("Start :" + Id);
        Thread.sleep(1000);
        System.out.println("end :" + Id);

        return Arrays.asList(new Integer[] {Id});

    }

}

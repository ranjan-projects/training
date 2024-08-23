package com.threads;

import org.apache.tomcat.util.digester.ArrayStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class CustomerGateway {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerGateway.class);

    public List<Integer> getCustomer(int Id) throws InterruptedException {

        LOGGER.info("Start :" + Id);
//        System.out.println("Start :" + Id);
        Thread.sleep(1000);
        LOGGER.info("end :" + Id);
//        System.out.println("end :" + Id);

        return Arrays.asList(new Integer[] {Id});

    }

}

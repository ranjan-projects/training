package com.threads;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TestThreads {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Integer> accountNumbers = Arrays.asList(new Integer[] {1,2,3,4,5,6,7,8,9, 10});

        /*System.out.println("processing no thread started " + Instant.now());
        ExampleHandlers.getData(accountNumbers);
        System.out.println("processing no thread ended " + Instant.now());*/


        System.out.println("processing with thread started " + Instant.now());
        ExampleHandlers.getDataViaLambdaThreads(accountNumbers);
        System.out.println("processing with thread ended " + Instant.now());


      /*  System.out.println("processing with old thread  style started " + Instant.now());
        ExampleHandlers.getDataViaExecutors(accountNumbers);
        System.out.println("processing with old thread style ended " + Instant.now());*/


    }
}

package com.threads;

import com.threads.pojo.AccountDetails;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ExampleHandlers {



    public static List<Integer> getData(List<Integer> accountList){

        CustomerGateway gateway = new CustomerGateway();
        return accountList.stream().map(id -> {
            try {
                return gateway.getCustomer(id);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).flatMap(l -> l.stream()).collect(Collectors.toList());

    }


    public static List<Integer> getDataViaLambdaThreads(List<Integer> accountList){

        CustomerGateway gateway = new CustomerGateway();

        List<CompletableFuture<List<Integer>>> future = accountList.stream().map(id -> CompletableFuture.supplyAsync(() -> {
            try {
                return gateway.getCustomer(id);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        })).collect(Collectors.toList());

        return future.stream().map(CompletableFuture::join).flatMap(List::stream).collect(Collectors.toList());

    }

    public static List<Integer> getDataViaExecutors(List<Integer> accountList)
                    throws ExecutionException, InterruptedException {

        CustomerGateway gateway = new CustomerGateway();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<List<Integer>>> futureList =
                        accountList.stream().map(id -> executor.submit(new CustomerCallable(id,gateway))).collect(Collectors.toList());



        List<Integer> integers = futureList.stream().map(f -> {
            try {
                return f.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).flatMap(List::stream).collect(Collectors.toList());

        executor.shutdown();
        return integers;
    }

    public List<AccountDetails> getData() {

       // CompletableFuture<List<AccountDetails>> accountsComparable = CompletableFuture.supplyAsync().thenCo
        return null;
    }
}

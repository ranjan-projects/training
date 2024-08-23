package com.threads;

import java.util.List;
import java.util.concurrent.Callable;

public class CustomerCallable implements Callable<List<Integer>> {

    public int id;
    public CustomerGateway gateway;

    public CustomerCallable(int id, CustomerGateway gateway) {
        this.id = id;
        this.gateway = gateway;
    }

    @Override
    public List<Integer> call() throws Exception {
        return gateway.getCustomer(id);
    }
}

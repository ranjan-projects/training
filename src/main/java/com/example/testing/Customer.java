package com.example.testing;

public class Customer implements ICustomer{

    @Override
    public String toString() {
        return "Customer{}";
    }

    public String onlySuperClass() {
        return "onlySuperClass";
    }

    @Override
    public String commonCustomer() {
        return "";
    }
}

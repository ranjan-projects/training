package com.example.testing;

public class BusinessCustomer extends Customer {

    @Override
    public String toString() {
        return "BusinessCustomer{}";
    }

    public String onlySubClass() {
        return "only sub class";
    }
}

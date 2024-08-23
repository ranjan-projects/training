package com.example.testing;

public class Inheritance {

    public static void main(String[] args) {
        ICustomer cust = new Customer();
        System.out.println(cust.toString());
        //cust.onlySubClass();
        System.out.println(cust.toString());
        //System.out.println(cust.

        Customer bCust = new BusinessCustomer();
        System.out.println(bCust.toString());
        //System.out.println(bCust.onlySubClass());
        System.out.println(bCust.onlySuperClass());
        System.out.println(bCust.commonCustomer());



    }
}

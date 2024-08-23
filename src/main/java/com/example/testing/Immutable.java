package com.example.testing;

import com.example.testing.model.Person;
import com.example.testing.model.PersonBuilder;

public class Immutable {

    public static void main(String[] args) {

        /* primitive and string are immutable */
        int x = 1000;
        int y = x;
        System.out.println(x + " before " + y);
        x = 3000;
        System.out.println(x + " after " + y);

        /* object constrauct are not immutable example */
        Person p1 = new Person();
        p1.setCity("Edin");

        Person p2 = new Person();
        p2 = p1;

        System.out.println(p1 + " before " + p2);

        p1.setCity("Glas");

        System.out.println(p1 + " after " + p2);


    }
}
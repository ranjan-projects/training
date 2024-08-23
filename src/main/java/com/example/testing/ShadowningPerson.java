package com.example.testing;

import com.example.testing.model.Person;

public class ShadowningPerson {

    public static void foo(Person i) {
        i = new Person("Edin",9,"Umesh");
        System.out.println("bb" + i);
    }

    public static void fooBar(Person i) {
        i.setCity("mumbai");   //demonstrates set is breaking immutability here
        System.out.println("bbc" + i);
    }

    public static void main(String[] args) {
        Person i = new Person("Edin",9,"Rajesh");
        System.out.println("aa" + i);
        foo(i);
        System.out.println("cc" + i);
        fooBar(i);
        System.out.println("d" + i);

    }
}

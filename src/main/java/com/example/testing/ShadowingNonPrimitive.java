package com.example.testing;

public class ShadowingNonPrimitive {

    public static void foo(Integer i) {
        i = new Integer(2);
        System.out.println("bb" + i);
    }
    public static void main(String[] args) {
        Integer i = new Integer(0);
        System.out.println("aa" + i);
        foo(i);
        System.out.println("cc" + i);

    }
}

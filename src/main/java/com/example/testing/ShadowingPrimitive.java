package com.example.testing;

public class ShadowingPrimitive {

    public static void foo(int i) {
        i = 2;
        System.out.println("b" + i);
    }
    public static void main(String[] args) {
        int i = 0;
        System.out.println("a" + i);
        foo(i);
        System.out.println("c" + i);

    }
}

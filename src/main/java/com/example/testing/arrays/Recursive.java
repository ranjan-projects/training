package com.example.testing.arrays;

import java.util.ArrayList;
import java.util.List;

public class Recursive {

    public static void main(String[] args) {

        int number = 10;
        recursiveCall(number);
        List<String> ls = new ArrayList<>();
    }

    public static void recursiveCall(int number) {

        if(number >= 12)
            return;

        number = (number * 1) + 1;

        recursiveCall(number);


        System.out.println(number);
        number = number / 2;
        System.out.println(number);

    }



}

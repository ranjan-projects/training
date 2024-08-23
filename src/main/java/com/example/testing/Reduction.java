package com.example.testing;

import java.util.Arrays;
import java.util.List;

public class Reduction {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList();

        System.out.println(integers.stream()
                   // .reduce(0, (i1,i2) -> i1 + i2); lambda way
                    .reduce(0, Integer::sum));

    }
}

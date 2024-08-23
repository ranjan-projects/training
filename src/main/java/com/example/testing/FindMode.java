package com.example.testing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindMode {

    public static void main(String[] args) {

        int[] intArray = {2,4,5,5,6,7,5};

        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i = 0 ; i <intArray.length ; i++) {
            countMap.put(intArray[i], countMap.getOrDefault(intArray[i],0) + 1);

        }

        int a = Collections.max(countMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        System.out.println("a" + a);

        countMap.forEach((k,v) -> {
            System.out.println(k + ":" + v);
        });




    }
}

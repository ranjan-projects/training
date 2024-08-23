package com.example.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class FindLargest {

    public static void main(String[] args) {

        Random randomInt = new Random();
        int[] intArray = new int[10];

        for(int i =0; i < intArray.length; i++) {
            intArray[i] = randomInt.nextInt(2000);
        }

        System.out.println("list of numbers : ");
        Arrays.stream(intArray).forEach(System.out::println);

        System.out.println("Largest : " + findLargest(intArray));

    }

    private static int findLargest(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length -1];
    }

}

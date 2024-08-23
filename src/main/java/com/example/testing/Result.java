package com.example.testing;

import java.util.function.Predicate;

class Result {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {

        Predicate<Integer> multipleOf3 = input -> input%3 ==0;
        Predicate<Integer> multipleOf5 = input -> input%5 ==0;

        if(multipleOf3.and(multipleOf5).test(n)) {
            System.out.println("FizzBuzz");
        } else if (multipleOf3.test(n)) {
            System.out.println("Fizz");
        } else if(multipleOf5.test(n)) {
            System.out.println("Buzz");
        } else {
            System.out.println(n);
        }



    }

}

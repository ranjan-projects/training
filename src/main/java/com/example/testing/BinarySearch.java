package com.example.testing;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    public static void main(String[] args) {

        Random randomInt = new Random();
        int[] intArray;
        int searchInt = 10;
        /*for(int i =0; i < intArray.length; i++) {
            intArray[i] = randomInt.nextInt(10);
        }*/
        intArray = new int[] { 1, 2, 4, 5, 7, 8, 9, 10, 3,6};


        System.out.println("list of numbers : ");
        Arrays.stream(intArray).forEach(System.out::println);
        Arrays.sort(intArray);

        System.out.println("Largest : " + binarySearchRecursive(intArray,searchInt, 0 , intArray.length-1));


    }

    private static boolean binarySearchRecursiveWithForLoop(int[] intArray, int searchInt) {

        int inputLength = intArray.length;

        if(inputLength < 2) {
            return false;
        }

        int midIndex = inputLength/2;

        if(intArray[midIndex] == searchInt) {
            return true;
        } else if(searchInt < intArray[midIndex]) {
            int[] leftHalf = new int[midIndex];
            for(int i =0; i < midIndex; i++) {
                leftHalf[i] = intArray[i];
            }
            return binarySearchRecursiveWithForLoop(leftHalf,searchInt);
        } else {
            int[] rightHalf = new int[inputLength - midIndex];
            for(int i =midIndex; i < inputLength; i++) {
                rightHalf[i-midIndex] = intArray[i];
            }
            return binarySearchRecursiveWithForLoop(rightHalf,searchInt);
        }

    }

    private static boolean binarySearchRecursive(int[] intArray, int searchInt , int left , int right) {

        if(left > right) {
            return false;
        }

        int midIndex = (left + right) /2;

        if(intArray[midIndex] == searchInt) {
            return true;
        } else if(searchInt < intArray[midIndex]) {
            return binarySearchRecursive(intArray,searchInt,left, midIndex-1);
        } else {
            return binarySearchRecursive(intArray,searchInt,midIndex+1, right);
        }

    }
}

package com.example.testing;

import java.util.Arrays;
import java.util.Random;

public class MergeSortExample {

    public static void main(String[] args) {

        Random randomInt = new Random();
        int[] intArray = new int[10];

        for(int i =0; i < intArray.length; i++) {
            intArray[i] = randomInt.nextInt(100);
        }

        System.out.println("Before : ");
        Arrays.stream(intArray).forEach(System.out::println);

        mergeSort(intArray);

        System.out.println("After : ");
        Arrays.stream(intArray).forEach(System.out::println);
    }

    public static void mergeSort(int[] numbers) {
        int inputLength = numbers.length;

        if(inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        for(int i =0; i < midIndex; i++) {
            leftHalf[i] = numbers[i];
        }

        for(int i =midIndex; i < inputLength; i++) {
            rightHalf[i-midIndex] = numbers[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(numbers,rightHalf,leftHalf);

    }

    private static void merge(int[] inputArray, int[] rightHalf, int[] lefthalf) {
        int leftsize = lefthalf.length;
        int rightsize = rightHalf.length;


        int i = 0,j =0 ,k = 0;

        while(i < leftsize && j < rightsize) {
            if(lefthalf[i] < rightHalf[j] ) {
                inputArray[k] = lefthalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while(i < leftsize) {
            inputArray[k] = lefthalf[i];
            i++;
            k++;
        }

        while(j < rightsize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }

    }

}

package com.example.testing;

import java.util.*;
import java.util.stream.Collectors;

public class KDiffPairs {


/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    An example would be:
    Input: nums = [3,3], target = 6
    Output: [0,1]
*/
    //k-diff pairs
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(5,8,3,4,2,6,10,7,1,9);
        //{1,2,3,4,5,6,7,8,9,10)
        Set<String> resultIndices = new HashSet<>();

        integers.sort(Comparator.naturalOrder());

        int[] intArray = integers.stream().mapToInt(Integer::intValue).toArray();
        int diff = 2;

        int lhsIndex = 0;
        int rhsIndex = 1;
        int arrayLength = intArray.length;

        while(lhsIndex < arrayLength && rhsIndex < arrayLength) {

            System.out.println(lhsIndex + " " + rhsIndex + " -> " + intArray[lhsIndex] + " :" + intArray[rhsIndex]);

            if((intArray[rhsIndex] - intArray[lhsIndex]) == diff && lhsIndex != rhsIndex) {
                System.out.println(lhsIndex + " " + rhsIndex + " -> " + intArray[lhsIndex] + " :" + intArray[rhsIndex]);
                resultIndices.add("{" + intArray[lhsIndex] + "," + intArray[rhsIndex] + "}");

                List<Integer> integers1 = Arrays.stream(intArray)
                                                        .boxed()
                                                        .collect(Collectors.toList());

                integers1.remove(lhsIndex);
                integers1.remove(rhsIndex-1);

                intArray = integers1.stream().mapToInt(Integer::intValue).toArray();
                arrayLength = intArray.length;
                lhsIndex = 0;
                rhsIndex = 1;
            } else if((intArray[rhsIndex] - intArray[lhsIndex]) < diff) {
                rhsIndex++;
            } else {
                lhsIndex++;
            }

        }

        System.out.println(resultIndices);



       /* Map<Map<Integer,Integer>,Integer> mapofMaps = new HashMap<>();

        int index = 0;
        for(Integer i1 : integers) {
            //System.out.println(i1);

            int internalIndex = 0;
            for(Integer i2 : integers) {
                if(index != internalIndex) {
                    //System.out.println(i2);
                    Map<Integer, Integer> indicesMap = new HashMap<>();
                    indicesMap.put(index, internalIndex);
                    mapofMaps.put(indicesMap,(i1 +i2));
                    internalIndex++;
                }
            }
            index++;
        }


        System.out.println(mapofMaps.toString());


        BiPredicate<Integer,Integer> intTarget = (i1,i2) -> i1 + i2 == target;

        System.out.println(intTarget.test(3,3));

        System.out.println(mapofMaps.entrySet().stream().filter(i -> i.getValue() == target).collect(Collectors.toSet()));

        Stack<Integer> resultIndices = new Stack<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < integers.size(); i++) {
            int remainder = target - integers.get(i);
            if (null != map.get(remainder)) {
                resultIndices.add(map.get(remainder));
                resultIndices.add(i);
            }
            map.put(integers.get(i), i);
        }

        System.out.println(resultIndices);*/

        //Arrays.asList(4,3,2,3,6,0);


    }






}

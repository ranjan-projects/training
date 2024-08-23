package com.example.testing;

import org.springframework.util.StringUtils;
import sun.lwawt.macosx.CSystemTray;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KSumPairs {


/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    An example would be:
    Input: nums = [3,3], target = 6
    Output: [0,1]
*/
    //k-sum pairs
    public static void main(String[] args) {

        /*System.out.println(StringUtils.containsWhitespace("EH10 4FF"));
        System.out.println(StringUtils.trimAllWhitespace("EH10 4FF"));*/

        List<Integer> integers = Arrays.asList(5,8,3,4,0,6,5,10,7,0,9,5);
        //{1,2,3,4,5,6,7,8,9,10)
        Set<String> resultIndices = new HashSet<>();

        integers.sort(Comparator.naturalOrder());

        int[] intArray = integers.stream().mapToInt(Integer::intValue).toArray();
        int target = 10;

        int lhsIndex = 0;
        int rhsIndex = intArray.length -1;

        while(lhsIndex < rhsIndex) {

            System.out.println(lhsIndex + " " + rhsIndex);

            if((intArray[lhsIndex] + intArray[rhsIndex]) > target ) {
                rhsIndex--;
            } else if((intArray[lhsIndex] + intArray[rhsIndex]) < target) {
                lhsIndex++;
            } else {
                resultIndices.add("{" + intArray[lhsIndex] + "," + intArray[rhsIndex] + "}");
                lhsIndex++;
            }

        }

        System.out.println(resultIndices + " count : " + resultIndices.size() );



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

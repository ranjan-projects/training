package com.example.testing;

import java.util.*;

//can have maximum two childs
public class PQueue {

    public static void main(String[] args) {

        int[] numbers = {10,6,8,3,4,2};

        PriorityQueue<Integer> minqueue = new PriorityQueue<>(); // queue.poll will get min
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());  //queue.poll will get maximim

        for(int i = 0 ; i < numbers.length; i++) {
            maxQueue.add(numbers[i]);
        }

        Iterator it = maxQueue.iterator();


        while(it.hasNext()) {

            System.out.println("next" + it.next());
        }


        //Arrays.stream(minqueue.toArray()).forEach(System.out::println);
        for(int i = 0 ; i < maxQueue.size(); i++) {
            System.out.println(maxQueue.poll());
        }


    }
}

package com.example.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryAndFinal {

    public static void main(String[] args) {

        Stream<String> streams = Stream.of("one", "two", "three", "four", "five");

        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");

        List<String> strings = new ArrayList<>();


        streams
                .peek(System.out::println)
                .filter(p2.or(p3))
                .peek(strings::add);

        System.out.println("done!");
        System.out.println("size of list is " + strings.size());

        //only final operation like foreach will trigger data processing
        streams
                .peek(System.out::println)
                .filter(p2.or(p3))
                .forEach(strings::add);

        System.out.println("done!");
        System.out.println("size of list is " + strings.size());


    }
}

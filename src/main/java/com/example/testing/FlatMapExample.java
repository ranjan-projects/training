package com.example.testing;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample {

    public static void main(String[] args) {

        List<Integer> intergers = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> evenIntergers = Arrays.asList(2,4,6);
        List<Integer> oddIntergers = Arrays.asList(3,5,7);

        List<List<Integer>> containerList = Arrays.asList(intergers, evenIntergers, oddIntergers);

        System.out.println(containerList);

        Function<List<?>, Integer> size = l -> l.size();
        Function<List<Integer>, Stream<Integer>> flatmap = l -> l.stream();


        containerList.stream()
                        //.flatMap(l -> flatmap.apply(l))  //lambda way
                        //.flatMap(flatmap::apply)  //method reference
                        .flatMap(l -> l.stream()) /// normal way
                        //.flatMap(flatmap) //functionalinterface way.. since only one method it will apply
                        .forEach(l -> System.out.println(l));

    }
}

package com.example.testing;

import com.example.testing.generic.SummaryStats;
import com.example.testing.model.Person;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTest {

    public static void main(String[] args) {


        List<Person> persons = new ArrayList<>();

        Person p1 = new Person();
        p1.setAge(13);
        p1.setName("Unnati");
        Person p2 = new Person();
        p2.setAge(15);
        p2.setName("Laksh");

        Person p3 = new Person();
        p3.setAge(14);
        p3.setName("palak");

        persons.add(p1);
        persons.add(p2);
        persons.add(p3);

        System.out.println(persons.stream()
                    .map(p -> p.getAge())
                    .filter(age -> age >= 12)
                    .min(Comparator.naturalOrder()));

        Map<Integer, List<Person>> ageGroup =
        persons.stream().filter(p -> p.getAge() >= 14).collect(java.util.stream.Collectors.groupingBy(Person::getAge));

        System.out.println(ageGroup);

        Map<Integer, Long> age =
                        persons.stream().filter(p -> p.getAge() >= 14).collect(java.util.stream.Collectors.groupingBy(Person::getAge,
                                        java.util.stream.Collectors.counting()));

        System.out.println(age);


        Function<List<String>, Map<String,Integer>> positionMapCreator =
                        aposition -> aposition.stream().map(e -> e.split(" ")).collect(
                                        java.util.stream.Collectors.toMap(e -> e[0], e -> Integer.parseInt(e[1])));

        List<String> pos0 = Arrays.asList("Appl 10", "Goog 220");

        Map<String,Integer> day1Position = positionMapCreator.apply(pos0);
        day1Position.forEach((k,v) -> System.out.println("k" + k + " " + "v" + v));


        int[] intArray = {1,5,5,6,7,7,8,3,1,1};
        IntSummaryStatistics stats = Arrays.stream(intArray).summaryStatistics();
        double[] doubleArray = {1,5,5,6,7,7,8,3,1,1};
        DoubleSummaryStatistics dStats = Arrays.stream(doubleArray).summaryStatistics();

        String[] chars = { "A", "B", "C", "A", "C", "A" };

        Map<String, Long> freq = Arrays.stream(chars)
                        .collect(java.util.stream.Collectors.groupingBy(Function.identity(),
                                        java.util.stream.Collectors.counting()));

        freq.forEach((k,v) -> System.out.println("k" + k + " " + "v" + v));

        Map<Integer,Long> frequencyMap = Arrays.stream(intArray).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        frequencyMap.forEach((k,v) -> System.out.println("k" + k + " " + "v" + v));

        List<Integer> integers1 = Arrays.asList(2,2);
        SummaryStats<List<Integer>, Integer> summary = integers -> integers.stream().reduce(0,Integer::sum) / 2;
        System.out.println(summary.compute(integers1));

    }

}

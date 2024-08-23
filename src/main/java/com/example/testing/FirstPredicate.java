package com.example.testing;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FirstPredicate {

    public static void main(String[] args) {


        Stream<String> streams = Stream.of("one", "two", "three", "four", "five");

        Predicate<String> p1 = s -> s.length() > 3;

        streams
                        .filter(s -> p1.test(s))
                        .forEach(s -> System.out.println(s));
                        //we can use peek which if you want to return stream.


        BiPredicate<String, Integer> filter = (x, y) -> {
            return x.length() == y;
        };

        boolean result = filter.test("Umesh", 9);
        System.out.println(result);

        Predicate<String> eNotationContainsCheck = s -> s.contains("E");
        Predicate<String> lengthCheck = s -> s.length() > 3;

        eNotationContainsCheck.or(lengthCheck);

    }
}

package com.example.testing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatVsOf {

    public static void main(String[] args) {

        List<String> strings1 = Arrays.asList("a", "b", "c", "d");
        List<String> strings2 = Arrays.asList("e", "f", "g", "h");
        List<String> strings3 = Arrays.asList("i", "j", "k", "l");

        //Stream<String> contactinatedStream =  Stream.concat(strings1.stream(),strings2.stream()); returns a stream , ordered and one after another and has a cost since
        //more than two you have to concat again...
        Stream<String> contactinatedStream =   Stream.concat(Stream.concat(strings1.stream(),strings2.stream()),strings3.stream());

        contactinatedStream.forEach(System.out::println);
        System.out.println("---------------");

        //a better appropach
        //Function.identity() takes the element and returns same element so stream -> stream
        Stream.of(strings1.stream(),strings2.stream(),strings3.stream()).flatMap(Function.identity()).forEach(System.out::println);

        Function<String, Stream<String>> split =
        line -> Pattern.compile("").splitAsStream(line);


        String aString = "Umesh";

        split.apply(aString).forEach(i -> {
            System.out.println("i" + i);
        });


    }
}

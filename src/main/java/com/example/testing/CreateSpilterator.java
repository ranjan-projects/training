package com.example.testing;

import com.example.testing.model.Person;
import com.example.testing.model.PersonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CreateSpilterator {

    public static void main(String[] args) {

        Person p = new PersonBuilder().setAge(2).setCity("mumbai").setName("Umesh").build();
        //System.out.println(p);

        Path path = Paths.get("/Users/s610231/work/example/micro-services/Testing/src/main/resources/static/peoples.txt");
        try (Stream<String> lines = Files.lines(path)) {

            //lines.forEach(System.out::println);
            Spliterator<String> lineSpliterator = lines.spliterator();
            Spliterator<Person> peopleSpliterator = new PersonSpliterator(lineSpliterator);


            /*Stream<Person> peopleStream = StreamSupport.stream(peopleSpliterator, false);
            peopleStream.forEach(System.out::println);*/


            Spliterator<HashMap<Integer,String>> customerMapByNameSpliterator = new CustomerSpliterator(peopleSpliterator);
            Stream<HashMap<Integer,String>> customerMapStream = StreamSupport.stream(customerMapByNameSpliterator, false);
            customerMapStream.forEach(i1 -> System.out.println(i1));

        } catch(IOException ex) {
            ex.printStackTrace();
        }




    }



}

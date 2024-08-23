package com.example.testing;

import com.example.testing.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TermicalOperations {

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

    }

}

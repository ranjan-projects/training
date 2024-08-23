package com.example.testing;

import com.example.testing.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class NulLCheck {

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

        Person p4 = new Person();
        p4.setAge(12);
        p4.setName(null);

        persons.add(p1);
        persons.add(p2);
        persons.add(p3);

        Predicate<String> nameNullCheck = s -> Objects.isNull(s);

        System.out.println(nameNullCheck.test(p4.getName()));


    }



}

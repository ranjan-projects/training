package com.example.testing;

import com.example.testing.model.Person;
import java.util.ArrayList;
import java.util.List;

public class Memory {

    public static void main(String[] args) {

        List memoryList = new ArrayList<Object>();

        Person object = new Person();
        object.setAge(21);
        object.setName("Umesh");
        object.setCity("Edinburgh");

        memoryList.add(object);
        object = null;

        System.out.println(null != object ? object.getName() : "is null");
        System.out.println(memoryList.get(0));

    }
}

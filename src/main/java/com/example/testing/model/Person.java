package com.example.testing.model;

public class Person {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    String city;
    int age;
    String name;   // default protected and if in same package instance can access this../ show this to grads -- and for others to refresh

    public Person(String city, int age, String name) {
        this.city = city;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                        "city='" + city + '\'' +
                        ", age=" + age +
                        ", name='" + name + '\'' +
                        '}';
    }

    public Person() {
    }




}

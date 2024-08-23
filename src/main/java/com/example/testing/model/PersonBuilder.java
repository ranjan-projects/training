package com.example.testing.model;

public class PersonBuilder {

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    private String city;
    private int age;
    private String name;   // default protected and if in same package instance can access this../ show this to grads -- and for others to refresh

    public PersonBuilder(String city, int age, String name) {
        this.city = city;
        this.age = age;
        this.name = name;
    }

    public PersonBuilder() {
    }

    public Person build() {
        return new Person(city, age , name);
    }

}

package com.example.testing;

import com.example.testing.model.Person;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.HashMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CustomerSpliterator implements Spliterator<HashMap<Integer, String>> {

    private final Spliterator<Person> peopleSpliterator;
    private Integer number;
    private String string;

    public CustomerSpliterator(Spliterator<Person> peopleSpliterator) {
        this.peopleSpliterator = peopleSpliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super HashMap<Integer, String>> action) {

        if(this.peopleSpliterator.tryAdvance(person -> {

            this.string = person.getName();
            this.number = person.getAge();

        }))
        {

            HashMap<Integer, String> customerMap = new HashMap<>();
            customerMap.put(number, string);
            action.accept(customerMap);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Spliterator<HashMap<Integer, String>> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return this.peopleSpliterator.estimateSize();
    }

    @Override
    public int characteristics() {
        return this.peopleSpliterator.characteristics();
    }
}

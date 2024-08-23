package com.example.testing.arrays;

public class IntArray {
    private int[] items;
    private int count;

    public IntArray(int length) {
        items = new int[length];
    }


    public void insert(int value) {
        if (items.length == count) {
            int newItems[] = new int[2 * count];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count++] = value;
    }

    public int size() {
        return count;
    }

    public void print() {
        for(int i= 0; i < count; i++)
            System.out.println(items[i]);
    }



}

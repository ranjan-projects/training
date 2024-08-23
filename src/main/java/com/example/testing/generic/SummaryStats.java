package com.example.testing.generic;

@FunctionalInterface
public interface SummaryStats<T, R> {
    R compute(T t);
}

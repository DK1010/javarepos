package com.example.demo.java8features;

import java.util.Arrays;
import java.util.List;

public class Java8Features {
    public static void main(String[] args) {
        // Lambda expression to implement a functional interface
        Runnable runnable = () -> System.out.println("Hello, World!");
        runnable.run();

        // Stream API to process collections
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.stream()
             .filter(name -> name.startsWith("A"))
             .forEach(System.out::println);
    }
}

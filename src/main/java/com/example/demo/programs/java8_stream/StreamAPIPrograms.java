package com.example.demo.programs.java8_stream;

public class StreamAPIPrograms {
    public static void main(String[] args) {
        String str= "BANANA ";
        //
        str.chars().filter(ch ->ch!=' ').forEach(System.out::print);

        //Write a java program to count occurrence of each character in a string using Stream API

       // str=str.replace(" ","");
        //write logic to print unique characters and their count in the string
        System.out.println("\n----------------------------");
        str.chars().filter(ch -> ch != ' ').distinct().forEach(c -> System.out.println((char)c +
                " : " + str.chars().filter(ch -> ch == c).count()));

        System.out.println("----------------------------");
        str.chars().filter(ch -> ch != ' ').forEach(c -> System.out.println((char)c +
                " : " + str.chars().filter(ch -> ch == c).count()));

    }
}

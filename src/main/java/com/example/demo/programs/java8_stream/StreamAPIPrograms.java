package com.example.demo.programs.java8_stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAPIPrograms {
    public static void main(String[] args) {
        String str= "BANANA ";
        //
        str.chars().filter(ch ->ch!=' ').forEach(System.out::print);

        //Write a java program to count occurrence of each character in a string using Stream API

       // str=str.replace(" ","");
        //write logic to print unique characters and their count in the string
        System.out.println("\n----------character occurence------------------");

        str.chars().filter(ch -> ch != ' ').distinct().forEach(c -> System.out.println((char)c +
                " : " + str.chars().filter(ch -> ch == c)));

        str.chars().filter(ch -> ch != ' ').distinct().forEach(c -> System.out.println((char)c +
                " : " + str.chars().filter(ch -> ch == c).count()));

        System.out.println("----------------------------");
        str.chars().filter(ch -> ch != ' ').forEach(c -> System.out.println((char)c +
                " : " + str.chars().filter(ch -> ch == c).count()));

        //Write a logic to find second highest number in the array using Stream api
        int[] intArray1= {10,7,45,67,888,97};


        //

        int[] intArray= {10,7,45,67,888,97};
       int secondLargestNumber= Arrays.stream(intArray).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
       System.out.println("secod Largest number is "+secondLargestNumber);

       // find second smallest number in the array using Stream api
        int secondSmallestNumber= Arrays.stream(intArray).boxed().sorted().skip(1).findFirst().orElse(-1);
        System.out.println("second Smallest number is "+secondSmallestNumber);

        // find second smallest number in the array using Stream api without sorting
        int secondSmallestNumberWithoutSorting= Arrays.stream(intArray).boxed()
                .filter(i -> i > Arrays.stream(intArray).min()
                        .orElse(Integer.MAX_VALUE))
                .min(Integer::compareTo)
                .orElse(-1);
        System.out.println("second Smallest number without sorting is "+secondSmallestNumberWithoutSorting);

        Arrays.stream(intArray).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);

        // To check number is prime or not using Stream api
        int num= 29;
        boolean isPrime=num>1 && IntStream.range(2,(int)Math.sqrt(num))
                .noneMatch(i-> num%i==0);
        System.out.println(isPrime ? "Number is prime": "Number is not a prime");

        //Find substring of length 5 in sentence.
        String sentence= "This is a sample sentence for testing substring of length 5";
        String[]strArray=sentence.split(" ");
        Arrays.stream(strArray).filter(s->s.length()==5)
                .forEach(System.out::println);

        // reverse String without using reverse method
        String s2="India";
       String reversed= java.util.stream.IntStream.iterate(s2.length()-1,i->i>=0,i->i-1)
                .mapToObj(s3->String.valueOf(s2.charAt(s3)))
                .collect(Collectors.joining());
       System.out.println("Reversed String is "+reversed);

       // merge two sorted Arrays into one sorted array using Stream api
        int[] a1={34,45,56};
        int[] a2={12,23,67};
        int[] mergedSortedArray=IntStream.concat(Arrays.stream(a1),Arrays.stream(a2)).sorted().toArray();
        System.out.println("Merged and sorted array is "+ Arrays.toString(mergedSortedArray));

        //
    }
}

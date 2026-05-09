package com.example.demo.programs.java8_stream.durgasoft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethods {
    public static void main(String[] args) {
        //Remove space from String using Stream.
        String s = "Deepak is good boy";
        s.chars().filter(c -> c != ' ').forEach(c -> System.out.print((char) c)); // cant use method reference here because of type casting like (char)c.

        //filter method to filter even number from arraylist..
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(20);
        arrayList.add(65);
        arrayList.add(78);
        arrayList.add(80);
        arrayList.stream().filter(i -> i % 2 == 0).forEach(System.out::println);

        //map() if we want to perform operation on every object...
        //increment every marks with 5 ..
        List<Integer> marks = new ArrayList<>();
        marks.add(50);
        marks.add(78);
        marks.add(90);
        marks.add(95);
        marks.stream().map(i -> i + 5).forEach(System.out::println);

        //count()
        //count marks <95 from list..
        long count = marks.stream().filter(i -> i < 95).count();
        System.out.println("count of marks less than 95 is " + count);

        //sorted() method
        List<Integer> sortedMarks = marks.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted marks in list " + sortedMarks);

        //sorted on list of stirings..
        List<String> strList = new ArrayList<>();
        strList.add("Deepak");
        strList.add("Adarsh");
        strList.add("Rohit");
        strList.add("Abc");
        strList.add("Raj");
        strList = strList.stream().sorted().collect(Collectors.toList());
        System.out.print("sorted String from List is " + strList);

        //Above sorted methods sort with natural sorting order

        //Custom Sorting.... i1<i2 return -1 for ascending 1 for descending
        List<Integer> customSortedMarks = marks
                .stream()
                .sorted((i1, i2) -> i2.compareTo(i1))// expression can be changed to i2.compareTo(i1)- as descending orelse i1.compareTo(i2).
                .collect(Collectors.toList());
        System.out.println("\ncustom Sorted marks from list in descending order is " + customSortedMarks);

        List<Integer> sortedMarks1 = marks
                .stream()
                .sorted((i1, i2) -> i1.compareTo(i2))// Method reference can be used Integer::compareTo // natural order
                .collect(Collectors.toList());
        System.out.print(sortedMarks1);

        /*---For descending or reverse order---*/
        List<Integer> sortedMarks2 = marks.stream()
                .sorted((i1, i2) -> -i1.compareTo(i2))
                .collect(Collectors.toList());
        System.out.println("Sorting in descending order using - minus before compareTo" + sortedMarks2);

        /*----Sorting String based on length of string usin comparator*/
        Comparator<String> c = (s1, s2) -> {
            int l1 = s1.length();
            int l2 = s2.length();

            if (l1 < l2) return -1;
            else if (l2 < l1) {
                return 1;
            } else return 0;
        };
        strList = strList.stream().sorted(c).collect(Collectors.toList());
        System.out.println(strList);

        //min() method.......
       Integer min= marks.stream().min((i1,i2)->i1.compareTo(i2)).get();
       System.out.println(min);

       Integer min2=marks.stream().min((i1,i2)-> -i1.compareTo(i2)).get();
       System.out.println(min2); // here min is 95 as we used - minus before compareTo. means min will change bsaed on sorting

        //max() method
         Integer max=marks.stream().max((i1,i2) -> i1.compareTo(i2)).get();
         System.out.println(max);// if we put - minus before compareTo max will change to 50 .

        //forEach() method
        marks.forEach(System.out::print);

        /*----we can create our own consumer and pass to foreach*/
        Consumer<Integer> con= i->{
            System.out.println(i*i);
        };
        marks.forEach(con);

        //toArray() Method to convert collection to array obejct
        Integer[] marksArray=marks.stream().toArray(Integer[]::new); // Need to check n deatil on difference between collection.toArray and stream.toArray

        //String.of()....to make stream of any group of object
        //if we have group of obejct like 9,99,999,87,87 -> we can create stream of this and use availbale methods on these as well
        Stream.of(9,50,76,5,39,99,878,87,90).filter(i->i>30).forEach(System.out::print);

    }
}

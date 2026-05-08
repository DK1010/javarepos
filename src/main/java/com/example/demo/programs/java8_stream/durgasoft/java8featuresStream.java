package com.example.demo.programs.java8_stream.durgasoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class java8featuresStream {

    //Stream () can be used on collections and also group of object. - list.stream().../ Stream.Of("Deepak","Rama")..like this
    //we use filter to filter based on some condition and forEach to iterate on collection
    public static void main(String[] args){

        System.out.println("\n--------------filter() examples--------------------------------------------------");

        // 1.---program to get even nubers form arrayList--
        ArrayList<Integer> list= new ArrayList<Integer>();
        list.add(10);list.add(89);list.add(34); list.add(64);

       List<Integer> updatedList= list.stream().filter(i-> i%2==0).toList();
       for(Integer i:updatedList){
           System.out.println(i);
       }
       System.out.println();
       // or we can use forEach in above statemnet itself as below:
        list.stream().filter(i->i%2==0).toList().forEach(System.out::println);
        // below java 16 we have to use Collectors.toList() insteam toList but after java 16 we can use toList directly.

        //2. filter String longer than 5 characters:
        String[] strArray={"Deepak","Raj","Kshitij",""};
        List<String> finalList= Stream.of(strArray).filter(str ->str.length()>5).toList();
        System.out.println(finalList);

        //3. filter non null values from string list
        List<String> strList= new ArrayList<>();
        strList= Arrays.asList("Deepak","Raj","Kshitij","");
        strList.stream().filter(s -> s!=null).toList().forEach(System.out::println);
        //s!=null can be replaced with method reference as below
        strList.stream().filter(Objects::nonNull).toList().forEach(System.out::println);

        //4. filter name starts with D
        strList.stream().filter(str-> str.startsWith("D")).toList().forEach(System.out::println);

        // reverse String using Stream and check if pallindrome...
        String s2="MADAMM";
        String reversed=java.util.stream.IntStream.iterate(s2.length()-1,i->i>=0,i->i-1)
                .mapToObj(i-> String.valueOf(s2.charAt(i)))
                        .collect(Collectors.joining());
        System.out.println("Reversed String is "+reversed);
        System.out.println(s2.equalsIgnoreCase(reversed)?"\nString is Pallindrome":"String Not a Pallindrome");

        /* explanation of above..
        * IntStream.iterate(s2.length()-1, i -> i >= 0, i -> i - 1)
        Creates a stream of integers starting from the last index of the string (s2.length()-1) down to 0.
        <></>he lambda i -> i - 1 decrements the index each time.
        .mapToObj(i -> String.valueOf(s2.charAt(i)))
        For each index i, gets the character at that position in s2 and converts it to a String.
        .collect(Collectors.joining())
        Collects all the single-character strings into one string, effectively reversing the original string.*/

        //reverse String Instream Example....
        String s3="India";
        String reversedString2=  java.util.stream.IntStream.iterate(s3.length()-1, i->i>=0,i->i-1)
                .mapToObj(i->String.valueOf(s3.charAt(i)))
                .collect(Collectors.joining());
        System.out.println("\nrevered String  using Instream and collected as string..."+reversedString2);

        //reverese sentence...
        String sentence="Stream is powerful";//take ssentence then itrate it using Instream while iterating mapToObj then join as String using collect

           String[] words= sentence.split(" ");
             String  reverseSentence= java.util.stream.IntStream.iterate(words.length-1,i->i>=0,i->i-1)// using IntStream start iteration fron length-1 to >=0
                        .mapToObj(i-> words[i])//while iterating take each word from words array and map as object
                                .collect(Collectors.joining(" "));// collect adn join each words again with space
                                System.out.println("reversed sentence is "+reverseSentence);//print the same.

        //count vowel in string using Stream API
        String s5="Deepak kumaraaaoooOOO";
           long count= java.util.stream.IntStream.range(0,s5.length())
                    .mapToObj(i->s5.charAt(i))
                            .filter(ch-> "AEIOUaeiou".indexOf(ch)>=0)
                                    .count();
           System.out.println("No of vowels in String is "+count);

           /*---Use of range and iterate---
           // IntStream.range: generates 0, 1, 2, 3, 4
              java.util.stream.IntStream.range(0, 5).forEach(System.out::println);

            // IntStream.iterate: generates 10, 8, 6, 4, 2 (decrement by 2) - for any custom iteration logic
                java.util.stream.IntStream.iterate(10, i -> i > 0, i -> i - 2).forEach(System.out::println);
            */

        /*---------------------------*/
        System.out.println("\n--------------map() examples---------------------------------------------------------------");
        //Add 5 grace marks to each student
        //Here we have to add 5 marks to each oject adn we want some result then we can use map as below----

        System.out.println("\nAdd 5 grace marks to each marks object");
        ArrayList<Integer> marks= new ArrayList<Integer>();
        marks.add(20); marks.add(56); marks.add(90); marks.add(95);

        System.out.println("\nobejct before grace"+marks.stream().toList());
        System.out.println("\nObject After adding grace marks");
        marks.stream().map(m-> m+5).forEach(System.out::println);



        //-- map will add 5 marks to each obejct and return the same object length





    }


}

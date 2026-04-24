package com.example.demo.programs;

import java.util.HashMap;

public class StringPrograms {

    // Check if a string is a palindrome
    static boolean isPallindrome(String s) {
        // String s="MADAM";
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                System.out.println("Not a palindrome");
                return false;
            }
        }
        return true;
    }

    // To count occurrence of each character in a string.
    static int countOccurrence(String s, char c) {
        //return s.length() - s.replace(c,'').length();
        return s.length() - s.replace(String.valueOf(c), "").length();
    }

    public static void main(String[] args) {
        //String and Character Methods in Java:
        System.out.println("------String and Character Methods in Java testsss-----STARTS:");
        String str1= "JAVA DEVELOPER LIFE IS GOOD";
        System.out.println(str1.length());
        System.out.println(str1.charAt(6));
        System.out.println(str1.toCharArray());
        System.out.println(str1.substring(7));// 7th index will be included in the output
        System.out.println(str1.substring(5, 15));// 5th index will be included and 15th index will be excluded in the output
        System.out.println(str1.indexOf("DEVELOPER"));
        System.out.println(str1.indexOf(6));
        System.out.println(str1.indexOf('S'));
        System.out.println(str1.indexOf("DEVELOPER", 5));// 5th index will be the starting point of the search:
        // returns index of string if found or -1 if not found
        System.out.println(str1.lastIndexOf('e'));
        System.out.println(str1.lastIndexOf("GOOD"));


        System.out.println("------String and Character Methods in Java testsss-----ENDS:");


        // Check if a string is a palindrome
        boolean result = isPallindrome("MADAM");
        if (result) {
            System.out.println("It is a palindrome");
        }

        // Count occurrence of each character in a string.
        String s = "DEEPAK";
        char c = 'E';
        System.out.println("Occurrence of " + c + " in " + s + " is " + countOccurrence(s, c));

        // Count each character of a String in that string.
        System.out.println("------------------------------");
        String str = "BANANA";
        StringBuilder checkedCharsString = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (checkedCharsString.indexOf(String.valueOf(ch)) == -1) {
                int count = countOccurrence(str, ch);
                System.out.println("Occurrence of " + ch + " in " + str + " is " + count);
                checkedCharsString.append(ch);
            }
        }

        // count occurrence of each character in a string using HashMap
        String str2 = "HELLOWORLD";
        System.out.println("----------Ocurence uson ghashMap Starts--------------------");
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (char ch : str2.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }
        for (Character key : charCountMap.keySet()) {
            System.out.println("Occurrence of " + key + " in " + str2 + " is " + charCountMap.get(key));
        }
        System.out.println("----------Occurence using hashmap ENDS--------------------");

        // count


        //credx interview
       String s1= 10+20+"DEEPAK"+10+20;
        System.out.println(s1);



    }
}

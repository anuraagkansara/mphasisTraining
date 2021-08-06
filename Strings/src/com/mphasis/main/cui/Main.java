package com.mphasis.main.cui;

public class Main {

    public static void main(String[] args)
    {
        String string1 = new String("First");
        String string2 = new String("first");

        System.out.println(string1 == string2);
        System.out.println(string1.equalsIgnoreCase(string2));

    }
}

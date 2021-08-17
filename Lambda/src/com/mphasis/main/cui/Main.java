package com.mphasis.main.cui;

import java.util.logging.Level;
import java.util.logging.Logger;

interface Printer{                         //There should be only one method in the interface if you want to use lambda functions.
    public void print(String text);
}
interface Transformer{
	int transform(String str);
}
interface Aggregate{
	String combine(String str1, String str2);
}

public class Main {

    public static void main(String[] args) {
	    Printer printer1 = (str) -> System.out.println(str);
	    printer1.print("Mphasis");

	    Printer printer2 = System.out::println;   //This works only if function takes one argument
	    printer1.print("Jodhpur");

	    Printer printer3 = new Printer(){
	        @Override
            public void print(String str){
                System.out.println(str);
            }
        };
	    printer3.print("India");

		printing((str) -> System.out.println(str), "HEllo Wrold!!!");

	    new Thread(() -> System.out.println(Thread.currentThread())).start();

		printing(System.out::println, "Jaipur!");

		Printer printer4 = (str) -> Logger.getLogger(Main.class.getName()).log(Level.INFO,str);
		printer4.print("Printed using Logger");

		Transformer transformer = (text) -> Integer.valueOf(text);
		Transformer transformer2 = Integer::valueOf;                //This is possible only if method takes only one argument.
		System.out.println(transformer.transform("123"));
		System.out.println(transformer.transform("234"));

		Aggregate aggregate = (text1,text2) -> text1.concat(text2);
		String result = aggregate.combine("Hello", " world");
		System.out.println(result);

		/*
		Logging logger1 = (level,text) -> Logger.getLogger(Main.class.getName()).log(level,text);
		logger1.audit(Level.INFO, "Test1);
		Logging logger2 = Logger.getLogger(Main.class.getName())::log;
		 */
    }

    public static void printing(Printer printer, String text){
    	printer.print(text);
	}
}

package com.mphasis.main.cui;

import com.mphasis.types.Month;

import static com.mphasis.types.Month.*;


public class Main {

    public static void main(String[] args) {
	    Month month;
//	    month = Month.FEB;
        month = FEB;
	    if(month == FEB){
            System.out.println("Month is Feb");
        }

	    Month[] months = values();

	    for(Month x :months){
            System.out.println(x + " has " + x.getDays() + " days...");
        }
	    Month currMonth = valueOf("JAN");

	    if(currMonth == FEB)
            System.out.println("August");
	    else
            System.out.println("Not august");
    }
}

package com.mphasis.payroll;

public class Permanent extends Employee{    //Inheritance
    @Override
    public void netPay() {
        System.out.println("Permanent Employee's salary");
    }
    public void transportation(){
        System.out.println("Transportation Provided");
    }
}

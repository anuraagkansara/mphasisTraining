package com.mphasis.main.cui;

import com.mphasis.payroll.*;

public class Main {

    public static void main(String[] args) {

       // Employee employee = new Permanent(); //Upcast
        HR hr = new HR();
        Employee employee = hr.recruit('p');
        employee.netPay();  //Dynamic Polymorphism
//
        Finance finance = new Finance();
        finance.processSalary(employee);

        //employee = new Intern();      This is similar to line 21
//        employee.netPay();
        //finance.processSalary(employee);
//        finance.processSalary(new Intern()); //upcasting
//        finance.processSalary(new Contract());
        finance.processSalary(hr.recruit('i')); //upcasting
        finance.processSalary(hr.recruit('c'));
        finance.processSalary(hr.recruit('k'));


    }
}

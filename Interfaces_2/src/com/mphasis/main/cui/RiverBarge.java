package com.mphasis.main.cui;

public class RiverBarge extends Vehicle implements Sailer {


    @Override
    public void dock() {
        System.out.println("Inside RiverBarge dock");
    }

    @Override
    public void cruise() {
        System.out.println("Inside RiverBarge cruise");
    }

}

package com.mphasis.main.cui;

public class Airplane extends Vehicle implements Flyer{
    @Override
    public void takeOff(){
        System.out.println("Inside Airplane takeoff");
    }

    @Override
    public void fly() {
        System.out.println("Inside Airplane fly");
    }

    @Override
    public void land() {
        System.out.println("Inside Airplane land");
    }
}

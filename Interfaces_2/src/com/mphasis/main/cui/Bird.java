package com.mphasis.main.cui;

public class Bird extends Animal implements Flyer{
    @Override
    public void takeOff(){
        System.out.println("Inside Bird takeoff");
    }
    @Override
    public void land(){
        System.out.println("Inside Bird Land");
    }
    @Override
    public void fly(){
        System.out.println("Inside Bird Fly");
    }
    public void buildNest(){
        System.out.println("Inside Bird buildNest");
    }
    public void layEggs(){
        System.out.println("Inside Bird Layeggs");
    }
}

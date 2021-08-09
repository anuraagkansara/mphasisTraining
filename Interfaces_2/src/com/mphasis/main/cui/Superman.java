package com.mphasis.main.cui;

public class Superman extends Kryptonian implements Flyer{
    @Override
    public void takeOff() {
        System.out.println("Inside Superman takeoff");
    }

    @Override
    public void land() {
        System.out.println("Inside Superman land");
    }

    @Override
    public void fly() {
        System.out.println("Inside Superman fly");
    }

    public void leapBuilding(){
        System.out.println("Inside Superman leapBuilding");
    }
    public void stopBullet() {
        System.out.println("Inside Superman stopBullet");
    }
}

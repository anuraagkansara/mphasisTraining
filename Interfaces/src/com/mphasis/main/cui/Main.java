package com.mphasis.main.cui;

public class Main {

    public static void main(String[] args) {

        Flyer flyer = new Seaplane();
        flyer.takeOff();
        flyer.fly();
        flyer.land();

        Sailor sailor = (Sailor) flyer;
        sailor.sail();
        sailor.dock();
    }
}

package com.mphasis.main.cui;

public class SeaPlane extends Airplane implements Sailer{
    @Override
    public void dock() {
        System.out.println("Inside SeaPlane dock");
    }

    @Override
    public void cruise() {
        System.out.println("Inside SeaPlane cruise");
    }
}

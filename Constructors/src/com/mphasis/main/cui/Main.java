package com.mphasis.main.cui;

class Base1{
    public void test(){
        System.out.println("test in base1");
    }
}

class Base extends Base1{
    public void test(){
        System.out.println("test in Base");
    }
}
class Derived extends Base{
    @Override
    public void test(){
        super.test();
        System.out.println("test in Derived");
    }
}

public class Main {

    public static void main(String[] args) {
	    Derived derived = new Derived();
	    derived.test();
    }
}

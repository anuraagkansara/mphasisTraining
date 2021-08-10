package com.mphasis.main.cui;

import javax.swing.*;

class Test{
    static int value; //Class variable
//    int value2;       //Instance variable

    static {
        System.out.println("Inside static block");
        value=10;
    }

    Test(){
        System.out.println("Inside constructor");
    }

    { //Anonymous block
        System.out.println("Inside Inline");
    }
}

class Outer{
    static class Inner{
        int value;
    }
}

public class Main {

    public static void main(String[] args) {
        //Logger logger = Logger.getLogger(Main.class.getName());  //Used to substitute System.out.println()

//        Test.value = 96; //  Syntax : ClassName.variableName
//        System.out.println(Test.value);

        //JOptionPane.showMessageDialog(null,"ERRRRR !!!!!","Greetings!!",JOptionPane.ERROR_MESSAGE);
        new Test();

        Outer.Inner outerInner = new Outer.Inner();
        outerInner.value = 10;
    }
}

package com.mphasis.main.cui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class IllegalAgeException extends Exception{
    @Override
    public String getMessage() {
        return "Need to be 18+ for voting.";
    }
}

class Voter{
    public void register(int age) throws IllegalAgeException{
        if(age<18){
            throw new IllegalAgeException();
        }
    }
}
//------------------------------------------------------------------------
class Test{
    public void testing1() throws IllegalAgeException {
        testing2();
    }
    public void testing2() throws IllegalAgeException {
        testing3();
    }
    public void testing3() throws IllegalAgeException {
        new Voter().register(17);
        System.out.println("testing3");
    }
}
//___________________________________________________________________________
class Base{
    public void test() throws SQLException, IOException {

    }
}
class Derived extends Base{
    @Override
    public void test() throws FileNotFoundException {

    }
}
//____________________________________________________________________________

public class CustomException {
    private static final Logger logger;
    static{
        logger = Logger.getLogger(Main.class.getName());
    }
    public static void main(String[] args){
        logger.log(Level.INFO, "Begin");

        try{
            new Voter().register(17);    //use and throw object
        }catch (IllegalAgeException exception){
            logger.log(Level.SEVERE, ""+exception);
        }

        try {
            new Test().testing1();
        } catch (IllegalAgeException exception) {
            exception.printStackTrace();
        }
        //hello world

        Arithmetic arithmetic = new Arithmetic();
        int result = arithmetic.sum(3,2);

        assert result==5:"There is a problem in Arithmetic class function";    //Testing Assertions

        logger.log(Level.INFO, "End");
    }

}

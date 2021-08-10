package com.mphasis.main.cui;

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

        logger.log(Level.INFO, "Begin");
    }

}

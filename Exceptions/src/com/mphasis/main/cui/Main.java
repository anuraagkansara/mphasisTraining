package com.mphasis.main.cui;

import java.sql.SQLOutput;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Main {

    private static final Logger logger;
    static{
        logger = Logger.getLogger(Main.class.getName());
    }

    public static void main(String[] args) {
        logger.log(Level.INFO, "Begin");

        try{
            int firstNumber = Integer.parseInt(args[0]);
            int secondNumber = Integer.parseInt(args[1]);
            int result = firstNumber / secondNumber;
            System.out.println(result);
        }
        catch (ArrayIndexOutOfBoundsException exception)
        {
            logger.log(Level.SEVERE, "Index out of Bounds");
        }
        catch (NumberFormatException | ArithmeticException exception){                    //Multi catch statement clubbed using a pipe
            logger.log(Level.SEVERE, "Please provide valid  non-zero numbers");
        }
//        catch(ArithmeticException exception) {
//            logger.log(Level.SEVERE, "Arithmetic Exception");
//        }
        catch(Exception exception)
        {                                        //Default Exception Handler
            logger.log(Level.SEVERE, "Exception occurred "+exception);
        }
        finally {
            //statements that need to be executed no matter if the exception has happened or not.
            //Usually closing sockets, files, etc.
            //It is always executed.
            logger.log(Level.INFO, "End");
        }
    }
}

package com.mphasis.main.cui;

public class EmailService1 implements MessageService{

    @Override
    public boolean sendMessage(String message, String receipient) {
        System.out.println("Version 1: Email message " + message + " sent to " + receipient);
        return true;
    }
}

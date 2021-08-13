package com.mphasis.main.cui;

public class EmailService2 implements MessageService{

    public EmailService2(){
        System.out.println("Email Service 2 instantiated");
    }

    @Override
    public boolean sendMessage(String message, String receipient) {
        System.out.println("Version 2: Email message " + message + " sent to " + receipient);
        return true;
    }
}

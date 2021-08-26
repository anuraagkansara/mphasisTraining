package com.mphasis.main;

import com.mphasis.spring.entities.MessageService;

public class EmailService implements MessageService {

    private int port;

    public EmailService(){
        System.out.println("Email Service instantiated");
    }
    public void initTwitterService(){
        System.out.println("Email Service initialized");
    }
    @Override
    public boolean sendMessage(String message, String receipient) {
        System.out.println("Email message " + message + " sent to " + receipient);
        return true;
    }
    public void destroyingTwitterService(){
        System.out.println("Email Service destroyed");
    }
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}

package com.mphasis.main;

import com.mphasis.spring.entities.MessageService;

public class Twitter implements MessageService {

    public Twitter(){
        System.out.println("Twitter instantiated");
    }
    public void initTwitterService(){
        System.out.println("Twitter Service initialized");
    }

    @Override
    public boolean sendMessage(String message, String receipient) {
        System.out.println("Twitter message " + message + " sent to " + receipient);
        return true;
    }

    public void destroyingTwitterService(){
        System.out.println("Twitter Service destroyed");
    }
}

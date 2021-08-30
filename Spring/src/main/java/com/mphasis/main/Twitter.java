package com.mphasis.main;

import com.mphasis.spring.entities.MessageService;
import com.mphasis.utils.Audit;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Twitter implements MessageService {

    private static final Logger logger;
    static{
        logger = Logger.getLogger(Audit.class.getName());
    }
    public Twitter(){
        System.out.println("Twitter instantiated");
    }
    public void initTwitterService(){
        System.out.println("Twitter Service initialized");
    }

    @Override
    public boolean sendMessage(String message, String receipient) {
        logger.log(Level.INFO,"Twitter message "+message+" sent to "+receipient);
        return true;
    }

    public void destroyingTwitterService(){
        System.out.println("Twitter Service destroyed");
    }
}

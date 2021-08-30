package com.mphasis.main;

import com.mphasis.spring.entities.MessageService;
import com.mphasis.utils.Audit;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailService implements MessageService {

    private static final Logger logger;
    static{
        logger = Logger.getLogger(Audit.class.getName());
    }

    private int port;

//    public EmailService(){
//        System.out.println("Email Service instantiated");
//    }

    public void initEmailService(){
        System.out.println("Email Service initialized");
    }

    @Override
    public boolean sendMessage(String message, String receipient) {
        logger.log(Level.INFO,"Email message "+message+" sent to "+receipient);
//        System.out.println("Email message " + message + " sent to " + receipient);
        return false;
    }

    public void destroyingEmailService(){
        System.out.println("Email Service destroyed");
    }
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}

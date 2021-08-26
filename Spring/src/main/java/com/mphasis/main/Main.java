package com.mphasis.main;

import com.mphasis.spring.entities.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("config/Beans.xml"); //IoC container(Dependency Injection)
//        MessageService messageService = (MessageService) context.getBean("email");                             //Inversion of Control
//        messageService.sendMessage("This is an Email", "kansara@iitk.ac.in");
//
//        System.out.println(((EmailService)messageService).getPort());
////        messageService = (MessageService) context.getBean("email");                             //Inversion of Control
////        messageService.sendMessage("This is an Email", "123@iitk.ac.in");
////
////        messageService = (MessageService) context.getBean("email");                             //Inversion of Control
////        messageService.sendMessage("This is an Email", "qwe@iitk.ac.in");
//
//        MessageService messageService1 = (MessageService) context.getBean("twitter");                             //Inversion of Control
//        messageService1.sendMessage("This is a Twitter", "kansara@iitk.ac.in");
//
//        ((FileSystemXmlApplicationContext)context).registerShutdownHook(); //graceful ending of Twitter destroy method

        TextEditor textEditor = (TextEditor)context.getBean("textEditor");
        textEditor.getSpellChecker().checkSpelling();

        JavaCollection jc=(JavaCollection)context.getBean("javaCollection");

        jc.getAddressList();
        jc.getAddressSet();
        jc.getAddressMap();
        jc.getAddressProp();
    }
}

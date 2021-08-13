package com.mphasis.main.cui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/Beans.xml"); //IoC container(Dependency Injection)
        MessageService messageService = (MessageService) context.getBean("email");
        messageService.sendMessage("This is an Email", "kansara@iitk.ac.in");
    }
}

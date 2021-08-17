package com.mphasis.main.cui;

import java.io.File;

public class Main {

    public static void main(String[] args) {
	    File file = new File("src/test");
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

    }
}

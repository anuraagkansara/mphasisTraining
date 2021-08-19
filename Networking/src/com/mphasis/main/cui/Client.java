package com.mphasis.main.cui;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        try {
           socket =  new Socket("DESKTOP-3THRRN6", 5678);
            System.out.println("Connected to server");

            InputStream is = socket.getInputStream();
            BufferedReader dis = new BufferedReader(new InputStreamReader(is));
            System.out.println(dis.readLine());
            System.out.println("Response obtained");
//            dis.close();
//            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

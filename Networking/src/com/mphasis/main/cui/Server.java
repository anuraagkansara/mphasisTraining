package com.mphasis.main.cui;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(5678);
        ) {
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Server started...");
                System.out.println("Client connected");
                System.out.println(socket.getInetAddress());

                OutputStream s1out = socket.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s1out));

                bw.write("Hello Net World!!\n");
                bw.flush();
                System.out.println("response sent");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

package com.mphasis.main.cui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) {

        try {
            AuthenticationRemoteImpl authenticationRemote = new AuthenticationRemoteImpl();
            //registering the object in RMI
            Naming.rebind("rmi:///Authentication",authenticationRemote);
            System.out.println("Remote Object Registered");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }

    }
}

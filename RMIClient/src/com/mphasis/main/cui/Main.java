package com.mphasis.main.cui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) {
	    //RMI listens on 1099 port number
        try {
            AuthenticationRemote remoteAuthentication =  (AuthenticationRemote)Naming.lookup("rmi://DESKTOP-3THRRN6/Authentication");
            boolean status = remoteAuthentication.validateCredentials("Anuraag","123");
            System.out.println(status);
        } catch (NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}

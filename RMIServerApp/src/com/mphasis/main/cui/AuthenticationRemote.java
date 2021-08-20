package com.mphasis.main.cui;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AuthenticationRemote extends Remote {
    boolean validateCredentials(String username, String password) throws RemoteException;
    //need to implement Serializable if parameter or return type is a class, if it is primitive, no need
    //every interface method in RMI needs to throw   RemoteException
}

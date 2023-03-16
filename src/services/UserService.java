package services;

import java.io.IOException;
import java.net.ProtocolException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {
    void getInfo() throws RemoteException, IllegalAccessException;
    void updateInfo() throws RemoteException, IllegalAccessException;
}

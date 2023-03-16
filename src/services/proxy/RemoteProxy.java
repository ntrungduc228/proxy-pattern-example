package services.proxy;

import services.UserService;
import java.io.IOException;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RemoteProxy implements UserService {

    private UserService userService;

    public RemoteProxy(String remoteServiceURL) throws MalformedURLException, RemoteException, NotBoundException {
        this.userService = (UserService) Naming.lookup(remoteServiceURL);
    }

    @Override
    public void getInfo() throws IllegalAccessException, RemoteException {
        this.userService.getInfo();
    }

    @Override
    public void updateInfo() throws IllegalAccessException, RemoteException {
        this.userService.updateInfo();
    }

}
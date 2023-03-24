package services.proxy;

import services.UserService;
import services.UserServiceImpl;

import java.io.IOException;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteProxy implements UserService {
    private final UserService userService;
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
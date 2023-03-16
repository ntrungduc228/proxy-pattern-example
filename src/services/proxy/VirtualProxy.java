package services.proxy;

import services.UserService;
import services.UserServiceImpl;

import java.io.IOException;
import java.rmi.RemoteException;

public class VirtualProxy implements UserService {
    private UserService userService;
    @Override
    public void getInfo() throws IllegalAccessException, RemoteException {
        if(userService == null){
            userService = new UserServiceImpl();
        }

        userService.getInfo();
    }

    @Override
    public void updateInfo() throws IllegalAccessException, RemoteException {
        if(userService == null){
            userService = new UserServiceImpl();
        }

        userService.updateInfo();
    }
}
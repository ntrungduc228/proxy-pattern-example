package services.proxy;

import services.UserService;
import services.UserServiceImpl;

import java.io.IOException;
import java.rmi.RemoteException;

public class ProtectionProxy implements UserService{
    private final String role;
    private final UserService userService;

    public ProtectionProxy(String role) {
        this.role = role;
        this.userService = new UserServiceImpl();
    }

    @Override
    public void getInfo() throws IllegalAccessException, RemoteException {
        if ((isAdmin())){
            userService.getInfo();
        }else {
            throw new IllegalAccessException("Access denied");
        }
    }

    @Override
    public void updateInfo() throws IllegalAccessException, RemoteException {
        if ((isAdmin())){
            userService.updateInfo();
        }else {
            throw new IllegalAccessException("Access denied");
        }
    }

    private boolean isAdmin() {
        return "admin".equalsIgnoreCase(this.role);
    }

}
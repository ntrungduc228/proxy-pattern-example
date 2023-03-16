package services.proxy;

import services.UserService;
import services.UserServiceImpl;

import java.io.IOException;

public class ProtectionProxy implements UserService{
    private String role;
    private UserService userService;

    public ProtectionProxy(String role) {
        this.role = role;
        this.userService = new UserServiceImpl();
    }

    @Override
    public void getInfo() throws IllegalAccessException, IOException {
        if ((isAdmin())){
            userService.getInfo();
        }else {
            throw new IllegalAccessException("Access denied");
        }
    }

    @Override
    public void updateInfo() throws IllegalAccessException {
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
package services.proxy;

import services.UserService;
import services.UserServiceImpl;

import java.io.IOException;

public class VirtualProxy implements UserService {
    private UserService userService;
    @Override
    public void getInfo() throws IOException, IllegalAccessException {
        if(userService == null){
            userService = new UserServiceImpl();
        }

        userService.getInfo();
    }

    @Override
    public void updateInfo() throws IllegalAccessException {
        if(userService == null){
            userService = new UserServiceImpl();
        }

        userService.updateInfo();
    }
}
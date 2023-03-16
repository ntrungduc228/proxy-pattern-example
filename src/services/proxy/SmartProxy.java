package services.proxy;

import services.UserService;

import java.io.IOException;
import java.lang.ref.Cleaner;

public class SmartProxy  implements UserService {
   private  UserService userService;
   private int count;
    public SmartProxy(UserService userService) {
        this.userService = userService;
        this.count = 0;
    }
    public void removeReference() {
        this.count--;
        if (this.count == 0) {
            this.userService = null;
            System.out.println("RealObject has been deleted.");
        }
    }

    @Override
    public void getInfo() throws IOException, IllegalAccessException {
        this.count += 1;
        this.userService.getInfo();
    }
    @Override
    public void updateInfo() throws IllegalAccessException {
    }
}
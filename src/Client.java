import services.UserService;
import services.UserServiceImpl;
import services.proxy.SmartProxy;

import java.io.IOException;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) throws IOException, IllegalAccessException {

        System.out.println("VIRTUAL PROXY");


        System.out.println("PROTECTION PROXY");
        System.out.println("SMART PROXY");
        UserService user = new UserServiceImpl();
        SmartProxy userProxy = new SmartProxy(user);
        userProxy.getInfo();
        userProxy.getInfo();
        userProxy.removeReference();
        userProxy.removeReference();
        userProxy.getInfo();
        System.gc();
        System.out.println("REMOTE PROXY");
    }
}
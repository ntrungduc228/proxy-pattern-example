import services.UserService;
import services.UserServiceImpl;
import services.proxy.ProtectionProxy;
import services.proxy.RemoteProxy;
import services.proxy.SmartProxy;
import services.proxy.VirtualProxy;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Client {
    void demoSmartProxy() throws RemoteException, IllegalAccessException {
        System.out.println("SMART PROXY");
        UserService user = new UserServiceImpl();
        SmartProxy userProxy = new SmartProxy(user);
        userProxy.getInfo();
        userProxy.getInfo();
        userProxy.removeReference();
        userProxy.removeReference();
        userProxy.getInfo();
    }

    void demoVirtualProxy() throws RemoteException, IllegalAccessException {
        System.out.println("VIRTUAL PROXY");
        VirtualProxy userProxy = new VirtualProxy();
        userProxy.getInfo();
        userProxy.getInfo();
    }

    void demoProtectionProxy() throws RemoteException, IllegalAccessException {
        System.out.println("PROTECTION PROXY");
        ProtectionProxy adminProxy = new ProtectionProxy("admin");
        adminProxy.getInfo();

        ProtectionProxy userProxy = new ProtectionProxy("user");
        userProxy.getInfo();
    }

    void demoRemoteProxy() throws RemoteException, MalformedURLException, NotBoundException, IllegalAccessException {
        System.out.println("REMOTE PROXY");
        UserService userService = new UserServiceImpl();
        UserService stub = (UserService) UnicastRemoteObject.exportObject(userService, 0);
        // Create and start the RMI registry
        LocateRegistry.createRegistry(8080);

        // Bind the remote object to the registry
        Naming.rebind("rmi://localhost:8080/UserService", stub);

        RemoteProxy remoteProxy = new RemoteProxy("rmi://localhost:8080/UserService");
        // Call the getInfo() method on the RemoteProxy
        remoteProxy.getInfo();
        // Call the updateInfo() method on the RemoteProxy
        remoteProxy.updateInfo();
    }

    public static void main(String[] args) throws IOException, IllegalAccessException, NotBoundException {
        Client client = new Client();
//        client.demoRemoteProxy();
//    client.demoVirtualProxy();
//    client.demoProtectionProxy();
    client.demoSmartProxy();

    }
}
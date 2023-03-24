import services.*;
import services.proxy.ProtectionProxy;
import services.proxy.RemoteProxy;
import services.proxy.SmartProxy;
import services.proxy.VirtualProxy;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    void demoSmartProxy() throws RemoteException, IllegalAccessException {
        System.out.println("SMART PROXY");
        SmartProxy userProxy = new SmartProxy();
        userProxy.getInfo();
        userProxy.getInfo();
        userProxy.removeReference();
        userProxy.removeReference();
        userProxy.getInfo();
    }

    void demoVirtualProxy() throws RemoteException, IllegalAccessException {
        System.out.println("VIRTUAL PROXY");
        VirtualProxy userProxy = new VirtualProxy();
        System.out.println("after call getInfo");
        userProxy.getInfo();
        userProxy.getInfo();
    }

    void demoProtectionProxy() throws RemoteException, IllegalAccessException {
        System.out.println("PROTECTION PROXY");
        ProtectionProxy adminProxy = new ProtectionProxy("admin");
        adminProxy.getInfo();

        System.out.println("--------------------------------------");

        ProtectionProxy userProxy = new ProtectionProxy("user");
        userProxy.getInfo();
    }

    void demoRemoteProxy() throws RemoteException, MalformedURLException, NotBoundException, IllegalAccessException {
        System.out.println("REMOTE PROXY");
        RemoteProxy remoteProxy = new RemoteProxy("rmi://localhost:8080/UserService");
        remoteProxy.getInfo();
        remoteProxy.updateInfo();
    }

    void demoImageProxy() throws InterruptedException {
        Image image1 = new RealImage("demo/image1.jpeg");
        System.out.println("--------user click to show image 1--------------");
        image1.showImage();

        Image image2 = new RealImage("demo/image2.jpeg");

        System.out.println("-----------using proxy-------");
        Image image3 = new ImageProxy("demo/image3.jpeg");
        Image image4 = new ImageProxy("demo/image4.jpeg");
        System.out.println("--------user click to show image 3--------------");
        image3.showImage();
    }



    public static void main(String[] args) throws IOException, IllegalAccessException, NotBoundException, InterruptedException {
        Client client = new Client();
        client.demoImageProxy();
//        client.demoRemoteProxy();
//    client.demoVirtualProxy();
//    client.demoProtectionProxy();
//    client.demoSmartProxy();

    }
}
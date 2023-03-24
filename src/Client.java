import services.*;
import services.proxy.ProtectionProxy;
import services.proxy.RemoteProxy;
import services.proxy.SmartProxy;
import services.proxy.VirtualProxy;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public static void main(String[] args) throws IllegalAccessException {

        System.out.println("Test user1");
        System.out.println("Init proxy image: ");
        ProxyImage proxyImage = new ProxyImage("http://demoimage.com/image1.png", "user1");

        System.out.println("---");
        System.out.println("Call real service 1: ");
        proxyImage.showImage();

        System.out.println("---");
        System.out.println("Call real service 2: ");
        proxyImage.showImage();

        System.out.println("---------------------");

        System.out.println("Test user2");
        System.out.println("Init proxy image: ");
        ProxyImage proxyImage2 = new ProxyImage("http://demoimage.com/image1.png", "user2");

        System.out.println("---");
        System.out.println("Call real service 1: ");
        proxyImage2.showImage();


    }
}
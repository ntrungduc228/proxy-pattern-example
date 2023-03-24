
import java.io.IOException;

import java.rmi.NotBoundException;


public class Client {
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
        System.out.println("--------show  show image 3 again --------------");
        image3.showImage();
    }

    public static void main(String[] args) throws IOException, IllegalAccessException, NotBoundException, InterruptedException {
        Client client = new Client();
        client.demoImageProxy();
    }
}
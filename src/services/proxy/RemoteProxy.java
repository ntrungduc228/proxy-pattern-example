package services.proxy;

import services.UserService;
import services.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class RemoteProxy implements UserService {
    private String url;
    private UserService userService;

    public RemoteProxy(String url) {
        this.url = url;
        this.userService = new UserServiceImpl();
    }

    @Override
    public void getInfo() throws IOException {
        URL url = new URL(this.url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String response = in.readLine();
        System.out.println("response " + response);
        in.close();
    }

    @Override
    public void updateInfo() throws IllegalAccessException {

    }

}
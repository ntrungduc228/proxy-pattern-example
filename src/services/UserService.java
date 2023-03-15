package services;

import java.io.IOException;
import java.net.ProtocolException;

public interface UserService {
    void getInfo() throws IOException, IllegalAccessException;

    void updateInfo() throws IllegalAccessException;
}

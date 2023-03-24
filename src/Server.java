import services.UserService;
import services.UserServiceImpl;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException, IllegalAccessException {
        UserService remoteObj = (UserService) UnicastRemoteObject.exportObject(new UserServiceImpl(), 0);
        Registry registry = LocateRegistry.createRegistry(8080);
        registry.rebind("UserService", remoteObj);
        UserService remote = (UserService) Naming.lookup("rmi://localhost:8080/UserService");
        remote.updateInfo();
    }
}

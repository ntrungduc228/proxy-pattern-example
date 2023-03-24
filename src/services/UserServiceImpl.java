package services;

public class UserServiceImpl implements UserService{

    public UserServiceImpl() {
        System.out.println("Create real object");
    }

    @Override
    public void getInfo() {
        System.out.println("Get info from UserServiceImpl");
    }

    @Override
    public void updateInfo() {
        System.out.println("Update info from UserServiceImpl");
    }

}
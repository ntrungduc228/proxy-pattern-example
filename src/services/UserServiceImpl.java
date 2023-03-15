package services;

public class UserServiceImpl implements UserService{
    @Override
    public void getInfo() {
        System.out.println("Get info from UserServiceImpl");
    }

    @Override
    public void updateInfo() {
        System.out.println("Update info from UserServiceImpl");
    }
}
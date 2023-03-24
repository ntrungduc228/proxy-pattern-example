import java.util.HashMap;
import java.util.Map;

public class User {
    private static Map<String, String> users = new HashMap<String, String>();

     static {
            users.put("user1", "admin");
            users.put("user2", "user");
            users.put("user3", "user");
    }

    public static boolean isAdmin(String username){
        if(users.containsKey(username)){
            return users.get(username).equalsIgnoreCase("admin");
        }
        return false;
    }

    public static boolean isUser(){

        return false;
    }
}
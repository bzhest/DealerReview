package utilityHelpers.data.user;

import utilityHelpers.data.api.UserDataMapper;

/**
 * Created by SYSTEM on 04.05.2017.
 */
public class TestApp {
    public static void main(String[] args) {
        UserDataMapper udm = new FileUserDataMapper();
        User user = udm.getUserByName("Lena");
        login(user);

        User user2 = udm.getUserByEmail("test_5@dxloo.com");
        login(user2);
    }
    public static void login(User user){
        System.out.println("User name: " + user.getUserName());
        System.out.println("User email: " + user.getEmail());
        System.out.println("User location: " + user.getLocation());
        System.out.println("User title: " + user.getTitle());
        System.out.println("User name: " + user.getText());
    }

}

package utilityHelpers.data.user;

import utilityHelpers.data.api.UserDataMapper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SYSTEM on 04.05.2017.
 */
public class FileUserDataMapper implements UserDataMapper {

    private List<User> users;

    public FileUserDataMapper() {
        users = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("reviews.txt")));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                users.add(new User(
                        strLine.split(",")[0],
                        strLine.split(",")[1],
                        strLine.split(",")[2],
                        strLine.split(",")[3],
                        strLine.split(",")[4]));
            }
            br.close();
        } catch (IOException ex) {

        }
    }

    @Override
    public User getUserByName(String name) {
       for (User u: users){
           if (u.getUserName().equals(name))
               return u;
       }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        for (User u: users){
            if (u.getEmail().equals(email))
                return u;
        }
        return null;
    }
}

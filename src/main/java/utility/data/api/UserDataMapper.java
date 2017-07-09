package utility.data.api;

import utility.data.user.User;

/**
 * Created by SYSTEM on 04.05.2017.
 */
public interface UserDataMapper {
    User getUserByName(String name);
    User getUserByEmail (String email);
}

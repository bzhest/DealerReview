package utility.data;

/**
 * Created by SYSTEM on 04.05.2017.
 */
public interface UserDataMapper {
    User getUserByName(String name);
    User getUserByEmail (String email);
}

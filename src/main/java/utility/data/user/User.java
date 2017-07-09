package utility.data.user;

/**
 * Created by SYSTEM on 04.05.2017.
 */
public class User {
    private String userName;
    private String email;
    private  String location;
    private  String title;
    private  String text;


    public User(String userName, String email, String location, String title, String text) {
        this.userName = userName;
        this.email = email;
        this.location = location;
        this.title = title;
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

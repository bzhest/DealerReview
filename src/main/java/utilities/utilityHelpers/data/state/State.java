package utilities.utilityHelpers.data.state;

/**
 * Created by Andrey on 08.07.2017.
 */
public class State {
    private String fullName;
    private String shortName;


    public State(String fullName, String shortName) {
        this.fullName = fullName;
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "State{" +
                "fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}

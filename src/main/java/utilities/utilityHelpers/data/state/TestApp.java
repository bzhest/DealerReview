package utilities.utilityHelpers.data.state;

import utilities.utilityHelpers.data.api.StateDataMapper;

/**
 * Created by Andrey on 08.07.2017.
 */
public class TestApp {
    public static void main(String[] args) {
        StateDataMapper file = new FileStateDateMapper();
        State state = file.getStateObjectByFullName("Hawaii");
        System.out.println(state.getShortName());
    }
}

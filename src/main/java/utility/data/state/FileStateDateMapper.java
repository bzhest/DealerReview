package utility.data.state;

import utility.data.api.StateDataMapper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrey on 08.07.2017.
 */
public class FileStateDateMapper implements StateDataMapper {

    private List<State> states;

    public FileStateDateMapper(){
        states = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/files/states.txt")));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                states.add(new State(
                        strLine.split(",")[0].toUpperCase(),
                        strLine.split(",")[1]));
            }

            br.close();
        }catch(IOException ex){

        }
    }


    @Override
    //With Java 8;
    public State getStateObjectByFullName(String fullName) {
        State result;
        result = states.stream()
                .filter( p -> p.getFullName().equals(fullName))
                .findFirst()
                .orElse(null);
        return result;
    }

    @Override
    //Without Java 8
    public State getStateObjectByShortName(String shortName) {
        for (State state : states){
            if(state.getShortName().equals(shortName))
                return state;
        }
        return null;
    }
}

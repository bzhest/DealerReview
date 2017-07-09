package utility.data.api;

import utility.data.state.State;

/**
 * Created by Andrey on 08.07.2017.
 */
public interface StateDataMapper {
    State getSateByFullName(String fullName);
    State getSateByShortName(String shortName);
}

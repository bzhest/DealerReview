package utilities.utilityHelpers.data.api;

import utilities.utilityHelpers.data.state.State;

/**
 * Created by Andrey on 08.07.2017.
 */
public interface StateDataMapper {
    State getStateObjectByFullName(String fullName);
    State getStateObjectByShortName(String shortName);
}

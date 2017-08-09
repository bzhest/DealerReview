package utilityHelpers.data.api;

import utilityHelpers.data.state.State;

/**
 * Created by Andrey on 08.07.2017.
 */
public interface StateDataMapper {
    State getStateObjectByFullName(String fullName);
    State getStateObjectByShortName(String shortName);
}

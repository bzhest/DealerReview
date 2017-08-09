package utilityProject.browser.enums;

/**
 * Created by Andrey on 29.04.2017.
 */
public enum RunOn {
    LOCAL,
    CLOUD,
    BUILDSERVER;

    public static RunOn fromString(String runOn){
        return valueOf(runOn.toUpperCase());
    }
}

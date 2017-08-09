package utilityProject.browser.enums;

/**
 * Created by Andrey on 29.04.2017.
 */
public enum BrowserType {
    CHROME,
    MOZILLA,
    IE,
    SAFARI;

    public  static BrowserType fromString (String type){
        return valueOf(type.toUpperCase());
    }
}

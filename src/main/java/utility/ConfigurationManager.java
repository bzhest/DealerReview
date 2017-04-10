package utility;

import dms.DmsLoginForm;
import dms.DmsMainPage;
import dmsDealerReviews.SettingsReviewDealershipReviewSettings;
import dmsDealerReviews.ToolsReviewsDealerReviewsPage;
import dwsDealerReviews.DealerReviewDWS;
import org.openqa.selenium.WebDriver;
import settings.Users;

/**
 * Created by SYSTEM on 04.04.2017.
 */
public class ConfigurationManager {

    private ToolsReviewsDealerReviewsPage toolsReviewsDealerReviewsPage;
    private WebDriver driver;
    private SettingsReviewDealershipReviewSettings settingsReviewDealershipReviewSettings;
    private DmsMainPage dmsMainPage;
    private DmsLoginForm dmsLoginForm;
    private DealerReviewDWS dealerReviewDWS;
    private Users users;
    //From my curses --------------------------------------------------------------------------------------------
    private static ConfigurationManager instance = null;


    public static ConfigurationManager getInstance(){
        if (instance ==null)
            instance = new ConfigurationManager();
        return instance;
    }

    private ConfigurationManager(){}

    public String getTestBrowser(){
        return getEnvironmentVariableOrDefault("testBrowser", "chrome");
    }

    public String getTestEnv(){
        return getEnvironmentVariableOrDefault("testEnv", "production");
    }

    private String getEnvironmentVariableOrDefault(String envVar, String defaultValue){
        return System.getenv(envVar) != null ? System.getenv(envVar) : defaultValue;
    }
//-------------------------------------------------------------------------------------------------------------------------
    public ToolsReviewsDealerReviewsPage getToolsReviewsDealerReviewsPage() {
        return toolsReviewsDealerReviewsPage;
    }

    public void setToolsReviewsDealerReviewsPage(ToolsReviewsDealerReviewsPage toolsReviewsDealerReviewsPage) {
        this.toolsReviewsDealerReviewsPage = toolsReviewsDealerReviewsPage;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public SettingsReviewDealershipReviewSettings getSettingsReviewDealershipReviewSettings() {
        return settingsReviewDealershipReviewSettings;
    }

    public void setSettingsReviewDealershipReviewSettings(SettingsReviewDealershipReviewSettings settingsReviewDealershipReviewSettings) {
        this.settingsReviewDealershipReviewSettings = settingsReviewDealershipReviewSettings;
    }

    public DmsMainPage getDmsMainPage() {
        return dmsMainPage;
    }


    public void setDmsMainPage(DmsMainPage dmsMainPage) {
        this.dmsMainPage = dmsMainPage;
    }

    public DmsLoginForm getDmsLoginForm() {
        return dmsLoginForm;
    }

    public void setDmsLoginForm(DmsLoginForm dmsLoginForm) {
        this.dmsLoginForm = dmsLoginForm;
    }

    public DealerReviewDWS getDealerReviewDWS() {
        return dealerReviewDWS;
    }

    public void setDealerReviewDWS(DealerReviewDWS dealerReviewDWS) {
        this.dealerReviewDWS = dealerReviewDWS;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

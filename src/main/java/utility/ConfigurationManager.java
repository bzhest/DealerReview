package utility;

import dms.DmsLoginForm;
import dms.DmsMainPage;
import dmsDealerReviews.SettingsReviewDealershipReviewSettings;
import dmsDealerReviews.ToolsReviewsDealerReviewsPage;
import dwsDealerReviews.DealerReviewDWS;
import org.openqa.selenium.WebDriver;
import page.Page;
import settings.UserEditor;
import settings.Users;
import settings.Website;

/**
 * Created by SYSTEM on 04.04.2017.
 */
public class ConfigurationManager {

    private ToolsReviewsDealerReviewsPage toolsReviewsDealerReviewsPage;
    //private WebDriver driver;
    private SettingsReviewDealershipReviewSettings settingsReviewDealershipReviewSettings;
    private DmsMainPage dmsMainPage;
    private DmsLoginForm dmsLoginForm;
    private DealerReviewDWS dealerReviewDWS;
    private Users users;
    private UserEditor userEditor;
    private Website website;
    private Page page;
    //From my curses --------------------------------------------------------------------------------------------
    private static ConfigurationManager instance=null;


    public static ConfigurationManager getInstance(){
        if (instance ==null)
            instance = new ConfigurationManager();
        return instance;
    }

    public ConfigurationManager(){}

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
        if(toolsReviewsDealerReviewsPage == null){
            toolsReviewsDealerReviewsPage = new ToolsReviewsDealerReviewsPage(this);
        }
        return toolsReviewsDealerReviewsPage;
    }

    public SettingsReviewDealershipReviewSettings getSettingsReviewDealershipReviewSettings() {
        if (settingsReviewDealershipReviewSettings ==null){
            settingsReviewDealershipReviewSettings = new SettingsReviewDealershipReviewSettings(this);
        }
        return settingsReviewDealershipReviewSettings;
    }

    /*public WebDriver getDriver() {
        return driver;
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }*/
    public DmsMainPage getDmsMainPage() {
        if(dmsMainPage == null){
            dmsMainPage = new DmsMainPage(this);
        }
        return dmsMainPage;
    }
    /*public DmsLoginForm getDmsLoginForm() {
        return dmsLoginForm;
    }*/
    public DealerReviewDWS getDealerReviewDWS() {
        if(dealerReviewDWS == null){
            dealerReviewDWS = new DealerReviewDWS(this);
        }
        return dealerReviewDWS;
    }


    public Users getUsers() {
        if(users ==null){
            users = new Users(this);
        }
        return users;
    }


    public UserEditor getUserEditor() {
        if(userEditor == null){
            userEditor = new UserEditor(this);
        }
        return userEditor;
    }

    public Website getWebsite() {return website;}
    public Page getPage() {
        if(page == null){
            page = new Page(this);}return page;}

    public DmsLoginForm getDmsLoginForm(){
        if(dmsLoginForm == null){
            dmsLoginForm = new DmsLoginForm(this);}return dmsLoginForm;}


}

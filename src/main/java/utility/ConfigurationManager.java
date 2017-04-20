package utility;

import dms.DmsLoginForm;
import dms.DmsMainPage;
import dmsDealerReviews.SettingsReviewDealershipReviewSettings;
import dmsDealerReviews.ToolsReviewsDealerReviewsPage;
import dwsDealerReviews.DealerReviewDWS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.Page;
import settings.UserEditor;
import settings.Users;
import settings.Website;

import static org.testng.Assert.fail;

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
    private UserEditor userEditor;
    private Website website;
    private Page page;
    //From my curses --------------------------------------------------------------------------------------------
    private static ConfigurationManager instance;
    public StringBuffer verificationErrors = new StringBuffer();

public ConfigurationManager(WebDriver driver){
     dmsLoginForm = new DmsLoginForm(driver);
     page = new Page(driver);
    dmsMainPage = new DmsMainPage(driver);
    dealerReviewDWS = new DealerReviewDWS(driver);
    users = new Users (driver);
    userEditor = new UserEditor(driver);
    website = new Website(driver);



 }


    public static ConfigurationManager getInstance(WebDriver driver){
        if (instance ==null)
            instance = new ConfigurationManager(driver);
        return instance;
    }

    //public ConfigurationManager(){}

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
    public DmsLoginForm getDmsLoginForm(WebDriver driver){
    if(dmsLoginForm == null){
        dmsLoginForm = new DmsLoginForm(driver);

    }
    return dmsLoginForm;
}

    public ToolsReviewsDealerReviewsPage getToolsReviewsDealerReviewsPage(WebDriver driver) {
        if(toolsReviewsDealerReviewsPage == null){
            toolsReviewsDealerReviewsPage = new ToolsReviewsDealerReviewsPage(driver);
        }
        return toolsReviewsDealerReviewsPage;
    }

    public SettingsReviewDealershipReviewSettings getSettingsReviewDealershipReviewSettings(WebDriver driver) {
        if (settingsReviewDealershipReviewSettings ==null){
            settingsReviewDealershipReviewSettings = new SettingsReviewDealershipReviewSettings(driver);
        }
        return settingsReviewDealershipReviewSettings;
    }


    public DmsMainPage getDmsMainPage(WebDriver driver) {
        if(dmsMainPage == null){
            dmsMainPage = new DmsMainPage(driver);
        }
        return dmsMainPage;
    }
    /*public DmsLoginForm getDmsLoginForm() {
        return dmsLoginForm;
    }*/
    public DealerReviewDWS getDealerReviewDWS(WebDriver driver) {
        if(dealerReviewDWS == null){
            dealerReviewDWS = new DealerReviewDWS(driver);
        }
        return dealerReviewDWS;
    }


    public Users getUsers(WebDriver driver) {
        if(users ==null){
            users = new Users(driver);
        }
        return users;
    }


    public UserEditor getUserEditor(WebDriver driver) {
        if(userEditor == null){
            userEditor = new UserEditor(driver);
        }
        return userEditor;
    }

    public Website getWebsite(WebDriver driver){
        if (website == null)
            website = new Website(driver);
        return website;
    }

    public Page getPage(WebDriver driver) {
        if(page == null){
            page = new Page(driver);
        }return page;}

        //stop driver

}

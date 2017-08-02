
package utility.config;

import dealerList.components.ZipPopUp;
import dealerList.page.DealerList;
import dms.DmsLoginForm;
import dms.DmsMainPage;
import dmsDealerReviews.SettingsReviewDealershipReviewSettings;
import dmsDealerReviews.ToolsReviewsDealerReviewsPage;
import dealerReviewForm.DealerReviewForm;
import loginForm.LoginForm;
import map2.Map2MainPage;
import map2.PageEditor;
import map2.PreviewPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.Page;
import settings.users.userEditor.page.UserEditor;
import settings.users.Users;
import settings.website.Website;
import utility.browser.users.DefaultWebDriverManager;
import utility.logger.FileLogger;
import utility.logger.api.LogBaseNew;
import utility.logger.StdLogger;

/**
 * Created by SYSTEM on 04.04.2017.
 */
public class  ConfigurationManager {

    private ToolsReviewsDealerReviewsPage toolsReviewsDealerReviewsPage;
    private WebDriver driver;
    private SettingsReviewDealershipReviewSettings settingsReviewDealershipReviewSettings;
    private DmsMainPage dmsMainPage;
    private DmsLoginForm dmsLoginForm;
    private DealerReviewForm dealerReviewDWS;
    private Users users;
    private UserEditor userEditor;
    private Website website;
    private Page page;
    private static ConfigurationManager instance;
    public StringBuffer verificationErrors = new StringBuffer();
    private FileLogger fileLogger;
    private StdLogger stdlogger;
    private Map2MainPage map2MainPage;
    private PageEditor pageEditor;
    private PreviewPage previewPage;
    private DealerList dealerList;
    private ZipPopUp zipPopUp;
    private LoginForm loginForm;
    //From my curses --------------------------------------------------------------------------------------------
    private static final String TEST_BROWSER = "testBrowser";
    private static final String RUN_ON = "runOn";

    public ConfigurationManager() {
        DefaultWebDriverManager defaultWebDriverManager = new DefaultWebDriverManager();
    }

    public ConfigurationManager(WebDriver driver) {
        this.driver = driver;
        //dmsLoginForm = new DmsLoginForm(driver);
       // page = new Page(driver);
       // dmsMainPage = new DmsMainPage(driver);
       // dealerReviewDWS = new DealerReviewForm(driver);
       // users = new Users(driver);
       // userEditor = new UserEditor(driver);
       // website = new Website(driver);
    }

    public static ConfigurationManager getInstance(WebDriver driver) {
        if (instance == null)
            instance = new ConfigurationManager(driver);
        return instance;
    }

    public static ConfigurationManager getInstance() {
        if (instance == null)
            instance = new ConfigurationManager();
        return instance;
    }

    //public ConfigurationManager(){}

    public String getTestBrowser() {
        return getEnvironmentVariableOrDefault(TEST_BROWSER, "chrome");
    }

    public String getTestEnv() {
        return getEnvironmentVariableOrDefault("testEnv", "production");
    }

    public String getLoggerFromEnv() {
        return getEnvironmentVariableOrDefault("testLogger", "console");
    }

    public String getRunOn() {
        return getEnvironmentVariableOrDefault(RUN_ON, "Local");
    }

    /** It's a Factory method pattern*/
    private String getEnvironmentVariableOrDefault(String envVar, String defaultValue) {
        return System.getenv(envVar) != null ? System.getenv(envVar) : defaultValue;
    }

    public LogBaseNew getLogger(String type) {
        return type.equals("console") ? new StdLogger() : new FileLogger();
    }

//-------------------------------------------------------------------------------------------------------------------------

    //PageObjects initialization

    public PageEditor getPageEditor(WebDriver driver){
        if (pageEditor ==null){
            pageEditor = new PageEditor(driver);
        }
        return pageEditor;
    }

    public LoginForm getLoginForm(WebDriver driver){
        if (loginForm ==null){
            loginForm = new LoginForm(driver);
        }
        return loginForm;
    }

    public Map2MainPage getMap2MainPage(WebDriver driver){
        if(map2MainPage ==null)
            map2MainPage = new Map2MainPage(driver);
        return map2MainPage;
    }

    public DmsLoginForm getDmsLoginForm(WebDriver driver) {
        if (dmsLoginForm == null) {
            dmsLoginForm = new DmsLoginForm(driver);
        }
        return dmsLoginForm;
    }

    public ToolsReviewsDealerReviewsPage getToolsReviewsDealerReviewsPage(WebDriver driver) {
        if (toolsReviewsDealerReviewsPage == null) {
            toolsReviewsDealerReviewsPage = new ToolsReviewsDealerReviewsPage(driver);
        }
        return toolsReviewsDealerReviewsPage;
    }

    public SettingsReviewDealershipReviewSettings getSettingsReviewDealershipReviewSettings(WebDriver driver) {
        if (settingsReviewDealershipReviewSettings == null) {
            settingsReviewDealershipReviewSettings = new SettingsReviewDealershipReviewSettings(driver);
        }
        return settingsReviewDealershipReviewSettings;
    }

    public DealerList getDealerList(WebDriver driver){
        if (dealerList == null){
            dealerList = new DealerList(driver);
        }
        return dealerList;
    }


    public DmsMainPage getDmsMainPage(WebDriver driver) {
        if (dmsMainPage == null) {
            dmsMainPage = new DmsMainPage(driver);
        }
        return dmsMainPage;
    }

    public DealerReviewForm getDealerReviewDWS(WebDriver driver) {
        if (dealerReviewDWS == null) {
            dealerReviewDWS = new DealerReviewForm(driver);
        }
        return dealerReviewDWS;
    }


    public Users getUsers(WebDriver driver) {
        if (users == null) {
            users = new Users(driver);
        }
        return users;
    }


    public UserEditor getUserEditor(WebDriver driver) {
        if (userEditor == null) {
            userEditor = new UserEditor(driver);
        }
        return userEditor;
    }

    public Website getWebsite(WebDriver driver) {
        if (website == null)
            website = new Website(driver);
        return website;
    }

    public Page getPage(WebDriver driver) {
        if (page == null) {
            page = new Page(driver);
        }
        return page;
    }

    public PreviewPage getPreviewPage(WebDriver driver){
        if (previewPage ==null){
            previewPage = new PreviewPage(driver);
        }
        return previewPage;
    }
    public ZipPopUp getZipPopUp(WebDriver driver){
        if (zipPopUp == null){
            zipPopUp = new ZipPopUp(driver);
        }
        return zipPopUp;
    }
}


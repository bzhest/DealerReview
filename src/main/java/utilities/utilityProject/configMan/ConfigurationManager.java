
package utilities.utilityProject.configMan;

import pageObjectClasses.dms.home.Home;
import pageObjectClasses.dms.home.settings.review.dealerReviews.DealerReview;
import pageObjectClasses.dms.home.tools.MAP2.widgets.reviews.dealerList.components.ZipPopUp;
import pageObjectClasses.dms.home.tools.MAP2.widgets.reviews.dealerList.page.DealerList;
import pageObjectClasses.dms.home.tools.reviews.dealerReview.DealerReviews;
import pageObjectClasses.dms.loginPage.LoginPage;
import pageObjectClasses.dms.home.tools.MAP2.widgets.reviews.dealerReviewForm.DealerReviewForm;
import pageObjectClasses.dms.home.tools.MAP2.widgets.form.loginForm.LoginForm;
import pageObjectClasses.dms.home.tools.MAP2.Map2MainPage;
import pageObjectClasses.dms.home.tools.MAP2.Map2PageConstructor;
import pageObjectClasses.dms.home.tools.MAP2.Map2PreviewPage;
import org.openqa.selenium.WebDriver;
import utilities.utilityProject.page.Page;
import pageObjectClasses.dms.home.settings.users.userEditor.page.UserEditor;
import pageObjectClasses.dms.home.settings.users.Users;
import pageObjectClasses.dms.home.settings.website.Website;
import utilities.utilityProject.browser.users.DefaultWebDriverManager;
import utilities.utilityHelpers.logger.FileLogger;
import utilities.utilityHelpers.logger.api.LogBaseNew;
import utilities.utilityHelpers.logger.StdLogger;

/**
 * Created by SYSTEM on 04.04.2017.
 */
public class  ConfigurationManager {

    private DealerReviews toolsReviewsDealerReviewsPage;
    private WebDriver driver;
    private DealerReview settingsReviewDealershipReviewSettings;
    private Home dmsMainPage;
    private LoginPage dmsLoginForm;
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
    private Map2PageConstructor pageEditor;
    private Map2PreviewPage previewPage;
    private DealerList dealerList;
    private ZipPopUp zipPopUp;
    private LoginForm loginForm;
    private DealerReviewForm dealerReviewForm;
    private pageObjectClasses.dms.home.tools.MAP2.widgets.reviews.dealerReview.page.DealerReview dealerReview;
    //From my curses --------------------------------------------------------------------------------------------
    private static final String TEST_BROWSER = "testBrowser";
    private static final String RUN_ON = "runOn";

    public ConfigurationManager() {
        DefaultWebDriverManager defaultWebDriverManager = new DefaultWebDriverManager();
    }

    public ConfigurationManager(WebDriver driver) {
        this.driver = driver;
        //dmsLoginForm = new LoginPage(driver);
       // page = new Page(driver);
       // dmsMainPage = new Home(driver);
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

    public pageObjectClasses.dms.home.tools.MAP2.widgets.reviews.dealerReview.page.DealerReview dealerReview(WebDriver driver){
        if (dealerReview ==null){
            dealerReview = new pageObjectClasses.dms.home.tools.MAP2.widgets.reviews.dealerReview.page.DealerReview(driver);
        }
        return dealerReview;
    }

    public Map2PageConstructor getPageEditor(WebDriver driver){
        if (pageEditor ==null){
            pageEditor = new Map2PageConstructor(driver);
        }
        return pageEditor;
    }

    public DealerReviewForm getDealerReviewForm(WebDriver driver){
        if (dealerReviewForm ==null){
            dealerReviewForm = new DealerReviewForm(driver);
        }
        return dealerReviewForm;
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

    public LoginPage getDmsLoginForm(WebDriver driver) {
        if (dmsLoginForm == null) {
            dmsLoginForm = new LoginPage(driver);
        }
        return dmsLoginForm;
    }

    public DealerReviews getToolsReviewsDealerReviewsPage(WebDriver driver) {
        if (toolsReviewsDealerReviewsPage == null) {
            toolsReviewsDealerReviewsPage = new DealerReviews(driver);
        }
        return toolsReviewsDealerReviewsPage;
    }

    public DealerReview getSettingsReviewDealershipReviewSettings(WebDriver driver) {
        if (settingsReviewDealershipReviewSettings == null) {
            settingsReviewDealershipReviewSettings = new DealerReview(driver);
        }
        return settingsReviewDealershipReviewSettings;
    }

    public DealerList getDealerList(WebDriver driver){
        if (dealerList == null){
            dealerList = new DealerList(driver);
        }
        return dealerList;
    }


    public Home getDmsMainPage(WebDriver driver) {
        if (dmsMainPage == null) {
            dmsMainPage = new Home(driver);
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

    public Map2PreviewPage getPreviewPage(WebDriver driver){
        if (previewPage ==null){
            previewPage = new Map2PreviewPage(driver);
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


package utility;

import dms.DmsLoginForm;
import dms.DmsMainPage;
import dmsDealerReviews.SettingsReviewDealershipReviewSettings;
import dmsDealerReviews.ToolsReviewsDealerReviewsPage;
import dwsDealerReviews.DealerReviewDWS;
import org.openqa.selenium.WebDriver;

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
    private static ConfigurationManager instance = null;

    public static ConfigurationManager getInstance(){
        if (instance ==null)
            instance = new ConfigurationManager();
        return instance;
    }

    private ConfigurationManager(){

    }

    public String getTestBrowser(){
        return getEnvironmentVariableOrDefault("testBrowser", "chrome");
    }

    public String getTestEnv(){
        return getEnvironmentVariableOrDefault("testEnv", "production");
    }

    private String getEnvironmentVariableOrDefault(String envVar, String defaultValue){
        return System.getenv(envVar) != null ? System.getenv(envVar) : defaultValue;
    }

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



    @Override
    public String toString() {
        return "ConfigurationManager{" +
                "toolsReviewsDealerReviewsPage=" + toolsReviewsDealerReviewsPage +
                ", driver=" + driver +
                ", settingsReviewDealershipReviewSettings=" + settingsReviewDealershipReviewSettings +
                ", dmsMainPage=" + dmsMainPage +
                ", dmsLoginForm=" + dmsLoginForm +
                ", dealerReviewDWS=" + dealerReviewDWS +
                '}';
    }


   /* public WebDriver getDriver() {
        return getWebDriverHelper().getDriver();
    }*/
// Уточнить у Леши. как правильно добавлять хелперы в эрей и вызывать их
    /*class CityRegistry {
        private static Map<String, City> references = new HashMap<>();
        public static void registerCity(String id, City reference) {
            references.put(id, reference);
        }
        public static City getCity(String id) {
            return references.get(id);
        }*/

    //Динамическое создание объекта
    /*String className = "Class1"; - здесь будет вместо Class1 - название хелпера
    Object xyz = Class.forName(className).newInstance();*/ //- здесь динамически будет создаваться объект


}

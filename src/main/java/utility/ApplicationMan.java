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
public class ApplicationMan {
    private static ApplicationMan singleton;
    private ToolsReviewsDealerReviewsPage toolsReviewsDealerReviewsPage;
    private WebDriver driver;
    private SettingsReviewDealershipReviewSettings settingsReviewDealershipReviewSettings;
    private DmsMainPage dmsMainPage;
    private DmsLoginForm dmsLoginForm;
    private DealerReviewDWS dealerReviewDWS;

    public static ApplicationMan getInstance() {
        if (singleton == null) {
            singleton = new ApplicationMan();
        }
        return singleton;
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
        return "ApplicationMan{" +
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

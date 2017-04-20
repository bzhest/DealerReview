package utility;

import org.openqa.selenium.WebDriver;

/**
 * Created by SYSTEM on 07.04.2017.
 */
public class TestServer {
    private WebDriver driver;
    public String url(){
        String testEnv = ConfigurationManager.getInstance(driver).getTestEnv();

        switch (testEnv){
            case "live":
                return "http://www.solomia.andreyb.ixloo.com";
            case "boxx":
                return "test.live.motorboxx.goxloo.com";
            default:
                return "Can't find such site";
        }


    }
}

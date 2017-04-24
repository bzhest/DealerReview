package utility.browser;

import utility.ConfigurationManager;

/**
 * Created by SYSTEM on 24.04.2017.
 */
public class DefaultWebDriverManager implements WebDriverManager {
    @Override
    public String getWebDriver() {
        String runOn = ConfigurationManager.getInstance().getghjRunOn().toUpperCase();
        WebDriverFactory factory;

        switch(runOn){
            case "LOCAL":
                factory = new LocalWebDriverFactory();
                break;
            case "BUILDSERVER":
                factory = new BuildServerWebDriverFactoryFactory();
                break;
            case "CLOUD":
                factory = new CloudWebDriverFactory();
                break;
            default:
                throw new RuntimeException();
        }
    return factory.create();
    }

    @Override
    public void destroyWebDriver(String driver) {
        /*if(driver ==null)
           id driver.quit();*/
        System.out.println("Quit driver - " + driver);
    }
}

package utility.browser;

/**
 * Created by SYSTEM on 24.04.2017.
 */
public class Test {
    public static void main(String[] args) {
        WebDriverManager wdm = new DefaultWebDriverManager();
        String webDriver = wdm.getWebDriver();
        System.out.println(webDriver);
        wdm.destroyWebDriver(webDriver);
    }
}

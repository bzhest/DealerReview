package utility;

/**
 * Created by SYSTEM on 07.04.2017.
 */
public class TestBrowser {
    public String create(){
        String testBrowser= ConfigurationManager.getInstance().getTestBrowser();
        switch(testBrowser){
            case "chrome":
                return "Google Chrome";
            case "mozilla":
                return "Mozilla FireFox";
            case "ie":
                System.out.println();
                return "MS Internet Explorer";
            default:
                throw new RuntimeException("Such browser is not supported");
        }
    }

    public void destroy(String browser){System.out.println("Browser" + browser + "closed");}
}

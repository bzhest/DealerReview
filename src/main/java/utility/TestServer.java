package utility;

/**
 * Created by SYSTEM on 07.04.2017.
 */
public class TestServer {
    public String url(){
        String testEnv = ConfigurationManager.getInstance().getTestEnv();

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

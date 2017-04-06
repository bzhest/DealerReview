package bases;


import com.example.managers.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import utility.ConfigurationManager;
import utility.Logger;

/**
 * Created by SYSTEM on 04.04.2017.
 */
public class Base1 {
    //Чтобы работать с ConfigurationManager - в Base1 должна быть ссылка на ApplicationManager
    public ConfigurationManager app;
    public Logger logger;

    @BeforeTest
    public void beforeTest() {
        logger.log("Create singleton");
        app = ConfigurationManager.getInstance();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        logger.log("Create singleton");
        ApplicationManager.getInstance().stop();

    }
}

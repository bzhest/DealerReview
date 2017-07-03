package utility.utils.exam.drivers;


import org.openqa.selenium.WebDriver;
import utility.utils.exam.drivers.components.AddBugForm;
import utility.utils.exam.drivers.components.Confirmation;
import utility.utils.exam.drivers.components.ControlPanel;
import utility.utils.exam.drivers.pages.BugsPage;

/**
 * Created by Andrey on 02.07.2017.
 */
public class Application {

    private WebDriver driver;
    public Application(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        try {
            driver.get("http://autotesttask.herokuapp.com/");
        } catch (Exception ex) {
            throw new RuntimeException("Page wasn't opened", ex);
        }
    }

    public BugsPage bugsPage() {
        return new BugsPage(driver);
    }

    public AddBugForm addBugForm() {
        return new AddBugForm(driver);
    }

    public ControlPanel controlPanel(){
        return new ControlPanel(driver);
    }

    public Confirmation confirmation(){
        return new Confirmation(driver);
    }


}

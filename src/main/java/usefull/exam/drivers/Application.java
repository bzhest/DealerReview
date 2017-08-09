package usefull.exam.drivers;


import org.openqa.selenium.WebDriver;
import usefull.exam.drivers.components.AddBugForm;
import usefull.exam.drivers.components.Confirmation;
import usefull.exam.drivers.components.ControlPanel;
import usefull.exam.drivers.pages.BugsPage;

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

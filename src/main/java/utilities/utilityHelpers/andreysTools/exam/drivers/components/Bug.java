package utilities.utilityHelpers.andreysTools.exam.drivers.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Andrey on 02.07.2017.
 */
public class Bug {

    private WebElement name;
    private WebElement notes;

    public Bug(WebElement name, WebElement notes) {
        this.name = name;
        this.notes = notes;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getNotes() {
        return notes;
    }

    public void doubleClickOnName(WebDriver driver){
        Actions action = new Actions(driver);
        action.doubleClick(getName()).perform();

    }

    public void doubleClickOnNotes(WebDriver driver){
        Actions action = new Actions(driver);
        action.doubleClick(getNotes()).perform();

    }
}

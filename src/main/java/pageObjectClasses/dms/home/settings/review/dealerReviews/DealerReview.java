package pageObjectClasses.dms.home.settings.review.dealerReviews;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.utilityProject.page.Page;

import java.util.List;

/**
 * Created by SYSTEM on 04.04.2017.
 */
public class DealerReview extends Page {
    /*public ReviewObject(WebDriver webDriver) {super(webDriver);}*/

    public DealerReview(WebDriver driver) {
        super(driver);
    }


    @FindBy(how = How.CSS, using = "input[name*=_visible]")
    private List<WebElement> checkboxes;

    @FindBy(how = How.CSS, using = ".sp")
    private List<WebElement> saveButtons;

    //Select single checkbox

    public void selectCheckbox(int checkboxNumber) {
        if (checkboxes.get(checkboxNumber).isSelected()) {
            checkboxes.get(checkboxNumber).click();
            sleep(1);
        }
    }
    // Select all checkboxes

    public void selectAllCheckbox() {
        for (WebElement e : checkboxes) {
            if (!e.isSelected()) {
                e.click();
                sleep(1);
            }
        }
    }


    public void clickSave() {
        saveButtons.get(0).click();
    }
}




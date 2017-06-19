package dmsDealerReviews;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page.Page;

import java.util.List;

/**
 * Created by SYSTEM on 04.04.2017.
 */
public class SettingsReviewDealershipReviewSettings extends Page {
    /*public SettingsReviewDealershipReviewSettings(WebDriver webDriver) {super(webDriver);}*/

    public SettingsReviewDealershipReviewSettings (WebDriver driver)
    {super(driver);}



    @FindBy (how = How.CSS, using = "input[name*=_visible]")
    private List<WebElement> checkboxes;

    @FindBy (how = How.CSS, using = ".sp")
    private List<WebElement> saveButtons;

    //Select single checkbox

    public void selectCheckbox(int checkboxNumber) {
        if (checkboxes.get(checkboxNumber).isSelected()) {
            checkboxes.get(checkboxNumber).click();
            waitForJSandJQueryToLoad();
        }
    }
    // Select all checkboxes

    public void selectAllCheckbox() {
        for (WebElement e: checkboxes) {
            if (!e.isSelected()) {
                e.click();
                waitForJSandJQueryToLoad();
            }
        }
    }


    public void clickSave(){
        saveButtons.get(0).click();
    }
}




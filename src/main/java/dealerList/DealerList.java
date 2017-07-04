package dealerList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.Page;

import java.util.List;

/**
 * Created by DWork on 22.06.2017.
 */
public class DealerList extends Page {

    public DealerList(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#dialog_search_close")
    WebElement closeButton;

    @FindBy(css = "a[href*= 'dealer-review-form']")
    List<WebElement> addReviewButtons;


    public WebElement getCloseButton() {
        //waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(closeButton));
        return closeButton;
    }

    public void getFirstAddReviewButton() {
        wait.until(ExpectedConditions.visibilityOf(addReviewButtons.get(0)));
        addReviewButtons.get(0);
        waitForJSandJQueryToLoad();
    }

    public void clickFirstAddReviewButton() {
        try {
            wait.until(ExpectedConditions.visibilityOf(addReviewButtons.get(0)));
            addReviewButtons.get(0).click();
            //waitForJSandJQueryToLoad();
        }catch(Exception ex){}
    }
}



package dealerList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.Page;

import java.util.List;

/**
 * Created by DWork on 22.06.2017.
 */
public class DealerList extends Page {

    public DealerList(WebDriver driver){
        super (driver);
    }

    @FindBy (css = "#dialog_search_close")
    WebElement closeButton;

    @FindBy (css = "a[href *= 'dealer-review-form']")
    List <WebElement> addReviewButtons;


    public WebElement getCloseButton(){
        waitForJSandJQueryToLoad();
        return closeButton;
    }

}

package dms;

import dmsDealerReviews.ToolsReviewsDealerReviewsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.Page;

/**
 * Created by SYSTEM on 16.03.2017.
 */
public class DmsMainPage extends Page {
    public DmsMainPage(WebDriver webDriver){super(webDriver);}

    @FindBy(how = How.CSS, using = "a[href='/dms/tools']")
    private WebElement toolsMenu;

    @FindBy(how = How.CSS, using = "a[href='/dms/tools/reviews']")
    private WebElement toolsMenuReviewsItem;

    /*go to dms Dealers page*/
    public ToolsReviewsDealerReviewsPage clickOnReviewsMenu() {
        /*move mouse on Admin menu item*/
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(toolsMenu).build();
        moveToElem.perform();
        toolsMenuReviewsItem.click();
        return PageFactory.initElements(driver, ToolsReviewsDealerReviewsPage.class);
    }

}

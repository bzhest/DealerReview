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
import settings.Users;
import utility.ConfigurationManager;

/**
 * Created by SYSTEM on 16.03.2017.
 */
public class DmsMainPage extends Page {
    /*public DmsMainPage(WebDriver webDriver){super(webDriver);}*/
    public DmsMainPage (ConfigurationManager manager)
    {super(manager);}

    @FindBy(how = How.CSS, using = "a[href='/dms/tools']")
    private WebElement toolsMenu;

    @FindBy(how = How.CSS, using = "a[href='/dms/tools/reviews']")
    private WebElement toolsMenuReviewsItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/tools/make_a_page_2']")
    private WebElement toolsMenuMAP2;

    @FindBy(how = How.CSS, using = "a[href='/dms/tools/make_a_page']")
    private WebElement toolsMenuMAP1;


    /*go to dms Dealers page*/
    public ToolsReviewsDealerReviewsPage clickOnSubmenuReviews() {
        /*move mouse on Admin menu item*/
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(toolsMenu).build();
        moveToElem.perform();
        toolsMenuReviewsItem.click();
        return PageFactory.initElements(driver, ToolsReviewsDealerReviewsPage.class);
    }

    public void clickOnSubmenuMAP2() {
        /*move mouse on Admin menu item*/
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(toolsMenu).build();
        moveToElem.perform();
        toolsMenuMAP2.click();

    }

    public void clickOnSubmenuMAP1() {
        /*move mouse on Admin menu item*/
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(toolsMenu).build();
        moveToElem.perform();
        toolsMenuMAP1.click();

    }

    public void clickOnUsersMenu() {
        driver.get("http://www.solomia.andreyb.ixloo.com/dms/settings/users");
    }
}

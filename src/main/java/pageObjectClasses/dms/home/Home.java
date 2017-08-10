package pageObjectClasses.dms.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.utilityProject.page.Page;

/**
 * Created by SYSTEM on 16.03.2017.
 */
public class Home extends Page {

    public Home(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(how = How.CSS, using = "a[href='/dms/tools']")
    private WebElement toolsMenu;

    @FindBy(how = How.CSS, using = "a[href='/dms/tools/reviews']")
    private WebElement toolsMenuReviewsItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/tools/make_a_page_2']")
    private WebElement toolsMenuMAP2;

    @FindBy(how = How.CSS, using = "a[href='/dms/tools/make_a_page']")
    private WebElement toolsMenuMAP1;

    @FindBy(how = How.CSS, using = "a[href='/dms/settings']")
    private WebElement settingsMenu;

    @FindBy(how = How.CSS, using = "a[href='/dms/settings/review-settings']")
    private WebElement settingsMenuReviewItem;



    public void clickToolsSubmenuReviewsItem() {
        /*move mouse on Tools menu item*/
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(toolsMenu).build();
        moveToElem.perform();
        toolsMenuReviewsItem.click();
    }

    public void clickToolsSubmenuMAP2Item() {
        /*move mouse on Tools menu item*/
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(toolsMenu));
        action.moveToElement(toolsMenu).perform();
        toolsMenuMAP2.click();
    }

    public void clickOnSettingsSubmenuReviewItem() {
        /*move mouse on Settings menu item*/
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(settingsMenu));
        action.moveToElement(settingsMenu).perform();
        settingsMenuReviewItem.click();


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

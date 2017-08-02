package map2;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.Page;
import utility.utils.javascript.Javascript;

/**
 * Created by Andrey on 13.04.2017.
 */

public class PageEditor extends Page {

    public PageEditor(WebDriver driver) {
        super(driver);
    }

    /*declare elements on the page*/

    @FindBy(how = How.XPATH, using = "//input[@data-param='name']")
    private WebElement nameInput;

    @FindBy(how = How.XPATH, using = "//input[@data-param='title']")
    private WebElement titleInput;

    @FindBy(how = How.CSS, using = "div.tab[data-tab='library'][title='Library']")
    private WebElement libraryTab;

    @FindBy(css = ".mapx-button-ico.globe")
    WebElement previewPage;

    @FindBy(how = How.CSS, using = "div.menu-launcher")
    private WebElement mapButton;

    @FindBy(how = How.CSS, using = "div.tab[data-tab='page-settings'][title='Page Settings']")
    private WebElement pageSettingsTab;

    @FindBy(how = How.CSS, using = ".ico-widget.widget-list_dealer")
    private WebElement iconDealerList;

    @FindBy(how = How.CSS, using = ".ico-widget.widget-login")
    private WebElement iconLoginForm;

    @FindBy(how = How.CSS, using = ".ico-widget.widget-dealer_review")
    private WebElement iconDealerReview;

    @FindBy(how = How.CSS, using = ".ico-widget.widget-dealer_reviewform")
    private WebElement iconDealerReviewForm;

    @FindBy(how = How.CSS, using = ".ax-container.empty")
    private WebElement emptyContainer;

    @FindBy(how = How.CSS, using = "div[data-widget=\'list_dealer\']")
    private WebElement widgetDealerList;

    @FindBy(how = How.XPATH, using = "//div[@class='ico-widget widget-contact_us']")
    private WebElement contactIconTree;

    @FindBy(how = How.XPATH, using = "//div[@class='ico-widget widget-form_trade_in']")
    private WebElement tradeInIconTree;

    @FindBy(how = How.XPATH, using = "//div[@class='mapx-button-ico activate']")
    private WebElement activateBtn;

    @FindBy(how = How.XPATH, using = "//div[@class='menu-launcher']")
    private WebElement menuLauncher;

    @FindBy(how = How.XPATH, using = "//div[@class='layout-container container']//div[@class='ax-widget panel panel-default']")
    private WebElement widget;

    @FindBy(how = How.XPATH, using = "//div[@data-widget='form_trade_in'][contains(@class, 'ax-widget')]")
    private WebElement tradeInWidgetInEditor;

    @FindBy(how = How.XPATH, using = "//div[@class='ax-btn btn-edit']")
    private WebElement widgetEditBtn;

    @FindBy(how = How.XPATH, using = "//div[@class='jGrowl-notification ui-state-highlight ui-corner-all jgrowl_default_alert']/div[@class='message'][contains(text(), 'Page activated')]")
    private WebElement pageActivatedTooltip;


    //Getter
    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getIconDealerList() {
        return iconDealerList;
    }

    public WebElement getIconLoginForm() {
        return iconLoginForm;
    }

    public WebElement getIconDealerReview() {
        return iconDealerReview;
    }

    public WebElement getIconDealerReviewForm() {
        return iconDealerReviewForm;
    }

    public WebElement getPageSettingsTab() {
        wait.until(ExpectedConditions.visibilityOf(pageSettingsTab));
        return pageSettingsTab;
    }

    public WebElement getEmptyContainer() {
        return emptyContainer;
    }

    public WebElement getTitleInput() {
        return titleInput;
    }

    public WebElement getActivateButton() {
        return activateBtn;
    }

    public void clickOnMapButton() {
        //waitForJSandJQueryToLoad();
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("mask")));
        wait.until(ExpectedConditions.visibilityOf(mapButton));
        /*int width = mapButton.getSize().getWidth();
        Actions action = new Actions (driver);
        action.moveToElement(mapButton,(width/2) - 20, 0).click().perform();*/
        //Javascript.clickOnElement(driver,mapButton);
        Actions action = new Actions (driver);
        action.moveToElement(mapButton).click().perform();
        /*try {
            Thread.sleep(500);
        }catch (Exception ex){}
            mapButton.click();*/
    }

    public WebElement getPreviewPage() {
        wait.until(ExpectedConditions.visibilityOf(previewPage));
        return previewPage;
    }

    /*protected ExpectedCondition<Boolean> isLoadingInvisible() {
        return ExpectedConditions.invisibilityOfElementLocated(By.className("mask"));
    }*/

    public WebElement getDealerListWidget() {
        return widgetDealerList;
    }


    //Click on Library tab
    public void clickOnLibrary() {
        libraryTab.click();
    }


    public void fillWidgetNameTitle() {

    }

    //Click on Page Settings tab
    public void clickOnPageSettings() {
        pageSettingsTab.click();
    }

    /*fill page name*/
    public void setPageName() {
        nameInput.clear();
        nameInput.sendKeys("contactauto");
    }

    //add widget
    public void addAnWidget(WebElement source, WebElement target) {
        Actions builder = new Actions(driver);
        builder.dragAndDrop(source, target).perform();
    }

    /*add a particular widget, using Java Script*/
    public void addWidget() {
        libraryTab.click();
        ((JavascriptExecutor) driver).executeScript("map.pg.addWidget(\"contact_us\", {destination: \"body_0_0\"});");
    }

    public void addTradeInWidget() {
        libraryTab.click();
        ((JavascriptExecutor) driver).executeScript("map.pg.addWidget(\"form_trade_in\", {destination: \"body_0_0\"});");
    }

    /*click on Activate page button*/
    public void activatePage() {
        activateBtn.click();
    }

    /*back to pages tree*/
    public void backToMap() {
        menuLauncher.click();

    }

    /*check if a particular widget exists in the widgets library*/
    public boolean isContactWidgetExists() {
        libraryTab.click();
        try {
            contactIconTree.isDisplayed();
            return true; // return true, if element exists
        } catch (NoSuchElementException ex) {
            return false; //return false, if element doesn't exist
        }
    }

    /*check if a particular widget exists in the widgets library*/
    public boolean isTradeInWidgetExistsInEditor() {
        try {
            tradeInWidgetInEditor.isDisplayed();
            return true; // return true, if element exists
        } catch (NoSuchElementException ex) {
            return false; //return false, if element doesn't exist
        }
    }

    public boolean isTradeInWidgetExists() {
        libraryTab.click();
        try {
            tradeInIconTree.isDisplayed();
            return true; // return true, if element exists
        } catch (NoSuchElementException ex) {
            return false; //return false, if element doesn't exist
        }
    }


    /*open widget settings*/
    public void openWidgetSettings() {
        Actions action = new Actions(driver);
        //Action moveToElem = action.moveToElement(contactUsWidget).build();
        Action moveToElem = action.moveToElement(widget).build();
        moveToElem.perform();
        widgetEditBtn.click();

    }


}

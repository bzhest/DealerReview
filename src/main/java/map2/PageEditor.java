package map2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.Page;
import utility.ConfigurationManager;

/**
 * Created by Andrey on 13.04.2017.
 */
public class PageEditor extends Page {
    public PageEditor(ConfigurationManager manager){
        super(manager);
    }
    /*declare elements on the page*/
    @FindBy(how= How.XPATH, using ="//input[@data-param='name']")
    private WebElement nameInput;

    @FindBy(how= How.XPATH, using ="//div[@data-tab='library']")
    private WebElement libraryTab;

    @FindBy(how= How.XPATH, using ="//div[@class='ico-widget widget-contact_us']")
    private WebElement contactIconTree;

    @FindBy(how= How.XPATH, using ="//div[@class='ico-widget widget-form_trade_in']")
    private WebElement tradeInIconTree;

    @FindBy(how= How.XPATH, using ="//div[@class='mapx-button-ico activate']")
    private WebElement activateBtn;

    @FindBy(how= How.XPATH, using ="//div[@class='menu-launcher']")
    private WebElement menuLauncher;

    @FindBy(how= How.XPATH, using ="//div[@class='mapx-button-ico globe']")
    private WebElement previewBtn;

    @FindBy(how= How.XPATH, using ="//div[@class='layout-container container']//div[@data-widget='contact_us']")
    private WebElement contactUsWidget;

    @FindBy(how= How.XPATH, using ="//div[@class='layout-container container']//div[@data-widget='form_trade_in']")
    private WebElement tradeInWidget;

    @FindBy(how= How.XPATH, using ="//div[@class='layout-container container']//div[@class='ax-widget panel panel-default']")
    private WebElement widget;

    @FindBy(how= How.XPATH, using ="//div[@data-widget='form_trade_in'][contains(@class, 'ax-widget')]")
    private WebElement tradeInWidgetInEditor;

    @FindBy(how= How.XPATH, using ="//div[@class='ax-btn btn-edit']")
    private WebElement widgetEditBtn;

    @FindBy(how= How.XPATH, using ="//div[@class='jGrowl-notification ui-state-highlight ui-corner-all jgrowl_default_alert']/div[@class='message'][contains(text(), 'Page activated')]")
    private WebElement pageActivatedTooltip;

    /*fill page name*/
    public void setPageName(){
        nameInput.clear();
        nameInput.sendKeys("contactauto");
    }

    /*add a particular widget, using Java Script*/
    public void addWidget(){
        libraryTab.click();
        ((JavascriptExecutor)driver).executeScript("map.pg.addWidget(\"contact_us\", {destination: \"body_0_0\"});");
    }

    public void addTradeInWidget(){
        libraryTab.click();
        ((JavascriptExecutor)driver).executeScript("map.pg.addWidget(\"form_trade_in\", {destination: \"body_0_0\"});");
    }

    /*click on Activate page button*/
    public void activatePage(){
        activateBtn.click();
    }

    /*back to pages tree*/
    public void backToMap(){
        menuLauncher.click();

    }

    /*check if a particular widget exists in the widgets library*/
    public boolean isContactWidgetExists(){
        libraryTab.click();
        try{
            contactIconTree.isDisplayed();
            return true; // return true, if element exists
        }
        catch (NoSuchElementException ex){
            return false; //return false, if element doesn't exist
        }
    }

    /*check if a particular widget exists in the widgets library*/
    public boolean isTradeInWidgetExistsInEditor(){
        try{
            tradeInWidgetInEditor.isDisplayed();
            return true; // return true, if element exists
        }
        catch (NoSuchElementException ex){
            return false; //return false, if element doesn't exist
        }
    }

    public boolean isTradeInWidgetExists(){
        libraryTab.click();
        try{
            tradeInIconTree.isDisplayed();
            return true; // return true, if element exists
        }
        catch (NoSuchElementException ex){
            return false; //return false, if element doesn't exist
        }
    }

    /*click on Preview Page button*/
    public void clickOnPreview(){
        previewBtn.click();

    }

    /*open widget settings*/
    public void openWidgetSettings(){
        Actions action = new Actions(driver);
        //Action moveToElem = action.moveToElement(contactUsWidget).build();
        Action moveToElem = action.moveToElement(widget).build();
        moveToElem.perform();
        widgetEditBtn.click();

    }

    public void openTradeInWidgetSettings(){
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(tradeInWidget).build();
        moveToElem.perform();
        widgetEditBtn.click();

    }

}

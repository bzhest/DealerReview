package settings.users.userEditor.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.users.userEditor.components.AccessTab;
import settings.users.userEditor.components.AddressTab;
import settings.users.userEditor.components.GeneralTab;

/**
 * Created by SYSTEM on 07.04.2017.
 */
public class UserEditor {
    private WebDriver driver;
    private WebDriverWait wait;
    private GeneralTab general;
    private AddressTab address;
    private AccessTab access;

    /*public UserEditor(WebDriver driver) {
        super(driver);
        //general = new GeneralTab(driver);
        //addressTab = new AddressTab(driver);
    }*/

    public UserEditor (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,25);
    }


    /*declare elements on the page*/

    /*@FindBy(how = How.XPATH, using = "//div[@class='access_group']/span[contains(text(), 'Tools')]")
    private WebElement toolsItem;*/

    /*@FindBy(how = How.ID, using = "addon_make_a_page_2")
    private WebElement map2Checkbox;*/

    @FindBy(how = How.ID, using = "user_editor_save")
    private WebElement saveBtn;

    /*@FindBy(how = How.ID, using = "login")
    private WebElement loginInput;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordInput;*/

    /*@FindBy(how = How.ID, using = "cpass")
    private WebElement confirmpwInput;

    @FindBy(how = How.ID, using = "name")
    private WebElement userDealerNameInput;

    @FindBy(how = How.ID, using = "role_id")
    private WebElement roleSelect;

    @FindBy(how = How.ID, using = "active")
    private WebElement activeCheckbox;*/


    //methods

    public void turnOnMAP2() {
        //waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(getAccessTab()));
        //sleep(1);
        getAccessTab().click();
        getAccessTab(driver).getToolsItem().click();
        //toolsItem.click();
        if (getAccessTab(driver).getMap2Checkbox().getAttribute("checked") == null) {
            //if (map2Checkbox.getAttribute("checked") == null) {
            //map2Checkbox.click();
            getAccessTab(driver).getMap2Checkbox().click();
            saveBtn.click();
        }
    }



    public AddressTab getAddressTab(WebDriver driver){
        if (address == null)
            address = new AddressTab(driver);
        return address;
    }

    public GeneralTab getGeneralTab(WebDriver driver){
        if (general == null)
            general = new GeneralTab(driver);
        return general;
    }

    public AccessTab getAccessTab(WebDriver driver){
        if (access == null)
            access = new AccessTab(driver);
        return access;
    }


    public WebElement getGeneralTab() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user_editor_tab1"))));
        return driver.findElement(By.id("user_editor_tab1"));
    }

    public WebElement getAddressTab() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user_editor_tab2"))));
        return driver.findElement(By.id("user_editor_tab2"));
    }

    public WebElement getAccessTab() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user_editor_tab4"))));
        return driver.findElement(By.id("user_editor_tab4"));
    }


    /*public void addNewManager() {
        inputText(loginInput, PropertyLoaderCredentials.loadProperty("newManagerLogin"));
        inputText(passwordInput, PropertyLoaderCredentials.loadProperty("newManagerPassword"));
        inputText(confirmpwInput, PropertyLoaderCredentials.loadProperty("newManagerPassword"));
        inputText(userDealerNameInput, "Vasil's cars");
        Select options = new Select(roleSelect);
        options.selectByValue("5");
        saveBtn.click();
    }*/

}

package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import page.Page;
import utility.ConfigurationManager;
import utility.PropertyLoaderCredentials;

/**
 * Created by SYSTEM on 07.04.2017.
 */
public class UserEditor extends Page {
    /*public UserEditor (WebDriver webDriver){
        super(webDriver);
    }*/
    public UserEditor (ConfigurationManager manager)
    {super(manager);}

    /*declare elements on the page*/
    @FindBy(how = How.ID, using = "user_editor_tab4")
    private WebElement accessTab;

    @FindBy(how = How.XPATH, using = "//div[@class='access_group']/span[contains(text(), 'Tools')]")
    private WebElement toolsItem;

    @FindBy(how = How.ID, using = "addon_make_a_page_2")
    private WebElement map2Checkbox;

    @FindBy(how = How.XPATH, using = "(//a[@class='button-style b_save notranslate'])[7]")
    private WebElement saveBtn;

    @FindBy(how = How.ID, using = "login")
    private WebElement loginInput;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordInput;

    @FindBy(how = How.ID, using = "cpass")
    private WebElement confirmpwInput;

    @FindBy(how = How.ID, using = "name")
    private WebElement userDealerNameInput;

    @FindBy(how = How.ID, using = "role_id")
    private WebElement roleSelect;

    @FindBy(how = How.ID, using = "active")
    private WebElement activeCheckbox;

    //methods

    public void turnOnMAP2(){
        waitForJSandJQueryToLoad();
        accessTab.click();
        toolsItem.click();
        if (map2Checkbox.getAttribute("checked") ==null){
            map2Checkbox.click();
            saveBtn.click();
        }
    }

    public void addNewManager(){
        inputText(loginInput,PropertyLoaderCredentials.loadProperty("newManagerLogin"));
        inputText(passwordInput,PropertyLoaderCredentials.loadProperty("newManagerPassword"));
        inputText(confirmpwInput,PropertyLoaderCredentials.loadProperty("newManagerPassword"));
        inputText(userDealerNameInput, "Vasil's cars");
        Select options = new Select(roleSelect);
        options.selectByValue("5");
        saveBtn.click();
    }


}

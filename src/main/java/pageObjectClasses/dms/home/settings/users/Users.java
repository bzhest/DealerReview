package pageObjectClasses.dms.home.settings.users;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.utilityProject.page.Page;

import java.util.List;

/**
 * Created by SYSTEM on 07.04.2017.
 */
@Getter
public class Users extends Page {

    /*public  Users (WebDriver webDriver){
        super(webDriver);
    }*/
    public Users (WebDriver driver)
    {super(driver);}



    @FindBy(how = How.CSS, using = ".rootUserBranch>a")
    private WebElement rootUser;

    @FindBy(css = "#user_14189")
    private WebElement manager;


    @FindBy(how = How.CSS, using = "#user_tree_add")
    private WebElement addUserBtn;

    @FindBy(how = How.ID, using = "#user_tree_delete")
    private WebElement deleteUserBtn;

    @FindBy(how = How.CSS, using = ".rootUserBranch.jstree-open.jstree-last a")
    private List<WebElement> usersList;

    public WebElement getRootUser(){
        return rootUser;
    }

    /*open User Editor of root user - Julia's version*/
    /*public userEditor openUserEditor() {
        Actions action = new Actions(driver);
        Action moveToElem = action.doubleClick(rootUser).build();
        moveToElem.perform();
        return PageFactory.initElements(driver, userEditor.class);
    }*/

    public void openUserEditor(WebElement user){
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(user));
        Action moveToElem = action.doubleClick(user).build();
        moveToElem.perform();
    }
}



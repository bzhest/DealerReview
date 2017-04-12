package settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.Page;
import utility.ConfigurationManager;

import java.util.List;

/**
 * Created by SYSTEM on 07.04.2017.
 */
public class Users extends Page {

    /*public  Users (WebDriver webDriver){
        super(webDriver);
    }*/
    public Users (ConfigurationManager manager)
    {super(manager);}

    @FindBy(how = How.CSS, using = ".rootUserBranch.jstree-open.jstree-last>a")
    private WebElement rootUser;

    @FindBy(how = How.CSS, using = "#user_tree_add")
    private WebElement addUserBtn;

    @FindBy(how = How.ID, using = "#user_tree_delete")
    private WebElement deleteUserBtn;

    @FindBy(how = How.CSS, using = ".rootUserBranch.jstree-open.jstree-last a")
    private List<WebElement> usersList;

    /*open User Editor of root user - Julia's version*/
    /*public UserEditor openUserEditor() {
        Actions action = new Actions(driver);
        Action moveToElem = action.doubleClick(rootUser).build();
        moveToElem.perform();
        return PageFactory.initElements(driver, UserEditor.class);
    }*/

    public void openUserEditor(){
        Actions action = new Actions(driver);
        Action moveToElem = action.doubleClick(rootUser).build();
        moveToElem.perform();

    }

}



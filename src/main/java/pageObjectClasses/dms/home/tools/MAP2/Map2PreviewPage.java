package pageObjectClasses.dms.home.tools.MAP2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.utilityProject.page.Page;

/**
 * Created by DWork on 19.06.2017.
 */
public class Map2PreviewPage extends Page {

    public Map2PreviewPage(WebDriver driver){
        super (driver);
    }

    @FindBy(css = ".mapx-button-ico.globe")
    WebElement visitOnWebsite;

    public WebElement getVisitOnVebsite(){
        wait.until(ExpectedConditions.visibilityOf(visitOnWebsite));
        return visitOnWebsite;
    }
}

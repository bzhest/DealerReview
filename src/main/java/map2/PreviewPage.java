package map2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.Page;

/**
 * Created by DWork on 19.06.2017.
 */
public class PreviewPage extends Page {

    public PreviewPage (WebDriver driver){
        super (driver);
    }

    @FindBy(css = ".mapx-button-ico.globe")
    WebElement visitOnWebsite;

    public WebElement getVisitOnVebsite(){
        return visitOnWebsite;
    }
}

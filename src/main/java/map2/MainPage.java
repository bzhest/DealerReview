package map2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.Page;
import utility.ConfigurationManager;

/**
 * Created by Andrey on 13.04.2017.
 */
public class MainPage extends Page {
    public MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(how = How.CSS, using = "div.map-link.pull-right")
    public WebElement addNewPageButton;
}

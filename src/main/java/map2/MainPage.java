package map2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page.Page;
import utility.ConfigurationManager;

/**
 * Created by Andrey on 13.04.2017.
 */
public class MainPage extends Page {
    public MainPage(ConfigurationManager manager){
        super(manager);
    }
    @FindBy(how = How.CSS, using = "div.map-link.pull-right")
    public WebElement addNewPageButton;
}

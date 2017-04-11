package dmsDealerReviews;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page.Page;
import utility.ConfigurationManager;

import java.util.List;

/**
 * Created by SYSTEM on 16.03.2017.
 */
public class ToolsReviewsDealerReviewsPage extends Page {
    /*public ToolsReviewsDealerReviewsPage(WebDriver webDriver) {super(webDriver);}*/
    public ToolsReviewsDealerReviewsPage (ConfigurationManager manager)
    {super(manager);}

    //Получаю список всех Ревью
    @FindBy(how = How.CSS, using = ".ui-widget-content.jqgrow.ui-row-ltr")
    private List<WebElement> listOfReviews;

    @FindBy(how = How.CSS, using = "td[title='Delete review']")
    private WebElement deleteButton;

    //ID-шник последнего добавленного ревью
    int ReviewIDforLastAddedReviewDMS = Integer.parseInt(getItemFromReviewsList(0).getAttribute("id"));

    //Элемент чекбокса последнего добавленного ревью
    WebElement firstReviewsCheckbox = driver.findElement(By.cssSelector("#jqg_reviews-list_"+ReviewIDforLastAddedReviewDMS+""));

    //Выбор чекбокса
    public void selectCheckbox(){
        if (!firstReviewsCheckbox.isSelected())
        {
            firstReviewsCheckbox.click();
        }
    }

    //Получение N-го ревью из списка ревью
    public WebElement getItemFromReviewsList(int number){
        return listOfReviews.get(number);
    }



}


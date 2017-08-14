package pageObjectClasses.dms.home.tools.reviews.dealerReview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.utilityHelpers.cookies.Cookies;
import utilities.utilityProject.page.Page;
import utilities.utilityProject.properties.PropertyLoader;

import java.util.List;

/**
 * Created by SYSTEM on 16.03.2017.
 */
public class DealerReviews extends Page {
    /*public DealerReviews(WebDriver webDriver) {super(webDriver);}*/

    public DealerReviews(WebDriver driver) {
        super(driver);
    }


    //Получаю список всех Ревью
    @FindBy(how = How.CSS, using = ".ui-widget-content.jqgrow.ui-row-ltr")
    private List<WebElement> listOfReviews;

    @FindBy(css = "#cb_reviews-list")
    private WebElement selectAllCheckBox;

    @FindBy(how = How.CSS, using = "td[title='Delete review']")
    private WebElement deleteButton;

    //ID-шник последнего добавленного ревью
    /*private int ReviewIDforLastAddedReviewDMS = Integer.parseInt(getItemFromReviewsList(0).getAttribute("id"));*/

    //Элемент чекбокса последнего добавленного ревью
    //private WebElement firstReviewsCheckbox = driver.findElement(By.cssSelector("#jqg_reviews-list_" + ReviewIDforLastAddedReviewDMS + ""));

    //Выбор чекбокса
    /*public void selectCheckbox() {
        if (!firstReviewsCheckbox.isSelected()) {
            firstReviewsCheckbox.click();
        }
    }*/

    //Получение N-го ревью из списка ревью
    /*private WebElement getItemFromReviewsList(int number) {
        return listOfReviews.get(number);
    }*/

    //удаление всех ревью
    public void deleteAllReviews() {
        Cookies.makeLogOut(driver);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        manager.getDmsLoginForm(driver).loginToDMSUnderSupervisor();
        driver.get(PropertyLoader.loadProperty("dms.url") + "/tools/reviews#dealer-review");
        if (listOfReviews.size() > 0) {
            selectAllCheckBox.click();
            deleteButton.click();
            sleep(2);
        }
    }
}


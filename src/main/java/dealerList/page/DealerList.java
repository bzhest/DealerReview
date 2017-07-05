package dealerList.page;

import dealerList.components.Dealer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.Page;
import utility.properties.PropertyLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by DWork on 22.06.2017.
 */
public class DealerList extends Page {

    public DealerList(WebDriver driver) {
        super(driver);
    }

    /*@FindBy(css = "#dialog_search_close")
    WebElement closeButton;

    @FindBy(css = "a[href*= 'dealer-review-form']")
    List<WebElement> addReviewButtons;*/



    public List <Dealer> getDealersList(){
        List <Dealer>  dealers = new ArrayList<>();
        for (WebElement dealer : driver.findElements(By.cssSelector("div.panel-body.no-padding-xs"))){
            WebElement userDealerName = driver.findElement(By.cssSelector("p.car-name"));
            List<WebElement> starsNumber = driver.findElements(By.cssSelector("p>.fa"));
            WebElement reviewsNumber = driver.findElement(By.cssSelector("p>.inline>a"));
            WebElement buttonViewInventory = driver.findElements(By.cssSelector(".fa.fa-eye")).get(0);
            WebElement buttonAddReview = driver.findElements(By.cssSelector(".fa.fa-plus")).get(0);

            dealers.add(new Dealer(userDealerName, starsNumber,reviewsNumber, buttonViewInventory,buttonAddReview));
        }
        return dealers;
    }

    public Dealer findDealerByDealerName(String userDealerName) {
        try {
            Predicate<Dealer> dealer = d -> d.sGetUserDealerName().contains(userDealerName);
            if (getDealersList().stream().filter(d -> d.sGetUserDealerName().contains(userDealerName)).noneMatch(dealer)) {
                buttonNextPage().click();
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".panel-heading"))));
            }
            return getDealersList().stream().filter(d -> d.sGetUserDealerName().contains(userDealerName)).findFirst().get();
        }catch(Exception ex){
            throw new RuntimeException("No user was found by given name");
        }
    }



    /*public Double getStarsNumber(){
        double count = 0;
        List<WebElement> stars = driver.findElements(By.cssSelector("p>.fa"));
        WebElement fullstar = driver.findElement(By.cssSelector("p>.fa.fa-star"));
        WebElement halfStar = driver.findElement(By.cssSelector("p>.fa-star-half-o"));
        for (WebElement star : stars){
            if(star==fullstar){
                count++;
            }else if(star==halfStar){
                count = count + 0.5;
            }
        }
        return count;
    }*/


    public void clickFirstAddReviewButton() {

        try {
            /*wait.until(ExpectedConditions.visibilityOf(addReviewButtons.get(0)));
            addReviewButtons.get(0).click();
            sleep(3);

            //waitForJSandJQueryToLoad();*/
            wait.until(ExpectedConditions.visibilityOf(findDealerByDealerName("Solomia Vasilivna").getButtonAddReview()));
            findDealerByDealerName("Solomia Vasilivna").getButtonAddReview().click();
        }catch(Exception ex){
            throw new RuntimeException("'Add Review' button wasn't clicked");
        }
    }

    public WebElement buttonNextPage() {
        return driver.findElement(By.cssSelector(".panel-heading a[aria-label='Next']"));
    }
}



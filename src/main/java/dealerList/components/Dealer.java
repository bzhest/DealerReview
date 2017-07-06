package dealerList.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Here are described an object Dealer with his properties and methods
 * sGetUserDealerName() - Receive all text before '/'
 * iGetReviewsNumber() - Receive all digit values from a string
 * getStarsNumber() - for each full-star class add '1' to counter, for half-star class add '0.5'
 */
public class Dealer {

    private WebElement userDealerName;
    private List<WebElement> stars;
    private WebElement reviewsNumber;
    private WebElement buttonViewInventory;
    private WebElement buttonAddReview;




    public Dealer(WebElement userDealerName, List<WebElement> stars, WebElement reviewsNumber, WebElement buttonViewInventory, WebElement buttonAddReview) {
        this.userDealerName = userDealerName;
        this.stars = stars;
        this.reviewsNumber = reviewsNumber;
        this.buttonViewInventory = buttonViewInventory;
        this.buttonAddReview = buttonAddReview;
    }

    public WebElement getUserDealerName() {
        return userDealerName;
    }

    public List<WebElement> getStars() {
        return stars;
    }

    public WebElement getReviewsNumber() {
        return reviewsNumber;
    }

    public WebElement getButtonViewInventory() {
        return buttonViewInventory;
    }

    public WebElement getButtonAddReview() {
        return buttonAddReview;
    }

    public String sGetUserDealerName(){
        String str = getUserDealerName().getText();
        return str.substring(0,str.indexOf('/')).trim();
    }

    public Integer iGetReviewsNumber(){
        return Integer.parseInt(getReviewsNumber().getText().replaceAll("\\D",""));
    }

    public Double getStarsNumber(WebDriver driver){
        double count = 0;
        List<WebElement> stars = getStars();
        WebElement fullstar = driver.findElement(By.cssSelector("p>.fa.fa-star"));
        WebElement halfStar = driver.findElement(By.cssSelector("p>.fa-star-half-o"));
        for (WebElement star : stars){
            if(star.equals(fullstar)){
                count++;
            }else if(star.equals(halfStar)){
                count += 0.5;
            }
        }
        return count;
    }
}

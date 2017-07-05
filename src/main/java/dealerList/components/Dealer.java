package dealerList.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Here are described an object Dealer with his properties and methods
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
}

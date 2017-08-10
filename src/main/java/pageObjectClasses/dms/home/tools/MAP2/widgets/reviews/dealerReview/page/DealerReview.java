package pageObjectClasses.dms.home.tools.MAP2.widgets.reviews.dealerReview.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjectClasses.dms.home.tools.MAP2.widgets.reviews.dealerReview.components.ReviewObject;
import utilities.utilityProject.page.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by DWork on 10.08.2017.
 */
public class DealerReview extends Page {

    public DealerReview(WebDriver driver){
        super(driver);
    }

    private By dealerReviewsList=  By.cssSelector(".panel.panel-default.panel_margin");
    private By byReviewTitle=  By.cssSelector("a[href^=\"/dealer-review_caption\"]");
    private By byReviewText=  By.cssSelector("div .drev-comentB>div");
    private By byStars=  By.cssSelector(".drev-stars-txt [class*= 'star']");
    private By byComments=  By.cssSelector("a[href^=\"/dealer-review_caption\"]");
    private By byAuthors=  By.cssSelector("strong small");

    public WebElement getNextButton(){
        List<WebElement> c = driver.findElements(By.cssSelector(".sr-only"));
        for(WebElement el:c){
            if (el.getText().contains("»"))
                return el;
        }
        return null;
    }


    public ReviewObject getDealerReviewByReviewTitle(String title){
        Predicate<ReviewObject> dealerReview = dr -> dr.sGetReviewTitleText().contains(title);
        if(getDealerReviewsList(driver).stream().filter( dr -> dr.sGetReviewTitleText().contains(title)).anyMatch(dealerReview)){
            return getDealerReviewsList(driver).stream().filter( dr -> dr.sGetReviewTitleText().contains(title)).findFirst().get();
        }
        try{
            if(getNextButton().isDisplayed()){
                getNextButton().click();
                getDealerReviewByReviewTitle(title);
            }
        }catch(Exception ex){
            throw new RuntimeException("review wasn't found");
        }
        return null;
    }

    public List<ReviewObject> getDealerReviewsList(WebDriver driver){
        List <ReviewObject> dealerReviews = new ArrayList<>();
        for (WebElement dealer: driver.findElements(dealerReviewsList)){
            WebElement reviewTitle = dealer.findElements(byReviewTitle).get(0);
            WebElement reviewText = dealer.findElement(byReviewText);
            List <WebElement> stars = dealer.findElements(byStars);
            WebElement comments = dealer.findElements(byComments).get(1);
            WebElement author = dealer.findElements(byAuthors).get(0);

            dealerReviews.add(new ReviewObject(reviewTitle,reviewText,stars,comments,author));
        }
        return dealerReviews;
    }

}

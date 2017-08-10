package pageObjectClasses.dms.home.tools.MAP2.widgets.reviews.dealerReview.components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Andrey on 09.08.2017.
 */
@Getter
public class DealerReview {
    private WebElement reviewTitle;
    private WebElement reviewText;
    private List<WebElement> stars;
    private WebElement comments;
    private WebElement author;

    By dealerReviewsList=  By.cssSelector(".panel.panel-default.panel_margin");
    By byReviewTitle=  By.cssSelector("a[href^=\"/dealer-review_caption\"]");
    By byReviewText=  By.cssSelector("div .drev-comentB>div");
    By byStars=  By.cssSelector(".drev-stars-txt [class*= 'star']");
    By byComments=  By.cssSelector("a[href^=\"/dealer-review_caption\"]");
    By byAuthors=  By.cssSelector("strong small");


    public DealerReview(WebElement reviewTitle, WebElement reviewText, List<WebElement> stars, WebElement comments, WebElement auther) {
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.stars = stars;
        this.comments = comments;
        this.author = auther;
    }

    public String sGetReviewTitleText(){
        return reviewTitle.getText();
    }

    public String sGetAuthorName(){
        String str = getAuthor().getText();
        return str.substring(str.indexOf("Written by "),str.indexOf(" on ")).trim();
    }

    public String sGetCommentsNumber() {
        String str = getAuthor().getText();
        return str.substring(str.indexOf("("), str.indexOf(")")).trim();
    }

    public List<DealerReview> getDealerReviewsList(WebDriver driver){
        List <DealerReview> dealerReviews = new ArrayList<>();
        for (WebElement dealer: driver.findElements(dealerReviewsList)){
            WebElement reviewTitle = dealer.findElements(byReviewTitle).get(0);
            WebElement reviewText = dealer.findElement(byReviewText);
            List <WebElement> stars = dealer.findElements(byStars);
            WebElement comments = dealer.findElements(byComments).get(1);
            WebElement author = dealer.findElements(byAuthors).get(0);

            dealerReviews.add(new DealerReview(reviewTitle,reviewText,stars,comments,author));
        }
        return dealerReviews;
    }

    public Double dGetStarsNumber(WebDriver driver){
        double count = 0;
        List<WebElement> stars = getStars();
        for (WebElement star : stars){
            if(star.getAttribute("class").equals("fa fa-star")){
                count++;
            }else if(star.getAttribute("class").equals("fa fa-star-half-o")){
                count += 0.5;
            }
        }
        return count;
    }

    public DealerReview getDealerReviewByReviewTitle(String title, WebDriver driver){
        Predicate<DealerReview> dealerReview = dr -> dr.sGetReviewTitleText().contains(title);
        if(getDealerReviewsList(driver).stream().filter( dr -> dr.sGetReviewTitleText().contains(title)).anyMatch(dealerReview)){
            return getDealerReviewsList(driver).stream().filter( dr -> dr.sGetReviewTitleText().contains(title)).findFirst().get();
        }
        return null;
    }
}

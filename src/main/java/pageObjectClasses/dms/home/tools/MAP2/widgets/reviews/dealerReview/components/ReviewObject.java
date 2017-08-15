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
public class ReviewObject {
    private WebElement reviewTitle;
    private WebElement reviewText;
    private List<WebElement> stars;
    private WebElement comments;
    private WebElement author;

    public ReviewObject(WebElement reviewTitle, WebElement reviewText, List<WebElement> stars, WebElement comments, WebElement auther) {
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

    public Double dGetStarsNumber(WebDriver driver){
        double count = 0;
        //List<WebElement> stars = getStars();
        for (WebElement star : stars){
            if(star.getAttribute("class").equals("fa fa-star")){
                count++;
            }else if(star.getAttribute("class").equals("fa fa-star-half-o")){
                count += 0.5;
            }else{
                count += 0;
            }
        }
        return count;
    }

}

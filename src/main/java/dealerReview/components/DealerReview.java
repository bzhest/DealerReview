package dealerReview.components;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Andrey on 09.08.2017.
 */
@Getter
public class DealerReview {
    private WebElement reviewTitle;
    private WebElement reviewText;
    private List<WebElement> stars;
    private WebElement comments;
    private WebElement auther;
    private WebElement date;

    public DealerReview(WebElement reviewTitle, WebElement reviewText, List<WebElement> stars, WebElement comments, WebElement auther, WebElement date) {
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.stars = stars;
        this.comments = comments;
        this.auther = auther;
        this.date = date;
    }

    public String sGetAuthorName(){
        String str = getAuther().getText();
        return str.substring(str.indexOf("Written by "),str.indexOf(" on ")).trim();
    }

    public Double dGetStarsNumber(WebDriver driver){
        double count = 0;
        List<WebElement> stars = getStars();
        //WebElement fullstar = driver.findElement(By.cssSelector("p>.fa.fa-star"));
        //WebElement halfStar = driver.findElement(By.cssSelector("p>.fa-star-half-o"));
        for (WebElement star : stars){
            if(star.getAttribute("class").equals("fa fa-star")){
                count++;
            }else if(star.getAttribute("class").equals("fa fa-star-half-o")){
                count += 0.5;
            }
        }
        return count;
    }
}

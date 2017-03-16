package dmsReviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by SYSTEM on 16.03.2017.
 */
public class DealerReview {
    @FindBy(how = How.CSS, using = "#.ui-widget-content.jqgrow.ui-row-ltr")
    private List<WebElement> ReviewsList;
}

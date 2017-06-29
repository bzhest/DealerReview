package utility.utils.lesson31FacadeAndMapping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by DWork on 29.06.2017.
 */
public class BookPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BookPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,30);
    }
}

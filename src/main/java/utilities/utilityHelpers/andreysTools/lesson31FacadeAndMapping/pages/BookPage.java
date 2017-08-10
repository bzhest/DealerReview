package utilities.utilityHelpers.andreysTools.lesson31FacadeAndMapping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.utilityHelpers.andreysTools.lesson31FacadeAndMapping.drivers.components.Book;

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

    public Book getBook(){
        WebElement image = driver.findElement(By.cssSelector("img[width = '200']"));
        WebElement title = driver.findElement(By.tagName("h1"));
        WebElement description = driver.findElement(By.cssSelector("span[itemprop = 'description']"));
        return new Book(image,title,description);
    }
}

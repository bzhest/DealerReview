package utility.utils.lesson31FacadeAndMapping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.utils.lesson31FacadeAndMapping.drivers.components.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DWork on 29.06.2017.
 */
public class SearchResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public List<Book> books() {
        List<Book> books = new ArrayList<>();
        WebElement list = driver.findElement(By.cssSelector(".top"));
        for (WebElement row : list.findElements(By.tagName("tr"))){
            WebElement image = row.findElement(By.tagName("img"));
            WebElement title = row.findElements(By.tagName("a")).get(1);
            WebElement description = row.findElements(By.tagName("td")).get(1);

            books.add(new Book(image,title,description));
        }
        return books;
    }

    public WebElement previousPageButton() {
        return driver.findElement(By.cssSelector("a[title = 'Prev page']"));
    }

    public WebElement nextPageButton() {
        return driver.findElement(By.cssSelector("a[title = 'Next page']"));
    }


}

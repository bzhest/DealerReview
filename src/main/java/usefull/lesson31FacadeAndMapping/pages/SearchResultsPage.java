package usefull.lesson31FacadeAndMapping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import usefull.lesson31FacadeAndMapping.drivers.components.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
        for (WebElement row : list.findElements(By.tagName("tr"))) {
            WebElement image = row.findElement(By.tagName("img"));
            WebElement title = row.findElements(By.tagName("a")).get(1);
            WebElement description = row.findElements(By.tagName("td")).get(1);

            books.add(new Book(image, title, description));
        }
        return books;
    }

    public Book findBookByTitle(String bookTitle) {
        Predicate<Book> title= b -> b.getTitle().getAttribute("title").contains(bookTitle);
        while (books().stream().filter(b -> b.getTitle().getAttribute("title").contains(bookTitle)).noneMatch(title)) {
                nextPageButton().click();
        }
        return books().stream().filter(b -> b.getTitle().getAttribute("title").contains(bookTitle)).findFirst().get();
    }

    public WebElement previousPageButton() {
        return driver.findElement(By.cssSelector("a[title = 'Prev page']"));
    }

    public WebElement nextPageButton() {
        return driver.findElement(By.cssSelector("a[title = 'Next page']"));
    }


}

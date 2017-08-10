package utilities.utilityHelpers.andreysTools.lesson31FacadeAndMapping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.utilityHelpers.andreysTools.lesson31FacadeAndMapping.drivers.components.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DWork on 29.06.2017.
 */
public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public WebElement topDownloadSection() {
        return getBlock("Top Download eBooks");
    }

    public List<Book> topDownloadedBooks() {
        List<Book> books = new ArrayList<>();
        for (WebElement book : topDownloadSection().findElements(By.className("top_box"))) {
            WebElement image = book.findElement(By.tagName("img"));
            WebElement title = book.findElements(By.tagName("a")).get(0);
            books.add(new Book(image, title));
        }
        return books;
    }

    public WebElement lastUploadedSection() {
        return getBlock("Last Upload eBooks");
    }

    public List<Book> lastUploadedBooks() {
        List<Book> books = new ArrayList<>();
        for (WebElement row : lastUploadedSection().findElements(By.cssSelector("tr[height = '150']"))) {
            WebElement image1 = row.findElements(By.cssSelector("td[width = '120']")).get(0);
            WebElement image2 = row.findElements(By.cssSelector("td[width = '120']")).get(1);

            WebElement title1 = row.findElements(By.tagName("a")).get(1);
            WebElement title2 = row.findElements(By.tagName("a")).get(3);

            WebElement description1 = row.findElements(By.tagName("div")).get(0);
            WebElement description2 = row.findElements(By.tagName("div")).get(1);

            books.add(new Book(image1, title1, description1));
            books.add(new Book(image2, title2, description2));

        }
        return books;
    }

    public WebElement newBookSection() {
        return getBlock("New eBooks");
    }

    private WebElement getBlock(String title) {
        try {
            return driver.findElements(By.cssSelector(".top")).stream().filter(b -> b.getText().contains(title)).findFirst().get();
        } catch (Exception ex) {
            throw new RuntimeException("block wasn't found", ex);
        }
    }
}

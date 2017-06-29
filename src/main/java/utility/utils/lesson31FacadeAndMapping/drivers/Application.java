package utility.utils.lesson31FacadeAndMapping.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.utils.lesson31FacadeAndMapping.drivers.components.SearchForm;
import utility.utils.lesson31FacadeAndMapping.pages.BookPage;
import utility.utils.lesson31FacadeAndMapping.pages.MainPage;
import utility.utils.lesson31FacadeAndMapping.pages.SearchResultsPage;

/**
 * Created by DWork on 29.06.2017.
 */
public class Application {
    private WebDriver driver;

    public Application(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        try{
            driver.get("http://it-ebooks.info");
            //wait for appication load
        }catch (Exception ex){
            throw  new RuntimeException("Page wasn't opened", ex);
        }
    }

    public BookPage bookpage(){
        return new BookPage(driver);
    }

    public MainPage mainPage(){
        return new MainPage(driver);
    }

    public SearchResultsPage searchResultsPage(){
        return new SearchResultsPage(driver);
    }

    public SearchForm searchForm(){
        return new SearchForm(driver.findElement(By.id("searchform")));
    }

}

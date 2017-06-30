package utility.utils.lesson31FacadeAndMapping.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.base.TestBase;
import utility.utils.lesson31FacadeAndMapping.drivers.Application;

/**
 * Created by DWork on 29.06.2017.
 */
public class BookSiteTests extends TestBase {
    private Application app;


    @Override
    protected void beforeTest() {
        logger.log("Open web application");
        app = new Application(driver);
        app.open();
    }

    @Test(priority = 1)
    public void testTopDownloadedBooksSection() {
        // it's easy to click for example on 5-th book title
        //app.mainPage().topDownloadedBooks().get(2).getTitle().click();

        logger.log("Check blog is present");
        Assert.assertTrue(app.mainPage().topDownloadSection().isDisplayed());
        logger.log("Check blog contains books");
        Assert.assertTrue(app.mainPage().topDownloadedBooks().size() == 10);
    }

    @Test(priority = 2)
    public void testLastDownloadedBooksSection() {
        logger.log("Check blog is present");
        Assert.assertTrue(app.mainPage().lastUploadedSection().isDisplayed());
        logger.log("Check blog contains books");
        Assert.assertTrue(app.mainPage().lastUploadedBooks().size() == 20);
    }


    @Test(priority = 3)
    public void testBookInfo() throws Exception {
        //SearchResultsPage searchResultsPage = home.selectTitleRadio().enterSearchField("Java").clickSearchButton();
        logger.log("Select Title search criteria");
        app.searchForm().radioTitle().click();
        logger.log("Enter search string");
        app.searchForm().input().sendKeys("Java");
        logger.log("click search button");
        app.searchForm().searchButton().click();
        //Assert.assertTrue(app.searchForm().searchButton().isEnabled());
        logger.log("open book page");
        //app.searchResultsPage().books().get(5).getTitle().click();
        app.searchResultsPage().findBookByTitle("Test-Driven Java Development").getTitle().click();
        logger.log("Check book info");
        Assert.assertEquals(app.bookpage().getBook().getTitle().getText(), "Test-Driven Java Development");
    }


}

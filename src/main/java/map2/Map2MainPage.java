package map2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.Page;
import utility.utils.javascript.Javascript;
import utility.utils.windowHandlers.WindowHandlers;

import java.util.List;


public class Map2MainPage extends Page {
    public Map2MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = "div[data-action='page_create']")
    public WebElement addNewPageButton;

    /*@FindBy(how = How.XPATH, using = "./*//*[@data-action='page_create']")
    public WebElement addNewPageButton;*/

    @FindBy(css = ".list-item")
    List<WebElement> pageItem;

    @FindBy(how = How.CSS, using = ".info>a")
    public WebElement linkHere;

    @FindBy(how = How.CSS, using = "span.ui-button.ui-state-default[title='Edit page']")
    public WebElement editPageButton;

    @FindBy(how = How.CSS, using = "span.ui-button.ui-state-default[title='Remove page']")
    public List<WebElement> deletePageButton;

    @FindBy(how = How.CSS, using = ".list.row")
    public List<WebElement> rowWithPageItems;

    @FindBy(how = How.CSS, using = "div.page-item[data-page='dealerlist']")
    public WebElement tabDealerList;

    @FindBy(how = How.CSS, using = "div.page-item[data-page='dealerreview']")
    public WebElement tabDealerReview;

    @FindBy(how = How.CSS, using = "div.page-item[data-page='dealerreviewform']")
    public WebElement tabDealerReviewForm;

    public void openDealerListTab() {
        wait.until(ExpectedConditions.visibilityOf(tabDealerList));
        tabDealerList.click();
    }

    public void openDealerReviewTab() {
        Javascript.scrollToElement(driver, tabDealerReview);
        wait.until(ExpectedConditions.visibilityOf(tabDealerReview));
        tabDealerReview.click();
    }

    public void openDealerReviewDetailsTab() {
        tabDealerReviewForm.click();
    }

    public WebElement getDeletePageButton() {
        return deletePageButton.get(0);
    }

    public void clickEditButton() {
        try {
            wait.until(ExpectedConditions.visibilityOf(editPageButton));
            editPageButton.click();
        }catch(Exception ex){

        }
    }

    //By noOneSavedPage = By.xpath(".//*[@class='page-browser']/div[2]/span");
    public void addNewPage() {
        wait.until(ExpectedConditions.visibilityOf(rowWithPageItems.get(0)));
        sleep(1);
        if (driver.findElements(By.cssSelector("span.info")).size() == 0) {
            sleep(1);
            for (WebElement e : pageItem) {
                sleep(1);
                wait.until(ExpectedConditions.visibilityOf(pageItem.get(0)));
                getDeletePageButton().click();
                WindowHandlers.acceptAlert(driver);
                sleep(1);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("mask")));
                wait.until(ExpectedConditions.visibilityOf(rowWithPageItems.get(0)));
            }
        } else {
//            wait.until(ExpectedConditions.visibilityOf(addNewPageButton));
            sleep(1);

            System.out.println("qweqq");
//            addNewPageButton.click();
//            Thread.sleep(1000);
        }
        addNewPageButton.click();
    }



    public void deleteCurrentWidget() {
        deletePageButton.get(0).click();
    }

    //------------------------------------------------------
    public void setUpDealerListWidget() throws Exception {
        openDealerListTab();
        addNewPage();
        manager.getPageEditor(driver).inputText(manager.getPageEditor(driver).getNameInput(), "Dealer List");
        manager.getPageEditor(driver).inputText(manager.getPageEditor(driver).getTitleInput(), "Dealer List");
        manager.getPageEditor(driver).clickOnLibrary();
    }
    //------------------------------------------------------
}
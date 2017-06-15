package map2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page.Page;

import java.util.List;


public class Map2MainPage extends Page {
    public Map2MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = "div.map-link.pull-right[data-action='page_create']")
    public WebElement addNewPageButton;

    @FindBy(how = How.CSS, using = "span.ui-button.ui-state-default[title='Edit page']")
    public WebElement editPageButton;

    @FindBy(how = How.CSS, using = "span.ui-button.ui-state-default[title='Remove page']")
    public List<WebElement> deletePageButton;

    @FindBy(how = How.CSS, using = "div.page-item[data-page='dealerlist']")
    public WebElement tabDealerList;

    @FindBy(how = How.CSS, using = "div.page-item[data-page='dealerreview']")
    public WebElement tabDealerReview;

    @FindBy(how = How.CSS, using = "div.page-item[data-page='dealerreviewform']")
    public WebElement tabDealerReviewForm;

    public void openDealerListTab() {
        tabDealerList.click();
    }

    public void openDealerReviewTab() {
        tabDealerReview.click();
    }

    public void openDealerReviewDetailsTab() {
        tabDealerReviewForm.click();
    }

    public void clickEditButton(){editPageButton.click();}

    public void addNewPage() {
        if(deletePageButton.size()>0) {
            deletePageButton.get(0).click();
            addNewPageButton.click();
        }else {
            addNewPageButton.click();
        }
    }

    public void deleteCurrentWidget(){
        deletePageButton.get(0).click();
    }

    //------------------------------------------------------
    public void setUpDealerListWidget(){
        openDealerListTab();

        addNewPage();
        manager.getPageEditor(driver).inputText(manager.getPageEditor(driver).getNameInput(),"Dealer List");
        manager.getPageEditor(driver).inputText(manager.getPageEditor(driver).getTitleInput(),"Dealer List");
        manager.getPageEditor(driver).clickOnLibrary();
    }
    //------------------------------------------------------
}
package dealerReviewForm.executor;

import utilities.utilityProject.properties.PropertyLoader;
import utilities.utilityProject.testBase.TestBase;

/**
 * Created by DWork on 15.08.2017.
 */
public class Executor extends TestBase {

    public void setUpDealerListPage(){
        logger.log("Open DMS main page");
        driver.get(PropertyLoader.loadProperty("dms.url"));
        logger.log("Go to MAP2");
        manager.getDmsMainPage(driver).clickToolsSubmenuMAP2Item();
        logger.log("Click on Dealer List tab");
        manager.getMap2MainPage(driver).openDealerListTab();
        logger.log("Add new Page");
        manager.getMap2MainPage(driver).addNewPage();
        logger.log("Add widget name");
        manager.getPage(driver).inputText(manager.getPageEditor(driver).getNameInput(), "dealerlist");
        logger.log("Add widget title");
        manager.getPage(driver).inputText(manager.getPageEditor(driver).getTitleInput(), "dealerlist");
        logger.log("Click on 'Library tab'");
        manager.getPageEditor(driver).clickOnLibrary();
        logger.log("drag and drop Dealer List icon");
        manager.getPageEditor(driver).addAnWidget(
                manager.getPageEditor(driver).getIconDealerList(),
                manager.getPageEditor(driver).getEmptyContainer());
        logger.log("drag and drop Login Form icon");
        manager.getPageEditor(driver).addAnWidget(
                manager.getPageEditor(driver).getIconLoginForm(),
                manager.getPageEditor(driver).getEmptyContainer());
        logger.log("Click on activation button");
        manager.getPageEditor(driver).getActivateButton().click();
    }

    public void setUpDealerReviewPage() {
        logger.log("Open DMS main page");
        driver.get(PropertyLoader.loadProperty("dms.url"));
        logger.log("Go to MAP2");
        manager.getDmsMainPage(driver).clickToolsSubmenuMAP2Item();
        manager.getMap2MainPage(driver).openDealerReviewTab();
        logger.log("Add new Page");
        manager.getMap2MainPage(driver).addNewPage();
        logger.log("Click on Page Settings");
        manager.getPageEditor(driver).getPageSettingsTab().click();
        logger.log("Add widget name");
        manager.getPage(driver).inputText(manager.getPageEditor(driver).getNameInput(), "dealerreview");
        logger.log("Add widget title");
        manager.getPage(driver).inputText(manager.getPageEditor(driver).getTitleInput(), "dealerreview");
        logger.log("Click on 'Library tab'");
        manager.getPageEditor(driver).clickOnLibrary();
        logger.log("drag and drop Dealer Review icon");
        manager.getPageEditor(driver).addAnWidget(
                manager.getPageEditor(driver).getIconDealerReview(),
                manager.getPageEditor(driver).getEmptyContainer());
        logger.log("Click on activation button");
        manager.getPageEditor(driver).getActivateButton().click();
        logger.log("Click on MAP button");
    }

    public void setUpDealerReviewFormPage() {
        logger.log("Open DMS main page");
        driver.get(PropertyLoader.loadProperty("dms.url"));
        logger.log("Go to MAP2");
        manager.getDmsMainPage(driver).clickToolsSubmenuMAP2Item();
        logger.log("Click on Dealer Review Form tab");
        manager.getMap2MainPage(driver).openDealerReviewDetailsTab();
        logger.log("Add new Page");
        manager.getMap2MainPage(driver).addNewPage();
        logger.log("Click on Page Settings");
        manager.getPageEditor(driver).getPageSettingsTab().click();
        logger.log("Add widget name");
        manager.getPage(driver).inputText(manager.getPageEditor(driver).getNameInput(), "dealerreview-form");
        logger.log("Add widget title");
        manager.getPage(driver).inputText(manager.getPageEditor(driver).getTitleInput(), "dealerreview-form");
        logger.log("Click on 'Library tab'");
        manager.getPageEditor(driver).clickOnLibrary();
        logger.log("drag and drop Dealer Review Form icon");
        manager.getPageEditor(driver).addAnWidget(
                manager.getPageEditor(driver).getIconDealerReviewForm(),
                manager.getPageEditor(driver).getEmptyContainer());
        logger.log("Click on activation button");
        manager.getPageEditor(driver).getActivateButton().click();
    }
}

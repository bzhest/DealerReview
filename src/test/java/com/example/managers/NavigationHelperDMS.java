package com.example.managers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by SYSTEM on 01.03.2017.
 */
public class NavigationHelperDMS extends HelperWithWebDriverBase{
    public NavigationHelperDMS(ApplicationManager manager){
        //Вызываем конструктор суперкласса и передаем ссылку
        super(manager);
    }

    public void openDMS() {
        if (manager.getWebDriverHelper().getDriver().getCurrentUrl() != manager.getWebDriverHelper().baseUrl + "dms") {
            manager.getWebDriverHelper().getDriver().get(manager.getWebDriverHelper().baseUrl + "dms");
                if(driver.findElements( By.cssSelector("#login") ).size() != 0){
                    manager.getFormHelper().loginToDMS("andrey.bzhestovskyy@xloo.com", "#login", "andrey87", "#password");
                    /*manager.getFormHelper().loginToDMS(
                            PropertyLoaderCredentials.loadProperty("loginValue"),
                            PropertyLoaderCredentials.loadProperty("loginLocator"),
                            PropertyLoaderCredentials.loadProperty("passwordValue"),
                            PropertyLoaderCredentials.loadProperty("passwordLocator") );*/
                }
        }
    }

    public void openDealershipReviewSettingsPage() {
        manager.getNavigationHelperDMS().openDMS();
        WebElement toolsMenu = manager.getWebDriverHelper().getDriver().findElements(By.cssSelector(".v9-main-item.v9_sub")).get(4);
        // захожу на Landing page в Settings > Review
        toolsMenu.click();
        WebElement ReviewImage = manager.getWebDriverHelper().getDriver().findElement(By.cssSelector(".big-module-item[href*='review-settings']"));
        //кликаю на иконку Review
        ReviewImage.click();
    }
}

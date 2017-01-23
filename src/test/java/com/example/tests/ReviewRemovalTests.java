package com.example.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by SYSTEM on 23.01.2017.
 */
public class ReviewRemovalTests extends TestBase{
    @Test(priority = 1) //этот тест будет выполняться первым
    public void reviewCanBeDeleted() {
        app.getFormHelper().deleteReview();
    }

    @AfterClass
    public void closeAllBrowsers() {
        app.getWebDriverHelper().driver.quit();
    }
}

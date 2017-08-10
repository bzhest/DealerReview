package com.example.managers;

import com.example.tests.FormFieldsObject;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by SYSTEM on 14.02.2017.
 */
public class LoaderHelper extends HelperWithWebDriverBase {

    public LoaderHelper(ApplicationManager manager){
        super(manager);
    }

    public boolean waitForJSandJQueryToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //method for execute Java Script: page should be loaded
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            //@Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            //@Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

}

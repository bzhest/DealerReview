package com.example.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by SYSTEM on 23.01.2017.
 */
public class ReviewRemovalTests extends TestBase{
    @Test(priority = 1) //этот тест будет выполняться первым
    public void reviewCanBeDeleted() {
        Set <FormFieldsObject> oldList = app.getFormHelper().getReviewsData();
        app.getFormHelper().deleteReview();
        Set <FormFieldsObject> newList = app.getFormHelper().getReviewsData();
        verifyReviewDeleted(oldList, newList);
    }

    @AfterClass
    public void closeAllBrowsers() {
        app.getWebDriverHelper().driver.quit();
    }

    private void verifyReviewDeleted(Set<FormFieldsObject> oldList, Set<FormFieldsObject> newList) {
        //Проверка при помощи библиотеки TestNG для Assert
        //Это альтернативная проверка - более легкая в понимании
        MatcherAssert.assertThat(newList.size()+1,equalTo(oldList.size()));
        /*validForm.setID("!!!");
        oldList.add(validForm);
        validForm.setID("null");
        MatcherAssert.assertThat(newList,equalTo(oldList));*/
    }

}

package com.example.tests;


import java.util.Set;

import org.hamcrest.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import org.openqa.selenium.*;

import static org.hamcrest.core.IsEqual.equalTo;


public class ReviewCreationTests extends TestBase {

    @AfterClass
    public void closeAllBrowsers() {
        app.getWebDriverHelper().driver.quit();
    }

    //Ниже указана логика работы теста
    @Test(priority = 1) //Этот тест будет выполняться первым
    public void reviewCanBeCreated() throws Exception {
        app.getNavigationHelper().fromHomePageGoToDealerReviewPage();
        //Получения группы Тайтлов до теста
         Set <FormFieldsObject> oldList = app.getFormHelper().getReviewsData();
        //Действия
        app.getNavigationHelper().onDealerReviewPageClick_AddReview();
        app.getNavigationHelper().switchToAnotherWindow(2);
        FormFieldsObject validForm = new FormFieldsObject()
                .setNickname("'rock-n-roll").setEmail("test_1@dxloo.com").setLocation("Dnipro").setReviewTitle("Title for test1").setReviewText("Here is a very long text, just imagine");
        app.getFormHelper().fillAllFormFields(validForm);
        app.getFormHelper().markParametersWithStars("1", "4");
        app.getFormHelper().markParametersWithStars("3", "2");
        app.getFormHelper().markParametersWithStars("5", "5");
        app.getFormHelper().clickSubmit();
        app.webDriverHelper.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-default.return")));
        app.getFormHelper().click_Return_OnOpenedModalWindow();
        //Получения группы Тайтлов после теста
        Set <FormFieldsObject> newList = app.getFormHelper().getReviewsData();
        verifyReviewAdded(oldList, validForm, newList);


    }

    private void verifyReviewAdded(Set<FormFieldsObject> oldList, FormFieldsObject validForm, Set<FormFieldsObject> newList) {
        //Проверка при помощи библиотеки TestNG для Assert
        //Это альтернативная проверка - более легкая в понимании
        MatcherAssert.assertThat(newList.size(),equalTo(oldList.size()+1));
        /*validForm.setID("!!!");
        oldList.add(validForm);
        validForm.setID("null");
        MatcherAssert.assertThat(newList,equalTo(oldList));*/
    }


    @Test(priority = 2) //Этот тест будет выполняться первым
    public void reviewFilledWithEmptyData() throws Exception {
        //Закрываем вторую вкладку браузера и переходим на первую
        app.getNavigationHelper().switchToAnotherWindow(2);
        app.getNavigationHelper().closeSecondTabAndGoToFirstTab();
        app.getNavigationHelper().fromHomePage_toDealerReviewForm();
        //Переходим с первой вкладки на вторую
        app.getNavigationHelper().switchToAnotherWindow(1);
        FormFieldsObject emptyForm = new FormFieldsObject()
                .setNickname("").setEmail("").setLocation("").setReviewTitle("").setReviewText("");
        app.getFormHelper().fillAllFormFields(emptyForm);
        app.getFormHelper().clickSubmit();
    }








    /*
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }*/
}

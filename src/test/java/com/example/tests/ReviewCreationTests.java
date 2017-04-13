package com.example.tests;


import java.util.*;

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
    @Test(dataProvider = "randomFormFields") //Этот тест будет выполняться первым
    public void reviewCanBeCreated(FormFieldsObject validForm) throws Exception {
        //app.getNavigationHelperDWS().fromHomePageGoToDealerReviewPage();
        //Получения группы Тайтлов до теста
         Set <FormFieldsObject> oldList = app.getFormHelper().getReviewsData();
        //Действия
        app.getNavigationHelperDWS().onDealerReviewPageClick_AddReview();
        app.getNavigationHelperDWS().switchToAnotherWindow(2);
        app.getFormHelper().fillAllFormFields(validForm);
        app.getFormHelper().selectStar("1", "4");
        app.getFormHelper().selectStar("3", "2");
        app.getFormHelper().selectStar("5", "5");
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

    private void verifyReviewDeleted(Set<FormFieldsObject> oldList, FormFieldsObject validForm, Set<FormFieldsObject> newList) {
        //Проверка при помощи библиотеки TestNG для Assert
        //Это альтернативная проверка - более легкая в понимании
        MatcherAssert.assertThat(newList.size()+1,equalTo(oldList.size()));
        /*validForm.setID("!!!");
        oldList.add(validForm);
        validForm.setID("null");
        MatcherAssert.assertThat(newList,equalTo(oldList));*/
    }


    /*@Test //Этот тест будет выполняться первым
    public void reviewFilledWithEmptyData() throws Exception {
        //Закрываем вторую вкладку браузера и переходим на первую

        app.getNavigationHelperDWS().switchToAnotherWindow(2);
        app.getNavigationHelperDWS().closeSecondTabAndGoToFirstTab();
        app.getNavigationHelperDWS().fromHomePage_toDealerReviewForm();
        Set <FormFieldsObject> oldList = app.getFormHelper().getReviewsData();
        //Переходим с первой вкладки на вторую
        app.getNavigationHelperDWS().switchToAnotherWindow(1);
        FormFieldsObject emptyForm = new FormFieldsObject()
                .setNickname("").setEmail("").setLocation("").setReviewTitle("").setReviewText("");
        app.getFormHelper().fillAllFormFields(emptyForm);
        app.getFormHelper().clickSubmit();
        Set <FormFieldsObject> newList = app.getFormHelper().getReviewsData();
        verifyReviewNotAdded(oldList, emptyForm, newList);
    }*/



    Random rnd = new Random();

    @DataProvider(name = "randomFormFields")
    public Iterator<Object[]> generateRandomFieldNames(){
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i = 0; i<1; i++) {
            FormFieldsObject form = new FormFieldsObject()
                    .setNickname("Vasia" + "+" + rnd.nextInt())
                    .setEmail("autotest@dxloo.com")
                    .setLocation("Dnipro" + "+" + rnd.nextInt())
                    .setReviewTitle("some title" + "+" + rnd.toString())
                    .setReviewText("some text" + "+" + rnd.toString());
            list.add(new Object[]{form});
        }
        return list.iterator();

    }

}

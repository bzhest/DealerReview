package com.example.managers;

import com.example.tests.FormFieldsObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by SYSTEM on 17.01.2017.
 */
public class FormHelper extends HelperWithWebDriverBase {

    public FormHelper(ApplicationManager manager) {
        //Вызываем конструктор суперкласса и передаем ссылку
    super(manager);
    }


    public void click_Return_OnOpenedModalWindow() {
        findElement(By.cssSelector(".btn.btn-default.return")).click();
    }

    public void clickSubmit() {

        findElement(By.cssSelector("#revf-submit")).click();
    }

    public void fillAllFormFields(FormFieldsObject formFieldsObject) {
        typeTextInField(formFieldsObject.getNickname(), ".form-control[name='user_nickname']");
        typeTextInField(formFieldsObject.getEmail(), ".form-control[name='user_email']");
        typeTextInField(formFieldsObject.getLocation(), ".form-control[name='user_location']");
        typeTextInField(formFieldsObject.getReviewTitle(), ".form-control[name='title']");
        typeTextInField(formFieldsObject.getReviewText(), ".form-control[name='content']");
    }

    /*public void typeTextInField(String nickname, String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
        driver.findElement(By.cssSelector(locator)).sendKeys(nickname);
    }*/

    public void markParametersWithStars(final String parameterNumber, final String starsNumber) {
    /*
    parameterNumber - это число, указывающее на номер параметра, в котором будут выставлять звезды
    starsNumber - принимает значения от 1 до 5 - это значит:
    1 - 0,5 звезды
    2 - 1.5 звезды
    3 - 2,5 звезды
    4 -  3,5 звезды
    5 - 5 звезд
    */
        findElement(By.xpath("//form[@id='reviewform']/fieldset[2]/div/div/div[" + parameterNumber + "]/div/div/span/i[" + starsNumber + "]")).click();
    }

    public void deleteReview() {
    }


}

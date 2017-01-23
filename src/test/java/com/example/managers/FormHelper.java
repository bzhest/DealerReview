package com.example.managers;

import  com.example.tests.FormFieldsObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

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
        driver.get("http://www.solomia.andreyb.ixloo.com/" + "/dms/login");
        loginToDMS("andrey.bzhestovskyy@xloo.com", "#login", "andrey87", "#password");
        Select dropdown = new Select(driver.findElements(By.cssSelector(".v9-main-item.v9_sub")).get(3));
        dropdown.selectByVisibleText("Reviews");
        findElement(By.id("leads_container")).click();
        findElement(By.linkText("Reviews")).click();
        findElement(By.xpath("//div[@id='tabs-1']/div[3]")).click();
        findElement(By.id("jqg_reviews-list_2857")).click();
        //Идем обратно в ДВС на Dealer Review страницу
        driver.get("http://www.solomia.andreyb.ixloo.com/dealer-review.html");
    }

    public void loginToDMS(String loginValue, String loginLocator, String passwordValue, String passwordLocator) {
        typeTextInField(loginValue, loginLocator);
        typeTextInField(passwordValue, passwordLocator);
        driver.findElement(By.id("login2")).click();

    }


}

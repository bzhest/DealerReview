package com.example.managers;

import  com.example.tests.FormFieldsObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

<<<<<<< HEAD
import java.awt.*;
import java.awt.event.KeyEvent;
=======
import java.util.regex.Matcher;
import java.util.regex.Pattern;
>>>>>>> 9dfd41f8b24b5313ffaaf86c007a617e0ca5c984

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
        Actions action = new Actions(driver);
        //Нахожу меню Tools
        WebElement toolsMenu = driver.findElements(By.cssSelector(".v9-main-item.v9_sub")).get(3);
<<<<<<< HEAD
        action.moveToElement(toolsMenu).build().perform();

        //В выпадающем списке кликаю на Reviews
        manager.getWebDriverHelper().wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a:contains('Reviews')")));

        /*WebElement toolMenuItemReviews = driver.findElement(By.cssSelector("li a:contains('Reviews')"));
        toolMenuItemReviews.click();*/
        Select dropdown = new Select(driver.findElements(By.cssSelector(".v9-main-item.v9_sub")).get(3));
        dropdown.selectByVisibleText("Reviews");




        //нахожу последнее добавленое Review и получаю его ID в поле ReviewIDforLastAddedReview
        WebElement lastAddedReview = driver.findElements(By.cssSelector(".ui-widget-content.jqgrow.ui-row-ltr")).get(0);
        int ReviewIDforLastAddedReview = Integer.parseInt(lastAddedReview.getAttribute("id"));
=======
        action.moveToElement(toolsMenu).build();
        action.moveToElement(toolsMenu).perform();

        //В выпадающем списке кликаю на Reviews
        WebElement toolMenuItemReviews = driver.findElement(By.cssSelector("a[href='/dms/tools/reviews']"));
        manager.getWebDriverHelper().wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/dms/tools/reviews']")));
        toolMenuItemReviews.click();


        //Нахожу последнее добавленое Review в DMS и получаю его ID в поле ReviewIDforLastAddedReviewDMS
        WebElement lastAddedReviewDMS = driver.findElements(By.cssSelector(".ui-widget-content.jqgrow.ui-row-ltr")).get(0);
        int ReviewIDforLastAddedReviewDMS = Integer.parseInt(lastAddedReviewDMS.getAttribute("id"));

>>>>>>> 9dfd41f8b24b5313ffaaf86c007a617e0ca5c984
        //Кликаю на чекбокс последнего добавленного ревью
        WebElement firstReviewsCheckbox = driver.findElement(By.cssSelector("#jqg_reviews-list_"+ReviewIDforLastAddedReviewDMS+""));
        if (!firstReviewsCheckbox.isSelected())
        {
            firstReviewsCheckbox.click();
        }
        //Нажимаю кнопку Удалить
        WebElement deleteButton = driver.findElement(By.cssSelector("td[title='Delete review']"));
        deleteButton.click();

        //Идем обратно в ДВС на Dealer Review страницу
        driver.get("http://www.solomia.andreyb.ixloo.com/dealer-review.html");

        //Нахожу последнее добавленое Review в DWS и получаю его ID в поле ReviewIDforLastAddedReviewDWS
        WebElement lastAddedReviewDWS = driver.findElements(By.cssSelector("a[href*='dealer-review_caption_title']")).get(0);
        String hrefValue = lastAddedReviewDWS.getAttribute("href");
        //Взять первое попавшееся число в тексте (в моем случае это будет ID)
        Pattern p = Pattern.compile("(^|\\s)([0-9]+)($|\\s)");
        Matcher ReviewIDforLastAddedReviewDWS = p.matcher(hrefValue);

        //int ReviewIDforLastAddedReviewDWS = Integer.parseInt(StringReviewIDforLastAddedReviewDWS);
    }

    public void loginToDMS(String loginValue, String loginLocator, String passwordValue, String passwordLocator) {
        typeTextInField(loginValue, loginLocator);
        typeTextInField(passwordValue, passwordLocator);
        driver.findElement(By.id("login2")).click();

    }


}

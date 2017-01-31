package com.example.managers;

import  com.example.tests.FormFieldsObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


//import java.awt.*;
import java.awt.event.KeyEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by SYSTEM on 17.01.2017.
 */
public class FormHelper extends HelperWithWebDriverBase {

    public FormHelper(ApplicationManager manager) {
        //Вызываем конструктор суперкласса и передаем ссылку
    super(manager);
    }

    public Set<FormFieldsObject> getReviewsTitles() {
        manager.getNavigationHelper().openHomePage();
        manager.getNavigationHelper().fromHomePageGoToDealerReviewPage();
        //Получаю список всех блков с Ревью
        List <WebElement> reviewsTitles = driver.findElements(By.cssSelector(".col-lg-12.col-md-12.col-sm-12.col-xs-12>a"));
        //Сюда будет в Сет помещаться объект ГрупОбджект, построенный из reviewBlock
        Set <FormFieldsObject> reviews =  new HashSet<FormFieldsObject>();
        //Переменная reviewBlock будет по очереди принимать значения из reviewsTitles
        for (WebElement reviewTitle : reviewsTitles)
              {
                  String idFromHref = reviewTitle.getAttribute("href");
                  FormFieldsObject review = new FormFieldsObject(idFromHref,null,null,null,null );
            reviews.add(review);
        }
           // ID = ID.substring("-rid_".length(),"_dealer_".length());
        } 
        return null;
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

        action.moveToElement(toolsMenu).build();
        action.moveToElement(toolsMenu).perform();


        //В выпадающем списке кликаю на Reviews

        WebElement toolMenuItemReviews = driver.findElement(By.cssSelector("a[href='/dms/tools/reviews']"));
        manager.getWebDriverHelper().wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/dms/tools/reviews']")));
        toolMenuItemReviews.click();


        //Нахожу последнее добавленое Review в DMS и получаю его ID в поле ReviewIDforLastAddedReviewDMS
        WebElement lastAddedReviewDMS = driver.findElements(By.cssSelector(".ui-widget-content.jqgrow.ui-row-ltr")).get(0);
        int ReviewIDforLastAddedReviewDMS = Integer.parseInt(lastAddedReviewDMS.getAttribute("id"));


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

        //Нахожу последнее добавленое Review в DWS и получаю его полный адрес в ссылку hrefValue
        WebElement lastAddedReviewDWS = driver.findElements(By.cssSelector("a[href*='dealer-review_caption_title']")).get(0);
        String hrefValue = lastAddedReviewDWS.getAttribute("href");
        //Проверяю, есть ли в этом адресе ID из ДМС
        Pattern p = Pattern.compile(String.valueOf(ReviewIDforLastAddedReviewDMS));
        Matcher m = p.matcher(hrefValue);
        boolean b = m.matches();
        Assert.assertFalse(b);
        //перед запуском надо чистить куки!!!!!!
        //Если результат False - то удаление прошло успешно, test прошел - в DWS ID из DMS нет


    }

    public void loginToDMS(String loginValue, String loginLocator, String passwordValue, String passwordLocator) {
        typeTextInField(loginValue, loginLocator);
        typeTextInField(passwordValue, passwordLocator);
        driver.findElement(By.id("login2")).click();

    }



}

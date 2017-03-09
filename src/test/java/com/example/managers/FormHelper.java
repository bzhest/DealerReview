package com.example.managers;

import  com.example.tests.FormFieldsObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


//import java.awt.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by SYSTEM on 17.01.2017.
 */
public class FormHelper extends HelperWithWebDriverBase {

    public FormHelper(ApplicationManager manager) {
        //Вызываем конструктор суперкласса и передаем ссылку
    super(manager);
    }

    public Set<FormFieldsObject> getReviewsData() {
        manager.getNavigationHelperDWS().openHomePage();
        manager.getNavigationHelperDWS().fromHomePageGoToDealerReviewPage();
        WebElement paginationButtonAll = driver.findElements(By.cssSelector(".pagination.pagination-sm>li>a")).get(4);
        paginationButtonAll.click();
        manager.getLoaderHelper().waitForJSandJQueryToLoad();
        //Ниже список элементов List будет перегоняться в множество объектов Set
        //Получаю список всех блоков с текстом ревью
        List <WebElement> reviewsTexts = driver.findElements(By.cssSelector(".drev-comentB.text-justify>div:first-child"));
        //Сюда будет в Сет помещаться объект ГрупОбджект, построенный из reviewText
        Set <FormFieldsObject> reviews =  new HashSet<FormFieldsObject>();//Set - коллекция, элементы которой неупорядоченны и уникальны. Используем ее реализацию HashSet
        //Переменная reviewText будет по очереди принимать значения из reviewsTexts
        for (WebElement reviewText : reviewsTexts)
              {

                  //Получение элемента, в атребуте которого содержится ID ревью
                  String id = reviewText.getAttribute("id");
                  id = id.substring("rsmall_".length(), id.length());
                  //Получение текста элемента, а именно reviewTextContent
                  String reviewTextContent = reviewText.getAttribute("textContent");
                  reviewTextContent = reviewTextContent.trim(); //Удаляет пробелы до и после предложения
                  //reviewTextContent = reviewTextContent.replaceAll("\\s+","");Удаляет все пробелы
                  //*ID = ID.replaceAll("\\D+",""); Удаляет все не цифры
                  // Символы в Java беруться в одинарный ковычки '', а строки в двойные ""
                  // int index = somestring.indexOf('P'); - получаю индекс символа 'P'

                  FormFieldsObject review = new FormFieldsObject()
                          .setID(id).setReviewText(reviewTextContent);
            reviews.add(review);
        }


        return reviews;
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
    parameterNumber - Это число, указывающее на номер параметра, в котором будут выставлять звезды
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
        manager.getNavigationHelperDMS().openDMS();
        //Пока закомичу, буду сразу переходить на страницу - http://solomia.andreyb.ixloo.com/dms/tools/reviews#dealer-review
        /*Actions action = new Actions(driver);
        //Нахожу меню Tools
        WebElement toolsMenu = driver.findElements(By.cssSelector(".v9-main-item.v9_sub")).get(3);

        action.moveToElement(toolsMenu).build();
        action.moveToElement(toolsMenu).perform();


        //В выпадающем списке кликаю на Reviews

        WebElement toolMenuItemReviews = driver.findElement(By.cssSelector("a[href='/dms/tools/reviews']"));
        manager.getWebDriverHelper().wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/dms/tools/reviews']")));
        toolMenuItemReviews.click();*/
        WebElement toolsMenu = driver.findElements(By.cssSelector(".v9-main-item.v9_sub")).get(3);
        toolsMenu.click();
        WebElement ReviewImage = driver.findElements(By.cssSelector(".img")).get(11);
        ReviewImage.click();
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
        //driver.get("http://www.solomia.andreyb.ixloo.com/dealer-review.html");

        //Нахожу последнее добавленое Review в DWS и получаю его полный адрес в ссылку hrefValue
        //WebElement lastAddedReviewDWS = driver.findElements(By.cssSelector("a[href*='dealer-review_caption_title']")).get(0);
        //String hrefValue = lastAddedReviewDWS.getAttribute("href");
        //Проверяю, есть ли в этом адресе ID из ДМС
        //Pattern p = Pattern.compile(String.valueOf(ReviewIDforLastAddedReviewDMS));
        //Matcher m = p.matcher(hrefValue);
        //boolean b = m.matches();
        //Assert.assertFalse(b);
        //перед запуском надо чистить куки!!!!!!
        //Если результат False - то удаление прошло успешно, test прошел - в DWS ID из DMS нет


    }

    public void loginToDMS(String loginValue, String loginLocator, String passwordValue, String passwordLocator) {
        typeTextInField(loginValue, loginLocator);
        typeTextInField(passwordValue, passwordLocator);
        driver.findElement(By.id("login2")).click();

    }
    public void selectStar(final String paramNumber, String starNumber) {

        double d= Double.valueOf(starNumber);
        if (d==(int)d){
            //Если starNumber - єто Intager, то наведение курсора на звезду со сдвигом право (получение целой звезди)
            WebElement star = manager.getWebDriverHelper().getDriver().findElement(By.xpath("//div[@class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12 full-width-in-thin\"]/div[@class=\"form-control-static row\"][" + paramNumber + "]//span[@class=\"stars\"]/i[@class=\"fa fa-star-o\"][" + starNumber + "]"));
            int width = star.getSize().getWidth();
            Actions act = new Actions(manager.getWebDriverHelper().getDriver());
            act.moveToElement(star).moveByOffset((width/2)-2, 0).click().perform();
        }else{
            //Если starNumber - єто Double, то наведение курсора на звезду со сдвигом влево (получение половины звезди)
            starNumber = "" + (int)(Double.parseDouble(starNumber)+0.5);
            WebElement star1 = manager.getWebDriverHelper().getDriver().findElement(By.xpath("//div[@class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12 full-width-in-thin\"]/div[@class=\"form-control-static row\"][" + paramNumber + "]//span[@class=\"stars\"]/i[@class=\"fa fa-star-o\"][" + starNumber + "]"));
            int width = star1.getSize().getWidth();
            Actions act = new Actions(manager.getWebDriverHelper().getDriver());
            act.moveToElement(star1).moveByOffset((width/2)-8, 0).click().perform();
        }

    }


}

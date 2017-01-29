package com.example.managers;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Andrey on 18.01.2017.
 */
public class NavigationHelper extends HelperWithWebDriverBase{

    public NavigationHelper(ApplicationManager manager){
        //Вызываем конструктор суперкласса и передаем ссылку
        super(manager);
    }

    public void onDealerReviewPageClick_AddReview() {
        findElement(By.linkText("Add Review")).click();
    }

    public void fromHomePageGoToDealerReviewPage() {
        //if (getCurrentURL() != "http://www.solomia.andreyb.ixloo.com/dealer-review.html")
        findElement(By.linkText("Dealer Review")).click();
    }

    public void openHomePage()
    {
        driver.get(manager.getWebDriverHelper().baseUrl + "index");
    }

    /*public void switchToAnotherWindow() {
        Set<String> allWindowHandles= driver.getWindowHandles();
        String window1 = (String)allWindowHandles.toArray()[0];
        String window2 = (String)allWindowHandles.toArray()[1];
        driver.switchTo().window(window2);
    }*/

    public void switchToAnotherWindow(int winNumber) {
        Set allWindowHandles= driver.getWindowHandles();// возвращает набор дискрипторов окон
        String neededWindow= (String)allWindowHandles.toArray()[winNumber -1];
        driver.switchTo().window(neededWindow);
    }



    public void fromHomePage_toDealerReviewForm() {
        //openHomePage();
        fromHomePageGoToDealerReviewPage();
        onDealerReviewPageClick_AddReview();
    }

    public void closeSecondTabAndGoToFirstTab() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }


}

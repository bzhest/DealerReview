package utility.utils.exam.drivers.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.utils.exam.drivers.components.Bug;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 02.07.2017.
 */
public class BugsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BugsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public List<Bug> getBugsList() {
        List<Bug> issuesList = new ArrayList<>();
        WebElement table = driver.findElement(By.cssSelector("table.x-grid-table"));
        for (WebElement row : table.findElements(By.cssSelector("tr.x-grid-row"))) {
            WebElement name = row.findElement(By.cssSelector("td.x-grid-cell.x-grid-cell-gridcolumn-1020"));
            WebElement notes = row.findElement(By.cssSelector("td.x-grid-cell.x-grid-cell-gridcolumn-1021"));

            issuesList.add(new Bug(name, notes));
        }
        return issuesList;
    }

    public Bug getBugByName(String name) {
        try {
            for (Bug bug : getBugsList()) {
                if (bug.getName().getText().equals(name))
                    return bug;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Bug with such name wasn't find");
        }
        return null;

    }

    public Boolean checkIfBugPresentByName(String name) {
        try {
            int count = 0;
            for (Bug bug : getBugsList()) {
                if (bug.getName().getText().equals(name)) {
                    count++;
                }
            }
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }


    public void inputText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }


}

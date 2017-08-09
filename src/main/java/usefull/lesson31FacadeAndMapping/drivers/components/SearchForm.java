package usefull.lesson31FacadeAndMapping.drivers.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by DWork on 29.06.2017.
 */
public class SearchForm {

    private WebElement form;

    public SearchForm (WebElement element){
        this.form = element;
    }

    public WebElement input(){
        return form.findElement(By.name("q"));
    }

    public WebElement searchButton(){
        return form.findElement(By.cssSelector("input[type = 'submit']"));
    }

    public WebElement radioTitle(){
        return radio("title");
    }

    public WebElement radioAuthor(){
        return radio("author");
    }

    public WebElement radioIsbn(){
        return radio("isbn");
    }

    public WebElement radioGoogle(){
        return radio("google");
    }

    private WebElement radio(String value){
        try{
            return form.findElements(By.id("type")).stream()
                    .filter( r -> r.getAttribute("value").contains(value)).findFirst().get();
        }catch(Exception ex){
            throw new RuntimeException("radio wasn't found", ex);
        }
    }
}

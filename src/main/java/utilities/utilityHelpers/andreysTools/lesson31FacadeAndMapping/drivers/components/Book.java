package utilities.utilityHelpers.andreysTools.lesson31FacadeAndMapping.drivers.components;

import org.openqa.selenium.WebElement;

/**
 * Created by DWork on 29.06.2017.
 */
public class Book {
    private WebElement image;
    private WebElement title;
    private WebElement description;

    public Book(WebElement image, WebElement title) {
        this(image,title,null);
    }

    public Book(WebElement image, WebElement title, WebElement description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public WebElement getImage() {
        return image;
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "image=" + image +
                ", title=" + title +
                ", description=" + description +
                '}';
    }
}

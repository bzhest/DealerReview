package com.example.managers;

import org.openqa.selenium.WebDriver;

/**
 * Created by Andrey on 16.01.2017.
 */
public class ApplicationManager {

    private static ApplicationManager singleton;
    public WebDriverHelper webDriverHelper;
    public FormHelper formHelper;
    public NavigationHelper navigationHelper;
    public LoaderHelper loaderHelper;

    public static ApplicationManager getInstance() {
        if (singleton == null) {
            singleton = new ApplicationManager();
        }
        return singleton;
    }



    public void stop() {
        if (webDriverHelper != null) {
            webDriverHelper.stop();
        }
    }

   /* public WebDriver getDriver() {
        return getWebDriverHelper().getDriver();
    }*/
// Уточнить у Леши. как правильно добавлять хелперы в эрей и вызывать их
    /*class CityRegistry {
        private static Map<String, City> references = new HashMap<>();
        public static void registerCity(String id, City reference) {
            references.put(id, reference);
        }
        public static City getCity(String id) {
            return references.get(id);
        }*/

    //Динамическое создание объекта
    /*String className = "Class1"; - здесь будет вместо Class1 - название хелпера
    Object xyz = Class.forName(className).newInstance();*/ //- здесь динамически будет создаваться объект

    public FormHelper getFormHelper() {
        if(formHelper == null) {
            formHelper = new FormHelper(this);
        }
        return formHelper;
    }

    public NavigationHelper getNavigationHelper(){
        if (navigationHelper == null){
            navigationHelper = new NavigationHelper(this);
        }
        return navigationHelper;
    }

    public WebDriverHelper getWebDriverHelper(){
        if(webDriverHelper == null){
            webDriverHelper = new WebDriverHelper(this);
        }
        return webDriverHelper;
    }

    public LoaderHelper getLoaderHelper(){
        if(loaderHelper == null){
            loaderHelper = new LoaderHelper(this);
        }
        return loaderHelper;
    }

}

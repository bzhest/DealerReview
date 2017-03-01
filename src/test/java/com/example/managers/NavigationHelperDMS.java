package com.example.managers;

/**
 * Created by SYSTEM on 01.03.2017.
 */
public class NavigationHelperDMS extends HelperWithWebDriverBase{
    public NavigationHelperDMS(ApplicationManager manager){
        //Вызываем конструктор суперкласса и передаем ссылку
        super(manager);
    }

    public void openDMS() {
        if (manager.getWebDriverHelper().getDriver().getCurrentUrl() != manager.getWebDriverHelper().baseUrl + "dms") {
            manager.getFormHelper().loginToDMS("andrey.bzhestovskyy@xloo.com", "#login", "andrey87", "#password");
        }
    }
}

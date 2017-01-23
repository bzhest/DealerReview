package com.example.tests;

import com.example.managers.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.fail;

/**
 * Created by Andrey on 14.01.2017.
 */
public class TestBase {

    //Чтобы работать с ApplicationManager - в TestBase должна быть ссылка на ApplicationManager
    public ApplicationManager app;

    // В методе beforeTest у нас иниц. ApplicationManager, поэтому в его конструктор можем перенести содержимое
    @BeforeTest
    public void beforeTest() {
        app = ApplicationManager.getInstance();
        app = new ApplicationManager();
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {

        //System.setProperty("webdriver.chrome.driver", "E://Selenium_Jars/chromedriver.exe");
        //driver = new ChromeDriver();

        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    //Ниже указаны реализационные детали (низкоуровневая часть)
    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        ApplicationManager.getInstance().stop();

    }
}

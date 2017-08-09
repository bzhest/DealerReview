
package utilityHelpers.thread;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Andrey on 18.06.2017.
 */
public class MyThread implements Runnable {
    private int delay;
    private int repeatNumber;
    private Thread thread;
    private String threadName;

    public MyThread(int delay, int repeatNumber, String threadName) {
        this.delay = delay;
        this.repeatNumber = repeatNumber;
        thread = new Thread(this);
        thread.start();
        this.threadName = threadName;

    }

    @Override
    public void run(){
        for (int i = 0; i < repeatNumber; i++) {
            System.out.println( threadName + "" + i);
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com");
            driver.findElement(By.id("lst-ib")).sendKeys("Automation testing");
            driver.findElement(By.id("lst-ib")).sendKeys(Keys.RETURN);
            try {
                Thread.sleep(delay);
            }catch(Exception ex){}
            driver.quit();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ie) {

            }
        }

    }
}


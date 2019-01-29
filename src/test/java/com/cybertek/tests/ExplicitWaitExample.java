package com.cybertek.tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {


    /*
    Explicit Wait:
    •There can be instance when a particular element takes more than a minute to load.
    •In that case you definitely not like to set a huge time to Implicit wait, as if you do this your browser will going to wait for the same   time for every element.
    •To avoid that situation you can simply put a separate time on the required element only.
    •By following this your browser implicit wait time would be short for every element and it would be large for specific element
   */


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(3);
        Driver.closeDriver();
    }

    @Test
    public void test() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();

        //this is explicit wait, it waits for like clickable, enable, disappear, and certain text, ect.
        //you create it by creating an object WebDriverWait
        //just by creating the object it doesnt do anything, you have to use the UNTIL
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello");
    }
}

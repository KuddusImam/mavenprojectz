package com.cybertek.tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SleepAndImplicitWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(3);
        //  Driver.closeDriver();
    }

    @Test
    public void testSleep() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("finish")).getText());

    }

    @Test
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.tagName("button")).click();
        System.out.println(driver.findElement(By.id("finish")).getText());
    }

    @Test
    public void implicitWait2(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("form#checkbox-example>button")).click();
        System.out.println(driver.findElement(By.id("message")).getText());
        driver.findElement(By.cssSelector("form#checkbox-example>button")).click();
        System.out.println(driver.findElement(By.id("checkbox")).isDisplayed());
    }
}

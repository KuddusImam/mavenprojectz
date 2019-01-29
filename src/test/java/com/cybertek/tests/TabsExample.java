package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class TabsExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/windows");
    }

    @AfterMethod
    public void leanUp(){

        driver.quit();
    }
    /*Test case:
    go to http://the-internet.herokuapp.com/windows
    click on click "Click Here"

    verify that new title is “New window”
    verify that new title is not “The internet”
     */

    @Test
    public void changeTab(){
        System.out.println(driver.getWindowHandles().size());
        System.out.println(driver.getWindowHandle());
        driver.findElement(By.linkText("Click Here")).click();

        System.out.println(driver.getWindowHandles().size());
        // change to the new tab

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("*******************************");
        for(String handle:windowHandles){
            System.out.println(handle);

            driver.switchTo().window(handle);
            System.out.println(driver.getTitle());

            if(driver.getTitle().equals("New Window")){
                break;
            }
        }
        Assert.assertEquals(driver.getTitle(), "New Window");
    }
}

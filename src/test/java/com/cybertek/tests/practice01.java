package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class practice01 {
    public static void main(String[] args) {
        /*Search Amazon
        1. Open browser
        2. Go to http://www.amazon.com
        3. Enter any search term
        4. Click on search button
        5. Verify title contains the search term
         */

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.amazon.com");

        //Web element
        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
        input.sendKeys("book"+ Keys.ENTER);

        String expected = "Book";
        String actual = driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");

        if(actual.equalsIgnoreCase(expected)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actual = "+ actual);
            System.out.println("expected = "+ expected);
        }
        //driver.close();


    }

}

package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://washingtondc.craigslist.org/");

        //driver.findElement(By.xpath("//*[@id=\"bbb1\"]/li[5]/a/span")).click();
        // find web element
        //1.id-> attribute
        //2.name
        //3.class
        //4.tagname
        //5.css

        //when our element is a link
        //1.linkText
        //2.partialLinkText

        //driver.findElement(By.linkText("computer")).click();
        //driver.findElement(By.partialLinkText("farm")).click();



    }
}

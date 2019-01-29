package com.cybertek.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cybertek.utilities.TestBase;

public class HoverTest extends TestBase {

    @Test
    public void test(){
        driver.get("https://www.amazon.com/");
        WebElement signin  = driver.findElement(By.xpath("//span[.='Hello. Sign in']"));
        //moving the mouse on top of the given element
        actions.moveToElement(signin).perform();
        driver.findElement(By.xpath("//span[.='YourHearts']")).click();
        Assert.assertTrue(driver.getTitle().contains("Interesting"));
    }

    @Test
    public void test2(){
        driver.get("https://www.amazon.com/");
        WebElement help = driver.findElement(By.xpath("(//a[.='Help'])[2]"));
        actions.moveToElement(help).perform();

    }
}

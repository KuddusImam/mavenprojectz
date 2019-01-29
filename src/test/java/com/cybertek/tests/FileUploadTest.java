package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        String path = "C:\\Users\\BestBuy\\Downloads\\cat1.jpg";
        chooseFile.sendKeys(path);

        driver.findElement(By.id("file-submit")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());
        Thread.sleep(3000);


    }
}

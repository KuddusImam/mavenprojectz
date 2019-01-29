package com.cybertek.tests;

/*
1.open browser
2.go to https://amazon.com
3.verifythat default dropdown option is all
4.verify that all options are sorted alphabetically
5.Click on the menu icon on the left
6.click on Full Store directory
7.capture all of the main department namesin the page.
8.verify that departments names are sorted alphabetically
9.verify that all departments names are listed in the dropdown from step 2
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DepartmentsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");
    }
    @Test (priority = 0)
    public void test(){
        //finding the element with a select tag
        WebElement selectElement = driver.findElement(By.id("searchDropdownbox"));
        // create a select class object
        Select allDepartment= new Select(selectElement);
        // get the current selected option
        String selectedOption = allDepartment.getFirstSelectedOption().getText();
        // verify that default dropdown options is all
        // TODO skipping because failing
        Assert.assertEquals(selectedOption,"All");
    }



}

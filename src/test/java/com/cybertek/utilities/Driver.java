package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
    private static WebDriver driver;//instance that will be shared across everybody
    // this is a private constructor, this make sure nobody create object
    private Driver(){};
    public  static WebDriver getDriver(){
        if (driver==null){
            String browser = ConfigurationReader.getProperty("browser");

            if ("chrome".equals(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

            } else if ("firefox".equals(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            } else if ("ie".equals(browser)) {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();

            } else if ("MicrosoftEdge".equals(browser)) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();

            }
        }
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver= null;
        }
    }
}


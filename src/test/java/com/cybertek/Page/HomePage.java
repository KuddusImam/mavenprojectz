package com.cybertek.Page;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement userName;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passWord;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement signinBtn;

    @FindBy(id = "ctl00_MainContent_status")
    public WebElement errMsg;

    public void login(String userName, String passWord){
        this.userName.sendKeys(userName);
        this.passWord.sendKeys(passWord);
        signinBtn.click();
    }

    public void open(){

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
}


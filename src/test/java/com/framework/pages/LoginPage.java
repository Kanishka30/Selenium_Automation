package com.framework.pages;

import com.framework.base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.LocatorUtils; 

public class LoginPage {

    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverManager.getDriver();
    }
    // Login user > verify if logged > logout 
    public void login(String username, String password) {
        Assert.assertTrue(driver.findElement(LocatorUtils.AUTO_EXE).isDisplayed(),"Automation Exercise NOT displayed");
        driver.findElement(LocatorUtils.LOGIN_SIGNUP).click();
        driver.findElement(LocatorUtils.EMAIL_INPUT).sendKeys(username); 
        driver.findElement(LocatorUtils.PASSWORD_INPUT).sendKeys(password); 
        driver.findElement(LocatorUtils.LOGIN_BUTTON).click();  
        Assert.assertTrue(driver.findElement(LocatorUtils.LOGGED).isDisplayed(),"User NOT logged in");
    }
    public void logout(){ 
        driver.findElement(LocatorUtils.LOGOUT).click();
        Assert.assertTrue(driver.findElement(LocatorUtils.LOGIN_SIGNUP).isDisplayed(),"User Logged in");
    }
}

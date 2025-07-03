package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.framework.base.DriverManager;
import utils.LocatorUtils;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage() {
        this.driver = DriverManager.getDriver();
    }

    // signup > register user > verify if logged > delete account > verify
    
    public void register() throws InterruptedException{
        Assert.assertTrue(driver.findElement(LocatorUtils.AUTO_EXE).isDisplayed(),"Automation Exercise");
        driver.findElement(LocatorUtils.LOGIN_SIGNUP).click();
        driver.findElement(LocatorUtils.SIGNUP_NAME).sendKeys("testuser456");
        driver.findElement(LocatorUtils.EMAIL_ADD).sendKeys("testuser456@yahoo.com");
        driver.findElement(LocatorUtils.SIGNUP_BUTTON).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(LocatorUtils.ENTER_ACCOUNT_INFORMATION).isDisplayed(),"Enter Account Information NOT displayed.");
    }

    public void accountInformation() throws InterruptedException{
        driver.findElement(LocatorUtils.TITLE_MR).click();
        driver.findElement(LocatorUtils.TITLE_MR).isSelected();
        driver.findElement(LocatorUtils.PASSWORD_REGISTER).sendKeys("password456");
        
        //Update DOB
        Select se = new Select(driver.findElement(LocatorUtils.DOB_DAY));
        se.selectByValue("18");
        Thread.sleep(2000);
        //Assert.assertTrue(driver.findElement(LocatorUtils.DOB_DAY).isSelected(), "Day NOT selected in DOB.");
        Select se1 = new Select(driver.findElement(LocatorUtils.DOB_MONTH));
        se1.selectByVisibleText("March");
        Thread.sleep(2000);
        //Assert.assertTrue(driver.findElement(LocatorUtils.DOB_MONTH).isSelected(),"Month NOT selected in DOB");
        Select se2 = new Select(driver.findElement(LocatorUtils.DOB_YEAR));
        se2.selectByValue("1998");
        Thread.sleep(2000);
        //Assert.assertTrue(driver.findElement(LocatorUtils.DOB_YEAR).isSelected()," Year NOT selected in DOB.");
        driver.findElement(LocatorUtils.NEWSLETTER).click();
        driver.findElement(LocatorUtils.NEWSLETTER).isSelected();
    }

    public void addressInformation(){
        driver.findElement(LocatorUtils.FIRST_NAME).sendKeys("testuser");
        driver.findElement(LocatorUtils.LAST_NAME).sendKeys("456");
        driver.findElement(LocatorUtils.COMPANY).sendKeys("Self-Employed");
        driver.findElement(LocatorUtils.ADDRESS).sendKeys("267");
        driver.findElement(LocatorUtils.ADDRESS2).sendKeys("8th street");
        Assert.assertTrue(driver.findElement(LocatorUtils.ADDRESS).isDisplayed(),"Address is NOT displayed.");
        Select se3 = new Select(driver.findElement(LocatorUtils.COUNTRY));
        se3.selectByVisibleText("Singapore");
        Assert.assertTrue(driver.findElement(LocatorUtils.COUNTRY).isDisplayed());

        driver.findElement(LocatorUtils.STATE).sendKeys("Central Region");
        driver.findElement(LocatorUtils.CITY).sendKeys("Newton");
        driver.findElement(LocatorUtils.ZIPCODE).sendKeys("543870");
    }

    public void accountCreated(){
        driver.findElement(LocatorUtils.MOBILE_NUM).sendKeys("+6587623490");
        driver.findElement(LocatorUtils.CREATE_ACC).click();
        Assert.assertTrue(driver.findElement(LocatorUtils.ACC_CREATED).isDisplayed());
        driver.findElement(LocatorUtils.CONTINUE).click();
        Assert.assertTrue(driver.findElement(LocatorUtils.LOGGED).isDisplayed());
    }

    public void accountDeleted(){
        driver.findElement(LocatorUtils.DELETE_ACC).click();
        driver.findElement(LocatorUtils.ACC_DELETED).isDisplayed();
        driver.findElement(LocatorUtils.CONTINUE).click();
        Assert.assertTrue(driver.findElement(LocatorUtils.AUTO_EXE).isDisplayed());
    }

}

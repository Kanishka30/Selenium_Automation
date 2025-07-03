package com.framework.pages;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.base.DriverManager;
import utils.LocatorUtils;

public class PlaceOrderPage {
    //checkin > view category product women > add to cart > category product men > add to cart > view cart > remove item > proceed to checkout > place order > download invoice > continue
    private WebDriver driver;

    public PlaceOrderPage() {
        this.driver = DriverManager.getDriver();
    }

    public void orderLogin(String username, String password) {
        driver.findElement(LocatorUtils.AUTO_EXE).isDisplayed();
        driver.findElement(LocatorUtils.LOGIN_SIGNUP).click();
        driver.findElement(LocatorUtils.EMAIL_INPUT).sendKeys(username); 
        driver.findElement(LocatorUtils.PASSWORD_INPUT).sendKeys(password); 
        driver.findElement(LocatorUtils.LOGIN_BUTTON).click();  
        Assert.assertTrue(driver.findElement(LocatorUtils.LOGGED).isDisplayed(),"User NOT logged in");
        driver.findElement(LocatorUtils.LOGGED).isDisplayed(); 
    }

    public void selectItem() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement womenBtn = wait.until(ExpectedConditions.elementToBeClickable(LocatorUtils.WOMEN));
        womenBtn.click();
        WebElement pdtBtn = wait.until(ExpectedConditions.elementToBeClickable(LocatorUtils.PRODUCT));
        pdtBtn.click();
        driver.findElement(LocatorUtils.ADD_TO_CART).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(LocatorUtils.CONTINUE_SHOP).isDisplayed());
        WebElement continueShoppingBtn = wait.until(ExpectedConditions.elementToBeClickable(LocatorUtils.CONTINUE_SHOP)); 
        continueShoppingBtn.click();
        WebElement menBtn = wait.until(ExpectedConditions.elementToBeClickable(LocatorUtils.MEN));
        menBtn.click();
        WebElement tshirtBtn = wait.until(ExpectedConditions.elementToBeClickable(LocatorUtils.TSHIRTS));
        tshirtBtn.click();
        //driver.findElement(LocatorUtils.TSHIRTS).click();
        //driver.findElement(LocatorUtils.PRODUCT).click();
        WebElement pdtBtn1 = wait.until(ExpectedConditions.elementToBeClickable(LocatorUtils.PRODUCT));
        pdtBtn1.click();
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(LocatorUtils.ADD_TO_CART));
        addToCart.click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(LocatorUtils.VIEW_CART).isDisplayed());
        }

    public void placeOrder(){
        driver.findElement(LocatorUtils.VIEW_CART).click();
        driver.findElement(LocatorUtils.REMOVE_ITEM).click();
        driver.findElement(LocatorUtils.PROCEED_TO_CHECKOUT).click();
        Assert.assertTrue(driver.findElement(LocatorUtils.ADDRESS_DETAILS).isDisplayed());
        driver.findElement(LocatorUtils.PLACE_ORDER).click();
    }

    public void payment(){
        driver.findElement(LocatorUtils.NAME_CARD).sendKeys("John Doe");
        driver.findElement(LocatorUtils.CARD_NUMBER).sendKeys("1234567890124321");
        driver.findElement(LocatorUtils.CVC).sendKeys("311");
        driver.findElement(LocatorUtils.EXPIRE_MONTH).sendKeys("11");
        driver.findElement(LocatorUtils.EXPIRE_YEAR).sendKeys("2019");
        Assert.assertTrue(driver.findElement(LocatorUtils.PAY_N_CONFIRM).isDisplayed());
        driver.findElement(LocatorUtils.PAY_N_CONFIRM).click();
    }

    public void orderPlaced(){
        Assert.assertTrue(driver.findElement(LocatorUtils.ORDER_PLACED).isDisplayed());
        driver.findElement(LocatorUtils.DOWNLOAD_INVOICE).click();
        driver.findElement(LocatorUtils.CONTINUE).click();
        Assert.assertTrue(driver.findElement(LocatorUtils.LOGGED).isDisplayed()); 
    }

    public void orderLogout(){
        driver.findElement(LocatorUtils.LOGOUT).click();
        Assert.assertTrue(driver.findElement(LocatorUtils.LOGIN_SIGNUP).isDisplayed());
    }
}

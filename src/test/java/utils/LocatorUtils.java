package utils;

import org.openqa.selenium.By;

public class LocatorUtils {
    // Locators for Login Page
    public static final By AUTO_EXE = By.xpath("//img[@alt='Website for automation practice']"); 
    public static final By LOGIN_SIGNUP = By.xpath("//div[@class='shop-menu pull-right']/ul/li[4]");
    public static final By EMAIL_INPUT = By.xpath("//input[@data-qa='login-email']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@name='password']");
    public static final By LOGIN_BUTTON = By.xpath("//button[@data-qa='login-button']");
    public static final By LOGGED = By.xpath("//i[@class='fa fa-user']");
    public static final By LOGOUT = By.xpath("//i[@class='fa fa-lock']");

    // Locators for Register Page
    public static final By SIGNUP_NAME = By.xpath("//input[@data-qa='signup-name']");
    public static final By EMAIL_ADD = By.xpath("//input[@data-qa='signup-email']");
    public static final By SIGNUP_BUTTON = By.xpath("//button[@data-qa='signup-button']");
    public static final By ENTER_ACCOUNT_INFORMATION = By.xpath("(//h2[@class='title text-center'])[1]");
    public static final By TITLE_MR = By.xpath("//input[@id='id_gender1']");
    public static final By PASSWORD_REGISTER = By.xpath("//input[@id='password']");
    public static final By DOB_DAY = By.xpath("//select[@id='days']");
    public static final By DOB_MONTH = By.xpath("//select[@id='months']");
    public static final By DOB_YEAR = By.xpath("//select[@id='years']");
    public static final By NEWSLETTER = By.xpath("//input[@type='checkbox']");
    public static final By FIRST_NAME = By.xpath("//input[@id='first_name']");
    public static final By LAST_NAME = By.xpath("//input[@id='last_name']");
    public static final By COMPANY = By.xpath("//input[@id='company']");
    public static final By ADDRESS = By.xpath("//input[@id='address1']");
    public static final By ADDRESS2 = By.xpath("//input[@id='address2']");
    public static final By COUNTRY = By.xpath("//select[@id='country']");
    public static final By STATE =By.xpath("//input[@id='state']");
    public static final By CITY = By.xpath("//input[@id='city']");
    public static final By ZIPCODE = By.xpath("//input[@id='zipcode']");
    public static final By MOBILE_NUM = By.xpath("//input[@id='mobile_number']");
    public static final By CREATE_ACC = By.xpath("//button[@class='btn btn-default']");
    public static final By ACC_CREATED = By.xpath("//b[text()='Account Created!']");
    public static final By CONTINUE = By.xpath("//a[text()='Continue']");
    public static final By DELETE_ACC = By.xpath("//i[@class='fa fa-trash-o']");
    public static final By ACC_DELETED = By.xpath("//b[text()='Account Deleted!']");

    //Locators for PlaceOrder Test
    public static final By WOMEN = By.xpath("//a[normalize-space()='Women']");
    public static final By DRESS = By.xpath("//a[text()='Dress ']");
    public static final By PRODUCT = By.xpath("(//i[@class='fa fa-plus-square'])[1]");
    public static final By ADD_TO_CART = By.xpath("//button[@class='btn btn-default cart']");
    public static final By CONTINUE_SHOP = By.xpath("//button[text()='Continue Shopping']"); 
    public static final By MEN = By.xpath("(//span[@class='badge pull-right'])[2]");
    public static final By TSHIRTS = By.xpath("//a[text()='Tshirts ']");
    public static final By VIEW_CART = By.xpath("//u[text()='View Cart']");
    public static final By REMOVE_ITEM = By.xpath("//a[@class='cart_quantity_delete'][@data-product-id='2']");
    public static final By PROCEED_TO_CHECKOUT = By.xpath("//a[text()='Proceed To Checkout']");
    public static final By ADDRESS_DETAILS = By.xpath("//h2[text()='Address Details']");
    public static final By PLACE_ORDER = By.xpath("//a[text()='Place Order']");
    public static final By NAME_CARD = By.xpath("//input[@name='name_on_card']");
    public static final By CARD_NUMBER = By.xpath("//input[@name='card_number']");
    public static final By CVC = By.xpath("//input[@name='cvc']");
    public static final By EXPIRE_MONTH = By.xpath("//input[@name='expiry_month']");
    public static final By EXPIRE_YEAR = By.xpath("//input[@name='expiry_year']");
    public static final By PAY_N_CONFIRM = By.xpath("//button[@class='form-control btn btn-primary submit-button']");
    public static final By ORDER_PLACED = By.xpath("//b[text() ='Order Placed!']");
    public static final By DOWNLOAD_INVOICE = By.xpath("//a[text() ='Download Invoice']");

 }

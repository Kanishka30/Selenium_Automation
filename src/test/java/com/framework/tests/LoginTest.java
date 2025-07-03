// package com.framework.tests;

// import com.framework.base.BaseTest;
// import com.framework.pages.LoginPage;
// import org.testng.annotations.Test;
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;
// //import java.util.Properties;

// public class LoginTest extends BaseTest {
    
//         @Test
//         public void testValidLogin() {
//             LoginPage loginPage = new LoginPage();
//             loginPage.login("testuser789@gmail.com", "password789");
//             loginPage.logout();
//             System.out.println("LoginTest successfully completed.");
//         }
// }
package com.framework.tests;

import com.framework.base.BaseTest;
import com.framework.pages.LoginPage;

import utils.ScreenshotUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Test
    public void testValidLogin() {
        test = extent.createTest("testValidLogin"); // Creating test in Extent Report

        LoginPage loginPage = new LoginPage();
        
        logger.info("Starting test: testValidLogin");
        test.info("Starting test: testValidLogin");

        try {
            logger.info("Attempting to log in with valid credentials.");
            test.info("Entering login credentials.");
            loginPage.login("testuser789@gmail.com", "password789");
            test.pass("Login successful.");
            
            logger.info("Logging out...");
            test.info("Logging out.");
            loginPage.logout();
            test.pass("Logout successful.");

            logger.info("LoginTest successfully completed.");
            test.info("LoginTest successfully completed.");
        } catch (Exception e) {
            logger.error("Test failed due to an exception.", e);
            test.fail("Test failed due to an exception: " + e.getMessage());
            String screenshotPath = ScreenshotUtils.takeScreenshot(driver, "testLoginUser");
            logger.error("Test failed. Screenshot saved at: " + screenshotPath, e);
            test.fail("Test failed. Screenshot below:").addScreenCaptureFromPath(screenshotPath);
        }
    }
}

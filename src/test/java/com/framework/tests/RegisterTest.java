// package com.framework.tests;

// import org.testng.annotations.Test;

// import com.framework.base.BaseTest;
// import com.framework.pages.RegisterPage;

// public class RegisterTest  extends BaseTest{
//     //private static final String UserInput = null;
    
//         @Test
//         public void testRegisterUser() throws InterruptedException{
//             RegisterPage registerUser = new RegisterPage();
//             registerUser.register();
//             registerUser.accountInformation();
//             registerUser.addressInformation();
//             registerUser.accountCreated();
//             System.out.println("User is registered.");
//             registerUser.accountDeleted();
//             System.out.println("User is deleted.");
//             System.out.println("RegisterTest.java is success!!!");
//     }   
// }
package com.framework.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import com.framework.base.BaseTest;
import com.framework.pages.RegisterPage;

import utils.ScreenshotUtils;

public class RegisterTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(RegisterTest.class);

    @Test
    public void testRegisterUser() throws InterruptedException {
        test = extent.createTest("testRegisterUser"); // Creating test in Extent Report

        RegisterPage registerUser = new RegisterPage();

        try {
            logger.info("Starting testRegisterUser test.");
            test.info("Starting testRegisterUser test.");

            logger.info("Filling out registration details.");
            test.info("Filling out registration details.");
            registerUser.register();
            test.pass("User details entered successfully.");

            logger.info("Entering account information.");
            test.info("Entering account information.");
            registerUser.accountInformation();
            test.pass("Account information entered successfully.");

            logger.info("Entering address details.");
            test.info("Entering address details.");
            registerUser.addressInformation();
            test.pass("Address information entered successfully.");

            logger.info("Creating account.");
            test.info("Creating account.");
            registerUser.accountCreated();
            test.pass("Account created successfully.");
            logger.info("User is registered.");

            logger.info("Deleting user account.");
            test.info("Deleting user account.");
            registerUser.accountDeleted();
            test.pass("User account deleted successfully.");
            logger.info("User is deleted.");

            logger.info("RegisterTest.java test completed successfully.");
            test.info("RegisterTest.java test completed successfully.");

        } catch (Exception e) {
            logger.error("Test failed due to an exception.", e);
            test.fail("Test failed due to an exception: " + e.getMessage());
            String screenshotPath = ScreenshotUtils.takeScreenshot(driver, "testRegisterUser");
            logger.error("Test failed. Screenshot saved at: " + screenshotPath, e);
            test.fail("Test failed. Screenshot below:").addScreenCaptureFromPath(screenshotPath);
        }
    }
}

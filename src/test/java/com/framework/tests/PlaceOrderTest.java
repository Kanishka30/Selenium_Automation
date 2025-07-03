// package com.framework.tests;

// import org.testng.annotations.Test;
// import com.framework.base.BaseTest;
// import com.framework.pages.PlaceOrderPage;

// public class PlaceOrderTest extends BaseTest {
//     @Test
//         public void placeOrderCheckout() throws InterruptedException{
//             PlaceOrderPage placeOrderPage = new PlaceOrderPage();
//             placeOrderPage.orderLogin("testuser789@gmail.com", "password789");
//             placeOrderPage.selectItem();
//             placeOrderPage.placeOrder();
//             placeOrderPage.payment();
//             placeOrderPage.orderPlaced();
//             placeOrderPage.orderLogout();
//     }
// }
package com.framework.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import com.framework.base.BaseTest;
import com.framework.pages.PlaceOrderPage;

import utils.ScreenshotUtils;

public class PlaceOrderTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(PlaceOrderTest.class);

    @Test
    public void placeOrderCheckout() throws InterruptedException {
        test = extent.createTest("placeOrderCheckout"); // Creating test in Extent Report

        PlaceOrderPage placeOrderPage = new PlaceOrderPage();

        try {
            logger.info("Starting placeOrderCheckout test.");
            test.info("Starting placeOrderCheckout test.");

            logger.info("Logging in with test user.");
            test.info("Logging in with test user.");
            placeOrderPage.orderLogin("testuser789@gmail.com", "password789");
            test.pass("Login successful.");

            logger.info("Selecting item for purchase.");
            test.info("Selecting item for purchase.");
            placeOrderPage.selectItem();
            test.pass("Item selected successfully.");

            logger.info("Proceeding to place the order.");
            test.info("Proceeding to place the order.");
            placeOrderPage.placeOrder();
            test.pass("Order placed successfully.");

            logger.info("Entering payment details.");
            test.info("Entering payment details.");
            placeOrderPage.payment();
            test.pass("Payment processed successfully.");

            logger.info("Confirming order placement.");
            test.info("Confirming order placement.");
            placeOrderPage.orderPlaced();
            test.pass("Order confirmed successfully.");

            logger.info("Logging out after order placement.");
            test.info("Logging out after order placement.");
            placeOrderPage.orderLogout();
            test.pass("Logout successful.");

            logger.info("placeOrderCheckout test completed successfully.");
            test.info("placeOrderCheckout test completed successfully.");

        } catch (Exception e) {
            logger.error("Test failed due to an exception.", e);
            test.fail("Test failed due to an exception: " + e.getMessage());
            String screenshotPath = ScreenshotUtils.takeScreenshot(driver, "testPlaceOrderUser");
            logger.error("Test failed. Screenshot saved at: " + screenshotPath, e);
            test.fail("Test failed. Screenshot below:").addScreenCaptureFromPath(screenshotPath);
        }
    }
}

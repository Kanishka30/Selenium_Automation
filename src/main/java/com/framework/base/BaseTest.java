// package com.framework.base;

// import com.aventstack.extentreports.ExtentReports;
// import com.aventstack.extentreports.ExtentTest;
// import com.aventstack.extentreports.reporter.ExtentSparkReporter;

// import java.io.File;
// import java.io.IOException;

// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;
// import org.apache.commons.io.FileUtils;
// import org.openqa.selenium.OutputType;
// import org.openqa.selenium.TakesScreenshot;
// import org.openqa.selenium.WebDriver;
// import org.testng.annotations.BeforeMethod;
// import org.testng.ITestResult;
// import org.testng.annotations.AfterMethod;

// public class BaseTest {
//     protected WebDriver driver;
//     public static ExtentReports extent;
//     public static ExtentTest test;
//     private static final Logger logger = LogManager.getLogger(BaseTest.class);

//     @BeforeMethod
//     public void setUp() {
//         if (extent == null) {
//             setupExtentReport();  // Initialize Extent Reports once
//         }
//         test = extent.createTest(getClass().getSimpleName()); // Test name is class name

//         driver = DriverManager.getDriver(); // Use DriverManager to get a single instance
//         driver.get("https://www.automationexercise.com/"); //url taht needs to be loaded
//         logger.info("Navigated to Automation Exercise Website"); // addlogs to extent reports via log4j
//         test.info("Navigated to Automation Exercise Website"); // website information
        
//         System.out.println("Inside BaseTest");
//     }

//     @AfterMethod
//     public void tearDown(ITestResult result) {
//         if (result.getStatus() == ITestResult.FAILURE) {
//             logger.error("Test Failed: " + result.getThrowable());
//             test.fail("Test Failed: " + result.getThrowable());

//             // Capture Screenshot on Failure
//             //String screenshotPath = takeScreenshot(result.getName());
//             //test.addScreenCaptureFromPath(screenshotPath); 
//             // Attach Screenshot Directly to Extent Report
//             String base64Screenshot = takeScreenshotBase64();
//             test.addScreenCaptureFromBase64String(base64Screenshot, "Screenshot of Failure");
//             String filePath = takeScreenshot("Failure_" + result.getName());
//             try {
//                 test.addScreenCaptureFromPath(filePath);
//             } catch (Exception e) {
//                 logger.error("Could not attach local screenshot: " + e.getMessage());
//             }
//         }
//         else if (result.getStatus() == ITestResult.SKIP) {
//             logger.warn("Test Skipped: " + result.getThrowable());
//             test.skip("Test Skipped: " + result.getThrowable());
//         } else {
//             logger.info("Test Passed");
//             test.pass("Test Passed");
//         }

//         DriverManager.quitDriver();
//         test.info("Browser closed");
//         logger.info("Browser closed");

//         extent.flush();
//     }

//     public static void setupExtentReport() {
//         ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
//         extent = new ExtentReports();
//         extent.attachReporter(htmlReporter);
//         logger.info("Extent Report setup initialized.");
//     }

//     public String takeScreenshotBase64() {
//         return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//     }

//     // Capture Screenshot & Save to File
//     public String takeScreenshot(String testName) {
//         File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//         String filePath = "test-output/screenshots/" + testName + ".png";
//         File destFile = new File(filePath);
//         try {
//             FileUtils.copyFile(srcFile, destFile);
//             logger.info("Screenshot saved at: " + filePath);
//         } catch (IOException e) {
//             logger.error("Error while saving screenshot: " + e.getMessage());
//         }
//         return filePath;
//     }

//     public static void flushReport() {
//         if (extent != null) {
//             extent.flush();
//             logger.info("Extent Report generated.");
//         }
//     }
// }
package com.framework.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
        if (extent == null) {
            setupExtentReport();
        }
        test = extent.createTest(getClass().getSimpleName());

        driver = DriverManager.getDriver();
        driver.get("https://www.automationexercise.com/");
        logger.info("Navigated to Automation Exercise Website");
        test.info("Navigated to Automation Exercise Website");

        System.out.println("Inside BaseTest");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error("Test Failed: " + result.getThrowable());
            test.fail("Test Failed: " + result.getThrowable());

            // **Failure step pe screenshot leke attach karega**
            try {
                String screenshotPath = takeScreenshot(result.getName());
                test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
                logger.info("Screenshot attached in Extent Report: " + screenshotPath);
            } catch (Exception e) {
                logger.error("Failed to attach screenshot: " + e.getMessage());
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.warn("Test Skipped: " + result.getThrowable());
            test.skip("Test Skipped: " + result.getThrowable());
        } else {
            logger.info("Test Passed");
            test.pass("Test Passed");
        }

        DriverManager.quitDriver();
        test.info("Browser closed");
        logger.info("Browser closed");

        extent.flush();
    }

    public static void setupExtentReport() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        logger.info("Extent Report setup initialized.");
    }

    // **Fail Step ka Screenshot Save Karega**
    public String takeScreenshot(String testName) {
        if (driver == null) {
            logger.error("WebDriver is null, cannot take screenshot.");
            return null;
        }

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filePath = System.getProperty("user.dir") + "/test-output/screenshots/" + testName + ".png";
        File destFile = new File(filePath);

        try {
            FileUtils.copyFile(srcFile, destFile);
            logger.info("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            logger.error("Error while saving screenshot: " + e.getMessage());
        }
        return filePath;
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
            logger.info("Extent Report generated.");
        }
    }
}

// package com.framework.base;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import io.github.bonigarcia.wdm.WebDriverManager;

// public class DriverManager {
//     private static WebDriver driver;

//     public static WebDriver getDriver() {
//         // Check if the driver is already initialized, if not, initialize it.
//         if (driver == null) {
//             // Automatically setup ChromeDriver
//             WebDriverManager.chromedriver().setup();
            
//             driver = new ChromeDriver();
//             driver.get("https://www.automationexercise.com/"); // URL you want to test on
//             System.out.println("Inside DriverManager");
//             driver.manage().window().maximize();
//         }
//         return driver;
//     }

//     // Quit the driver when all tests are done
//     public static void quitDriver() {
//         if (driver != null) {
//             driver.quit();
//             driver = null; // Set driver to null to release the resources
//         }
//     }
// }
package com.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Set up WebDriver only once
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Set driver to null to allow reinitialization for new tests
        }
    }
}

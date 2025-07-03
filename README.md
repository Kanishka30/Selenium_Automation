# Automation Testing Project

I developed an automation project using Selenium and Maven to test the 'Automation Exercise' website. The scripts cover login/logout, product purchase, and user account creation followed by deletion, ensuring core user flows are validated effectively.

## Features
- Login/Logout automation
- Product purchase flow
- Account creation and deletion

## How to Run
Clone the repo
Verify maven is installed `mvn -v`
JDK is installed `java -version`
chromedriver is installed `DriverManager.java`
run using maven command `mvn clean test`
run a specific test file `mvn test -Dtest=LoginTest`

#Framework Structure

AutomationFramework/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com.framework.base/
│   │           └── BaseTest.java        // Common setup & teardown and url
	        └── DriverManager.java //chromedriver and url
│   │           └── BeforeMethod.java
│   │           └── TestCleanUp.java //
│   │
│   ├── test/
│   │   └── java/
		 └── com.framework.pages/
			 └── LoginPage.java //Test pages
│   │       └── com.framework.tests/
│   │           └── LoginTest.java      // Test Class
│   │
│       └── utils/
│       ├── LocatorUtils.java           // Element locators
│       └── ConfigUtils.java            // Configuration reader 
│       └── ScreenshotUtils.java  // screenshot file
|└── test-output
|        └── ExtentReport.html
│
|└── lo4j2.xml                              //log to file logs in extentReport file
├── pom.xml                             // Maven dependencies
└── config.properties               // email & password

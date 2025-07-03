package com.framework.base;

import org.testng.annotations.AfterMethod;

public class TestCleanUp {

    @AfterMethod
    public void tearDown() {
        BaseTest.flushReport();  // Ensures Extent Report is flushed after each test
    }
}

package com.salesforce.base;

import com.salesforce.constants.FrameworkConstants;
import com.salesforce.driver.DriverFactory;
import com.salesforce.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        try {
            DriverFactory.initDriver(browser);
            DriverManager.getDriver().get(FrameworkConstants.BASE_URL);
        } catch (Exception e) {
            Assert.fail("BaseTest setup failed: " + e.getMessage(), e);
        }
    }

    @AfterMethod
    public void tearDown() {
        try {
            DriverFactory.quitDriver();
        } catch (Exception e) {
            Assert.fail("BaseTest teardown failed: " + e.getMessage(), e);
        }
    }
}

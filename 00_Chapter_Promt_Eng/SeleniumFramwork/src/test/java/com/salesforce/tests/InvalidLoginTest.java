package com.salesforce.tests;

import com.salesforce.base.BaseTest;
import com.salesforce.constants.FrameworkConstants;
import com.salesforce.driver.DriverManager;
import com.salesforce.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

    @Test(priority = 1)
    public void testInvalidCredentialsDisplaysError() {
        try {
            WebDriver driver = DriverManager.getDriver();
            LoginPage loginPage = new LoginPage(driver);

            Assert.assertTrue(loginPage.isLoginPageLoaded(), "Login page failed to load.");

            loginPage.doLogin("invalid.user@nonexistentdomain.com", "WrongPassword!123");

            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message was not displayed for invalid credentials.");
            String actualError = loginPage.getErrorMessage();
            Assert.assertTrue(actualError.contains(FrameworkConstants.ERROR_INVALID_CREDENTIALS),
                    "Error message text did not match expected invalid credentials warning. Actual: " + actualError);
        } catch (Exception e) {
            Assert.fail("Invalid credentials test failed with exception: " + e.getMessage(), e);
        }
    }

    @Test(priority = 2)
    public void testEmptyPasswordDisplaysError() {
        try {
            WebDriver driver = DriverManager.getDriver();
            LoginPage loginPage = new LoginPage(driver);

            Assert.assertTrue(loginPage.isLoginPageLoaded(), "Login page failed to load.");

            loginPage.enterUsername("testuser@salesforce.com");
            loginPage.clickLogin();

            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message was not displayed for blank password.");
            String actualError = loginPage.getErrorMessage();
            Assert.assertTrue(actualError.contains(FrameworkConstants.ERROR_EMPTY_PASSWORD),
                    "Error message text did not match expected empty password warning. Actual: " + actualError);
        } catch (Exception e) {
            Assert.fail("Empty password test failed with exception: " + e.getMessage(), e);
        }
    }
}

package com.salesforce.tests;

import com.salesforce.base.BaseTest;
import com.salesforce.constants.FrameworkConstants;
import com.salesforce.driver.DriverManager;
import com.salesforce.pages.LoginPage;
import com.salesforce.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidLoginTest extends BaseTest {

    @Test(priority = 1)
    public void testValidLoginFlowWithRememberMe() {
        try {
            WebDriver driver = DriverManager.getDriver();
            LoginPage loginPage = new LoginPage(driver);

            Assert.assertTrue(loginPage.isLoginPageLoaded(), "Salesforce login page failed to load properly.");

            loginPage.clickRememberMe();
            Assert.assertTrue(loginPage.isRememberMeSelected(), "Remember Me checkbox was not selected.");

            loginPage.enterUsername("testuser@salesforce.enterprise.com");
            loginPage.enterPassword("ValidSecurePassword123!");
            loginPage.clickLogin();

            boolean isNavigationInitiated = WaitUtils.waitForUrlContains(driver, "salesforce.com", FrameworkConstants.EXPLICIT_WAIT);
            Assert.assertTrue(isNavigationInitiated, "Login action did not initiate expected navigation sequence.");
        } catch (Exception e) {
            Assert.fail("Valid login test encountered an unexpected exception: " + e.getMessage(), e);
        }
    }
}

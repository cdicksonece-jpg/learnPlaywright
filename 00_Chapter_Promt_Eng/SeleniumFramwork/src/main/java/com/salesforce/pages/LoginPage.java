package com.salesforce.pages;

import com.salesforce.constants.FrameworkConstants;
import com.salesforce.utils.WaitUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class LoginPage {

    private final WebDriver driver;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='rememberUn']")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//div[@id='error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//img[@id='logo']")
    private WebElement salesforceLogo;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoginPageLoaded() {
        try {
            WaitUtils.waitForVisibility(driver, salesforceLogo, FrameworkConstants.EXPLICIT_WAIT);
            return salesforceLogo.isDisplayed() && usernameInput.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public void enterUsername(String username) {
        try {
            WaitUtils.waitForVisibility(driver, usernameInput, FrameworkConstants.EXPLICIT_WAIT);
            usernameInput.clear();
            usernameInput.sendKeys(username);
        } catch (TimeoutException | NoSuchElementException e) {
            throw new RuntimeException("Failed to enter username: " + e.getMessage(), e);
        }
    }

    public void enterPassword(String password) {
        try {
            WaitUtils.waitForVisibility(driver, passwordInput, FrameworkConstants.EXPLICIT_WAIT);
            passwordInput.clear();
            passwordInput.sendKeys(password);
        } catch (TimeoutException | NoSuchElementException e) {
            throw new RuntimeException("Failed to enter password: " + e.getMessage(), e);
        }
    }

    public void clickRememberMe() {
        try {
            WaitUtils.waitForClickability(driver, rememberMeCheckbox, FrameworkConstants.EXPLICIT_WAIT);
            if (!rememberMeCheckbox.isSelected()) {
                rememberMeCheckbox.click();
            }
        } catch (TimeoutException | NoSuchElementException e) {
            throw new RuntimeException("Failed to toggle Remember Me checkbox: " + e.getMessage(), e);
        }
    }

    public boolean isRememberMeSelected() {
        try {
            WaitUtils.waitForVisibility(driver, rememberMeCheckbox, FrameworkConstants.EXPLICIT_WAIT);
            return rememberMeCheckbox.isSelected();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public void clickLogin() {
        try {
            WaitUtils.waitForClickability(driver, loginButton, FrameworkConstants.EXPLICIT_WAIT);
            loginButton.click();
        } catch (TimeoutException | NoSuchElementException e) {
            throw new RuntimeException("Failed to click Login button: " + e.getMessage(), e);
        }
    }

    public void doLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        try {
            WaitUtils.waitForVisibility(driver, errorMessage, FrameworkConstants.EXPLICIT_WAIT);
            return errorMessage.getText().trim();
        } catch (TimeoutException | NoSuchElementException e) {
            return "";
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            WaitUtils.waitForVisibility(driver, errorMessage, FrameworkConstants.EXPLICIT_WAIT);
            return errorMessage.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}

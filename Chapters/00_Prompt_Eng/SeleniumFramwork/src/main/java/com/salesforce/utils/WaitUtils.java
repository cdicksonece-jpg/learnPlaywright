package com.salesforce.utils;

import com.salesforce.constants.FrameworkConstants;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitUtils {

    private WaitUtils() {
    }

    public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
        return waitForVisibility(driver, element, FrameworkConstants.EXPLICIT_WAIT);
    }

    public static WebElement waitForVisibility(WebDriver driver, WebElement element, Duration timeout) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not visible within " + timeout.toSeconds() + " seconds: " + e.getMessage(), e);
        }
    }

    public static WebElement waitForClickability(WebDriver driver, WebElement element) {
        return waitForClickability(driver, element, FrameworkConstants.EXPLICIT_WAIT);
    }

    public static WebElement waitForClickability(WebDriver driver, WebElement element, Duration timeout) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not clickable within " + timeout.toSeconds() + " seconds: " + e.getMessage(), e);
        }
    }

    public static boolean waitForUrlContains(WebDriver driver, String fraction, Duration timeout) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.urlContains(fraction));
        } catch (TimeoutException e) {
            return false;
        }
    }
}

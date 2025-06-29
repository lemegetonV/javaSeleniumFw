package com.framework.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// OOP Concept: Abstraction
// This utility class abstracts the low-level Selenium commands (like waiting, clicking, sending keys)
// into higher-level, more robust, and self-logging methods.
public class SeleniumUtils {

    private static final Logger log = LogManager.getLogger(SeleniumUtils.class);
    private static final int TIMEOUT = 10; // Default timeout in seconds

    /**
     * A robust method to click on a WebElement. It waits until the element is clickable.
     * @param driver The WebDriver instance.
     * @param element The WebElement to click.
     */
    public static void safeClick(WebDriver driver, WebElement element) {
        try {
            // Create a WebDriverWait instance
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            // Wait for the element to be clickable before performing the click
            wait.until(ExpectedConditions.elementToBeClickable(element));
            log.info("Clicking on element: " + element.toString());
            element.click();
        } catch (Exception e) {
            log.error("Could not click on element: " + element.toString(), e);
            // Re-throw the exception to ensure the test fails if the click is critical
            throw e;
        }
    }

    /**
     * A robust method to send keys to a WebElement. It waits until the element is visible.
     * @param driver The WebDriver instance.
     * @param element The WebElement to send keys to.
     * @param text The text to send.
     */
    public static void sendKeys(WebDriver driver, WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            wait.until(ExpectedConditions.visibilityOf(element));
            log.info("Sending keys '" + text + "' to element: " + element.toString());
            element.clear(); // Clear the field before entering text
            element.sendKeys(text);
        } catch (Exception e) {
            log.error("Could not send keys to element: " + element.toString(), e);
            throw e;
        }
    }

    /**
     * A robust method to get text from a WebElement. It waits until the element is visible.
     * @param driver The WebDriver instance.
     * @param element The WebElement to get text from.
     * @return The text of the element.
     */
    public static String getText(WebDriver driver, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            wait.until(ExpectedConditions.visibilityOf(element));
            String text = element.getText();
            log.info("Retrieved text '" + text + "' from element: " + element.toString());
            return text;
        } catch (Exception e) {
            log.error("Could not get text from element: " + element.toString(), e);
            throw e;
        }
    }
}
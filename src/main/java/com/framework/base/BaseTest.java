package com.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    // Declare WebDriver at the class level
    // 'protected' means it's accessible by this class and any child classes (our tests)
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        // NOTE: We are still setting the property manually for now.
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed\\IdeaProjects\\javaSeleniumFw\\src\\test\\resources\\drivers\\chromedriver.exe"); // <-- CHANGE THIS PATH

        // Initialize the WebDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        // Quit the driver to close the browser and end the session
        if (driver != null) {
            driver.quit();
        }
    }
}
package com.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

// OOP Concept: Inheritance
// This class acts as a PARENT class. Other test classes will "extend" this class
// to inherit its methods and properties, promoting code reusability.
public class BaseTest {

    // OOP Concept: Encapsulation (via access modifier)
    // The 'protected' modifier makes this 'driver' variable accessible to this class
    // and any child classes (our tests) that inherit from BaseTest.
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        // WebDriver is an Interface.
        // An interface is like a contract. It defines what methods a class must have (e.g., get(), getTitle(), quit()),
        // but not how they work. It hides the complex implementation details.
        // ChromeDriver is a Class that implements the WebDriver interface.
        // The ChromeDriver class contains the specific code to control the Google Chrome browser.

        // Selenium Manager works automatically. When new ChromeDriver() is called,
        // it checks for a compatible driver, downloads it if needed, and starts it.
        // This is a form of Abstraction, as the complex driver management logic
        // is hidden from us. We just ask for a new browser instance.

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
package com.framework.tests;

import com.framework.base.BaseTest;
import com.framework.pages.DashboardPage;
import com.framework.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

// OOP Concept: Inheritance
// LoginTest is the CHILD class, and BaseTest is the PARENT.
// LoginTest inherits the 'setup' and 'tearDown' methods from BaseTest.
public class LoginTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(LoginTest.class);

    @Test(description = "Test a valid login to OrangeHRM")
    public void validLoginTest() {
        log.info("--- Starting Test: validLoginTest ---");

        driver.get("https://opensource-demo.orangehrmlive.com/");
        log.info("Navigated to OrangeHRM login page.");

        // Here we are creating an instance (an object) of our LoginPage class.
        LoginPage loginPage = new LoginPage(driver);

        // OOP Concept: Abstraction
        // The test does NOT know HOW the login happens. It just calls the high-level method.
        // The complexity of finding elements and clicking them is hidden inside the LoginPage class.
        DashboardPage dashboardPage = loginPage.loginToApplication("Admin", "admin123");
        log.info("Login submitted. Verifying dashboard...");

        String actualHeaderText = dashboardPage.getHeaderText();
        Assert.assertEquals(actualHeaderText, "Dashboard", "Header text did not match!");
        log.info("Successfully verified dashboard header. Test PASSED.");
        log.info("--- Ending Test: validLoginTest ---");
    }
}
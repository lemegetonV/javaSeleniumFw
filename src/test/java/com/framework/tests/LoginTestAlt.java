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
public class LoginTestAlt extends BaseTest {
    private static final Logger log = LogManager.getLogger(LoginTestAlt.class);

    @Test(description = "Test a valid login to OrangeHRM")
    public void validLoginTest() {
        log.info("--- Starting Test: validLoginTest ---");

        driver.get("https://opensource-demo.orangehrmlive.com/");
        log.info("Navigated to OrangeHRM login page.");

        // Here we are creating an instance (an object) of our LoginPage class.
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

        // Here we are creating an instance (an object) of our DashboardPage class.
        DashboardPage dashboardPage = new DashboardPage(driver);
        log.info("Login submitted. Verifying dashboard...");

        String actualHeaderText = dashboardPage.getHeaderText();
        Assert.assertEquals(actualHeaderText, "Dashboard", "Header text did not match!");
        log.info("Successfully verified dashboard header. Test PASSED.");
        log.info("--- Ending Test: validLoginTest ---");
    }
}
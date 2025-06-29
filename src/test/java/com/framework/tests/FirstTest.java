package com.framework.tests;

import com.framework.base.BaseTest; // Import the BaseTest
import org.testng.Assert;
import org.testng.annotations.Test;

// This class now inherits from BaseTest
public class FirstTest extends BaseTest {

    @Test(description = "Verify Google homepage title")
    public void openGoogleAndVerifyTitle() {
        // The 'driver' object is inherited from the BaseTest class
        driver.get("https://www.google.com");

        String pageTitle = driver.getTitle();
        System.out.println("The title of the page is: " + pageTitle);

        Assert.assertEquals(pageTitle, "Google");
    }

    @Test(description = "Verify OrangeHRM homepage title")
    public void openOrangeHrmAndVerifyTitle() {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        String pageTitle = driver.getTitle();
        System.out.println("The title of the page is: " + pageTitle);

        Assert.assertEquals(pageTitle, "OrangeHRM");
    }
}
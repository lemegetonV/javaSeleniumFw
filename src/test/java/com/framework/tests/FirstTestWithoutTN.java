package com.framework.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestWithoutTN {

    public static void main(String[] args) {

        // 1. Set the path to your WebDriver executable
        // NOTE: This is the OLD way. We will automate this later.
        // Download chromedriver from https://chromedriver.chromium.org/downloads
        // and place it somewhere on your computer.
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed\\IdeaProjects\\javaSeleniumFw\\src\\test\\resources\\drivers\\chromedriver.exe"); // <-- CHANGE THIS PATH

        // 2. Instantiate a WebDriver object
        WebDriver driver = new ChromeDriver();

        // 3. Navigate to a URL
        driver.get("https://www.google.com");

        // 4. Get the title of the page
        String pageTitle = driver.getTitle();
        System.out.println("The title of the page is: " + pageTitle);

        // 6. Close the browser
        driver.quit();
    }
}
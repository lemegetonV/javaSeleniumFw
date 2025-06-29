package com.framework.pages;

import com.framework.utils.SeleniumUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// OOP Concept: Encapsulation
// This class encapsulates the locators and actions for the Dashboard Page.
public class DashboardPage {

    // Field to hold a WebDriver instance.
    private WebDriver driver;

    // OOP Concept: Encapsulation (Data Hiding)
    @FindBy(tagName = "h6")
    private WebElement headerText;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // OOP Concept: Encapsulation (Public Interface)
    // A public method to expose page data in a controlled way.
    public String getHeaderText() {
        return SeleniumUtils.getText(driver, headerText);
    }
}
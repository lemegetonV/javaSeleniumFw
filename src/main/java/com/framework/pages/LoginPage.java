package com.framework.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// OOP Concept: Encapsulation
// This class encapsulates all the locators and actions related to the Login Page.
// The test scripts will not know the implementation details (e.g., the 'name' of the username field).
public class LoginPage {

    private static final Logger log = LogManager.getLogger(LoginPage.class);

    // By declaring private WebDriver driver;, you are defining the state of the LoginPage object.
    // You are saying that an essential piece of data that makes up a LoginPage object is a WebDriver instance
    private WebDriver driver;

    // OOP Concept: Encapsulation (Data Hiding)
    // These WebElements are the 'data' of the class. They are marked 'private'
    // so they cannot be accessed directly from outside the class.
    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    // The constructor is used to initialize the state of the object.
    // The constructor public LoginPage(WebDriver driver) is responsible for initializing this state.
    // It takes the driver from the outside world (your test class) and stores it internally, so the object is ready to perform its work.
    public LoginPage(WebDriver driver) {
        // OOP Concept: Encapsulation (Bundling Data with Methods)
        // PageFactory initializes the private WebElements (the data) so the public methods can use them.
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // OOP Concept: Encapsulation (Public Interface)
    // These 'public' methods provide a clean way for outside classes (our tests)
    // to interact with the private data (the WebElements).
    public void enterUsername(String username) {
        log.info("Entering username: " + username);
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        log.info("Entering password");
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        log.info("Clicking login button");
        loginButton.click();

    }

    // This is a "business logic" method, combining several page actions into one step.
    public DashboardPage loginToApplication(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        // This returns an object of the next page, allowing for a fluent interface.
        return new DashboardPage(driver);
    }
}
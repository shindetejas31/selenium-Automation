package framework.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Locators
    By usernameField = By.cssSelector("#user-name");
    By passwordField = By.cssSelector("#password");
    By loginButton = By.cssSelector("#login-button");
    By dashboardLogo = By.cssSelector(".app_logo");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void navigateToLoginPage() {
        driver.get("https://example.com/login");
    }

    public boolean isDashboardDisplayed() {
        try {
            return driver.findElement(dashboardLogo).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

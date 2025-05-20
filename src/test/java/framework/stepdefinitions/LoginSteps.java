package framework.stepdefinitions;

import framework.pages.LoginPage;
import framework.utils.ConfigReader;
import framework.utils.JsonDataReader;
import framework.hooks.hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {
    private WebDriver driver = hooks.driver;
    private LoginPage loginPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get(ConfigReader.getProperty("baseUrl"));
        loginPage = new LoginPage(driver);
    }

    @When("the user enters valid username and password")
    public void the_user_enters_valid_username_and_password() {
        String path = "src/test/resources/data/loginData.json";
        JSONObject loginData = JsonDataReader.getLoginData(path);
        
        String username = loginData.get("username").toString();
        String password = loginData.get("password").toString();
        
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        Assert.assertTrue(loginPage.isDashboardDisplayed());
    }
}

package com.auto.steps;

import components.WebDriverUtil;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utilities.ConfigProperties;

public class LoginStep extends WebDriverUtil {
    LoginPage loginpage=new LoginPage(getDriver());
    ConfigProperties configProperties=new ConfigProperties();

    @Given("user launches the url")
    public void userLaunchesTheUrl() {
        String url= configProperties.getProperty("url");
        WebDriverUtil.getDriver().navigate().to(url);
    }

    @And("user logs in to portal with username {string} and password {string}")
    public void userLogsInToPortalWithUsernameAndPassword(String username, String password) {
        loginpage.login(username,password);
    }

    @Then("user validates message {string} on the login page")
    public void userValidatesMessageOnTheLoginPage(String message) {

    }
}


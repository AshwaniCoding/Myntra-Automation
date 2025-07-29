package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

    LoginPage loginPage = new LoginPage();

    @Then("verify user is on login page")
    public void verifyUserIsOnLoginPage() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @When("user enters the mobile number {string}")
    public void userEntersTheMobileNumber(String mobileNumber) {
        loginPage.enterMobileNumber(ConfigReader.getConfigValue(mobileNumber));
    }

    @And("check on terms of use and click on continue button")
    public void checkOnTermsOfUseAndClickOnContinueButton() {
        loginPage.checkOnTermsOfUseAndClickOnContinueButton();
    }

    @And("enters the valid otp")
    public void entersTheValidOtp() {
        loginPage.enterTheValidOtp();
    }

}

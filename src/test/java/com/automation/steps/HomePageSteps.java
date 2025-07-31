package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomePageSteps {

    HomePage homePage = new HomePage();

    @Given("user opens website")
    public void userOpensWebsite() {
        homePage.openWebsite();
    }

    @Then("verify user is on homepage")
    public void verifyUserIsOnHomepage() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user search for a product {string}")
    public void userSearchForAProduct(String productName) {
        if (productName.contains("search.product")) {
            homePage.searchForProduct(ConfigReader.getConfigValue(productName));
        }else {
            homePage.searchForProduct(productName);
        }
    }

    @When("user hover on profile icon")
    public void userHoverOnProfileIcon() {
        homePage.hoverOnProfileIcon();
    }

    @And("click on login signup button")
    public void clickOnLoginSignupButton() {
        homePage.clickOnLoginSignUpButton();
    }

    @Then("verify user is logged in")
    public void verifyUserIsLoggedIn() {
        Assert.assertTrue(homePage.isUserLoggedIn());
    }

    @Then("verify bag quantity increases by {int}")
    public void verifyBagQuantityIncreasesBy(int bagItemCount) {
        Assert.assertTrue(homePage.isBagItemCountIncreasesBy(bagItemCount));
    }

    @When("user login through cookies")
    public void userLoginThroughCookies() {
        homePage.loginThroughCookies();
    }

}

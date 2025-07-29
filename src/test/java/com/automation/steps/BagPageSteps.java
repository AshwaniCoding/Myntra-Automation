package com.automation.steps;

import com.automation.pages.BagPage;
import com.automation.utils.ConfigReader;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BagPageSteps {

    BagPage bagPage = new BagPage();

    @Then("verify user is on bag page")
    public void verifyUserIsOnBagPage() {
        Assert.assertTrue(bagPage.isBagPageDisplayed());
    }

    @And("verify item added to cart is available")
    public void verifyItemAddedToCartIsAvailable() {
        Assert.assertTrue(bagPage.isItemAddedToCartIsAvailable());
    }

    @When("user click on remove button and confirms the dialog to remove")
    public void userClickOnRemoveButtonAndConfirmsTheDialogToRemove() {
        bagPage.clickOnRemoveButtonAndConfirmsTheDialogToRemove();
    }

    @Then("verify bag is empty with message {string}")
    public void verifyBagIsEmptyWithMessage(String message) {
        Assert.assertEquals(message,bagPage.getBagMessage());
    }
}

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

    @Then("verify bag is empty with message {string}")
    public void verifyBagIsEmptyWithMessage(String message) {
        Assert.assertEquals(message,bagPage.getBagMessage());
    }

    @And("verify item count in bag is {int}")
    public void verifyItemCountInBagIs(int itemCount) {
        Assert.assertEquals(itemCount,bagPage.getItemCount());
    }

    @When("user update the product quantity to {int}")
    public void userUpdateTheProductQuantityTo(int quantity) {
        bagPage.updateTheProductQuantity(quantity);
    }

    @Then("verify product quantity is updated to {int}")
    public void verifyProductQuantityIsUpdatedTo(int quantity) {
        Assert.assertEquals(quantity,bagPage.getProductQuantity());
    }

    @And("verify bag reflects updated total price")
    public void verifyBagReflectsUpdatedTotalPrice() {
        Assert.assertTrue(bagPage.isBagReflectsUpdatedTotalPrice());
    }

    @When("user click on remove button of added product and confirms the dialog to remove")
    public void userClickOnRemoveButtonOfAddedProductAndConfirmsTheDialogToRemove() {
        bagPage.clickOnRemoveButtonAndConfirmsTheDialogToRemove(ConfigReader.getConfigValue("added.item.desc"));
    }

    @Then("verify added item is removed from bag")
    public void verifyAddedItemIsRemovedFromBag() {
        Assert.assertTrue(bagPage.isAddedItemRemovedFromBag());
    }
}

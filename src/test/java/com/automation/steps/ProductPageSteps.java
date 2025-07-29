package com.automation.steps;

import com.automation.pages.ProductPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductPageSteps {

    ProductPage productPage = new ProductPage();

    @Then("verify user is on product page")
    public void verifyUserIsOnProductPage() {
        Assert.assertTrue(productPage.isProductPageDisplayed());
    }

    @When("user click on add to bag button")
    public void userClickOnAddToBagButton() {
        productPage.clickOnAddToBagButton();
    }

    @When("user click on bag icon")
    public void userClickOnBagIcon() {
        productPage.clickOnBagIcon();
    }

    @When("user select the size as {string}")
    public void userSelectTheSizeAs(String size) {
        if (size.equals("search.product.size")) {
            productPage.selectSize(ConfigReader.getConfigValue(size));
        } else {
            productPage.selectSize(size);
        }
    }

    @When("user click on place order button")
    public void userClickOnPlaceOrderButton() {
        productPage.clickOnPlaceOrderButton();
    }

}

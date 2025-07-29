package com.automation.steps;

import com.automation.pages.ProductListingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductListingPageSteps {

    ProductListingPage productListingPage = new ProductListingPage();

    @Then("verify user is on product listing page")
    public void verifyUserIsOnProductListingPage() {
        Assert.assertTrue(productListingPage.isProductPageDisplayed());
    }

    @When("user click on first product")
    public void userClickOnFirstProduct() {
        productListingPage.clickOnFirstProduct();
    }
}

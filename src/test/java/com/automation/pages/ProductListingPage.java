package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListingPage extends BasePage{

    @FindBy(xpath = "//span[@class='title-count']")
    WebElement searchProductCount;

    @FindBy(xpath = "//div[@class='product-imageSliderContainer']")
    List<WebElement> productList;

    public boolean isProductPageDisplayed() {
        return searchProductCount.isDisplayed();
    }

    public void clickOnFirstProduct() {
        productList.getFirst().click();
    }
}

package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(css = ".pdp-title")
    WebElement productTitle;

    @FindBy(css = ".pdp-name")
    WebElement productDescription;

    @FindBy(xpath = "//div[text()='ADD TO BAG']")
    WebElement addToBagBtn;

    @FindBy(xpath = "//a[contains(@class,'desktop-cart')]/span")
    WebElement bagIcon;

    @FindBy(xpath = "//div[text()='PLACE ORDER']")
    WebElement placeOrderBtn;

    @FindBy(xpath = "//span[contains(@class,'desktop-badge')]")
    WebElement bagItemCountLabel;

    String SIZE_XPATH = "//p[text()='%s']";

    public boolean isProductPageDisplayed() {
        switchTab();
        return productTitle.isDisplayed() && addToBagBtn.isDisplayed() && driver.getCurrentUrl().contains("/buy");
    }

    public void clickOnAddToBagButton() {
        ConfigReader.setConfigValue("bag.item.count", bagItemCountLabel.getText());
        ConfigReader.setConfigValue("added.item.title",productTitle.getText());
        ConfigReader.setConfigValue("added.item.desc",productDescription.getText());
        addToBagBtn.click();
        waitForSecond(2);
    }

    public void clickOnBagIcon() {
        bagIcon.click();
    }

    public void selectSize(String size) {
        driver.findElement(By.xpath(String.format(SIZE_XPATH,size))).click();
    }

    public void clickOnPlaceOrderButton() {
        placeOrderBtn.click();
    }
}

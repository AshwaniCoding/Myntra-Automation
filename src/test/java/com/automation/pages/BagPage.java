package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class BagPage extends BasePage{

    @FindBy(xpath = "//div[@class='itemContainer-base-brand']")
    List<WebElement> productTitleList;

    @FindBy(xpath = "//a[@class='itemContainer-base-itemLink']")
    List<WebElement> productDescriptionList;

    @FindBy(xpath = "//button[text()='REMOVE']")
    WebElement removeBtn;

    @FindBy(xpath = "//button[@class='inlinebuttonV2-base-actionButton ']")
    WebElement removeConfirmationBtn;

    @FindBy(xpath = "//div[@class='emptyCart-base-emptyDesc']")
    WebElement emptyBagMessage;

    @FindBy(css = ".bulkActionStrip-itemSelected")
    WebElement bagItemCount;

    @FindBy(xpath = "//div[@class='itemContainer-base-price']/div[contains(@class,'bold')]/div")
    WebElement productPriceLabel;

    @FindBy(xpath = "//div[@class='itemComponents-base-quantity']/span")
    WebElement productQuantity;

    @FindBy(xpath = "//span[@class='priceDetail-base-redesignRupeeTotalIcon']/..")
    WebElement totalPriceLabel;

    @FindBy(xpath = "//span[@class='priceDetail-base-value']/span")
    WebElement platformFeeLabel;

    @FindBy(xpath = "//div[@role='dialog']")
    WebElement quantityDialog;

    @FindBy(xpath = "//div[text()='DONE']")
    WebElement doneBtn;

    String REMOVE_SPECIFIC_PRODUCT = "//a[text()='%s']/ancestor::div[@class='itemContainer-base-item  ']//*[name()='svg' and @class ='itemContainer-base-closeIcon']";

    public String getBagMessage() {
        return emptyBagMessage.getText();
    }

    public void clickOnRemoveButtonAndConfirmsTheDialogToRemove(String addedProduct) {
        driver.findElement(By.xpath(String.format(REMOVE_SPECIFIC_PRODUCT,addedProduct))).click();
        removeConfirmationBtn.click();
    }

    public boolean isBagPageDisplayed() {
        return driver.getCurrentUrl().contains("/checkout/cart") && driver.getTitle().contains("BAG");
    }

    public boolean isItemAddedToCartIsAvailable() {
        String productTitle = ConfigReader.getConfigValue("added.item.title");
        String productDescription = ConfigReader.getConfigValue("added.item.desc");

        for(int i=0; i<productTitleList.size();i++){

            if (productTitleList.get(i).getText().equals(productTitle) && productDescriptionList.get(i).getText().equals(productDescription)){
                actions.moveToElement(productDescriptionList.get(i)).perform();
                return true;
            }
        }
        return false;
    }

    public int getItemCount() {
        String count = bagItemCount.getText();
        count = count.split("/")[1].split(" ")[0];
        return Integer.parseInt(count);
    }

    public void updateTheProductQuantity(int quantity) {
        productQuantity.click();
        wait.until(ExpectedConditions.visibilityOf(quantityDialog));
        driver.findElement(By.id(String.valueOf(quantity))).click();
        doneBtn.click();
        actions.pause(Duration.ofSeconds(2)).perform();
    }

    public int getProductQuantity() {
        return Integer.parseInt(productQuantity.getText().split(":")[1].trim());
    }

    public boolean isBagReflectsUpdatedTotalPrice() {
        int productPrice = Integer.parseInt(productPriceLabel.getText().replaceAll("[^0-9]",""));
        int platformFee = Integer.parseInt(platformFeeLabel.getText());
        int totalPrice = Integer.parseInt(totalPriceLabel.getText().replaceAll("[^0-9]", ""));
        return productPrice + platformFee == totalPrice;
    }

    public boolean isAddedItemRemovedFromBag() {
        String productTitle = ConfigReader.getConfigValue("added.item.title");
        String productDescription = ConfigReader.getConfigValue("added.item.desc");

        waitForSecond(2);

        for(int i=0; i<productTitleList.size();i++){

            if (productTitleList.get(i).getText().equals(productTitle) && productDescriptionList.get(i).getText().equals(productDescription)){
                actions.moveToElement(productDescriptionList.get(i)).perform();
                return false;
            }
        }
        return true;
    }
}

package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public String getBagMessage() {
        return emptyBagMessage.getText();
    }

    public void clickOnRemoveButtonAndConfirmsTheDialogToRemove() {
        removeBtn.click();
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
                return true;
            }
        }
        return false;
    }
}

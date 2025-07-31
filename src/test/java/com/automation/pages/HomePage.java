package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class HomePage extends BasePage {

    @FindBy(xpath = "//p[@class='index-lcHeader']")
    WebElement registeredOfficeAddressLabel;

    @FindBy(xpath = "//input[contains(@placeholder,'Search')]")
    WebElement searchInput;

    @FindBy(xpath = "//span[text()='Profile']")
    WebElement profileIcon;

    @FindBy(xpath = "//a[text()='login / Signup']")
    WebElement loginSignUpBtn;

    @FindBy(xpath = "//a[@href='/my/profile']")
    WebElement myProfile;

    @FindBy(xpath = "//span[contains(@class,'desktop-badge')]")
    WebElement bagItemCountLabel;

    public void openWebsite() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }

    public boolean isHomePageDisplayed() {
        return registeredOfficeAddressLabel.isDisplayed() && driver.getTitle().contains("Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra");
    }

    public void searchForProduct(String productName) {
        searchInput.sendKeys(productName + Keys.ENTER);
    }

    public void clickOnLoginSignUpButton() {
        loginSignUpBtn.click();
    }

    public void hoverOnProfileIcon() {
        actions.moveToElement(profileIcon).perform();
    }

    public boolean isUserLoggedIn() {
        hoverOnProfileIcon();
        return myProfile.isDisplayed();
    }

    public boolean isBagItemCountIncreasesBy(int quantity) {
        String value = ConfigReader.getConfigValue("bag.item.count");
        int oldCount = (value == null || value.isBlank()) ? 0 : Integer.parseInt(value.trim());

        return oldCount + quantity == Integer.parseInt(bagItemCountLabel.getText().trim());
    }

    public void loginThroughCookies() {
        Set<Cookie> allCookies = ConfigReader.getSavedCookies();
        for(Cookie cookie : allCookies){
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();
    }

    public void navigateBackToHomePage() {
        driver.close();
        switchToDefaultTab();
    }
}

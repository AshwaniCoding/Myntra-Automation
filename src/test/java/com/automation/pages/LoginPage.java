package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//div[contains(text(),'Login')]")
    WebElement loginTitleLabel;

    @FindBy(xpath = "//input[@type='tel']")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//input[@class='consentCheckbox']")
    WebElement termsOfUseCheckBox;

    @FindBy(xpath = "//div[text()='CONTINUE']")
    WebElement continueBtn;

    public boolean isLoginPageDisplayed() {
        return loginTitleLabel.isDisplayed();
    }

    public void enterMobileNumber(String mobileNumber) {
        mobileNumberInput.click();
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public void checkOnTermsOfUseAndClickOnContinueButton() {
        termsOfUseCheckBox.click();
        continueBtn.click();

        //for dynamically handle continue button
        waitForSecond(35);
        continueBtn.click();
    }

    public void enterTheValidOtp() {
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs(driver.getTitle())));
    }
}

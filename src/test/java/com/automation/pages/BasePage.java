package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);
    }

    public void switchToNewTab(){
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for(String window : allWindows){
            if(!window.equals(currentWindow)){
                driver.switchTo().window(window);
            }
        }
    }

    public void switchToDefaultTab(){
        driver.switchTo().defaultContent();
    }


    public void waitForSecond(int time) {
        try{
            Thread.sleep(Duration.ofSeconds(time));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}

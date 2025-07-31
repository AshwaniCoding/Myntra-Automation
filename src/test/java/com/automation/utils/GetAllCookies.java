package com.automation.utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Set;

public class GetAllCookies {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();

        // STEP 1: Login manually or load a session (first run)
        driver.get("https://www.myntra.com");

        System.out.println("----------------------login--------------------------");

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----------------------login done--------------------------");



        // STEP 2: Get and save cookies to file
        Set<Cookie> allCookies = driver.manage().getCookies();
        FileOutputStream fileOut = new FileOutputStream("src/test/resources/config/cookies.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(allCookies);
        out.close();
        fileOut.close();
        System.out.println("✅ Cookies saved to cookies.ser");

        driver.quit();

        // ----------------- Simulate Next Scenario -----------------

        WebDriver newDriver = new ChromeDriver();
        newDriver.get("https://www.myntra.com");

        // STEP 3: Load cookies from file and add to new browser session
        FileInputStream fileIn = new FileInputStream("src/test/resources/config/cookies.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Set<Cookie> savedCookies = (Set<Cookie>) in.readObject();
        in.close();
        fileIn.close();

        for (Cookie cookie : savedCookies) {
            newDriver.manage().addCookie(cookie);
        }

        newDriver.navigate().refresh(); // important to apply session
        System.out.println("✅ Cookies loaded successfully");

        // Validate session (check if user is logged in)
        Thread.sleep(10000); // for observation
        newDriver.quit();




    }
}

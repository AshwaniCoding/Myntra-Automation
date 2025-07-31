package com.automation.utils;


import org.openqa.selenium.Cookie;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Properties;
import java.util.Set;

public class ConfigReader {

    private static Properties prop;

    public static void initConfig() {
        try {
            prop = new Properties();
            prop.load(new FileInputStream("src/test/resources/config/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setConfigValue(String key, String value) {
        prop.setProperty(key, value);
    }

    public static String getConfigValue(String key) {
        return prop.getProperty(key);
    }

    public static Set<Cookie> getSavedCookies() {

        Set<Cookie> savedCookies = null;
        try {

            FileInputStream fileIn = new FileInputStream("src/test/resources/config/cookies.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            savedCookies = (Set<Cookie>) in.readObject();

            in.close();
            fileIn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return savedCookies;
    }

}

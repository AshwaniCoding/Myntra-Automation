package com.automation.utils;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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

    public static void setConfigValue(String key, String value){
        prop.setProperty(key, value);
    }

    public static String getConfigValue(String key){
        return prop.getProperty(key);
    }

}

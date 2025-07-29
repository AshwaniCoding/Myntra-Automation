package com.automation.utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static void saveScreenshot(Scenario scenario) {

        File src = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        String fileName = scenario.getName().replaceAll("[^a-zA-Z0-9_-]", "_") + ".png";

        String destinationPath = (scenario.isFailed()) ? "report/screenshots/failed/" + fileName : "report/screenshots/passed/" + fileName ;

        File destination = new File(destinationPath);

        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] saveScreenshot(){
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}

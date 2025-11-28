package com.isrtc.utils;

import java.io.File;
import java.nio.file.Files;

import org.openqa.selenium.*;

public class ScreenshotUtil {

    // Fixed path to overwrite every time
    private static final String SCREENSHOT_PATH = "screenshots/screenshot.png";

    public static void captureScreenshot(WebDriver driver) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            File destination = new File(SCREENSHOT_PATH);
            destination.getParentFile().mkdirs(); // create folder if not exists
            Files.copy(source.toPath(), destination.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved at: " + SCREENSHOT_PATH);

        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }
}

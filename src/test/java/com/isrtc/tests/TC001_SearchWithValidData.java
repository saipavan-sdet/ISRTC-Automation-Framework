package com.isrtc.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.isrtc.base.BaseTest;
import com.isrtc.base.DriverFactory;
import com.isrtc.pages.HomePage;

public class TC001_SearchWithValidData extends BaseTest {

    @Test(groups = {"sanity"}, retryAnalyzer = com.isrtc.utils.RetryAnalyzer.class)
    public void verifySearchWithValidData() throws InterruptedException {
        HomePage home = new HomePage(); // No driver passed

        home.enterFromCity("Hyderabad");
        home.enterToCity("Vijayawada");
        home.selectDepartDate("28");
        home.selectReturnDate("30");
        home.clickCheckAvailability();

        Thread.sleep(5000);

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));

        // Wait for results section to load
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("result-grid")),
                ExpectedConditions.visibilityOfElementLocated(By.id("bookingsForm"))
        ));

        System.out.println("Results table loaded.");
    }
}

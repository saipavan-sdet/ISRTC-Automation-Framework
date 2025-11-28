package com.isrtc.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.isrtc.base.DriverFactory;

public class SearchResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor using ThreadLocal driver
    public SearchResultsPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickFirstBusSelectSeat() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // Wait until results are visible
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("result-grid")),
                ExpectedConditions.visibilityOfElementLocated(By.id("bookingsForm"))
        ));

        System.out.println("Results table loaded.");

        // Get all seat-selection buttons
        List<WebElement> buttons = driver.findElements(By.xpath("//input[contains(@id,'SrvcSelectBtnForward')]"));
        System.out.println("Total Select Seat buttons found: " + buttons.size());

        for (WebElement btn : buttons) {
            if (btn.isDisplayed() && btn.isEnabled()) {

                // Scroll into view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
                Thread.sleep(500);

                try {
                    wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
                    System.out.println("Clicked using normal click");
                } catch (Exception e) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
                    System.out.println("Clicked using JavaScript (fallback)");
                }

                return;
            }
        }

        throw new RuntimeException("No visible Select Seats button found!");
    }
}

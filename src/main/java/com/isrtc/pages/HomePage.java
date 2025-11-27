package com.isrtc.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.isrtc.base.DriverFactory;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By fromInput = By.id("fromPlaceName");
    private By toInput = By.id("toPlaceName");

    private By fromSuggestion = By.xpath("//ul[@id='ui-id-1']/li");
    private By toSuggestion = By.xpath("//ul[@id='ui-id-2']/li");

    private By searchBtn = By.id("searchBtn");


    // Constructor (using ThreadLocal Driver)
    public HomePage() {
        this.driver = DriverFactory.getDriver();         // ThreadLocal driver
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void enterFromCity(String fromCity) {
        System.out.println("Entering FROM city: " + fromCity);

        WebElement from = wait.until(ExpectedConditions.visibilityOfElementLocated(fromInput));
        from.clear();
        from.sendKeys(fromCity);

        WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(fromSuggestion));
        suggestion.click();

        System.out.println("FROM city selected.");
    }

    public void enterToCity(String toCity) {
        System.out.println("Entering TO city: " + toCity);

        WebElement to = wait.until(ExpectedConditions.visibilityOfElementLocated(toInput));
        to.clear();
        to.sendKeys(toCity);

        WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(toSuggestion));
        suggestion.click();

        System.out.println("TO city selected.");
    }

    public void selectDepartDate(String date) {
        System.out.println("Selecting depart date: " + date);

        WebElement departDate = wait.until(ExpectedConditions.elementToBeClickable(By.id("txtJourneyDate")));
        departDate.click();

        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//table[contains(@class,'ui-datepicker-calendar')]//a[text()='" + date + "']")));
        dateElement.click();

        System.out.println("Depart date selected: " + date);
    }

    public void selectReturnDate(String date) {
        WebElement returnDate = wait.until(ExpectedConditions.elementToBeClickable(By.id("txtReturnJourneyDate")));
        returnDate.click();

        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//table[contains(@class,'ui-datepicker-calendar')]//a[text()='" + date + "']")));
        dateElement.click();

        System.out.println("Return date selected: " + date);
    }

    public void clickCheckAvailability() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        System.out.println("Clicked on Check Availability...");
    }
}

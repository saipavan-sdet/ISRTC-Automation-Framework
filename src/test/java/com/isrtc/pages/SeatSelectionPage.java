package com.isrtc.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.isrtc.base.DriverFactory;

public class SeatSelectionPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ===== Locators =====
    private By boardingPointDD = By.id("ForwardBoardId");
    private By droppingPointDD = By.id("ForwardDroppingId");
    private By layoutBtn = By.id("fwLtBtn");
    private By availableSeats = By.id("seatlayout-Forward1");

    private By seat = By.xpath("//li[contains(@class,'availSeatClass')]");
    private By passengerName = By.id("passengerNameForward0");
    private By passengerAge = By.id("passengerAgeForward0");
    private By passengerGender = By.id("genderCodeIdForward0");
    private By passengerConcession = By.id("concessionIdsForward0");
    private By mobileNo = By.id("mobileNo");
    private By email = By.id("email");
    private By bookReturnButton = By.id("BookRetBtn");

    private By seatDetails = By.id("seatDetailsForward0");
    private By totalFare = By.id("ForwardtotFare");

    // Constructor using ThreadLocal driver
    public SeatSelectionPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void selectBoardingPoint() {
        wait.until(ExpectedConditions.elementToBeClickable(boardingPointDD)).click();
        driver.findElement(By.xpath("//select[@id='ForwardBoardId']/option[2]")).click();
        System.out.println("Selected Boardingpoint Successfully...");
    }

    public void selectDroppingPoint() {
        wait.until(ExpectedConditions.elementToBeClickable(droppingPointDD)).click();
        driver.findElement(By.xpath("//select[@id='ForwardDroppingId']/option[2]")).click();
        System.out.println("Selected Droppingpoint Successfully...");
    }

    public void clickLayoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(layoutBtn)).click();
        System.out.println("Clicked on layout button Successfully...");
    }

    public void selectFirstAvailableSeat() {
        List<WebElement> seats = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(seat));
        System.out.println("Available seats: " + seats.size());

        for (WebElement seat : seats) {
            try {
                seat.click();
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", seat);
            }
            System.out.println("Seat selected: " + seat.getAttribute("id"));
            return;
        }

        throw new RuntimeException("❌ No available seats found");
    }

    public void enterPassengerDetails(String name, String age, String gender, String concessionIndex) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passengerName)).sendKeys(name);
        driver.findElement(passengerAge).sendKeys(age);

        Select genderSelect = new Select(driver.findElement(passengerGender));
        genderSelect.selectByVisibleText(gender);

        Select concessionSelect = new Select(driver.findElement(passengerConcession));
        concessionSelect.selectByVisibleText(concessionIndex);

        System.out.println("Passenger details entered :");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Concession Type: " + concessionIndex);
    }

    public void enterContactDetails(String mobile, String emailId) {
        driver.findElement(mobileNo).sendKeys(mobile);
        driver.findElement(email).sendKeys(emailId);

        System.out.println("Contact details entered :");
        System.out.println("mobileNo: " + mobile);
        System.out.println("emailId: " + emailId);
    }

    public void clickBookReturn() {
        wait.until(ExpectedConditions.elementToBeClickable(bookReturnButton)).click();
        System.out.println("Clicked on Book Return button.");
    }

    public void printSelectedSeatDetails() {
        String seatInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(seatDetails)).getAttribute("value");
        String fareText = wait.until(ExpectedConditions.visibilityOfElementLocated(totalFare)).getText();

        System.out.println("Selected Seat Details: " + seatInfo);
        System.out.println("Total Fare: ₹" + fareText);
    }
}

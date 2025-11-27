package com.isrtc.tests;

import org.testng.annotations.Test;

import com.isrtc.base.BaseTest;
import com.isrtc.pages.HomePage;
import com.isrtc.pages.SearchResultsPage;
import com.isrtc.pages.SeatSelectionPage;

public class TC003_ContactDetails_ValidData extends BaseTest {

    @Test(groups = {"sanity"}, retryAnalyzer = com.isrtc.utils.RetryAnalyzer.class)
    public void enterContactDetailsValid() throws InterruptedException {
        // No driver parameter passed
        HomePage home = new HomePage();
        home.enterFromCity("Hyderabad");
        home.enterToCity("Vijayawada");
        home.selectDepartDate("28");
        home.selectReturnDate("30");
        home.clickCheckAvailability();

        Thread.sleep(5000);

        SearchResultsPage results = new SearchResultsPage(); // No driver passed
        results.clickFirstBusSelectSeat();

        SeatSelectionPage seat = new SeatSelectionPage(); // No driver passed
        seat.selectBoardingPoint();
        seat.selectDroppingPoint();

        seat.clickLayoutButton();
        seat.selectFirstAvailableSeat();
        seat.enterContactDetails("9876543210", "test@gmail.com");

        System.out.println("No Popup was found...");
    }
}

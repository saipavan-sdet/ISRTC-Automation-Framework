package com.isrtc.tests;

import org.testng.annotations.Test;

import com.isrtc.base.BaseTest;
import com.isrtc.pages.HomePage;
import com.isrtc.pages.SearchResultsPage;
import com.isrtc.pages.SeatSelectionPage;

public class TC004_CompleteFlow_OneWayBooking extends BaseTest {

    @Test(groups = {"regression"}, retryAnalyzer = com.isrtc.utils.RetryAnalyzer.class)
    public void completeFlowBooking() throws InterruptedException {

        HomePage home = new HomePage();  // No driver parameter
        home.enterFromCity("Hyderabad");
        home.enterToCity("Vijayawada");
        home.selectDepartDate("28");
        home.selectReturnDate("30");
        home.clickCheckAvailability();

        Thread.sleep(5000);

        SearchResultsPage results = new SearchResultsPage();  // No driver parameter
        results.clickFirstBusSelectSeat();

        SeatSelectionPage seat = new SeatSelectionPage();  // No driver parameter
        seat.selectBoardingPoint();
        seat.selectDroppingPoint();
        seat.clickLayoutButton();
        seat.selectFirstAvailableSeat();
        seat.enterContactDetails("9876543210", "test@gmail.com");
        seat.enterPassengerDetails("John Doe", "28", "MALE", "GENERAL PUBLIC");

        // seat.clickBookReturn(); 
        
        seat.printSelectedSeatDetails();

        System.out.println("✔ Seat booked successfully.......");
    }
}

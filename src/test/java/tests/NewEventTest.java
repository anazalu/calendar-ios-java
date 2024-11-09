package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.DriverSetup;

public class NewEventTest extends DriverSetup {

    @Severity(SeverityLevel.BLOCKER)
//    @Story("Unsuccessful creation af a new event")
    @Description("Create new event")
    @Test(testName = "Event test")
    public void newEventTest() {

        Assert.assertTrue(calendarHomePage.calendarHomePageLoaded(), "Calendar home page is not loaded");

        calendarHomePage.chooseTimeslot("02:00");
        Assert.assertTrue(newEventPage.newEventPageLoaded(), "New event page is not loaded");

        newEventPage.chooseStartHour("20", "05");
    }
}

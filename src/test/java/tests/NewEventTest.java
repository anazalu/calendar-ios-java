package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.DriverSetup;
import util.GlobalVariables;

@Epic("Mobile automation Calendar app testing")
@Feature("Event")
public class NewEventTest extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Create new event")
    @Story("Successful creation of a new calendar event")
    @Test(testName = "Event test")
    public void newEventTest() {

        Assert.assertTrue(calendarHomePage.calendarHomePageLoaded(), "Calendar home page is not loaded");

        calendarHomePage.tapToAddNewEvent();
        Assert.assertTrue(newEventPage.newEventPageLoaded(), "New event page is not loaded");
//
//        GlobalVariables.response = restAssuredUtility.getActivityValue("activity");
//        newEventPage.enterEventTitle(GlobalVariables.response);
//        Assert.assertEquals(newEventPage.getEventTitleText().toLowerCase(), GlobalVariables.response.toLowerCase());
        newEventPage.enterEventTitle("My title");
        Assert.assertEquals(newEventPage.getEventTitleText().toLowerCase(), "My title".toLowerCase());
//
//
//        newEventPage.chooseTravelTimeSpan("30 minutes");
//
////        calendarHomePage.chooseTimeslot("02:00");
//
//        newEventPage.chooseStartHour("20", "05");
    }
}

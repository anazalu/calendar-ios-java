package tests;

import io.qameta.allure.*;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
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

//  //    Code 429 for now - not able to use REST API at this point
        GlobalVariables.response = restAssuredUtility.getActivityValue("activity");
        newEventPage.enterEventTitle(GlobalVariables.response);
        Assert.assertEquals(newEventPage.getEventTitleText().toLowerCase(), GlobalVariables.response.toLowerCase());
//        Temporary solution:
//        newEventPage.enterEventTitle("My unique activity");
//        Assert.assertEquals(newEventPage.getEventTitleText().toLowerCase(), "My unique activity".toLowerCase());

        newEventPage.tapOnStartsDateToExpand();

        newEventPage.tapOnNextMonthArrow();

        newEventPage.chooseDate("24");

        newEventPage.tapOnStartsTextToCollapse();

        newEventPage.tapOnEndsDateToExpand();

        newEventPage.chooseDate("25");

        newEventPage.tapOnEndsTextToCollapse();

//        WIP - choose time
//        newEventPage.chooseStartHour("11", "10");

        newEventPage.chooseTravelTimeSpan("30 minutes");

        newEventPage.switchToAllDay();
        Assert.assertTrue(newEventPage.startDateWithoutTimeDisplayed(), "End time is still displayed");
        Assert.assertTrue(newEventPage.endDateWithoutTimeDisplayed());

        newEventPage.tapOnAddEventButton();
        Assert.assertTrue(calendarHomePage.calendarHomePageLoaded(), "Calendar home page is not loaded");

        calendarHomePage.tapOnMonth("December 2024");
        Assert.assertTrue(monthPage.monthPageLoaded());

        Assert.assertTrue(monthPage.eventAdded("Tuesday, 24 December"), "Event not added");
    }
}

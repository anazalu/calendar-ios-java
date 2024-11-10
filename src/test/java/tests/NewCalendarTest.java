package tests;

import io.qameta.allure.*;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.DriverSetup;

@Epic("Mobile automation Calendar app testing")
@Feature("New calendar")
public class NewCalendarTest extends DriverSetup {

    @Severity(SeverityLevel.NORMAL)
    @Story("Successful creation of a new calendar event")
    @Description("Create new calendar")
    @Test(testName = "Calendar test")
    public void newCalendarTest() {

        Assert.assertTrue(calendarHomePage.calendarHomePageLoaded(), "Calendar home page is not loaded");
        calendarHomePage.tapOnCalendars();
        Assert.assertTrue(calendarsPage.calendarsPageLoaded(), "Calendars page not loaded");

        calendarsPage.tapToAddNewCalendar();
        Assert.assertTrue(newCalendarPage.newCalendarPageLoaded(), "Add calendar page not loaded");

        newCalendarPage.enterEventTitle("Blue calendar");
        newCalendarPage.chooseColor("Blue");
        Assert.assertTrue(newCalendarPage.newCalendarPageLoaded(), "Add calendar page not loaded");

        newCalendarPage.tapOnDoneButton();
        Assert.assertTrue(calendarsPage.calendarsPageLoaded(), "Calendars page not loaded");

        Assert.assertTrue(calendarsPage.defaultCalendarIsChecked(), "Main Calendar is not checkmarked");
        Assert.assertTrue(calendarsPage.newCalendarIsChecked(), "New Calendar is not checkmarked");

        calendarsPage.tapNewCalendarInfoCircle();
        calendarsPage.deleteNewCalendar();
        Assert.assertTrue(calendarsPage.calendarsPageLoaded(), "Calendars page not loaded");

//        Validate only one Calendar displayed - WIP
        Assert.assertTrue(calendarsPage.defaultCalendarIsChecked(), "Main Calendar is not checkmarked");
//        Assert.assertFalse(calendarsPage.assertThatNewCalendarIsDisplayed());

        calendarsPage.tapOnDoneButton();
        Assert.assertTrue(calendarHomePage.calendarHomePageLoaded(), "Calendar home page is not loaded");
    }
}

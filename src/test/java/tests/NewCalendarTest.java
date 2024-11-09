package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.DriverSetup;

public class NewCalendarTest extends DriverSetup {

    @Severity(SeverityLevel.BLOCKER)
//    @Story("Unsuccessful creation af a new calendar")
    @Description("Create new calendar")
    @Test(testName = "Calendar test")
    public void newCalendarTest() {

        Assert.assertTrue(calendarHomePage.calendarHomePageLoaded(), "Calendar home page is not loaded");
    }
}

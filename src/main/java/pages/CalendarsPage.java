package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;
import util.Helpers;

public class CalendarsPage {

    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Calendars\"`]")
    private RemoteWebElement calendarsPageContainer;
//    with (i)
//    **/XCUIElementTypeCell[`name == "Calendar"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther
//    (i)
//    access: info.circle
//    access Delete Calendar
//    **/XCUIElementTypeButton[`name == "Delete Calendar"`]
//    access done-button

//**/XCUIElementTypeImage[`name == "checkmark.circle.fill"`][2]

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Calendar\"`]")
    private RemoteWebElement defaultCalendarTitle;

    @iOSXCUITFindBy(accessibility = "add-calendar-button")
    private RemoteWebElement addNewCalendarButton;

//  After tapping on Add Calendar
    @iOSXCUITFindBy(accessibility = "add-calendar-menubutton")
    private RemoteWebElement addCalendarOption;

    public CalendarsPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Calendars page is loaded")
    public boolean calendarsPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(calendarsPageContainer)).isDisplayed();
    }

    public void tapToAddNewCalendar() {
        addNewCalendarButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(addCalendarOption)).click();
    }
}

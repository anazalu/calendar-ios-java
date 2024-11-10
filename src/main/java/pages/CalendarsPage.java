package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;

public class CalendarsPage {

    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Calendars\"`]")
    private RemoteWebElement calendarsPageContainer;

    @iOSXCUITFindBy(accessibility = "add-calendar-button")
    private RemoteWebElement addNewCalendarButton;

//  After tapping on Add Calendar
    @iOSXCUITFindBy(accessibility = "add-calendar-menubutton")
    private RemoteWebElement addCalendarOption;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name == \"checkmark.circle.fill\"`][1]")
    private RemoteWebElement defaultCalendarCheckmark;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name == \"checkmark.circle.fill\"`][2]")
    private RemoteWebElement secondCalendarCheckmark;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name == \"info.circle\"`][2]")
    private RemoteWebElement secondCalendarInfoCircle;

//    After tapping on Info Circle
    @iOSXCUITFindBy(accessibility = "Delete Calendar")
    private RemoteWebElement deleteCalendarButton;

//    After tapping on Delete Calendar
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Delete Calendar\"`]")
    private RemoteWebElement confirmDeleteCalendar;

    @iOSXCUITFindBy(accessibility = "done-button")
    private RemoteWebElement doneButton;

    public CalendarsPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Calendars page is loaded")
    public boolean calendarsPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(calendarsPageContainer)).isDisplayed();
    }

    @Step("Tap on Add calendar")
    public void tapToAddNewCalendar() {
        addNewCalendarButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(addCalendarOption)).click();
    }

    public void tapNewCalendarInfoCircle() {
        secondCalendarInfoCircle.click();
    }

    @Step("Delete second calendar")
    public void deleteNewCalendar() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(deleteCalendarButton)).click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(confirmDeleteCalendar)).click();
    }

    public void tapOnDoneButton() {
        doneButton.click();
    }

    public boolean defaultCalendarIsChecked() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(defaultCalendarCheckmark)).isDisplayed();
    }

    public boolean newCalendarIsChecked() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(secondCalendarCheckmark)).isDisplayed();
    }

//    WIP
    public boolean assertThatNewCalendarIsDisplayed() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.invisibilityOf(secondCalendarCheckmark));
        try {
            return secondCalendarCheckmark.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

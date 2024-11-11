package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;

public class NewEventPage {

    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"New\"`]")
    private RemoteWebElement newEventPageContainer;

    @iOSXCUITFindBy(accessibility = "add-button")
    private RemoteWebElement addEventButton;

    @iOSXCUITFindBy(accessibility = "Title")
    private RemoteWebElement titleTextField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"All-day\"]")
    private RemoteWebElement allDaySwitch;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[1]")
    private RemoteWebElement hourPicker;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[2]")
    private RemoteWebElement minutePicker;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Starts']/preceding-sibling::XCUIElementTypeButton/XCUIElementTypeButton)[2]")
    private RemoteWebElement startsHourPickerButton;

    @iOSXCUITFindBy(accessibility = "Starts")
    private RemoteWebElement startsText;

    @iOSXCUITFindBy(accessibility = "Ends")
    private RemoteWebElement endsText;

    //    Before choosing All-day
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Date and Time Picker\"`][1]")
    private RemoteWebElement startDateAndTimePicker;

    //    After choosing All-day
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Date Picker\"`][1]")
    private RemoteWebElement startDatePicker;

    //    Before choosing All-day
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Date and Time Picker\"`][2]")
    private RemoteWebElement endDateAndTimePicker;

    //    After choosing All-day
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Date Picker\"`][2]")
    private RemoteWebElement endDatePicker;

    @iOSXCUITFindBy(accessibility = "DatePicker.NextMonth")
    private RemoteWebElement nextMonthButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"None\"])[1]")
    private RemoteWebElement travelTimePicker;

    public NewEventPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("New event page is loaded")
    public boolean newEventPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(newEventPageContainer)).isDisplayed();
    }

    @Step("Enter title of the event")
    public void enterEventTitle(String titleText) {
        titleTextField.sendKeys(titleText);
    }

    public String getEventTitleText() {
        return titleTextField.getText();
    }

    public void tapOnStartsDateToExpand() {
        startDateAndTimePicker.click();
    }

    public void tapOnEndsDateToExpand() {
        endDateAndTimePicker.click();
    }

    public void tapOnNextMonthArrow() {
        nextMonthButton.click();
    }

    @Step("Date {0} is chosen")
    public void chooseDate(String dateChosen) {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId(dateChosen))).click();
    }

//    @Step("Start hour {0} and minutes {1} is chosen")
//    public void chooseStartHour(String hour, String minutes) {
//        startsHourPickerButton.click();
//        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(hourPicker)).sendKeys(hour);
//        minutePicker.sendKeys(minutes);
//    }

    public void tapOnStartsTextToCollapse() {
        startsText.click();
    }

    public void tapOnEndsTextToCollapse() {
        endsText.click();
    }

    @Step("Travel time of {0} is chosen")
    public void chooseTravelTimeSpan(String timeSpan) {
        travelTimePicker.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId(timeSpan))).click();
    }

    @Step("Make it an all-day event")
    public void switchToAllDay() {
        allDaySwitch.click();
    }

    @Step("Only start date, but no time, is displayed")
    public boolean startDateWithoutTimeDisplayed() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(startDatePicker)).isDisplayed();
    }

    @Step("Only end date, but no time, is displayed")
    public boolean endDateWithoutTimeDisplayed() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(endDatePicker)).isDisplayed();
    }

    @Step("Add event")
    public void tapOnAddEventButton() {
        addEventButton.click();
    }
}

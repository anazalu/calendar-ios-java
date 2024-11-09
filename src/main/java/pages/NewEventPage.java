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
//    value = 0
//    value = 1

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[1]")
    private RemoteWebElement hourPicker;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[2]")
    private RemoteWebElement minutePicker;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Starts']/preceding-sibling::XCUIElementTypeButton/XCUIElementTypeButton)[2]")
    private RemoteWebElement startsHourPickerButton;

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

    @Step("Start hour {0} and minutes {1} is chosen")
    public void chooseStartHour(String hour, String minutes) {
        startsHourPickerButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(hourPicker)).sendKeys(hour);
        minutePicker.sendKeys(minutes);
    }

    @Step("Time span {0} is chosen")
    public void chooseTravelTimeSpan(String timeSpan) {
        travelTimePicker.click();
        driver.findElement(AppiumBy.accessibilityId(timeSpan)).click();
    }

    @Step("Date {0} is chosen")
    public void chooseDate(String dateChosen) {
//        travelTimePicker.click();
        driver.findElement(AppiumBy.accessibilityId(dateChosen)).click();
    }
}

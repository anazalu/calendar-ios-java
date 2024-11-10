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

public class NewCalendarPage {

    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Add Calendar\"`]")
    private RemoteWebElement newCalendarContainer;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"done-button\"`][2]")
    private RemoteWebElement doneButton;

    @iOSXCUITFindBy(accessibility = "calendar-title-field")
    private RemoteWebElement calendarTitleTextField;

    @iOSXCUITFindBy(accessibility = "chevron")
    private RemoteWebElement colorPickerButton;

    public NewCalendarPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Add calendar page is loaded")
    public boolean newCalendarPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(newCalendarContainer)).isDisplayed();
    }

    @Step("Enter {0} calendar name")
    public void enterEventTitle(String calendarName) {
        calendarTitleTextField.sendKeys(calendarName);
    }

    @Step("Color {0} is chosen")
    public void chooseColor(String colorChosen) {
        colorPickerButton.click();
        WebElement element = driver.findElement(AppiumBy.accessibilityId(colorChosen));
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(element)).click();
        driver.findElement(AppiumBy.accessibilityId("Add Calendar")).click();
    }

    @Step("Tap done")
    public void tapOnDoneButton() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(doneButton)).click();
    }
}

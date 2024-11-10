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

public class MonthPage {

    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "monthXXX")
    private RemoteWebElement monthXXX;

    public MonthPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Month page is loaded")
    public boolean monthPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(monthXXX)).isDisplayed();
    }

//    Temporary solution - should be December
    @Step("Event is added")
    public boolean eventAdded() {
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Sunday, 24 November"));

        return !element.getAttribute("value").equalsIgnoreCase("no events");
    }
}
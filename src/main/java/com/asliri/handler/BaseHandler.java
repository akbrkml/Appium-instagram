package com.asliri.handler;

import com.asliri.enums.WaitStrategy;
import com.asliri.factories.ExplicitWaitFactory;
import com.asliri.model.Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class BaseHandler {

    public AppiumDriver driver;

    public Platform platform;

    public BaseHandler(AppiumDriver driver, Platform platform) {
        this.driver = driver;
        this.platform = platform;
    }

    protected void click(By by) {
        WebElement element = ExplicitWaitFactory.explicitWait(WaitStrategy.CLICKABLE, by);
        element.click();
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void sendKeys(By by, String value) {
        WebElement element = ExplicitWaitFactory.explicitWait(WaitStrategy.VISIBILITY, by);
        element.sendKeys(value);
    }

    protected boolean isTextVisible(String text) {
        try {
            By selector = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + text.toLowerCase() + "\")");
            return driver.findElement(selector).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected void scrollDown() {
        By selector = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollForward()");
        driver.findElement(selector);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    protected void swipeDown() {
        // Perform the swipe action
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();

        int startPercentage = 80;
        int endPercentage = 20;

        int startX = screenWidth / 2;
        int startY = screenHeight * startPercentage / 100;
        int endX = screenWidth / 2;
        int endY = screenHeight * endPercentage / 100;

        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

}

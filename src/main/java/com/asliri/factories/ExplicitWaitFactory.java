package com.asliri.factories;

import com.appium.manager.AppiumDriverManager;
import com.asliri.Constants;
import com.asliri.driver.DriverManager;
import com.asliri.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitFactory {

    public static WebElement explicitWait(WaitStrategy waitStrategy, By by) {
        WebElement element;
        WebDriverWait wait = new WebDriverWait(AppiumDriverManager.getDriver(), Duration.ofMillis(Constants.WAIT_TIME));
        switch (waitStrategy) {
            case CLICKABLE:
                element = wait.until(ExpectedConditions.elementToBeClickable(by));
                break;
            case VISIBILITY:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                break;
            case PRESENCE:
                element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
                break;
            case NONE:
                System.out.println("No wait strategy is applied");
                element = DriverManager.getDriver().findElement(by);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + waitStrategy);
        }
        return element;
    }

    public static void explicitWait(By by) {
        WebDriverWait wait = new WebDriverWait(AppiumDriverManager.getDriver(), Duration.ofMillis(Constants.WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
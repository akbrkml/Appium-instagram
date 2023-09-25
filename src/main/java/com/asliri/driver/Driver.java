package com.asliri.driver;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;

import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Driver {

    public Driver() {
    }

    public static AppiumDriver driver;

    public static void init(URL url, DesiredCapabilities capabilities) {
        if (Objects.isNull(DriverManager.getDriver())) {
            driver = new AppiumDriver(url, capabilities);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
        }
    }

    public static void deinit() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}

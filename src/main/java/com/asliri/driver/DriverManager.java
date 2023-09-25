package com.asliri.driver;

import io.appium.java_client.AppiumDriver;

public final class DriverManager {

    public DriverManager() {

    }

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(AppiumDriver driverRef) {
        driver.set(driverRef);
    }

    public static void unload() {
        driver.remove();
    }
}

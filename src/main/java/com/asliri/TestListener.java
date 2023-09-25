package com.asliri;


import com.appium.manager.AppiumDeviceManager;
import com.appium.manager.AppiumDriverManager;
import com.asliri.model.Platform;
import com.asliri.pages.HomePage;
import com.asliri.pages.LoginPage;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.HashMap;

public class TestListener implements IInvokedMethodListener {

    static LoginPage loginPage;
    static HomePage homePage;
    static HashMap<String, Object> pageObjects = new HashMap<>();

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        String msg = String.format("%s.afterInvocation() was invoked", getClass().getName());
//        System.out.println("After DeviceId"
//            + AppiumDeviceManager.getAppiumDevice().getUdid());
        System.err.println(msg);
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        String msg = String.format("%s.beforeInvocation() was invoked", getClass().getName());
        loginPage = new LoginPage(AppiumDriverManager.getDriver(), Platform.INSTAGRAM);
        homePage = new HomePage(AppiumDriverManager.getDriver(), Platform.INSTAGRAM);
    }

    public static HashMap<String, Object> getPageObjectsInitialized() {
        pageObjects.put("loginPage", loginPage);
        pageObjects.put("homePage", homePage);
        return pageObjects;
    }
}
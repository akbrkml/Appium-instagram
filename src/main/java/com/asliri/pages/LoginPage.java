package com.asliri.pages;

import com.asliri.factories.ViewFactory;
import com.asliri.handler.BaseHandler;
import com.asliri.handler.SocialMediaHandler;
import com.asliri.model.Platform;
import com.asliri.pages.objects.LoginPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage extends BaseHandler {

    public ViewFactory viewFactory = new ViewFactory(driver);

    private final SocialMediaHandler runnerInfo;

    private final LoginPageObjects loginPageObjects = new LoginPageObjects();

    public LoginPage(AppiumDriver driver, Platform platform) {
        super(driver, platform);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofMillis(15000)), loginPageObjects);
        runnerInfo = viewFactory.getSocialMediaHandler(platform);
    }

    public HomePage login(String username, String password) {
        runnerInfo.login(this, username, password);
        return new HomePage(driver, platform);
    }

    public void enterUserCredentials(String username, String password) {
        loginPageObjects.username.sendKeys(username);
        loginPageObjects.password.sendKeys(password);
    }

    public void onClickLoginButton() {
        loginPageObjects.loginButton.click();
    }
}

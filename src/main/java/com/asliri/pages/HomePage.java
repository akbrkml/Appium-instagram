package com.asliri.pages;

import com.asliri.factories.ViewFactory;
import com.asliri.handler.BaseHandler;
import com.asliri.handler.SocialMediaHandler;
import com.asliri.model.Platform;
import com.asliri.pages.objects.HomePageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends BaseHandler {

    public ViewFactory viewFactory = new ViewFactory(driver);

    private final SocialMediaHandler runnerInfo;

    private final HomePageObjects homePageObjects = new HomePageObjects();


    public HomePage(AppiumDriver driver, Platform platform) {
        super(driver, platform);
        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageObjects);
        runnerInfo = viewFactory.getSocialMediaHandler(platform);
    }

    public HomePage loadHomePage() {
        click(homePageObjects.homeTabMenu);
        return new HomePage(driver, platform);
    }

    public void like() {
        runnerInfo.like(this);
    }

    public boolean validateLikeButton() {
        String likeButtonContentDesc = homePageObjects.likeButton.getAttribute("content-desc");
        if (likeButtonContentDesc == null) return false;
        boolean isLiked = likeButtonContentDesc.equalsIgnoreCase("liked");
        return !isLiked;
    }

    public void onClickLikeButton() {
        click(homePageObjects.likeButton);
    }

    public void navigateToFeed(String caption) {
        runnerInfo.navigateToFeed(caption);
    }
}

package com.asliri.factories;

import com.asliri.handler.FacebookHandler;
import com.asliri.handler.InstagramHandler;
import com.asliri.handler.SocialMediaHandler;
import com.asliri.model.Platform;
import io.appium.java_client.AppiumDriver;

public class ViewFactory {

    private InstagramHandler instagramHandler;
    private FacebookHandler facebookHandler;

    private final AppiumDriver driver;

    public ViewFactory(AppiumDriver driver) {
        this.driver = driver;
    }

    public SocialMediaHandler getSocialMediaHandler(Platform platform) {
        if (platform == null) {
            return null;
        }
        switch (platform) {
            case INSTAGRAM:
                if (instagramHandler == null) {
                    instagramHandler = new InstagramHandler(driver);
                }
                return instagramHandler;
            case FACEBOOK:
                if (facebookHandler == null) {
                    facebookHandler = new FacebookHandler(driver);
                }
                return facebookHandler;
            default:
                return null;
        }
    }

}

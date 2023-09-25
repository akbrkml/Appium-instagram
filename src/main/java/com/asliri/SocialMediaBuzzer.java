package com.asliri;

import com.asliri.handler.SocialMediaHandler;
import com.asliri.model.CommentElement;
import com.asliri.model.Platform;
import com.asliri.model.SearchElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class SocialMediaBuzzer {

    private final Map<Platform, SocialMediaHandler> handlers;

    public SocialMediaBuzzer() {
        handlers = new HashMap<>();
    }

    public void addHandler(Platform platform, SocialMediaHandler handler) {
        handlers.put(platform, handler);
    }

    public void performNavigateToFeed(Platform platform, String caption) {
        if (handlers.containsKey(platform)) {
            SocialMediaHandler handler = handlers.get(platform);
            handler.navigateToFeed(caption);
        } else {
            System.out.println("Platform not supported: " + platform);
        }
    }

    public void performNavigateToReels(Platform platform, String caption) {
        if (handlers.containsKey(platform)) {
            SocialMediaHandler handler = handlers.get(platform);
            handler.navigateToReels(caption);
        } else {
            System.out.println("Platform not supported: " + platform);
        }
    }

    public void performSearch(Platform platform, SearchElement element, String username) {
        if (handlers.containsKey(platform)) {
            SocialMediaHandler handler = handlers.get(platform);
            handler.search(element, username);
        } else {
            System.out.println("Platform not supported: " + platform);
        }
    }

    public void performOpenProfile(Platform platform, String username) {
        if (handlers.containsKey(platform)) {
            SocialMediaHandler handler = handlers.get(platform);
            handler.openProfile(username);
        } else {
            System.out.println("Platform not supported: " + platform);
        }
    }

    public void performOpenHashtag(Platform platform, String username) {
        if (handlers.containsKey(platform)) {
            SocialMediaHandler handler = handlers.get(platform);
            handler.openHashtag(username);
        } else {
            System.out.println("Platform not supported: " + platform);
        }
    }

    public void performLike(Platform platform, String id) {
        if (handlers.containsKey(platform)) {
            SocialMediaHandler handler = handlers.get(platform);
            handler.like(id);
        } else {
            System.out.println("Platform not supported: " + platform);
        }
    }

    public void performComment(Platform platform, CommentElement element, String commentText) {
        if (handlers.containsKey(platform)) {
            SocialMediaHandler handler = handlers.get(platform);
            handler.comment(element, commentText);
        } else {
            System.out.println("Platform not supported: " + platform);
        }
    }

    public DesiredCapabilities createCapabilitiesForPlatform(Map<String, Object> additionalParams) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, additionalParams.get("deviceName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, additionalParams.get("platformName"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, additionalParams.get("automationName"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, additionalParams.get("appPackage"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, additionalParams.get("appActivity"));
        capabilities.setCapability("noReset", additionalParams.get("noReset"));
        return capabilities;
    }

}

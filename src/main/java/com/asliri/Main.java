package com.asliri;

import com.asliri.handler.FacebookHandler;
import com.asliri.handler.InstagramHandler;
import com.asliri.model.CommentElement;
import com.asliri.model.Platform;
import com.asliri.model.SearchElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class  Main {
    public static void main(String[] args) throws MalformedURLException {
        SocialMediaBuzzer buzzer = new SocialMediaBuzzer();

//        Map<String, Object> parameter = setupFacebookParameter();
        Map<String, Object> parameter = setupInstagramParameter();
        DesiredCapabilities capabilities = buzzer.createCapabilitiesForPlatform(parameter);

//        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4730"), capabilities);

//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);

//        setupFacebookBuzzer(buzzer);
        setupInstagramBuzzer(buzzer);

//        driver.quit();
    }

    private static Map<String, Object> setupFacebookParameter() {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("deviceName", "emulator-5554");
        parameter.put("platformName", "Android");
        parameter.put("automationName", "UiAutomator2");
        parameter.put("appPackage", "com.facebook.katana");
        parameter.put("appActivity", "com.facebook.mainactivity.MainActivity");
        parameter.put("noReset", true);
        return parameter;
    }

    private static void setupFacebookBuzzer(SocialMediaBuzzer buzzer) {
//        buzzer.addHandler(Platform.FACEBOOK, new FacebookHandler());

        SearchElement searchElement = new SearchElement(
                "//android.widget.Button[@content-desc='Search']",
                "//*[@class='android.widget.EditText']",
                "searchKeywordTitle");

        buzzer.performSearch(Platform.FACEBOOK, searchElement, "ganjar");

        buzzer.performLike(Platform.FACEBOOK, "//*[@class='android.view.ViewGroup']");

        CommentElement commentElement = new CommentElement(
                "//android.view.ViewGroup[@content-desc='Comment']",
                "//*[@class='android.widget.EditText']",
                "//android.view.ViewGroup[@content-desc='Send']"
        );

        buzzer.performComment(Platform.FACEBOOK, commentElement, "Nice post!");
    }

    private static Map<String, Object> setupInstagramParameter() {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("deviceName", "emulator-5554");
        parameter.put("platformName", "Android");
        parameter.put("automationName", "UiAutomator2");
        parameter.put("appPackage", "com.instagram.android");
        parameter.put("appActivity", "com.instagram.mainactivity.MainActivity");
        parameter.put("noReset", true);
        return parameter;
    }

    private static void setupInstagramBuzzer(SocialMediaBuzzer buzzer) {
//        buzzer.addHandler(Platform.INSTAGRAM, new InstagramHandler());

        SearchElement searchElement = new SearchElement(
                "//*[@content-desc='Search and explore']",
                "//*[@resource-id='com.instagram.android:id/action_bar_search_edit_text']",
                "searchKeywordTitle");

        buzzer.performSearch(Platform.INSTAGRAM, searchElement, "ganjar_pranowo");

        buzzer.performLike(Platform.INSTAGRAM, "com.instagram.android:id/row_feed_button_like");

        CommentElement commentElement = new CommentElement(
                "com.instagram.android:id/row_feed_button_comment",
                "com.instagram.android:id/layout_comment_thread_edittext",
                "com.instagram.android:id/layout_comment_thread_post_button"
        );

        buzzer.performComment(Platform.INSTAGRAM, commentElement, "Nice post!");
    }
}
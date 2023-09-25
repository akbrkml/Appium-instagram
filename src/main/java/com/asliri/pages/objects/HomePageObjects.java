package com.asliri.pages.objects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomePageObjects {

    @AndroidFindBy(id = "com.instagram.android:id/clips_tab")
    public WebElement homeTabMenu;

    @AndroidFindBy(id = "com.instagram.android:id/like_button")
    public WebElement likeButton;

}

package com.asliri.pages.objects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

public class CommentPageObjects {

    @CacheLookup
    @AndroidFindBy(id = "org.wordpress.android:id/nux_username")
    public WebElement commentTextField;

    @AndroidFindBy(id = "org.wordpress.android:id/nux_password")
    public WebElement commentSubmitButton;

}

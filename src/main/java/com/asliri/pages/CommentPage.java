package com.asliri.pages;

import com.asliri.factories.ViewFactory;
import com.asliri.handler.BaseHandler;
import com.asliri.handler.SocialMediaHandler;
import com.asliri.model.Platform;
import com.asliri.pages.objects.CommentPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CommentPage extends BaseHandler {

    public ViewFactory viewFactory = new ViewFactory(driver);

    private final SocialMediaHandler runnerInfo;

    private final CommentPageObjects commentPageObjects = new CommentPageObjects();

    public CommentPage(AppiumDriver driver, Platform platform) {
        super(driver, platform);
        PageFactory.initElements(new AppiumFieldDecorator(driver), commentPageObjects);
        runnerInfo = viewFactory.getSocialMediaHandler(platform);
    }

    public CommentPage commentOnFeed(String comment) {
        runnerInfo.comment(this, comment);
        return new CommentPage(driver, platform);
    }

    public void enterComment(String comment) {
        commentPageObjects.commentTextField.sendKeys(comment);
    }

    public void onClickCommentSubmitButton() {
        commentPageObjects.commentSubmitButton.click();
    }
}

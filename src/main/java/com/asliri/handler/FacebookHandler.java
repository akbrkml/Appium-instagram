package com.asliri.handler;

import com.asliri.model.CommentElement;
import com.asliri.model.Platform;
import com.asliri.model.SearchElement;
import com.asliri.pages.CommentPage;
import com.asliri.pages.HomePage;
import com.asliri.pages.LoginPage;
import com.asliri.utils.Pair;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class FacebookHandler extends BaseHandler implements SocialMediaHandler {

    public FacebookHandler(AppiumDriver driver) {
        super(driver, Platform.FACEBOOK);
    }

    @Override
    public void login(LoginPage loginPage, String username, String password) {

    }

    @Override
    public void navigateToFeed(String caption) {

    }

    @Override
    public void navigateToReels(String caption) {

    }

    @Override
    public void search(SearchElement element, String username) {
        WebElement searchTabMenu = driver.findElement(By.xpath(element.getSearchTabMenuContentDesc()));
        if (!searchTabMenu.isDisplayed()) return;
        searchTabMenu.click();

        WebElement searchInput = driver.findElement(By.xpath(element.getSearchTextInputId()));
        if (!searchInput.isDisplayed()) return;

//        //Check user exists on the search list, then directly open profile if matched
//        Map.Entry<Boolean, WebElement> userExists = isUserExists(driver, username);
//
//        boolean isUserMatched = userExists.getKey();
//        if (isUserMatched) {
//            openProfile(driver, username);
//            return;
//        }

        //If not exists search with username
        searchInput.sendKeys(username);
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));

        openProfile(username);
    }

    @Override
    public void openProfile(String username) {
        WebElement recyclerView = driver.findElement(By.xpath("//*[@class='android.view.ViewGroup']"));
        if (!recyclerView.isDisplayed()) return;

        WebElement gridRecyclerView = driver.findElement(By.id("android:id/list"));
        if (!gridRecyclerView.isDisplayed()) return;
        gridRecyclerView.click();
    }

    @Override
    public void openHashtag(String username) {

    }

    @Override
    public void like(String id) {
        // Find and click the post's like button
        WebElement likeButton = driver.findElement(By.xpath(id));
        if (!likeButton.isDisplayed()) return;

        String contentDesc = likeButton.getAttribute("content-desc");
        boolean isLiked = contentDesc.equalsIgnoreCase("Like button, pressed. Double tap and hold to change reaction.");
        if (isLiked) return;

        likeButton.click();
    }

    @Override
    public void like(HomePage homePage) {

    }

    @Override
    public void comment(@NotNull CommentElement element, String comment) {
        // Find and click the comment button
        WebElement commentButton = driver.findElement(By.xpath(element.getCommentButtonId()));
        if (!commentButton.isDisplayed()) return;
        commentButton.click();

        // Enter a comment
        WebElement commentInput = driver.findElement(By.xpath(element.getCommentTextInputId()));
        if (!commentInput.isDisplayed()) return;
        commentInput.sendKeys(comment);

        // Submit the comment
        WebElement submitComment = driver.findElement(By.xpath(element.getCommentPostButtonId()));
        if (!submitComment.isDisplayed()) return;
        submitComment.click();
    }

    @Override
    public void comment(CommentPage commentPage, String comment) {

    }

    private Map.Entry<Boolean, WebElement> isUserExists(AppiumDriver driver, String username) {
        WebElement recyclerView = driver.findElement(By.xpath("//*[@class='androidx.recyclerview.widget.RecyclerView"));
        if (!recyclerView.isDisplayed()) return Pair.of(false, null);

        WebElement userItem = recyclerView.findElement(By.id("com.instagram.android:id/row_search_user_username"));
        if (!userItem.isDisplayed()) return Pair.of(false, null);

        return Pair.of(userItem.getText().equalsIgnoreCase(username), userItem);
    }

}

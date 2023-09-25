package com.asliri.handler;

import com.asliri.enums.WaitStrategy;
import com.asliri.factories.ExplicitWaitFactory;
import com.asliri.model.CommentElement;
import com.asliri.model.Platform;
import com.asliri.model.SearchElement;
import com.asliri.pages.CommentPage;
import com.asliri.pages.HomePage;
import com.asliri.pages.LoginPage;
import com.asliri.utils.Pair;
import io.appium.java_client.AppiumDriver;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class InstagramHandler extends BaseHandler implements SocialMediaHandler {

    public InstagramHandler(AppiumDriver driver) {
        super(driver, Platform.INSTAGRAM);
    }

    @Override
    public void login(LoginPage loginPage, String username, String password) {
        loginPage.enterUserCredentials(username, password);
        loginPage.onClickLoginButton();
    }

    @Override
    public void navigateToFeed(String caption) {
        boolean postFound = false;
        while (!postFound) {
            // Check if the target post description is visible on the screen
            if (isTextVisible(caption)) {
                postFound = true;
            } else {
                // Scroll down to load more posts
                scrollDown();
            }
        }
    }

    @Override
    public void navigateToReels(String caption) {
        By reelsTabMenuLocator = By.id("com.instagram.android:id/clips_tab");
        click(reelsTabMenuLocator);

        boolean postFound = false;
        while (!postFound) {
            // Check if the target post description is visible on the screen
            if (isTextVisible(caption)) {
                postFound = true;
            } else {
                // Swipe down to load more reels
                swipeDown();
            }
        }
    }

    @Override
    public void search(SearchElement element, String username) {
        By searchTabMenuXpath = By.xpath(element.getSearchTabMenuContentDesc());
        click(searchTabMenuXpath);

        By searchInputViewXpath = By.xpath(element.getSearchTextInputId());
        click(searchInputViewXpath);

        By searchInputXpath = By.xpath(element.getSearchTextInputId());
        sendKeys(searchInputXpath, username);

        By searchKeywordTitle = By.id(element.getSearchKeywordTitle());
        click(searchKeywordTitle);
    }

    @Override
    public void openHashtag(String username) {
        By tabWidgetXpath = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.TabWidget");
        WebElement tabWidgetElement = ExplicitWaitFactory.explicitWait(WaitStrategy.CLICKABLE, tabWidgetXpath);
        boolean isTabWidgetHashtag = tabWidgetElement.getText().equalsIgnoreCase("Tags");

        if (!isTabWidgetHashtag) return;

        click(tabWidgetElement);

        By hashtagItemId = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
        WebElement hashtagItemElement = ExplicitWaitFactory.explicitWait(WaitStrategy.VISIBILITY, hashtagItemId);

        boolean isHashtagsMatched = hashtagItemElement.getText().contains(username);
        if (!isHashtagsMatched) return;

        click(hashtagItemElement);

        By gridRecyclerViewId = By.id("com.instagram.android:id/recycler_view");
        WebElement gridRecyclerViewElement = ExplicitWaitFactory.explicitWait(WaitStrategy.VISIBILITY, gridRecyclerViewId);

        By itemPostGridId = By.id("com.instagram.android:id/image_button");
        ExplicitWaitFactory.explicitWait(itemPostGridId);
        WebElement itemPostGridElement = gridRecyclerViewElement.findElement(itemPostGridId);

        String contentDesc = itemPostGridElement.getAttribute("content-desc").toLowerCase();

        if (!contentDesc.contains("row 1, column 2")) return;

        click(itemPostGridElement);
    }

    @Override
    public void openProfile(String username) {
        By tabWidgetXpath = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TabWidget");
        WebElement tabWidgetElement = ExplicitWaitFactory.explicitWait(WaitStrategy.CLICKABLE, tabWidgetXpath);
        boolean isTabWidgetAccount = tabWidgetElement.getText().equalsIgnoreCase("Accounts");

        if (!isTabWidgetAccount) return;

        click(tabWidgetElement);

        Map.Entry<Boolean, WebElement> userExists = isUserExists(username);

        boolean isUserMatched = userExists.getKey();
        if (!isUserMatched) return;

        WebElement userItemElement = userExists.getValue();
        click(userItemElement);

        By gridRecyclerViewId = By.id("android:id/list");
        WebElement gridRecyclerViewElement = ExplicitWaitFactory.explicitWait(WaitStrategy.VISIBILITY, gridRecyclerViewId);

        By itemPostGridId = By.id("com.instagram.android:id/media_set_row_content_identifier");
        ExplicitWaitFactory.explicitWait(itemPostGridId);
        WebElement itemPostGridElement = gridRecyclerViewElement.findElement(itemPostGridId);

        By buttonXpath = By.xpath("//*[@class='android.widget.Button']");
        ExplicitWaitFactory.explicitWait(buttonXpath);
        WebElement buttonElement = itemPostGridElement.findElement(buttonXpath);

        String buttonContentDesc = buttonElement.getAttribute("content-desc").toLowerCase();
        if (!buttonContentDesc.contains("row 1, column 1")) return;
        click(buttonElement);
    }

    @Override
    public void like(String id) {
        // Find and click the post's like button
        By likeButtonId = By.id(id);
        WebElement likeButtonElement = ExplicitWaitFactory.explicitWait(WaitStrategy.VISIBILITY, likeButtonId);

        String likeButtonContentDesc = likeButtonElement.getAttribute("content-desc");
        if (likeButtonContentDesc == null) return;
        boolean isLiked = likeButtonContentDesc.equalsIgnoreCase("liked");
        if (isLiked) return;

        click(likeButtonElement);
    }

    @Override
    public void like(HomePage homePage) {
        homePage.validateLikeButton();
        homePage.onClickLikeButton();
    }

    @Override
    public void comment(@NotNull CommentElement element, String comment) {
        // Find and click the comment button
        By commentButtonId = By.id(element.getCommentButtonId());
        click(commentButtonId);

        // Enter a comment
        By commentInputId = By.id(element.getCommentTextInputId());
        sendKeys(commentInputId, comment);

        // Submit the comment
        By submitCommentId = By.id(element.getCommentPostButtonId());
        click(submitCommentId);
    }

    @Override
    public void comment(CommentPage commentPage, String comment) {
        commentPage.enterComment(comment);
        commentPage.onClickCommentSubmitButton();
    }

    private Map.Entry<Boolean, WebElement> isUserExists(String username) {
        By userItemId = By.id("com.instagram.android:id/row_search_user_username");
        WebElement userItemElement = ExplicitWaitFactory.explicitWait(WaitStrategy.VISIBILITY, userItemId);

        boolean isUserMatched = userItemElement.getText().equalsIgnoreCase(username);
        return Pair.of(isUserMatched, userItemElement);
    }

}

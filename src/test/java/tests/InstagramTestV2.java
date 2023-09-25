package tests;

import com.appium.manager.AppiumDriverManager;
import com.asliri.driver.Driver;
import com.asliri.handler.InstagramHandler;
import com.asliri.model.CommentElement;
import com.asliri.model.Platform;
import com.asliri.model.SearchElement;
import com.asliri.pages.HomePage;
import com.asliri.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class InstagramTestV2  {

    LoginPage loginPage;

    HomePage homePage;

    Platform platform = Platform.INSTAGRAM;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        loginPage = new LoginPage(AppiumDriverManager.getDriver(), platform);
        homePage = new HomePage(AppiumDriverManager.getDriver(), platform);
    }

    @Test(groups = "Parallel")
    public void likeFeed() throws InterruptedException, IOException {
        homePage.navigateToFeed("kemarin");
        homePage.like();
    }

//    @Test
//    public void searchUserUsingUsernameThenLikeAndCommentFeedFromUserProfile() {
//        SearchElement searchElement = new SearchElement(
//                "//*[@content-desc='Search and explore']",
//                "//*[@resource-id='com.instagram.android:id/action_bar_search_edit_text']",
//                "com.instagram.android:id/row_search_keyword_title"
//        );
//
//        buzzer.performSearch(Platform.INSTAGRAM, searchElement, "ganjar_pranowo");
//
//        buzzer.performOpenProfile(Platform.INSTAGRAM, "ganjar_pranowo");
//
//        buzzer.performLike(Platform.INSTAGRAM, "com.instagram.android:id/row_feed_button_like");
//
//        CommentElement commentElement = new CommentElement(
//                "com.instagram.android:id/row_feed_button_comment",
//                "com.instagram.android:id/layout_comment_thread_edittext",
//                "com.instagram.android:id/layout_comment_thread_post_button"
//        );
//
//        buzzer.performComment(Platform.INSTAGRAM, commentElement, "Nice post!");
//    }
//
//    @Test
//    public void searchUserUsingUsernameThenLikeAndCommentFeedFromHashtag() {
//        SearchElement searchElement = new SearchElement(
//                "//*[@content-desc='Search and explore']",
//                "//*[@resource-id='com.instagram.android:id/action_bar_search_edit_text']",
//                "com.instagram.android:id/row_search_keyword_title"
//        );
//
//        buzzer.performSearch(Platform.INSTAGRAM, searchElement, "ganjar_pranowo");
//
//        buzzer.performOpenHashtag(Platform.INSTAGRAM, "ganjar_pranowo");
//
//        buzzer.performLike(Platform.INSTAGRAM, "com.instagram.android:id/row_feed_button_like");
//
//        CommentElement commentElement = new CommentElement(
//                "com.instagram.android:id/row_feed_button_comment",
//                "com.instagram.android:id/layout_comment_thread_edittext",
//                "com.instagram.android:id/layout_comment_thread_post_button"
//        );
//
//        for (int i = 0; i < 2; i++) {
//            buzzer.performComment(Platform.INSTAGRAM, commentElement, "Nice post!"+i);
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Test
//    public void searchFeedUsingCaptionThenLikeAndComment() {
//        buzzer.performNavigateToFeed(Platform.INSTAGRAM, "Bismillah");
//
//        buzzer.performLike(Platform.INSTAGRAM, "com.instagram.android:id/row_feed_button_like");
//
//        CommentElement commentElement = new CommentElement(
//                "com.instagram.android:id/row_feed_button_comment",
//                "com.instagram.android:id/layout_comment_thread_edittext",
//                "com.instagram.android:id/layout_comment_thread_post_button"
//        );
//
//        buzzer.performComment(Platform.INSTAGRAM, commentElement, "Nice post!");
//    }
//
//    @Test
//    public void searchFeedUsingUsernameThenLikeAndComment() {
//        buzzer.performNavigateToFeed(Platform.INSTAGRAM, "dashcam");
//
//        buzzer.performLike(Platform.INSTAGRAM, "com.instagram.android:id/row_feed_button_like");
//
//        CommentElement commentElement = new CommentElement(
//                "com.instagram.android:id/row_feed_button_comment",
//                "com.instagram.android:id/layout_comment_thread_edittext",
//                "com.instagram.android:id/layout_comment_thread_post_button"
//        );
//
//        buzzer.performComment(Platform.INSTAGRAM, commentElement, "Nice post!");
//    }
//
//    @Test
//    public void searchReelsUsingUsernameThenLike() {
//        buzzer.performNavigateToReels(Platform.INSTAGRAM, "dashcam");
//
//        buzzer.performLike(Platform.INSTAGRAM, "com.instagram.android:id/like_button");
//    }


}

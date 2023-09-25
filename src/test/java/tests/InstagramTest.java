package tests;

import com.asliri.handler.InstagramHandler;
import com.asliri.model.CommentElement;
import com.asliri.model.Platform;
import com.asliri.model.SearchElement;
import org.testng.annotations.Test;

public class InstagramTest extends BaseTest {

    @Override
    protected void setupSocialMediaHandler() {
//        buzzer.addHandler(Platform.INSTAGRAM, new InstagramHandler());
    }

    @Test
    public void searchUserUsingUsernameThenLikeAndCommentFeedFromUserProfile() {
        SearchElement searchElement = new SearchElement(
                "//*[@content-desc='Search and explore']",
                "//*[@resource-id='com.instagram.android:id/action_bar_search_edit_text']",
                "com.instagram.android:id/row_search_keyword_title"
        );

        buzzer.performSearch(Platform.INSTAGRAM, searchElement, "ganjar_pranowo");

        buzzer.performOpenProfile(Platform.INSTAGRAM, "ganjar_pranowo");

        buzzer.performLike(Platform.INSTAGRAM, "com.instagram.android:id/row_feed_button_like");

        CommentElement commentElement = new CommentElement(
                "com.instagram.android:id/row_feed_button_comment",
                "com.instagram.android:id/layout_comment_thread_edittext",
                "com.instagram.android:id/layout_comment_thread_post_button"
        );

        buzzer.performComment(Platform.INSTAGRAM, commentElement, "Nice post!");
    }

    @Test
    public void searchUserUsingUsernameThenLikeAndCommentFeedFromHashtag() {
        SearchElement searchElement = new SearchElement(
                "//*[@content-desc='Search and explore']",
                "//*[@resource-id='com.instagram.android:id/action_bar_search_edit_text']",
                "com.instagram.android:id/row_search_keyword_title"
        );

        buzzer.performSearch(Platform.INSTAGRAM, searchElement, "ganjar_pranowo");

        buzzer.performOpenHashtag(Platform.INSTAGRAM, "ganjar_pranowo");

        buzzer.performLike(Platform.INSTAGRAM, "com.instagram.android:id/row_feed_button_like");

        CommentElement commentElement = new CommentElement(
                "com.instagram.android:id/row_feed_button_comment",
                "com.instagram.android:id/layout_comment_thread_edittext",
                "com.instagram.android:id/layout_comment_thread_post_button"
        );

        for (int i = 0; i < 2; i++) {
            buzzer.performComment(Platform.INSTAGRAM, commentElement, "Nice post!"+i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void searchFeedUsingCaptionThenLikeAndComment() {
        buzzer.performNavigateToFeed(Platform.INSTAGRAM, "Bismillah");

        buzzer.performLike(Platform.INSTAGRAM, "com.instagram.android:id/row_feed_button_like");

        CommentElement commentElement = new CommentElement(
                "com.instagram.android:id/row_feed_button_comment",
                "com.instagram.android:id/layout_comment_thread_edittext",
                "com.instagram.android:id/layout_comment_thread_post_button"
        );

        buzzer.performComment(Platform.INSTAGRAM, commentElement, "Nice post!");
    }

    @Test
    public void searchFeedUsingUsernameThenLikeAndComment() {
        buzzer.performNavigateToFeed(Platform.INSTAGRAM, "dashcam");

        buzzer.performLike(Platform.INSTAGRAM, "com.instagram.android:id/row_feed_button_like");

        CommentElement commentElement = new CommentElement(
                "com.instagram.android:id/row_feed_button_comment",
                "com.instagram.android:id/layout_comment_thread_edittext",
                "com.instagram.android:id/layout_comment_thread_post_button"
        );

        buzzer.performComment(Platform.INSTAGRAM, commentElement, "Nice post!");
    }

    @Test
    public void searchReelsUsingUsernameThenLike() {
        buzzer.performNavigateToReels(Platform.INSTAGRAM, "dashcam");

        buzzer.performLike(Platform.INSTAGRAM, "com.instagram.android:id/like_button");
    }

}

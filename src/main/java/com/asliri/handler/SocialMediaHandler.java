package com.asliri.handler;

import com.asliri.model.CommentElement;
import com.asliri.model.SearchElement;
import com.asliri.pages.CommentPage;
import com.asliri.pages.HomePage;
import com.asliri.pages.LoginPage;

public interface SocialMediaHandler {

    void login(LoginPage loginPage, String username, String password);

    void navigateToFeed(String caption);

    void navigateToReels(String caption);

    void search(SearchElement element, String username);

    void openProfile(String username);

    void openHashtag(String username);

    void like(String id);
    void like(HomePage homePage);

    void comment(CommentElement element, String comment);

    void comment(CommentPage commentPage, String comment);

}

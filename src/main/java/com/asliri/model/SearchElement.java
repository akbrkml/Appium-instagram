package com.asliri.model;

public class SearchElement {

    private String searchTabMenuContentDesc;
    private String searchTextInputId;
    private String searchKeywordTitle;

    public SearchElement(String searchTabMenuContentDesc, String searchTextInputId, String searchKeywordTitle) {
        this.searchTabMenuContentDesc = searchTabMenuContentDesc;
        this.searchTextInputId = searchTextInputId;
        this.searchKeywordTitle = searchKeywordTitle;
    }

    public String getSearchTabMenuContentDesc() {
        return searchTabMenuContentDesc;
    }

    public void setSearchTabMenuContentDesc(String searchTabMenuContentDesc) {
        this.searchTabMenuContentDesc = searchTabMenuContentDesc;
    }

    public String getSearchTextInputId() {
        return searchTextInputId;
    }

    public void setSearchTextInputId(String searchTextInputId) {
        this.searchTextInputId = searchTextInputId;
    }

    public String getSearchKeywordTitle() {
        return searchKeywordTitle;
    }

    public void setSearchKeywordTitle(String searchKeywordTitle) {
        this.searchKeywordTitle = searchKeywordTitle;
    }
}

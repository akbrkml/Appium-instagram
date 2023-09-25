package com.asliri.model;

public class CommentElement {

    private String commentButtonId;
    private String commentTextInputId;
    private String commentPostButtonId;

    public CommentElement(String commentButtonId, String commentTextInputId, String commentPostButtonId) {
        this.commentButtonId = commentButtonId;
        this.commentTextInputId = commentTextInputId;
        this.commentPostButtonId = commentPostButtonId;
    }

    public String getCommentButtonId() {
        return commentButtonId;
    }

    public void setCommentButtonId(String commentButtonId) {
        this.commentButtonId = commentButtonId;
    }

    public String getCommentTextInputId() {
        return commentTextInputId;
    }

    public void setCommentTextInputId(String commentTextInputId) {
        this.commentTextInputId = commentTextInputId;
    }

    public String getCommentPostButtonId() {
        return commentPostButtonId;
    }

    public void setCommentPostButtonId(String commentPostButtonId) {
        this.commentPostButtonId = commentPostButtonId;
    }
}

package com.example.tests;

public class FormFieldsObject {
    private final String nickname;
    private final String email;
    private final String location;
    private final String reviewTitle;
    private final String reviewText;


    public FormFieldsObject(String nickname, String email, String location, String reviewTitle, String reviewText) {
        this.nickname = nickname;
        this.email = email;
        this.location = location;
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;

    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public String getReviewText() {
        return reviewText;
    }

}

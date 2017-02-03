package com.example.tests;

public class FormFieldsObject {
    public String nickname;
    public String email;
    public String location;
    public String reviewTitle;
    public String reviewText;
    public String ID;


//Сеттеры



    public FormFieldsObject setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public FormFieldsObject setEmail(String email) {
        this.email = email;
        return this;
    }


    public FormFieldsObject setLocation(String location) {
        this.location = location;
        return this;
    }

    public FormFieldsObject setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
        return this;
    }

    public FormFieldsObject setReviewText(String reviewText) {
        this.reviewText = reviewText;
        return this;
    }

    public FormFieldsObject setID(String ID) {
        this.ID = ID;
        return this;
    }


    //Геттеры

    
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

    public String getID() {
        return ID;
    }

    //Благодаря добавлению методов equals и hashCode - сравнение объектов будет происходить по именам, а не по их адресу в памяти

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormFieldsObject)) return false;

        FormFieldsObject that = (FormFieldsObject) o;

        return ID.equals(that.ID);
    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }
}



/* public FormFieldsObject(String nickname, String email, String location, String reviewTitle, String reviewText) {
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
*/


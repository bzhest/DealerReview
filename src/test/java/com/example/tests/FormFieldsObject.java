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
   //Если не делать Override - то будет использована реазизация методов hashCode и equals общего объекта Object, что не правильно тут делать

    @Override
    public int hashCode() {
        final int prime =31;
        int result = 1;
        result = prime * result + ((reviewText == null) ? 0 : reviewText.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        // Проверяем.ю что ссылки ссылаются на один и тот же объект
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        if (!(obj instanceof FormFieldsObject)) return false;

        FormFieldsObject other = (FormFieldsObject) obj;
        if (reviewText == null){
            if (other.reviewText != null)
                return false;
    } else if (!reviewText.equals(other.reviewText))
        return false;
//Тут ниже сравниваются идентификаторы, если оба они не нулевые. Если один из них нулевой - ничего делать не надо
        if (ID!=null && other.ID!=null){
            return ID.equals(other.ID);
        }

        return true;
    }

  /*  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormFieldsObject)) return false;

        FormFieldsObject that = (FormFieldsObject) o;

        if (!getReviewText().equals(that.getReviewText())) return false;
        return getID() != null ? getID().equals(that.getID()) : that.getID() == null;
    }

    @Override
    public int hashCode() {
        return getReviewText().hashCode();
    }*/
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


package com.example.mads.Models;

public class stories {

    String Title,Content,Date;
    int userPhoto;




    public stories(String title, String content, String date, int userPhoto) {
        Title = title;
        Content = content;
        Date = date;
        this.userPhoto = userPhoto;
    }

    public stories() {
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(int userPhoto) {
        this.userPhoto = userPhoto;
    }
}

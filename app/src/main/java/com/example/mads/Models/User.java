package com.example.mads.Models;

public class User {
    private String username,id;
    private String imageUrl;
    private String status;
    private String title;
    private String description;

    public User(String username, String id, String imageUrl,String status,String title,String description) {
        this.username = username;
        this.id = id;
        this.imageUrl = imageUrl;
        this.status =  status;
        this.title = title;
        this.description = description;
    }
public User(){

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

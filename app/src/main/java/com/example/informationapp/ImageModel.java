package com.example.informationapp;

public class ImageModel {
    private String username;
    private String location;
    private String title;
    private String views;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ImageModel(String username, String location, String title, String views, String desc) {
        this.username = username;
        this.location = location;
        this.title = title;
        this.views = views;
        this.desc = desc;
    }

    private String desc;

}

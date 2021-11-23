package com.example.f21comp1011s1assignment2;

public class ArticleSource {
    /*
     * Declare instance variables; url, title, favicon
     * */
    private String url, title, favicon;


    /*
     * The JSON library uses the default constructor that handles the reflection.
     *       So, JSON won't trigger your validations on setters
     * */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }
}

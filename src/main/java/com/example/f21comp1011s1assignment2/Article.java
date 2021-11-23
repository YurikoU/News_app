package com.example.f21comp1011s1assignment2;

import com.google.gson.annotations.SerializedName;

public class Article {
    /*
     * Declare instance variables; source, title, link, publishedDate, description, thumbnail
     * */
    private ArticleSource source;

    private String title;

    private String link;

    //Inside of Java, tell the system to look for "publishedDate" instead of "published_date"
    //      so the variable name can meet the Java name convention and not become confusing.
    //      Only for JSON, still refer to "published_date."
    @SerializedName("published_date")
    private String publishedDate;

    private String description;

    private String thumbnail;


    /*
     * The JSON library uses the default constructor that handles the reflection.
     *       So, JSON won't trigger your validations on setters
     * */
    public ArticleSource getSource() {
        return source;
    }

    public void setSource(ArticleSource source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}

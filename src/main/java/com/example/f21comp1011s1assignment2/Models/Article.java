package com.example.f21comp1011s1assignment2.Models;

import com.google.gson.annotations.SerializedName;

public class Article {
    /*
     * Declare instance variables
     * */
    //Inside of Java, tell the system to look for "id" instead of "_id"
    //      so the variable name can meet the Java name convention and not become confusing.
    //      Only for JSON, still refer to "_id."
    @SerializedName("_id")
    private String id;

    @SerializedName("_score")
    private double score;

    private String author;

    @SerializedName("clean_url")
    private String cleanUrl;

    private String country;

    private String language;

    private String link;

    @SerializedName("published_date")
    private String publishedDate;

    private String rank;

    private String rights;

    private String summary;

    private String title;

    private String topic;


    /*
     * The JSON library uses the default constructor that handles the reflection.
     *       So, JSON won't trigger your validations on setters
     * */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCleanUrl() {
        return cleanUrl;
    }

    public void setCleanUrl(String cleanUrl) {
        this.cleanUrl = cleanUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return title;
    }
}

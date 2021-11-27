package com.example.f21comp1011s1assignment2.Models;

import com.google.gson.annotations.SerializedName;

public class UserInput {
    /*
     * Instance variables
     * */
    private String from;

    private String lang;

    private int page;

    private String q;

    //Inside of Java, tell the system to look for "rankedOnly" instead of "ranked_only"
    //      so the variable name can meet the Java name convention and not become confusing.
    //      Only for JSON, still refer to "ranked_only."
    @SerializedName("ranked_only")
    private String rankedOnly;

    private int size;

    @SerializedName("sort_by")
    private String sortBy;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getRankedOnly() {
        return rankedOnly;
    }

    public void setRankedOnly(String rankedOnly) {
        this.rankedOnly = rankedOnly;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}

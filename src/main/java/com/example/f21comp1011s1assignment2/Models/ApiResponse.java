package com.example.f21comp1011s1assignment2.Models;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {

    /*
     * Instance variables
     * */
    private Article[] articles;

    private int page;

    @SerializedName("page_size")
    private int pageSize;

    private String status;

    @SerializedName("total_hits")
    private int totalHits;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("user_input")
    private UserInput userInput;

    public Article[] getArticles() {
        return articles;
    }

    public void setArticles(Article[] articles) {
        this.articles = articles;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public UserInput getUserInput() {
        return userInput;
    }

    public void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }
}

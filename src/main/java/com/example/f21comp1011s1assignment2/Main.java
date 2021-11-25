package com.example.f21comp1011s1assignment2;


import javafx.scene.web.WebView;

public class Main {
    public static void main(String[] args) {
        ApiResponse result = ApiUtility.getArticlesFromApi("COVID");
        System.out.println(result);


        //Get the URL for the main content of the first article
        String url = result.getArticles()[0].getLink();

        WebView webView = new WebView();
        webView.getEngine().loadContent(String.valueOf(url));

    }
}

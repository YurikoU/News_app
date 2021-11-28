package com.example.f21comp1011s1assignment2.Controllers;

import com.example.f21comp1011s1assignment2.Interface.InitializeArticle;
import com.example.f21comp1011s1assignment2.Models.Article;
import com.example.f21comp1011s1assignment2.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;

public class NewsDetailsViewController implements InitializeArticle {


    @FXML
    private Button BackToArticleListButton;

    @FXML
    private WebView articleDataWebView;

    @FXML
    private Label articleTitleLabel;

    private WebEngine webEngine;

    @FXML
    public void loadFullArticle(Article article) {
        //Set the news title on the top
        articleTitleLabel.setText(article.getTitle());

        //Get the site URL
        String url = article.getLink();

        //Access the URL from the WebView element
        webEngine = articleDataWebView.getEngine();
        webEngine.load(url);
    }

    /*
     * Switch the JavaFX scene
     * */
    @FXML
    private void backToList(ActionEvent event) throws IOException {
        SceneChanger.change(event, "news-search-view.fxml", "Search News");
    }


}

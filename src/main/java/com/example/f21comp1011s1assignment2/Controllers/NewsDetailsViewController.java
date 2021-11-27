package com.example.f21comp1011s1assignment2.Controllers;

import com.example.f21comp1011s1assignment2.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewsDetailsViewController implements Initializable {


    @FXML
    private Button BackToArticleListButton;

    @FXML
    private WebView articleDataWebView;

    @FXML
    private Label articleTitleLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /*
     * Switch the JavaFX scene
     * */
    @FXML
    private void backToList(ActionEvent event) {
        try {
            SceneChanger.change(event, "news-search-view.fxml", "Search News");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

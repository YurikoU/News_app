package com.example.f21comp1011s1assignment2.Controller;

import com.example.f21comp1011s1assignment2.Models.ApiResponse;
import com.example.f21comp1011s1assignment2.Utilities.ApiUtility;
import com.example.f21comp1011s1assignment2.Models.Article;
import com.example.f21comp1011s1assignment2.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class NewsSearchViewController implements Initializable {

    @FXML
    private Label authorLabel;

    @FXML
    private Label countryLabel;

    @FXML
    private Button exploreButton;

    @FXML
    private Label languageLabel;

    @FXML
    private Label publishedDateLabel;

    @FXML
    private ListView<Article> resultDataListView;

    @FXML
    private Label totalHitsLabel;

    @FXML
    private Label searchTermLabel;

    @FXML
    private TextField searchTermTextField;

    @FXML
    private Label titleLabel;

    @FXML
    private Label topicLabel;

    @FXML
    private Button viewThisArticleButton;

    @FXML
    private Label headerLabel;


    /*
    * Initial settings
    * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Once any article is selected, show the brief description
        resultDataListView.getSelectionModel().selectedItemProperty().addListener(
            (observableValueValue, oldArticle, articleSelected) -> {
                if(articleSelected != null)
                {
                    publishedDateLabel.setText("Published Date: " + articleSelected.getPublishedDate());
                    titleLabel.setText("Title: " + articleSelected.getTitle());
                    authorLabel.setText("Author: " + articleSelected.getAuthor());
                    topicLabel.setText("Topic: " + articleSelected.getTopic());
                    countryLabel.setText("country: " + articleSelected.getCountry());
                    languageLabel.setText("Language: " + articleSelected.getLanguage());
                    setLabelsVisibility(true);
                } else
                {
                    //Unless an article is selected, the labels are still invisible
                    setLabelsVisibility(false);
                }
        });

        //Set the labels as invisible by default
        //setLabelsVisibility(false);

        //Show the number of results
        totalHitsLabel.setText("Total Hits : 0");
    }

    /*
    * Action when the "Explore" button is clicked
    * */
    @FXML
    private void getSearchResult(ActionEvent event)
    {
        //Clear the current list out
        resultDataListView.getItems().clear();

        //Get the API response
        ApiResponse apiResponse = ApiUtility.getArticlesFromApi(searchTermTextField.getText());
        if(apiResponse != null)
        {
            //Once it finds some articles, display them
            resultDataListView.getItems().addAll(apiResponse.getArticles());
        }

        //Set the number of rows
        searchTermLabel.setText("Search Term: \"" + searchTermTextField.getText() + "\"");
        setNumOfTotalHits(apiResponse);
    }


    /*
    * Switch the visibility of the article description
    * */
    public void setLabelsVisibility(boolean visibility)
    {
        publishedDateLabel.setVisible(visibility);
        titleLabel.setVisible(visibility);
        authorLabel.setVisible(visibility);
        topicLabel.setVisible(visibility);
        countryLabel.setVisible(visibility);
        languageLabel.setVisible(visibility);
        viewThisArticleButton.setVisible(visibility);
    }


    /*
     * Set the number of hits
     * */
    public void setNumOfTotalHits(ApiResponse response)
    {
        int numOfTotalHits = response.getTotalHits();
        totalHitsLabel.setText("Total Hits : " + numOfTotalHits);
    }


    /*
    * Switch the JavaFX scene
    * */
    @FXML
    public void viewThisArticle(ActionEvent event)
    {
        try {
            SceneChanger.change(event, "news-details-view.fxml", "The Details of The News");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

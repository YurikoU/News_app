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


public class NewsViewController implements Initializable {

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
    private Button viewArticleButton;

    @FXML
    private Label headerLabel;

    private String searchTerm;

    /*
    * Default settings
    * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.searchTerm = this.searchTermTextField.getText();

        //Once any article is selected, show the brief description
        this.resultDataListView.getSelectionModel().selectedItemProperty().addListener(
            (observableValueValue, oldArticle, articleSelected) -> {
                if(articleSelected != null)
                {
                    this.publishedDateLabel.setText(articleSelected.getPublishedDate());
                    this.titleLabel.setText(articleSelected.getTitle());
                    this.authorLabel.setText(articleSelected.getAuthor());
                    this.topicLabel.setText(articleSelected.getTopic());
                    this.countryLabel.setText(articleSelected.getCountry());
                    this.languageLabel.setText(articleSelected.getLanguage());
                    setLabelsVisibility(true);
                } else
                {
                    //Unless an article is selected, the labels are still invisible
                    setLabelsVisibility(false);
                }
        });
        //Set the labels as invisible by default
        setLabelsVisibility(false);

        //Show the number of results
        setNumOfTotalHits();
    }

    @FXML
    private void getSearchResult(ActionEvent event)
    {
        //Clear the current list out
        this.resultDataListView.getItems().clear();

        //Get the API response
        ApiResponse apiResponse = ApiUtility.getArticlesFromApi(this.searchTerm);
        if(apiResponse != null)
        {
            //Once it finds some articles, display them
            this.resultDataListView.getItems().addAll(apiResponse.getArticles());
        }
    }


    /*
    * Switch the visibility of the article description
    * */
    public void setLabelsVisibility(boolean visibility)
    {
        this.publishedDateLabel.setVisible(visibility);
        this.titleLabel.setVisible(visibility);
        this.authorLabel.setVisible(visibility);
        this.topicLabel.setVisible(visibility);
        this.countryLabel.setVisible(visibility);
        this.languageLabel.setVisible(visibility);
        this.viewArticleButton.setVisible(visibility);
    }


    /*
     * Show the number of hits
     * */
    public void setNumOfTotalHits()
    {
        //Reload the list view obj
        this.resultDataListView.refresh();

        //int numOfTotalHits = this.apiResponse.getTotalHits();

        //Set the number of rows
        //this.totalHitsLabel.setText("Total Hits : " + numOfTotalHits);
    }


    /*
    * Switch the JavaFX scene
    * */
    @FXML
    public void viewArticle(ActionEvent event)
    {
        try {
            SceneChanger.change(event, "news-view.fxml", "Article Details");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

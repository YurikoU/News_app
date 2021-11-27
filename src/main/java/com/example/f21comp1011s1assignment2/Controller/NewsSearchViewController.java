package com.example.f21comp1011s1assignment2.Controller;

import com.example.f21comp1011s1assignment2.Models.ApiResponse;
import com.example.f21comp1011s1assignment2.Utilities.ApiUtility;
import com.example.f21comp1011s1assignment2.Models.Article;
import com.example.f21comp1011s1assignment2.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeSet;


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

    @FXML
    private ComboBox<String> specifyLanguageComboBox;


    /*
     * Initial settings
     * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Once any article is selected, show the brief description
        resultDataListView.getSelectionModel().selectedItemProperty().addListener(
                (observableValueValue, oldArticle, articleSelected) -> {
                    if (articleSelected != null) {
                        publishedDateLabel.setText("Published Date: " + articleSelected.getPublishedDate().substring(0, 10));
                        titleLabel.setText("Title: " + articleSelected.getTitle());
                        authorLabel.setText("Author: " + articleSelected.getAuthor());
                        topicLabel.setText("Topic: " + articleSelected.getTopic());
                        countryLabel.setText("Country: " + articleSelected.getCountry());
                        languageLabel.setText("Language: " + articleSelected.getLanguage());
                        setLabelsVisibility(true);
                        if (articleSelected.getAuthor() == null) {
                            authorLabel.setText("Author: -");
                        }
                    } else {
                        //Unless an article is selected, the labels are still invisible
                        setLabelsVisibility(false);
                    }
                });

        //Set the labels as invisible by default
        setLabelsVisibility(false);

        //Show the number of results
        totalHitsLabel.setText("Total Hits : 0");

        //Configure the combo box
        List<String> validLanguages = Arrays.asList("en", "fr", "es", "de", "hi", "All");
        specifyLanguageComboBox.getItems().addAll(validLanguages);
    }

    /*
     * Action when the "Explore" button is clicked
     * */
    @FXML
    public void getSearchResult(ActionEvent event) {
        //Clear the current list out
        resultDataListView.getItems().clear();
        totalHitsLabel.setText("Total Hits : 0");

        String term = searchTermTextField.getText();
        String lang = specifyLanguageComboBox.getSelectionModel().getSelectedItem();

        //Get the API response
        ApiResponse apiResponse = ApiUtility.getArticlesFromApi(term, lang);
        if (apiResponse != null) {
            //Once it finds some articles, display them
            resultDataListView.getItems().addAll(apiResponse.getArticles());
        }

        //Set the number of rows
        searchTermLabel.setText("Search Term: \"" + searchTermTextField.getText() + "\"");
        setNumOfTotalHits();

        //Clear the text field
        searchTermTextField.clear();
    }

    /*
     * Switch the visibility of the article description
     * */
    public void setLabelsVisibility(boolean visibility) {
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
    public void setNumOfTotalHits()
    {
        int numOfTotalHits = resultDataListView.getItems().size();
        totalHitsLabel.setText("Total Hits : " + numOfTotalHits);
    }


    /*
     * Switch the JavaFX scene
     * */
    public void viewThisArticle(ActionEvent event)
    {
        try {
            SceneChanger.change(event, "news-details-view.fxml", "The Details of The News");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}

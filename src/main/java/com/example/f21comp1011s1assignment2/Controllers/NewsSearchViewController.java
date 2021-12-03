package com.example.f21comp1011s1assignment2.Controllers;

import com.example.f21comp1011s1assignment2.Models.ApiResponse;
import com.example.f21comp1011s1assignment2.Models.Article;
import com.example.f21comp1011s1assignment2.Utilities.ApiUtility;
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
    private Label summaryLabel;

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
                        summaryLabel.setText("Summary: " + articleSelected.getSummary());
                        authorLabel.setText("Author: " + articleSelected.getAuthor());
                        topicLabel.setText("Topic: " + articleSelected.getTopic());
                        countryLabel.setText("Country: " + articleSelected.getCountry());
                        languageLabel.setText("Language: " + articleSelected.getLanguage());
                        if (articleSelected.getAuthor() == null) {
                            authorLabel.setText("Author: -");
                        }
                        setVisibility(true, true);
                    }
                });

        //Set the labels and the list as invisible by default
        setVisibility(false, false);


        //Show the number of results
        totalHitsLabel.setText("Total Hits : 0");

        //Configure the combo box
        List<String> validLanguages = Arrays.asList("en", "fr", "es", "de", "hi", "pa", "ar", "fa", "All");
        specifyLanguageComboBox.getItems().addAll(validLanguages);
    }

    /*
     * Action when the "Explore" button is clicked
     * */
    @FXML
    public void getSearchResult(ActionEvent event) {
        //Clear the current list out
        resultDataListView.getItems().clear();
        setVisibility(false, false);

        String term = searchTermTextField.getText();
        String lang = specifyLanguageComboBox.getSelectionModel().getSelectedItem();

        //Get the API response
        ApiResponse apiResponse = ApiUtility.getArticlesFromApi(term, lang);
        if (apiResponse.getArticles() != null) {
            setVisibility(true, false);
            //Once it finds some articles, display them
            resultDataListView.getItems().addAll(apiResponse.getArticles());
        }

        //Set the number of rows
        searchTermLabel.setText("Search Term: \"" + searchTermTextField.getText() + "\"");
        setNumOfTotalHits(apiResponse);
    }

    /*
     * Switch the visibility
     * */
    @FXML
    public void setVisibility(boolean isNewsFound, boolean isNewsSelected) {
        //Only when it finds articles, the list is shown
        resultDataListView.setVisible(isNewsFound);

        //Only when any article is selected, these are shown
        publishedDateLabel.setVisible(isNewsSelected);
        summaryLabel.setVisible(isNewsSelected);
        authorLabel.setVisible(isNewsSelected);
        topicLabel.setVisible(isNewsSelected);
        countryLabel.setVisible(isNewsSelected);
        languageLabel.setVisible(isNewsSelected);
        viewThisArticleButton.setVisible(isNewsSelected);
    }


    /*
     * Set the number of hits
     * */
    @FXML
    public void setNumOfTotalHits(ApiResponse apiResponse) {
        int numOfTotalHits = apiResponse.getArticles().length;
        totalHitsLabel.setText("Total Hits : " + numOfTotalHits);
    }


    /*
     * Switch the JavaFX scene
     * */
    @FXML
    public void viewThisArticle(ActionEvent event) throws IOException {
        Article articleSelected = resultDataListView.getSelectionModel().getSelectedItem();
        SceneChanger.change(event, "news-details-view.fxml", "The Details of The News", articleSelected);
    }

}

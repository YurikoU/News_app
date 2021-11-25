package com.example.f21comp1011s1assignment2.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NewsViewController implements Initializable {
    @FXML
    private Button exploreButton;

    @FXML
    private Button moreDetailsButton;

    @FXML
    private ListView<?> resultDataListView;

    @FXML
    private Label resultsLabel;

    @FXML
    private TextField searchTermTextField;

    @FXML
    private Label titleLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

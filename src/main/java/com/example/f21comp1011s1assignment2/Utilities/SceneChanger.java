package com.example.f21comp1011s1assignment2.Utilities;

import com.example.f21comp1011s1assignment2.Interface.InitializeArticle;
import com.example.f21comp1011s1assignment2.Main;
import com.example.f21comp1011s1assignment2.Models.Article;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    public static void change(ActionEvent event, String fmxlFileLocation, String sceneTitle, Article article) throws IOException {
        //This fxmlLoader attaches to your fxml file, and in the fxml file, it holds controllers name.
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fmxlFileLocation));
        Scene scene = new Scene(fxmlLoader.load());

        //By creating and using interface, the method can be generic throughout the project
        //Utilize the InitializeMovie interface to call the loadFullArticle() method
        InitializeArticle controller = fxmlLoader.getController();

        //Once you have the controller, you can get loadFullArticle() method and pass in the article obj
        controller.loadFullArticle(article);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(sceneTitle);
        stage.setScene(scene);
        stage.show();
    }

    public static void change(ActionEvent event, String fmxlFileLocation, String sceneTitle) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fmxlFileLocation));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(sceneTitle);
        stage.setScene(scene);
        stage.show();
    }
}

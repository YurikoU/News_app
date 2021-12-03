package com.example.f21comp1011s1assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("news-search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("News Reader");
        stage.setScene(scene);
        stage.getIcons().add(
                new Image(this.getClass().getResourceAsStream("icon.png"))
        );
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
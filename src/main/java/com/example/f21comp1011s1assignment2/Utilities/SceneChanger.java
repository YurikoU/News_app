package com.example.f21comp1011s1assignment2.Utilities;

import com.example.f21comp1011s1assignment2.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    public static void change(ActionEvent event, String fmxlFileLocation, String sceneTitle) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fmxlFileLocation));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(sceneTitle);
        stage.setScene(scene);
        stage.show();
    }
}

module com.example.f21comp1011s1assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.google.gson;
    requires java.net.http; //module for javafx.scene.web.WebView
    requires javafx.web;    //module for HttpClient class

    //Allow you to build the project exporting gson through the project
    opens com.example.f21comp1011s1assignment2 to javafx.fxml, com.google.gson;
    exports com.example.f21comp1011s1assignment2;
}
module com.example.f21comp1011s1assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.f21comp1011s1assignment2 to javafx.fxml;
    exports com.example.f21comp1011s1assignment2;
}
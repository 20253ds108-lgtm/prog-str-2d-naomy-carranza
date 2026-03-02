module com.example.demolistview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.demolistview to javafx.fxml;
    exports com.example.demolistview;
}
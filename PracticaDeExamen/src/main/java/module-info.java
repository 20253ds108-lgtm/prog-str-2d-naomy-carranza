module com.consultorio.practicadeexamen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.consultorio.practicadeexamen to javafx.fxml;
    exports com.consultorio.practicadeexamen;
}
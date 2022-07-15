module com.desktop.simpleapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.desktop.simple_app to javafx.fxml;
    exports com.desktop.simple_app;
}
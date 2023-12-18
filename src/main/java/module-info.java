module com.example.exameninterfaces {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exameninterfaces to javafx.fxml;
    exports com.example.exameninterfaces;
    exports com.example.exameninterfaces.controllers;
    opens com.example.exameninterfaces.controllers to javafx.fxml;
}
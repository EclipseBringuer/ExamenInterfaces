package com.example.exameninterfaces;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Parking CESUR");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Alert makeNewAlert(Alert.AlertType type, String title, String header, String content) {
        Image imagen = new Image(App.class.getResourceAsStream("/img/logo_cesur.png"));
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(150);
        imageView.setFitHeight(100);
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.setGraphic(imageView);
        Stage st = (Stage) alert.getDialogPane().getScene().getWindow();
        st.getIcons().add(imagen);
        return alert;
    }
}
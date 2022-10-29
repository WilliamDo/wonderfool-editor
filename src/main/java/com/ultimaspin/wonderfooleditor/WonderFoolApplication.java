package com.ultimaspin.wonderfooleditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class WonderFoolApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WonderFoolApplication.class.getResource("editor-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("WonderFool Editor");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Are you a fool?");
            alert.setHeaderText("So you agree you are a fool?");
            alert.showAndWait().filter(r -> r != ButtonType.YES).ifPresentOrElse(
                    r -> event.consume(),
                    () -> {
                        Alert alertBye = new Alert(Alert.AlertType.INFORMATION);
                        alertBye.setTitle("Goodbye");
                        alertBye.setHeaderText("Bye bye fool!");
                        alertBye.showAndWait();
                    }
            );
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
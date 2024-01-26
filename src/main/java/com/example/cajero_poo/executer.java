package com.example.cajero_poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class executer extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Image image = new Image("https://creazilla-store.fra1.digitaloceanspaces.com/emojis/47456/atm-sign-emoji-clipart-md.png");

        // Establecer la imagen del ícono para la ventana
        stage.getIcons().add(image);

        FXMLLoader fxmlLoader = new FXMLLoader(executer.class.getResource("login_menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 620);
        stage.setTitle("Cajero Automatico");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
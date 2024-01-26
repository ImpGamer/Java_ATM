package com.example.cajero_poo.switchWindow;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.util.Objects;

public class SceneSwitch {
    public SceneSwitch(AnchorPane currentAnchorPane,String fxml)throws IOException {
        AnchorPane nextAnchorPane = FXMLLoader.load(Objects.requireNonNull(com.example.cajero_poo.executer.class.getResource(fxml)));
        currentAnchorPane.getChildren().removeAll();
        currentAnchorPane.getChildren().setAll(nextAnchorPane);
    }
}
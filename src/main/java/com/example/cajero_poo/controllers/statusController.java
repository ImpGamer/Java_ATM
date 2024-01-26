package com.example.cajero_poo.controllers;

import com.example.cajero_poo.switchWindow.SceneSwitch;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import static com.example.cajero_poo.persistencia.conexionDB.processException;
import java.io.IOException;

public class statusController {
    @FXML
    public AnchorPane statusPain = new AnchorPane();

    public void initialize() {
        statusPain.setFocusTraversable(true);
        statusPain.setOnKeyPressed(this::handleKeyPress);
    }
    protected void handleKeyPress(KeyEvent event) {
        try {
            if (event.getCode() == KeyCode.ENTER) {
                new SceneSwitch(statusPain, "actionsMenu.fxml");
            }
        }catch (IOException e) {
            processException(e);
        }
    }
}

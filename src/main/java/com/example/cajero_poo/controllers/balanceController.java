package com.example.cajero_poo.controllers;

import com.example.cajero_poo.switchWindow.SceneSwitch;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class balanceController {
    @FXML
    public AnchorPane balancePane = new AnchorPane();
    @FXML
    public Label saldo = new Label();
    public void initialize() {
        this.saldo.setText("Saldo Actual: $"+actionsMenuController.usuario.getSaldo());
        this.saldo.setStyle("-fx-font-size: 45;"+"-fx-font-weight: bold;");
        this.saldo.setAlignment(Pos.CENTER);
    }
    @FXML
    public void actionsBack()throws IOException {
        new SceneSwitch(balancePane,"actionsMenu.fxml");
    }
}

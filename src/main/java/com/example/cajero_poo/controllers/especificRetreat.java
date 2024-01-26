package com.example.cajero_poo.controllers;

import com.example.cajero_poo.switchWindow.SceneSwitch;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.IOException;

public class especificRetreat extends especificDeposit{
    private final retreatController retiroController = new retreatController();
    @FXML
    public void retirar()throws IOException {
        double retiro = Double.parseDouble(String.valueOf(especificMont));
        if(retiro <= 100000 && retiro > 0) {
            if(retiroController.confirmedWindow(retiro,"Estas seguro de retirar: $")) {
                if(usuarioCon.retirar(actionsMenuController.usuario,retiro)) {
                    new SceneSwitch(especificPane,"succesTramit.fxml");
                } else {
                    new SceneSwitch(especificPane,"errorTramit.fxml");
                }
            }
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Cantidad no Valido");
            alert.setContentText("El retiro especificado supera el limite de $100,000 o no es superior a $0\nIntentelo de nuevo");
            alert.showAndWait();
        }
    }
}
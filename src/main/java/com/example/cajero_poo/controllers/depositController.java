package com.example.cajero_poo.controllers;
import com.example.cajero_poo.switchWindow.SceneSwitch;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import com.example.cajero_poo.logica.usuarioCon;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import static com.example.cajero_poo.persistencia.conexionDB.processException;
import java.io.IOException;

public class depositController {
    private double deposito;
    @FXML
    public AnchorPane depositPane = new AnchorPane();
    @FXML
    public Label labelSaldo = new Label(),labelAction = new Label();
    protected Alert alert;
    protected usuarioCon usuarioCon = new usuarioCon();

    public void initialize() {
        labelSaldo.setText("Saldo actual: $"+actionsMenuController.usuario.getSaldo());
        labelSaldo.setFont(new Font(20));
        labelSaldo.setStyle("-fx-font-weight: bold");
        this.labelAction.setFont(new Font(14));
        this.labelAction.setTextFill(Color.WHITE);
        this.labelAction.setStyle("-fx-font-weight: bold");
        this.labelAction.setAlignment(Pos.CENTER);
        labelAction.setText("Deposito");
    }
    @FXML
    public void actionsBack()throws IOException {
        new SceneSwitch(depositPane,"actionsMenu.fxml");
    }

    @FXML
    public void sobreBoton(javafx.scene.input.MouseEvent event) {
        ((Button) event.getSource()).setStyle("-fx-background-color: #e1e368");
    }
    @FXML
    public void salirBoton(javafx.scene.input.MouseEvent event) {
        ((Button) event.getSource()).setStyle(
                "-fx-background-color:  #4287f5;" +
                        "-fx-border-color: #b0bccf;" +
                        "-fx-border-width: 1.9;");
    }
    @FXML
    public void valor50() {
        this.deposito = 50;
        realizarDeposito(this.deposito);
    }
    @FXML
    public void valor300() {
        this.deposito = 300;
        realizarDeposito(this.deposito);
    }
    @FXML
    public void valor500() {
        this.deposito = 500;
        realizarDeposito(this.deposito);
    }
    @FXML
    public void valor1000() {
        this.deposito = 1000;
        realizarDeposito(this.deposito);
    }
    @FXML
    public void especificValue()throws IOException {
        if(confirmedWindow("Estas seguro que deseas especificar un valor")) {
            new SceneSwitch(depositPane,"especificDeposit.fxml");
        }
    }
    protected boolean confirmedWindow(double deposito,String mensaje) {
        boolean confirmed = false;

        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText(mensaje+deposito+"?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            confirmed = true;
        }
        return confirmed;
    }
    protected boolean confirmedWindow(String mensaje) {
        boolean confirmed = false;

        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText(mensaje+"?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            confirmed = true;
        }
        return confirmed;
    }
    public void realizarDeposito(double deposito) {
        try {
            if (confirmedWindow(deposito,"Estas seguro que deseas depositar: $")) {
                if (usuarioCon.depositar(actionsMenuController.usuario,deposito)) {
                    new SceneSwitch(depositPane,"succesTramit.fxml");
                } else {
                    new SceneSwitch(depositPane,"errorTramit.fxml");
                }
            }
        } catch (IOException e) {
            processException(e);
        }
    }
}
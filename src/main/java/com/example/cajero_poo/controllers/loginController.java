package com.example.cajero_poo.controllers;

import com.example.cajero_poo.logica.usuarioCon;
import com.example.cajero_poo.logica.usuarios;
import com.example.cajero_poo.switchWindow.SceneSwitch;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;

public class loginController {
    @FXML
    public AnchorPane pantallaLogin = new AnchorPane();
    @FXML
    public Label errorPIN;
    @FXML
    public TextField pantalla = new TextField();
    usuarioCon usuarioCon = new usuarioCon();
    public static usuarios usuario = new usuarios();
    StringBuilder PIN_X = new StringBuilder();
    Alert alert;
    /*
    * Inicio de metodos
     */
    public void initialize() {
        pantalla.setAlignment(Pos.CENTER);
        errorPIN.setTextFill(Color.RED);
        errorPIN.setFont(new Font(16));
        pantalla.setFont(new Font(25));
        pantalla.setStyle("-fx-text-fill: lightblue");
    }
    @FXML
    public void boton0() {
        imprimirPantalla();
        agregarValor("0");
    }
    @FXML
    public void boton1() {
        imprimirPantalla();
        agregarValor("1");
    }
    @FXML
    public void boton2() {
        imprimirPantalla();
        agregarValor("2");
    }
    @FXML
    public void boton3() {
        imprimirPantalla();
        agregarValor("3");
    }
    @FXML
    public void boton4() {
        imprimirPantalla();
        agregarValor("4");
    }
    @FXML
    public void boton5() {
        imprimirPantalla();
        agregarValor("5");
    }
    @FXML
    public void boton6() {
        imprimirPantalla();
        agregarValor("6");
    }
    @FXML
    public void boton7() {
        imprimirPantalla();
        agregarValor("7");
    }
    @FXML
    public void boton8() {
        imprimirPantalla();
        agregarValor("8");
    }
    @FXML
    public void boton9() {
        imprimirPantalla();
        agregarValor("9");
    }
    @FXML
    public void entrar()throws IOException {
        if(usuario.getPIN().length() == 4) {
            if(usuarioCon.validarUsuario(usuario)) {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("PIN Valido");
                alert.setTitle(null);
                alert.showAndWait();
                new SceneSwitch(pantallaLogin,"actionsMenu.fxml");

            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("PIN INVALIDO");
                alert.setContentText("El PIN que introdujo no es valido\nO no se encuentra existente\nVuelva a intentar o consulte a un supervisor");
                alert.showAndWait();
                limpiarPIN();
            }
        } else {
            errorPIN.setText("El PIN no cuenta con los 4 digitos establecidos");
        }
    }

    private void agregarValor(String numero) {
        if(usuario.getPIN().length() < 4) {
            usuario.setPIN(numero);
            System.out.println(usuario.getPIN());
        } else {
            errorPIN.setText("El PIN no puede exceder mas de 4 digitos");
        }
    }
    private void imprimirPantalla() {
        PIN_X.append("X");
        pantalla.setText(String.valueOf(PIN_X));
    }
    @FXML
    public void limpiarPIN() {
        usuario.getPIN().delete(0,usuario.getPIN().length());
        pantalla.setText("");
        PIN_X.delete(0,PIN_X.length());
        errorPIN.setText("");
    }
    @FXML
    public void salir() {
        Platform.exit();
        System.out.println("\u001B[32mGracias por usar :)");
    }
}
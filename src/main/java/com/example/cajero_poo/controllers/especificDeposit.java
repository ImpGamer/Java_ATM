package com.example.cajero_poo.controllers;

import com.example.cajero_poo.logica.usuarioCon;
import com.example.cajero_poo.switchWindow.SceneSwitch;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import static com.example.cajero_poo.persistencia.conexionDB.processException;
import java.io.IOException;
public class especificDeposit {
    private final depositController depositoController = new depositController();
    @FXML
    public AnchorPane especificPane = new AnchorPane();
    @FXML
    public TextField especificField = new TextField();
    protected StringBuilder especificMont = new StringBuilder();
    protected Alert alert;
    protected byte puntosDecimales=0;
    protected usuarioCon usuarioCon = new usuarioCon();

    public void initialize() {
        especificField.setText("$");
        especificField.setFont(new Font(24));
        especificField.setAlignment(Pos.CENTER);
    }

    //Metodos para los botones numericos
    @FXML
    public void boton0() {
        agregarValor('0');
    }

    @FXML
    public void boton1() {
        agregarValor('1');
    }

    @FXML
    public void boton2() {
        agregarValor('2');
    }

    @FXML
    public void boton3() {
        agregarValor('3');
    }

    @FXML
    public void boton4() {
        agregarValor('4');
    }

    @FXML
    public void boton5() {
        agregarValor('5');
    }

    @FXML
    public void boton6() {
        agregarValor('6');
    }

    @FXML
    public void boton7() {
        agregarValor('7');
    }

    @FXML
    public void boton8() {
        agregarValor('8');
    }

    @FXML
    public void boton9() {
        agregarValor('9');
    }

    public void botonPunto() {
        if(puntosDecimales < 1) {
            ++puntosDecimales;
            agregarValor('.');
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setContentText("No se puede ingresar otro punto decimal, pues este ya lo contiene");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }

    //Metodos para botones depositar,limpiar y regresar
    @FXML
    public void limpiar() {
        especificMont.delete(0, especificMont.length());
        especificField.setText("$");
        puntosDecimales=0;
    }

    @FXML
    public void backActions() {
        try {
            if (depositoController.confirmedWindow("Estas seguro que deseas volver al menu")) {
                new SceneSwitch(especificPane, "actionsMenu.fxml");
            }
        } catch (IOException e) {
            System.err.println("Se a producido un error al intentar cambiar de ventana!");
            processException(e);
        }
    }

    protected void agregarValor(char numero) {
            especificMont.append(numero);
            System.out.println(especificMont);
            especificField.setText("$" + especificMont);
    }

    @FXML
    public void depositar()throws IOException {
        double deposito = Double.parseDouble(String.valueOf(especificMont));

        if (deposito <= 100000 && deposito > 0) {
            if(depositoController.confirmedWindow(deposito,"Estas seguro de depositar: $")) {
                if(usuarioCon.depositar(actionsMenuController.usuario,deposito)) {
                    new SceneSwitch(especificPane,"succesTramit.fxml");
                } else {
                    new SceneSwitch(especificPane,"errorTramit.fxml");
                }
            }
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Cantidad no valida");
            alert.setContentText("El deposito especificado supera el limite de $100,000 o no es superior a $0\nIntentelo de nuevo");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }
}
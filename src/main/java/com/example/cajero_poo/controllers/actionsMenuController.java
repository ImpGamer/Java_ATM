package com.example.cajero_poo.controllers;
import com.example.cajero_poo.logica.usuarios;
import com.example.cajero_poo.switchWindow.SceneSwitch;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import static com.example.cajero_poo.persistencia.conexionDB.processException;
import java.io.IOException;
import com.example.cajero_poo.logica.userDates;

public class actionsMenuController {
    public static usuarios usuario = new usuarios(String.valueOf(loginController.usuario.getPIN()));
    userDates getUserDates = new userDates();
    @FXML
    public AnchorPane actionsPane = new AnchorPane();
    @FXML
    public Label saludo = new Label();
    Alert alerta;

    public void initialize() {
        usuario.setUser(getUserDates.darUsuario(loginController.usuario));
        usuario.setId(getUserDates.darID(loginController.usuario));
        usuario.setSaldo(getUserDates.darSaldo(loginController.usuario));
        usuario.setTelefono(getUserDates.darTelefono(loginController.usuario));

        System.out.println(usuario.toString());
        this.saludo.setText("!Bienvenido "+usuario.getUser()+" que operacion realizaras hoy!?");
        aplicarEstiloSaludo();
    }
    @FXML
    public void volverLogin() throws IOException {
        try {
            alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle(null);
            alerta.setContentText("Hasta Luego " + usuario.getUser() + "!\nVuelve pronto");
            alerta.setHeaderText(null);
            alerta.showAndWait();
            new SceneSwitch(actionsPane,"login_menu.fxml");
        } catch (IOException e) {
            processException(e);
            throw new IOException("No se pudo cambiar de ventana\n"+e.getCause());
        }
    }
    @FXML
    public void depositar()throws IOException {
        new SceneSwitch(actionsPane,"depositar.fxml");
    }
    @FXML
    public void retirar()throws IOException {
        new SceneSwitch(actionsPane,"retirar.fxml");
    }
    @FXML
    public void consultarSaldo()throws IOException {
        new SceneSwitch(actionsPane,"saldo.fxml");
    }


    @FXML
    public void sobreBoton(javafx.scene.input.MouseEvent event) {
        ((Button) event.getSource()).setStyle("-fx-background-color: #e1e368");
    }
    @FXML
    public void salirBoton(javafx.scene.input.MouseEvent event) {
        ((Button) event.getSource()).setStyle(
                "-fx-background-color: null;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 1.4;" +
                        "-fx-border-radius: 12;");
    }
    private void aplicarEstiloSaludo() {
        this.saludo.setFont(new Font(20));
        this.saludo.setAlignment(Pos.CENTER);
        this.saludo.setStyle(
                "-fx-border-radius: 15;" +
                        "-fx-border-color: red;" +
                        "-fx-border-width: 2;" +
                        "-fx-font-weight: bold;"
        );
    }


}

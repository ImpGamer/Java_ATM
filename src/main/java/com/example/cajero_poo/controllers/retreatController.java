package com.example.cajero_poo.controllers;
import static com.example.cajero_poo.persistencia.conexionDB.processException;
import com.example.cajero_poo.switchWindow.SceneSwitch;

import java.io.IOException;

public class retreatController extends depositController{
    private double retiro;

   @Override
    public void initialize() {
       super.initialize();
       this.labelAction.setText("Retiro");
   }
   @Override
   public void especificValue()throws IOException {
       if(confirmedWindow("Estas seguro que deseas realizar un retiro especifico")) {
           new SceneSwitch(depositPane,"especificRetreat.fxml");
       }
   }
    @Override
    public void valor50() {
        this.retiro = 50;
        realizarRetiro(this.retiro);
    }
    @Override
    public void valor300() {
        this.retiro = 300;
        realizarRetiro(this.retiro);
    }
    @Override
    public void valor500() {
        this.retiro = 500;
        realizarRetiro(this.retiro);
    }
    @Override
    public void valor1000() {
        this.retiro = 1000;
        realizarRetiro(this.retiro);
    }

    public void realizarRetiro(double retiro) {
      try {
          if(confirmedWindow(retiro,"Estas seguro que deseas retirar: $")) {
              if(usuarioCon.retirar(actionsMenuController.usuario,retiro)) {
                  new SceneSwitch(depositPane,"succesTramit.fxml");
              } else {
                  new SceneSwitch(depositPane,"errorTramit.fxml");
              }
          }
      }catch (IOException e) {
          processException(e);
      }
    }

}

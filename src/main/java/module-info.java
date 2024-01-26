module com.example.cajero_poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.cajero_poo to javafx.fxml;
    exports com.example.cajero_poo;
    exports com.example.cajero_poo.controllers;
    opens com.example.cajero_poo.controllers to javafx.fxml;
}
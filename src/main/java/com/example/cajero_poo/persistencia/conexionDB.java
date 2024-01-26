package com.example.cajero_poo.persistencia;
import java.sql.*;
public class conexionDB {
    private static final String urlDB = ""; //URL base de datos JDBC
    private static final String user = ""; //Usuario que tiene acceso a la BD
    private static final String password = ""; //Contraseña del usuario puesto arriba
    public static Connection getConnection()throws SQLException,ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(urlDB, user, password);
    }
    public static void processException(Exception e) {
        System.err.println("Ha ocurrido un error: "+e.getMessage());
        System.err.println(e.getLocalizedMessage());
        System.err.println(e.getClass());
    }
}
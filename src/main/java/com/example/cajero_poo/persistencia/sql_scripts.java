package com.example.cajero_poo.persistencia;

public interface sql_scripts {
    String validarUsuario = "SELECT COUNT(*) AS validPIN FROM usuarios WHERE PIN=?";
    String actualizarSaldo = "UPDATE usuarios SET saldo=? WHERE user=? AND PIN=?";
    String darUsuario = "SELECT user FROM usuarios WHERE PIN=?";
    String darPIN = "SELECT PIN FROM usuarios WHERE user=?";
    String darSaldo = "SELECT saldo FROM usuarios WHERE PIN=?";
    String darID = "SELECT id FROM usuarios WHERE PIN=?";
    String darTelefono = "SELECT telefono FROM usuarios WHERE PIN=?";
}

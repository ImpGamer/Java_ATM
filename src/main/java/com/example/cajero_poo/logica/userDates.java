package com.example.cajero_poo.logica;
import com.example.cajero_poo.persistencia.sql_scripts;
import static com.example.cajero_poo.persistencia.conexionDB.*;
import java.sql.*;

public class userDates extends usuarioCon{
    public String darUsuario(usuarios usuario) {
        String user = "";
        try {
            this.connection = getConnection();
            this.preparedStatement = this.connection.prepareStatement(sql_scripts.darUsuario);

            this.preparedStatement.setString(1,String.valueOf(usuario.getPIN()));

            this.resultSet = preparedStatement.executeQuery();
            if(this.resultSet.next()) {
                user = this.resultSet.getString("user");
            }

        } catch (SQLException | ClassNotFoundException e) {
            processException(e);
        } finally {
            cerrarSQL();
        }

        return user;
    }
    public String darPIN(usuarios usuario) {
        String PIN = "";
        try {
            this.connection = getConnection();
            this.preparedStatement = this.connection.prepareStatement(sql_scripts.darPIN);

            this.preparedStatement.setString(1,usuario.getUser());

            this.resultSet = this.preparedStatement.executeQuery();
            if(this.resultSet.next()) {
                PIN = this.resultSet.getString("PIN");
            }

        } catch (SQLException | ClassNotFoundException e) {
            processException(e);
        } finally {
            cerrarSQL();
        }
        return PIN;
    }
    public double darSaldo(usuarios usuario) {
        double saldo=0;
        try {
            this.connection = getConnection();
            this.preparedStatement = this.connection.prepareStatement(sql_scripts.darSaldo);

            this.preparedStatement.setString(1,String.valueOf(usuario.getPIN()));
            this.resultSet = this.preparedStatement.executeQuery();
            if(this.resultSet.next()) {
                saldo = this.resultSet.getDouble("saldo");
            }

        } catch (SQLException | ClassNotFoundException e) {
            processException(e);
        } finally {
            cerrarSQL();
        }
        return saldo;
    }
    public int darID(usuarios usuario) {
        int id=-1;
        try {
            this.connection = getConnection();
            this.preparedStatement = this.connection.prepareStatement(sql_scripts.darID);

            this.preparedStatement.setString(1,String.valueOf(usuario.getPIN()));
            this.resultSet= this.preparedStatement.executeQuery();
            if(this.resultSet.next()) {
                id= this.resultSet.getInt("id");
            }

        } catch (SQLException | ClassNotFoundException e ) {
            processException(e);
        } finally {
            cerrarSQL();
        }
        return id;
    }
    public String darTelefono(usuarios usuario) {
        String telefono = "";
        try {
            this.connection = getConnection();
            this.preparedStatement = this.connection.prepareStatement(sql_scripts.darTelefono);

            this.preparedStatement.setString(1,String.valueOf(usuario.getPIN()));
            this.resultSet =this.preparedStatement.executeQuery();
            if (this.resultSet.next()) {
                telefono = this.resultSet.getString("telefono");
            }

        } catch (SQLException | ClassNotFoundException e) {
            processException(e);
        } finally {
            cerrarSQL();
        }
        return telefono;
    }

}
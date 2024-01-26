package com.example.cajero_poo.logica;
import com.example.cajero_poo.persistencia.sql_scripts;
import static com.example.cajero_poo.persistencia.conexionDB.*;
import java.sql.*;
public class usuarioCon {
    protected Connection connection = null;
    protected ResultSet resultSet = null;
    protected PreparedStatement preparedStatement = null;
    public boolean validarUsuario(usuarios usuario) {
        boolean validPIN = false;
        try {
            this.connection = getConnection();
            this.preparedStatement = connection.prepareStatement(sql_scripts.validarUsuario);

            this.preparedStatement.setString(1,String.valueOf(usuario.getPIN()));

            this.resultSet = preparedStatement.executeQuery();
            if(this.resultSet.next()) {
                int result = resultSet.getInt("validPIN");
                if(result == 1) {
                    validPIN = true;
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            processException(e);
        } finally {
            cerrarSQL();
        }
        return validPIN;
    }
    public boolean depositar(usuarios usuario,double deposito) {
        boolean validDeposit = false;
        try {
            this.connection = getConnection();
            usuario.setSaldo(usuario.getSaldo()+deposito);

            this.preparedStatement = this.connection.prepareStatement(sql_scripts.actualizarSaldo);

            this.preparedStatement.setDouble(1,usuario.getSaldo());
            this.preparedStatement.setString(2,usuario.getUser());
            this.preparedStatement.setString(3,String.valueOf(usuario.getPIN()));

            int result = this.preparedStatement.executeUpdate();
            if(result == 1) {
                validDeposit = true;
            }

        }catch (SQLException | ClassNotFoundException e) {
            processException(e);
        } finally {
            cerrarSQL();
        }
        return validDeposit;
    }
    public boolean retirar(usuarios usuario,double retiro) {
        boolean successRetreat = false;
        try {
            boolean retiroPermitido = false;
            this.connection = getConnection();

            if(usuario.getSaldo() >= retiro) {
                retiroPermitido = true;
            }

            if(retiroPermitido) {
                usuario.setSaldo(usuario.getSaldo()-retiro);
                this.preparedStatement = this.connection.prepareStatement(sql_scripts.actualizarSaldo);

                this.preparedStatement.setDouble(1, usuario.getSaldo());
                this.preparedStatement.setString(2, usuario.getUser());
                this.preparedStatement.setString(3, String.valueOf(usuario.getPIN()));

                int result = this.preparedStatement.executeUpdate();
                if (result == 1) {
                    successRetreat = true;
                }
            }
        }catch (SQLException | ClassNotFoundException e) {
            processException(e);
        } finally {
            cerrarSQL();
        }
        return successRetreat;
    }
    
    protected void cerrarSQL() {
        try {
            if(this.connection != null) {
                connection.close();
            }
            if(this.resultSet != null) {
                resultSet.close();
            }
            if(this.preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            processException(e);
        }
    }
}

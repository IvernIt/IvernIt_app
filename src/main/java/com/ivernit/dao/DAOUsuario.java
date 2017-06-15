package com.ivernit.dao;

import com.ivernit.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gautarra
 */
public class DAOUsuario {

    Connection conexion;

    PreparedStatement preparedStatement;
    ResultSet rs;

    public DAOUsuario() {
        this.conexion = Conexion.conectar();
    }

    public void insertUsuario(Usuario usuario) {

        String statement;

        try {

            statement = "insert into usuario "
                    + "'uNombre', 'uContraseña', 'uPremium'"
                    + " values"
                    + " ((?), (?), (?), (?));";

            preparedStatement = conexion.prepareStatement(statement);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getContraseña());
            preparedStatement.setBoolean(3, usuario.isPremium());

        } catch (SQLException ex) {
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario getUsuario(String nombreUsuario) {

        String statement;
        Usuario usuario = new Usuario();

        try {
            statement = "select * from usuario where uNombre = (?)";

            preparedStatement = conexion.prepareStatement(statement);
            preparedStatement.setString(1, nombreUsuario);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                usuario.setId(rs.getInt("uId"));
                usuario.setPremium(rs.getBoolean("uPremium"));
                usuario.setContraseña(rs.getString("uContrasena"));
                usuario.setNombre(rs.getString("uNombre"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    public void updateUsuario(Usuario usuario) {

        String statement;

        try {

            statement = "update usuario set "
                    + "'uNombre' = (?), 'uContrasena' = (?), 'uPremium' = (?)"
                    + " where 'uId' = (?);";

            preparedStatement = conexion.prepareStatement(statement);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getContraseña());
            preparedStatement.setBoolean(3, usuario.isPremium());
            preparedStatement.setInt(4, usuario.getId());

        } catch (SQLException ex) {
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

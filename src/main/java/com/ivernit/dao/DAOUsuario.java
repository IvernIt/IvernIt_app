/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public DAOUsuario(){        
        this.conexion = Conexion.conectar();      
    }
    
    public void insertUsuario(Usuario usuario){
        
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
            
        }catch (SQLException ex){
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Usuario getUsuario(int idUsuario){
        
        String statement;
        Usuario usuario = null;
        
        try {
            
            statement = "select * from usuario"
                + " where uId = (?)"
                + " order by iId;";
            
            preparedStatement = conexion.prepareStatement(statement);
            preparedStatement.setInt(1, idUsuario);   
            
            usuario = new Usuario();
            
            while(rs.next()){
                usuario.setId(rs.getInt("uId"));
                usuario.setContraseña(rs.getString("uContrasena"));
                usuario.setPremium(rs.getBoolean("uPremium"));
                usuario.setNombre(rs.getString("uNombre"));
            }
            
        }catch (SQLException ex){
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }    
    
    public void updateUsuario(Usuario usuario){
        
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
            
        }catch (SQLException ex){
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

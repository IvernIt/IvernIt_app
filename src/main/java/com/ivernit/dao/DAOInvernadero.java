/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.dao;

import com.ivernit.modelo.Invernadero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gautarra
 */
public class DAOInvernadero {

    Connection conexion;
    PreparedStatement preparedStatement;
    ResultSet rs;
    
    ArrayList<Invernadero> listaInvernadero;
    
    /**
     * 
     * @param conexion
     * @param usuario 
     */
    public DAOInvernadero(Connection conexion, String usuario) {
        this.conexion = conexion;        
    }
    
    /**
     * 
     * @param usuario
     * @return 
     */
    public ArrayList<Invernadero> getInvernaderoPorUsr(String usuario){
        String statement;
        Invernadero invernadero;
        
        try {
            statement = "SELECT * from invernadero " +
                "inner join  usuario on invernadero.uId = usuario.uId " +
                "where usuario.uNombre = (?) " +
                "order by invernadero.iId;";
            preparedStatement = conexion.prepareStatement(statement);
            preparedStatement.setString(1, usuario);
            rs = preparedStatement.executeQuery();
            
            listaInvernadero = new ArrayList<>();
            
            while(rs.next()){
                invernadero = new Invernadero(conexion);
                invernadero.setId(rs.getInt("iId"));
                invernadero.setNombre(rs.getString("iNombre"));
                listaInvernadero.add(invernadero);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaInvernadero;       
    }
    
}

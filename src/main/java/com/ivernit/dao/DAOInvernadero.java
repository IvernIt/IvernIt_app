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
    ArrayList<Invernadero> listaInvernadero;
    PreparedStatement preparedStatement;
    ResultSet rs;
    
    
    public DAOInvernadero(Connection conexion) {
        this.conexion = conexion;
    }
    
    public ArrayList<Invernadero> getInvernaderoPorUsr(String usuario){
        
        try {
            preparedStatement = conexion.prepareStatement("select * from invernaderos where usuario = (?)");
            preparedStatement.setString(1, usuario);
            rs = preparedStatement.executeQuery();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;       
    }
    
}

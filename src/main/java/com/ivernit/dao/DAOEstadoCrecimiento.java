/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.dao;

import com.ivernit.modelo.EstadoCrecimiento;
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
public class DAOEstadoCrecimiento {
    
    Connection conexion;
    PreparedStatement preparedStatement;
    ResultSet rs;
    
    /**
     * 
     * @param conexion 
     */
    public DAOEstadoCrecimiento(){
        this.conexion = Conexion.conectar();       
    }
    
    /**
     * 
     * @param idVegetal
     * @return 
     */
    public EstadoCrecimiento getEstadoCrecimientoPorIdVegetal(int idVegetal){
        
        String statement;
        EstadoCrecimiento estadoCrecimiento = null;
        
        try {
            statement = "SELECT * from estadoCrecimiento " +
                "inner join vegetal on estadoCrecimiento.ecId = vegetal.ecId " +
                "where vegetal.vId = (?);";
            
            preparedStatement = conexion.prepareStatement(statement);
            preparedStatement.setInt(1, idVegetal);
            rs = preparedStatement.executeQuery();
                        
            while(rs.next()){
                estadoCrecimiento = new EstadoCrecimiento();
                estadoCrecimiento.setId(rs.getInt("ecId"));
                estadoCrecimiento.setNombre(rs.getString("ecNombre"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return estadoCrecimiento; 
        
    }
    
}

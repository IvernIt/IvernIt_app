/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.dao;

import com.ivernit.modelo.Vegetal;
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
public class DAOVegetal {
    
    Connection conexion;
    ArrayList<Vegetal> listaVegetal;
    PreparedStatement preparedStatement;
    ResultSet rs;
    
    /**
     * 
     */
    public DAOVegetal(){
        this.conexion = Conexion.conectar();      
    }
    
    /**
     * 
     * @param idCultivo
     * @return 
     */
    public ArrayList<Vegetal> getVegetalPorCultivo(int idCultivo){
    String statement;
        Vegetal vegetal;
        
        try {
            statement = "SELECT * from vegetal " +
                "inner join  cultivo on vegetal.vId = cultivo.vId " +
                "where cultivo.cId = (?) " +
                "order by vegetal.vId;";
            
            preparedStatement = conexion.prepareStatement(statement);
            preparedStatement.setInt(1, idCultivo);
            rs = preparedStatement.executeQuery();
            
            listaVegetal = new ArrayList<>();
            
            while(rs.next()){
                vegetal = new Vegetal(rs.getInt("vId"), idCultivo);
                vegetal.setNombre(rs.getString("vNombre"));
               // vegetal.setParametro(rs.getInt("pId")); REVISAR ESTO
                listaVegetal.add(vegetal);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaVegetal;  
    }
    
}

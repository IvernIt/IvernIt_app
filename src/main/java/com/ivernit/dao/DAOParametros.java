/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.dao;

import com.ivernit.modelo.Parametros;
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
public class DAOParametros {
    
    Connection conexion;
    ArrayList<Parametros> listaParametros;
    PreparedStatement preparedStatement;
    ResultSet rs;
    
    /**
     * 
     * @param conexion 
     */
    public DAOParametros(Connection conexion){
        this.conexion = conexion;
    }   
    
    /**
     *
     * @param idCultivo
     * @return
     */
    public ArrayList<Parametros> getParametrosPorCultivo(int idCultivo){
    String statement;
        Parametros parametros;
        
        try {
            statement = "SELECT * from parametro " +
                "inner join  cultivo on parametro.pId = cultivo.pId " +
                "where cultivo.cId = (?) " +
                "order by parametro.pId;";
            
            preparedStatement = conexion.prepareStatement(statement);
            preparedStatement.setInt(1, idCultivo);
            rs = preparedStatement.executeQuery();
            
            listaParametros = new ArrayList<>();
            
            while(rs.next()){
                parametros = new Parametros();
                parametros.setAgua(rs.getDouble("pAgua"));
                parametros.setHorasLuz(rs.getDouble("pHorasLuz"));
                parametros.setId(rs.getInt("pId"));
                parametros.setTemperatura(rs.getDouble("pTemperatura"));
                parametros.setTipoTierra(rs.getString("pTipoTierra"));
                listaParametros.add(parametros);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaParametros;  
    }
    
}

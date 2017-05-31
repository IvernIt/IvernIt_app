/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.dao;

import com.ivernit.modelo.Cultivo;
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
public class DAOCultivo {
    
    Connection conexion;
    ArrayList<Cultivo> listaCultivo;
    PreparedStatement preparedStatement;
    ResultSet rs;

    /**
     *
     * @param conexion
     */
    public DAOCultivo(){        
        this.conexion = Conexion.conectar();        
    }
    
    /**
     *
     * @param invernadero
     * @return
     */
    public ArrayList<Cultivo> getCultivoPorInvernadero(int invernadero){
        String statement;
        Cultivo cultivo;
        
        try {
            statement = "SELECT * from cultivo " +
                "inner join  invernadero on cultivo.iId = invernadero.iId " +
                "where invernadero.iId = (?) " +
                "order by cultivo.iId;";
            preparedStatement = conexion.prepareStatement(statement);
            preparedStatement.setInt(1, invernadero);
            rs = preparedStatement.executeQuery();
            
            System.out.println(statement);
            
            listaCultivo = new ArrayList<>();
            
            while(rs.next()){
                cultivo = new Cultivo(rs.getInt("cId"));
                cultivo.setId(rs.getInt("cId"));
                cultivo.setFechaDeInicio(rs.getDate("cFechaInicio"));
                cultivo.setResultado(rs.getString("cResultado"));
                listaCultivo.add(cultivo);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaCultivo;       
    }
    
}

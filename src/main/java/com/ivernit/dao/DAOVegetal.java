package com.ivernit.dao;

import com.ivernit.modelo.Parametros;
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
        Parametros parametro;
        
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
                listaVegetal.add(vegetal);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaVegetal;  
    }
    
    public void insertVegetal(Vegetal vegetal){
        
        String statement;
        
        try {
            
            statement = "insert into vegetal "
                + "'vNombre'"
                + " values"
                + " ((?));";
            
            preparedStatement = conexion.prepareStatement(statement);
            preparedStatement.setString(1, vegetal.getNombre());
            
        }catch (SQLException ex){
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateVegetal(Vegetal vegetal){
        
        String statement;
        
        try {
            
            statement = "update vegetal set "
                + "'vNombre' = (?)"
                + " where vId = (?)";
            
            preparedStatement = conexion.prepareStatement(statement);
            preparedStatement.setString(1, vegetal.getNombre());
            preparedStatement.setInt(2, vegetal.getId());
            
        }catch (SQLException ex){
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

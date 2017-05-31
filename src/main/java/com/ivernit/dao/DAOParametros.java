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
    public DAOParametros() {
        this.conexion = Conexion.conectar();      
    }

    /**
     *
     * @param idCultivo
     * @return
     */
    public Parametros getParametrosPorCultivo(int idCultivo, int idVegetal) {
        String statement;
        Parametros parametros = null;

//        try {
//            statement = "SELECT * from parametro "
//                    + "inner join  cultivo on parametro.pId = cultivo.pId "
//                    + "where cultivo.cId = (?) "
//                    + "order by parametro.pId;";
//
//            preparedStatement = conexion.prepareStatement(statement);
//            preparedStatement.setInt(1, idCultivo);
//            rs = preparedStatement.executeQuery();
//
//            listaParametros = new ArrayList<>();

          // while (rs.next()) {
                parametros = new Parametros();
                parametros.setAgua(25);
                parametros.setHorasLuz(5);
                parametros.setId(1);
                parametros.setTemperatura(24);
                parametros.setTipoTierra("morosa");
               
           // }

//        } catch (SQLException ex) {
//            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
//        }

        return parametros;
    }

    public ArrayList<Parametros> getParametrosPorInverndero(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

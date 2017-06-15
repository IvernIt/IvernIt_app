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

        try {
    
            statement = "SELECT * from cultivo " + 
                    "inner join parametro on cultivo.pId = parametro.pId " +
                    "inner join vegetal on cultivo.vId = vegetal.vId " +
                    "where vegetal.vId = (?) and cultivo.cId = (?) " +
                    "order by parametro.pId;";
            

            preparedStatement = conexion.prepareStatement(statement);
            preparedStatement.setInt(1, idVegetal);
            preparedStatement.setInt(2, idCultivo);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                parametros = new Parametros();
                parametros.setAgua(rs.getDouble("pAgua"));
                parametros.setHorasLuz(rs.getDouble("pHorasLuz"));
                parametros.setId(rs.getInt("pId"));
                parametros.setTemperatura(rs.getDouble("pTemperatura"));
                parametros.setTipoTierra(rs.getString("pTipoTierra"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }

        return parametros;
    }

    public ArrayList<Parametros> getParametrosPorInverndero(int idInvernadero) {
        
        String statement;
        Parametros parametros = null;

        try {
            statement = "SELECT * from parametro "
                    + "inner join  cultivo on parametro.pId = cultivo.pId "
                    + "where cultivo.iId = (?) "
                    + "order by parametro.pId;";

            preparedStatement = conexion.prepareStatement(statement);
            preparedStatement.setInt(1, idInvernadero);
            rs = preparedStatement.executeQuery();

            listaParametros = new ArrayList<>();

            while (rs.next()) {
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
    
    public void insertParametros(Parametros parametro){
        
        String statement;

        try {
                
            statement = "insert into parametro "
                    + "('pAgua', 'pHorasLuz', 'pTemperatura', 'pTipoTierra'"
                    + "values"
                    + "((?), (?),(?),(?));";

            preparedStatement = conexion.prepareStatement(statement);
            preparedStatement.setDouble(1, parametro.getAgua());
            preparedStatement.setDouble(2, parametro.getHorasLuz());
            preparedStatement.setDouble(3, parametro.getTemperatura());
            preparedStatement.setString(4, parametro.getTipoTierra());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

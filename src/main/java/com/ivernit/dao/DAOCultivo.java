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
     */
    public DAOCultivo() {
        this.conexion = Conexion.conectar();
    }

    /**
     *
     * @param invernadero
     * @return
     */
    public ArrayList<Cultivo> getCultivoPorInvernadero(int invernadero) {
        String statement;
        Cultivo cultivo;

        try {
            statement = "SELECT * from cultivo "
                    + "inner join  invernadero on cultivo.iId = invernadero.iId "
                    + "where invernadero.iId = (?) "
                    + "group by cultivo.cId "
                    + "order by cultivo.iId;";
            preparedStatement = conexion.prepareStatement(statement);
            preparedStatement.setInt(1, invernadero);
            rs = preparedStatement.executeQuery();

            System.out.println(statement);

            listaCultivo = new ArrayList<>();

            while (rs.next()) {
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

    public boolean insetCultivo(Cultivo cultivo, int idInvernadero) {
        String statement;
        Boolean resultado = false;

        try {

            statement = "insert into cultivo "
                    + "('cId', 'vId', 'pId', 'iId', 'cFechaInicio', 'cResultado') "
                    + "values ((?), (?), (?), (?), '(?)', '(?)'";
            for (int i = 0; i < cultivo.getVegetales().size(); i++) {
                preparedStatement = conexion.prepareStatement(statement);
                preparedStatement.setInt(1, cultivo.getId());
                preparedStatement.setInt(2, cultivo.getVegetales().get(i).getId());
                preparedStatement.setInt(3, cultivo.getVegetales().get(i).getParametros().getId());
                preparedStatement.setInt(4, idInvernadero);
                preparedStatement.setDate(5, cultivo.getFechaDeInicio());
                preparedStatement.setString(6, cultivo.getResultado());
                preparedStatement.executeUpdate();
            }
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public boolean updateCultivo(Cultivo cultivo, int idInvernadero) {
        String statement;
        Boolean resultado = false;

        try {

            statement = "update cultivo "
                    + "('cId' = (?), 'vId' = (?), 'pId' = (?), 'iId' = (?), 'cFechaInicio' = (?), 'cResultado' = (?)) "
                    + "where 'cId' = (?) and 'vId' = (?) and 'pId' = (?) and 'iId' = (?)";
            for (int i = 0; i < cultivo.getVegetales().size(); i++) {
                preparedStatement = conexion.prepareStatement(statement);
                preparedStatement.setInt(1, cultivo.getId());
                preparedStatement.setInt(2, cultivo.getVegetales().get(i).getId());
                preparedStatement.setInt(3, cultivo.getVegetales().get(i).getParametros().getId());
                preparedStatement.setInt(4, idInvernadero);
                preparedStatement.setDate(5, cultivo.getFechaDeInicio());
                preparedStatement.setString(6, cultivo.getResultado());
                preparedStatement.executeUpdate();
            }
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvernadero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

}

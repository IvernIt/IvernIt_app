/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gautarra
 */
public class Conexion {

    private static Connection connection;

    public static Connection conectar() {
        String jdbcDriverStr;
        String jdbcURL;

        if (connection == null) {
            jdbcDriverStr = "com.mysql.jdbc.Driver";
            jdbcURL = "jdbc:mysql://sampru.sytes.net/IvernIt?user=ivernit&password=1vern1t";
            try {
                Class.forName(jdbcDriverStr);
                connection = DriverManager.getConnection(jdbcURL);
            } catch (ClassNotFoundException | SQLException ex ) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("conectado");
        }
        return connection;
    }

    public static void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}

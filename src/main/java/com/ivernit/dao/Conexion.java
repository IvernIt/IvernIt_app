/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gautarra
 */
public class Conexion {

    private static Connection connection;
    private static final String FICHERO_PROPIEDADES = "ivernit.properties";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String HOST = "host";
    private static final String DATABASE = "database";
    private static final String USUARIO = "usuario";
    private static final String CONTRASEÑA = "contrasena";

    /**
     *
     * @return
     */
    synchronized public static Connection conectar() {
        String jdbcDriverStr;
        String jdbcURL;

        if (connection == null) {
            try {
                Properties prop = new Properties();
                prop.load(new FileInputStream(FICHERO_PROPIEDADES));
                jdbcDriverStr = DRIVER.toString();
                jdbcURL = prop.getProperty(HOST)
                        + prop.getProperty(DATABASE)
                        + "?user=" + prop.getProperty(USUARIO)
                        + "&password=" + prop.getProperty(CONTRASEÑA);

                Class.forName(jdbcDriverStr);
                connection = DriverManager.getConnection(jdbcURL);
            } catch (ClassNotFoundException | SQLException | IOException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("conectado");
        }
        return connection;
    }

    /**
     * 
     */
    public static void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

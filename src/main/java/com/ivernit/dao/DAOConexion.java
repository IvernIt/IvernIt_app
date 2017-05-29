/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gautarra
 */
public class DAOConexion {
    
    private final String jdbcDriverStr;
    private final String jdbcURL;
    
    private Connection connection;

    public DAOConexion(String jdbcDriverStr, String jdbcURL) {
        this.jdbcDriverStr = jdbcDriverStr;
        this.jdbcURL = jdbcURL;
    }
    
    public Connection conectar() throws Exception{
        
        
        Class.forName(jdbcDriverStr);
        connection = DriverManager.getConnection(jdbcURL);
        System.out.println("conectado");
        
        return connection;
    }

    public void close() {
        try{
            if(connection!=null) connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}

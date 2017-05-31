/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gautarra
 */
public class DAOUsuario {
    
    Connection conexion;
    
    PreparedStatement preparedStatement;
    ResultSet rs;

    public DAOUsuario(){        
        this.conexion = Conexion.conectar();      
    }
    
}

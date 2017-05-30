/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.app;

import com.ivernit.dao.DAOConexion;
import com.ivernit.dao.DAOCultivo;
import com.ivernit.dao.DAOInvernadero;
import com.ivernit.modelo.Cultivo;
import com.ivernit.modelo.Invernadero;
import com.ivernit.vista.MainFrame;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author sampru
 */
public class App {
    
    DAOConexion connecter = new DAOConexion("com.mysql.jdbc.Driver","jdbc:mysql://sampru.sytes.net/IvernIt?user=ivernit&password=1vern1t");
    Connection conexion;
    DAOInvernadero DaoInvernadero;
    DAOCultivo DaoCultivo;
    ArrayList<Invernadero> invernadero;
    

    public App() {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        new MainFrame();
        
        try {
            conexion = connecter.conectar();
            
            DaoInvernadero = new DAOInvernadero(conexion, "pablo");
            invernadero = DaoInvernadero.getInvernaderoPorUsr("pablo");
            
            DaoCultivo = new DAOCultivo(conexion);
            
            System.out.println(invernadero.get(0).getCultivo(1).get(1).getVegetales(1).get(1).getNombre());
            
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void main(String[] args) {
        new App();
    }

}

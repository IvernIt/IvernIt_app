/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.app;

import com.ivernit.vista.mainFrame.MainFrame;
import com.ivernit.dao.Conexion;
import com.ivernit.dao.DAOCultivo;
import com.ivernit.dao.DAOInvernadero;
import com.ivernit.modelo.Invernadero;
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
    public App() {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

        } catch (Exception e) {
            e.printStackTrace();
        }
        new MainFrame();
    }

    public static void main(String[] args) {
        new App();
    }

}

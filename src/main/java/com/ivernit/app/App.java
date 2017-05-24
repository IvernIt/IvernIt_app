/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.app;

import com.ivernit.vista.mainFrame.MainFrame;
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

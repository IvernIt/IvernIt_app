/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class MainFrame extends JFrame{
    private final int xSize = 680;
    private final int ySize = 400;
    private final String title = "IvernIt - Gestion de invernaderos";
    
    public MainFrame(){
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);        
        this.setPreferredSize(new Dimension(xSize, ySize));
        this.setLayout(new AbsoluteLayout());
        this.setResizable(false);
        this.setTitle(title);        
        JPanel login = new PLogin();
        this.setContentPane(login);   
        this.pack();
        this.setVisible(true);
    }
    
    
    
}

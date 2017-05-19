/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
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
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenW = screenSize.getWidth();
        double screenH = screenSize.getHeight();
        Container contentPane;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    
        this.setLocation((int)( screenW/2 - xSize/2),((int)(  screenH/2 - ySize/2)));
        this.setPreferredSize(new Dimension(xSize, ySize));
        this.setResizable(false);
        this.setTitle(title);        
        contentPane = this.getContentPane();   
        contentPane.setLayout(null);
        contentPane.add( new PLogin(xSize, ySize));
        this.pack();
        this.setVisible(true);
    }   
    
}

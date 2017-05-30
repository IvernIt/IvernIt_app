/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista;

import com.ivernit.utils.Strings;
import com.ivernit.vista.gestion.PanelGestion;
import com.ivernit.vista.inicio.PanelLogin;
import com.ivernit.vista.inicio.PanelRegistro;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Pablo
 */
public class MainFrame extends JFrame{
    private static MainFrame mainFrame = null;
    private final int xSize = 1024;
    private final int ySize = 460;
    private MainMenuBar menu ;
    public MainFrame(){
        mainFrame = this;
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
        this.setTitle(Strings.TITULO);        
        menu = new MainMenuBar();
        this.setJMenuBar(menu);
        this.pack();
        contentPane = this.getContentPane();   
        contentPane.setLayout(null);
        contentPane.add( new PanelGestion(contentPane.getWidth(), contentPane.getHeight()));
        this.pack();
        this.setVisible(true);
    }   
    public void mostrarRegistro()
    {
        Container contentPane = this.getContentPane();
        contentPane.removeAll();
        contentPane.add( new PanelRegistro(contentPane.getWidth(), contentPane.getHeight()));
        contentPane.repaint();
    }
    
    public void mostrarGestion()
    {
        Container contentPane = this.getContentPane();
        contentPane.removeAll();
        contentPane.add( new PanelGestion(contentPane.getWidth(), contentPane.getHeight()));
        contentPane.repaint();
    }
    public static MainFrame get()
    {
        return mainFrame;
    }
            
            
}

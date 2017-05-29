/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.inicio;

import com.ivernit.vista.auxiliarControls.NorthBorderPane;
import com.ivernit.utils.Strings;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Pablo
 */
public class PanelRegistro extends JInternalFrame{

     private int xPos = 213;
    private int yPos = 153;
    private final int width = 335;
    private final int height = 300;
    private JTextField tfUsuario;
    private JTextField tfEmail;
    private JPasswordField pfContraseña;
    private JPasswordField pfRepetir;

    
    public PanelRegistro(int parentWidth, int parentHeight) {
        xPos = parentWidth/2 - width/2;
        yPos = parentHeight/2 - height/2;
        initComponents();
    }

    private void initComponents() {
        
        JPanel pPrincipal = new JPanel(new GridLayout(4, 2));
        JPanel pBotones = new JPanel();
        JLabel lbUsuario = new JLabel(Strings.USUARIO);
        JLabel lbEmail = new JLabel(Strings.EMAIL);
        JLabel lbContraseña = new JLabel(Strings.CONTRASENA);
        JLabel lbRepetir = new JLabel(Strings.REPETIR_CONTRASENA);
        JButton bPremium = new JButton(Strings.REGISTRO_PREMIUM);
        JButton bRegistrarse = new JButton(Strings.REGISTRARSE);
        tfUsuario = new JTextField();
        tfEmail = new JTextField();
        pfRepetir = new JPasswordField();
        pfContraseña = new JPasswordField();
        this.setTitle(Strings.REGISTRO);
        this.setFrameIcon(null);
        this.setBounds(xPos, yPos, width, height);
        this.setLayout(new BorderLayout());
        pBotones.add(bRegistrarse);
        pBotones.add(bPremium);
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(30, 20, 10, 20));
        pPrincipal.add(new NorthBorderPane(lbUsuario));
        pPrincipal.add(new NorthBorderPane(tfUsuario));
        pPrincipal.add(new NorthBorderPane(lbEmail));
        pPrincipal.add(new NorthBorderPane(tfEmail));
        pPrincipal.add(new NorthBorderPane(lbContraseña));
        pPrincipal.add(new NorthBorderPane(pfContraseña));
        pPrincipal.add(new NorthBorderPane(lbRepetir));
        pPrincipal.add(new NorthBorderPane(pfRepetir));
        this.add(pPrincipal, BorderLayout.CENTER);
        this.add(pBotones, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public PanelRegistro init(int parentWidth, int parentHeight) {
        xPos = parentWidth/2 - width/2;
        yPos = parentHeight/2 - height/2;
        return this;
    }
}

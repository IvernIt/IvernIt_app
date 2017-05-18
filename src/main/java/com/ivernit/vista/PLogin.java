/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Pablo
 */
public class PLogin extends JPanel {
    private final int xPos = 213;
    private final int yPos = 153;
    private final int xSize = 334;
    private final int ySize = 190;
    private final String sLogin = "Login";
    private final String sUsuario = "Usuario";
    private final String sContraseña = "Contraseña";
    private final String sEntrar = "Entrar";
    private final String sRegistrarse = "Registrarse";
    private JTextField tfUsuario;
    private JPasswordField pfContraseña;
    public PLogin() {
        initComponents();
    }

    private void initComponents() {    
        JPanel pPrincipal = new JPanel(new GridLayout(2,2));
        JPanel pTitulo = new JPanel(new FlowLayout());
        JPanel pBotones = new JPanel();
        JLabel lbLogin = new JLabel(sLogin);
        JLabel lbUsuario = new JLabel(sUsuario);
        JLabel lbContraseña = new JLabel(sContraseña);
        JButton bEntrar = new JButton(sEntrar);
        JButton bRegistrarse = new JButton(sRegistrarse);     
        tfUsuario = new JTextField(sUsuario);
        pfContraseña = new JPasswordField(sContraseña);
        this.setLocation(xPos, yPos);
        this.setPreferredSize(new Dimension(xSize, ySize));
        this.setLayout(new BorderLayout());    
        pTitulo.add(lbLogin);
        pBotones.add(bRegistrarse);
        pBotones.add(bEntrar);
        pPrincipal.add(lbUsuario);
        pPrincipal.add(tfUsuario);
        pPrincipal.add(lbContraseña);
        pPrincipal.add(pfContraseña);
        this.add(pTitulo, BorderLayout.NORTH);
        this.add(pPrincipal, BorderLayout.CENTER);
        this.add(pBotones, BorderLayout.SOUTH);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista;

import com.ivernit.utils.Strings;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Pablo
 */
public class PRegistro extends JPanel{

     private int xPos = 213;
    private int yPos = 153;
    private final int width = 335;
    private final int height = 300;
    private JTextField tfUsuario;
    private JTextField tfEmail;
    private JPasswordField pfContraseña;
    private JPasswordField pfRepetir;

    
    public PRegistro(int parentWidth, int parentHeight) {
        xPos = parentWidth/2 - width/2;
        yPos = parentHeight/2 - height/2;
        initComponents();
    }

    private void initComponents() {
        
        JPanel pPrincipal = new JPanel(new GridLayout(4, 2));
        JPanel pTitulo = new JPanel(new FlowLayout());
        JPanel pBotones = new JPanel();
        JLabel lbRegistro = new JLabel(Strings.REGISTRO);
        JLabel lbUsuario = new JLabel(Strings.USUARIO);
        JLabel lbEmail = new JLabel(Strings.EMAIL);
        JLabel lbContraseña = new JLabel(Strings.CONTRASENA);
        JLabel lbRepetir = new JLabel(Strings.REPETIR_CONTRASENA);
        JButton bEntrar = new JButton(Strings.ENTRAR);
        JButton bRegistrarse = new JButton(Strings.REGISTRARSE);
        tfUsuario = new JTextField();
        tfEmail = new JTextField();
        pfRepetir = new JPasswordField();
        pfContraseña = new JPasswordField();
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.setBounds(xPos, yPos, width, height);
        this.setLayout(new BorderLayout());
        pTitulo.setLayout(new BorderLayout());
        pTitulo.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        pTitulo.add(lbRegistro,BorderLayout.NORTH);
        pBotones.add(bRegistrarse);
        pBotones.add(bEntrar);
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(30, 20, 10, 20));
        pPrincipal.add(new NorthBorderPane(lbUsuario));
        pPrincipal.add(new NorthBorderPane(tfUsuario));
        pPrincipal.add(new NorthBorderPane(lbEmail));
        pPrincipal.add(new NorthBorderPane(tfEmail));
        pPrincipal.add(new NorthBorderPane(lbContraseña));
        pPrincipal.add(new NorthBorderPane(pfContraseña));
        pPrincipal.add(new NorthBorderPane(lbRepetir));
        pPrincipal.add(new NorthBorderPane(pfRepetir));
        this.add(pTitulo, BorderLayout.NORTH);
        this.add(pPrincipal, BorderLayout.CENTER);
        this.add(pBotones, BorderLayout.SOUTH);
    }
}

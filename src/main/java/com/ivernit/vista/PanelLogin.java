/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista;

import com.ivernit.utils.Strings;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Pablo
 */
public class PanelLogin extends JInternalFrame {

    private int xPos = 213;
    private int yPos = 153;
    private final int width = 335;
    private final int height = 190;
    private JTextField tfUsuario;
    private JPasswordField pfContraseña;

    public PanelLogin(int parentWidth, int parentHeight) {
        xPos = parentWidth / 2 - width / 2;
        yPos = parentHeight / 2 - height / 2;
        initComponents();
    }

    private void initComponents() {

        JPanel pPrincipal = new JPanel(new GridLayout(2, 2));
        JPanel pBotones = new JPanel();
        JLabel lbUsuario = new JLabel(Strings.USUARIO);
        JLabel lbContraseña = new JLabel(Strings.CONTRASENA);
        JButton bEntrar = new JButton(Strings.ENTRAR);
        JButton bRegistrarse = new JButton(Strings.REGISTRARSE);
        tfUsuario = new JTextField();
        pfContraseña = new JPasswordField();
        this.setTitle(Strings.LOGIN);
        this.setBounds(xPos, yPos, width, height);
        this.setLayout(new BorderLayout());
        this.setIconifiable(false);
        this.setFrameIcon(null);
        pBotones.add(bRegistrarse);
        pBotones.add(bEntrar);
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(30, 20, 10, 20));
        pPrincipal.add(new NorthBorderPane(lbUsuario));
        pPrincipal.add(new NorthBorderPane(tfUsuario));
        pPrincipal.add(new NorthBorderPane(lbContraseña));
        pPrincipal.add(new NorthBorderPane(pfContraseña));
        
        this.add(pPrincipal, BorderLayout.CENTER);
        this.add(pBotones, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
}

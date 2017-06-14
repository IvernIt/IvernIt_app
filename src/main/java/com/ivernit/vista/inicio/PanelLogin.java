/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.inicio;

import com.ivernit.dao.DAOUsuario;
import com.ivernit.modelo.Usuario;
import com.ivernit.vista.control.IvernitActionListeners;
import com.ivernit.vista.auxiliarControls.NorthBorderPane;
import com.ivernit.utils.Strings;
import com.ivernit.vista.auxiliarControls.ControlButton;
import com.ivernit.vista.auxiliarControls.JPasswordFieldLimit;
import com.ivernit.vista.auxiliarControls.JTextFieldLimit;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class PanelLogin extends JInternalFrame {

    private int xPos = 213;
    private int yPos = 153;
    private final int width = 335;
    private final int height = 190;
    private JTextFieldLimit tfUsuario;
    private JPasswordFieldLimit pfContraseña;

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
        JButton bEntrar = new ControlButton(Strings.ENTRAR, IvernitActionListeners.ENTRAR);
        JButton bRegistrarse = new ControlButton(Strings.REGISTRARSE, IvernitActionListeners.REGISTRO);
        tfUsuario = new JTextFieldLimit();
        tfUsuario.addActionListener(IvernitActionListeners.get());
        tfUsuario.setActionCommand(IvernitActionListeners.ENTRAR);
        pfContraseña = new JPasswordFieldLimit();
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

    public Usuario getUsuario() {
        Usuario usuario;
        usuario = new Usuario(tfUsuario.getText());
        return usuario;
    }

    public PanelLogin init(int parentWidth, int parentHeight) {
        xPos = parentWidth / 2 - width / 2;
        yPos = parentHeight / 2 - height / 2;
        tfUsuario.setText("");
        pfContraseña.setText("");
        setLocation(xPos, yPos);
        return this;
    }

    public void contrasenaIncorrecta() {
        JOptionPane.showConfirmDialog(this, Strings.CONTRASENA_INCORRECTA, Strings.ERROR, JOptionPane.ERROR_MESSAGE, JOptionPane.OK_OPTION);
        this.tfUsuario.setText("");
        this.pfContraseña.setText("");
    }

    public boolean login() {
        boolean logged = true;
        if (logged) {
            DAOUsuario daoUsuario = new DAOUsuario();
            Usuario activo = daoUsuario.getUsuario(tfUsuario.getText());
            Usuario.setUsuarioActivo(activo);
        }
        return logged;
    }
}

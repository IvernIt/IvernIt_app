/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.ayuda;

import com.ivernit.ice.ClienteIce;
import com.ivernit.modelo.Usuario;
import com.ivernit.utils.Strings;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 * Panel en el qué se atenderá al cliente en caso de que necesite asistencia
 *
 * @author Pablo
 */
public class PanelAyuda extends JInternalFrame implements ActionListener{

    private int xPos;
    private int yPos;
    private int Width = 300;
    private int Height = 335;
    ClienteIce cliente;
    JTextField tfEnviar;
    JTextArea mensajes;
    public PanelAyuda(int parentWidth, int parentHeight) {
        xPos = parentWidth / 2 - Width / 2;
        yPos = parentHeight / 2 - Height / 2;
        initComponents();
    }

    private void initComponents() {
        this.setTitle(Strings.SOPORTE);
        this.setBounds(xPos, yPos, Width, Height);
        this.setLayout(new BorderLayout());
        this.setIconifiable(false);
        this.setFrameIcon(null);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        JScrollPane spMensajes = new JScrollPane();
        mensajes = new JTextArea();
        mensajes.setEditable(false);
        spMensajes.setViewportView(mensajes);
        JPanel pEscribir = new JPanel(new BorderLayout());
        JButton bEnviar = new JButton(Strings.Enviar);
        tfEnviar = new JTextField();
        tfEnviar.addActionListener(this);
        bEnviar.addActionListener(this);
        pEscribir.add(tfEnviar, BorderLayout.CENTER);
        pEscribir.add(bEnviar, BorderLayout.EAST);
        contentPane.add(spMensajes, BorderLayout.CENTER);
        contentPane.add(pEscribir, BorderLayout.SOUTH);
        cliente= new ClienteIce(mensajes);
        String[] args = {""};
        cliente.start();
        this.addInternalFrameListener(new InternalFrameAdapter(){
            public void internalFrameClosing(InternalFrameEvent e) {
                cliente.cerrar();
                
            }
        });
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String mensaje = tfEnviar.getText() ;
        String texto = Usuario.getUsuarioActivo().getNombre() +  ": " +  mensaje+ "\n";
        tfEnviar.setText("");
        mensajes.setText(mensajes.getText()+ texto);
        cliente.enviarMensaje(mensaje);
    }
    
}

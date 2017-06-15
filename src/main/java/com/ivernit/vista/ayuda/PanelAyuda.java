/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.ayuda;

import com.ivernit.vista.control.IvernitActionListeners;
import com.ivernit.utils.Strings;
import com.ivernit.vista.auxiliarControls.ControlButton;
import com.ivernit.vista.auxiliarControls.NorthBorderPane;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Panel en el qué se atenderá al cliente en caso de que necesite asistencia
 * @author Pablo
 */
public class PanelAyuda extends JInternalFrame{

    private int xPos;
    private int yPos;
    private int Width;
    private int Height;
    
    public PanelAyuda(int parentWidth, int parentHeight) {
        xPos = parentWidth / 2 - Width / 2;
        yPos = parentHeight / 2 - Height / 2;
        initComponents();
    }

    private void initComponents() {
        Container contentPane = this.getContentPane();
        JPanel pConcepto = new JPanel(new GridLayout(1,2));
        JPanel pMensaje = new JPanel(new GridLayout(1,2));
        ControlButton bEnviar = new ControlButton(Strings.ENVIAR,IvernitActionListeners.ENVIAR_AYUDA);
        JLabel lConcepto = new JLabel(Strings.CONCEPTO);
        JLabel lMensaje = new JLabel(Strings.MENSAJE);
        JTextField tfConcepto = new JTextField();
        JTextArea taMensaje = new JTextArea();
        contentPane.setLayout(new BorderLayout());
        pConcepto.add(new NorthBorderPane(lConcepto));
        pConcepto.add(new NorthBorderPane((tfConcepto)));
        contentPane.add(pConcepto,BorderLayout.NORTH);
        pMensaje.add(new NorthBorderPane(lMensaje));
        pMensaje.add(tfConcepto);
        contentPane.add(pMensaje,BorderLayout.CENTER);
        contentPane.add(bEnviar, BorderLayout.SOUTH);
    }
    
    
}

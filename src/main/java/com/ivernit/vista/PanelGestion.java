/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista;

import com.ivernit.utils.Strings;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Pablo
 */
public class PGestion extends JPanel {

    private int width;
    private int height;
    private DefaultListModel lmInvernderos;

    public PGestion(int parentWidth, int parentHeight) {
        width = parentWidth;
        height = parentHeight;
        initComponents();
    }

    private void initComponents() {

        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.setBounds(0, 0, width, height);
        this.setLayout(new BorderLayout());
        this.add(panelLista(), BorderLayout.WEST);
        this.add(panelGestion(),BorderLayout.CENTER);
    }

    private Component panelLista() {
        JScrollPane pInvernaderos = new JScrollPane();
        lmInvernderos = new DefaultListModel();
        lmInvernderos.addElement("invernadero1");
        lmInvernderos.addElement("invernadero2");
        lmInvernderos.addElement("invernadero3");
        JList lInvernderos = new JList(lmInvernderos);
        lInvernderos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        lInvernderos.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        lInvernderos.setVisibleRowCount(-1);
        pInvernaderos.add(lInvernderos);
        return pInvernaderos;
    }

    private Component panelGestion() {
        JTabbedPane pGesion = new JTabbedPane(JTabbedPane.TOP);
        pGesion.add(Strings.VER, new PanelVer());
        pGesion.add(Strings.MODIFICAR, new PanelModificar());
        pGesion.add(Strings.RESULTADOS, new PanelResultados());
        pGesion.add(Strings.CONTROL_MANUAL, new PanelControl());
        return pGesion;
    }

}

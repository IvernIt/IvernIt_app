/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.gestion;

import com.ivernit.vista.auxiliarControls.EditToolbar;
import com.ivernit.utils.Strings;
import com.ivernit.vista.auxiliarControls.SingleColTableModel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class PanelGestion extends JPanel implements ListSelectionListener {

    private int width;
    private int height;
    private JTable tInvernderos;
    private JTabbedPane pGestion;

    public PanelGestion(int parentWidth, int parentHeight) {
        width = parentWidth;
        height = parentHeight;
        initComponents();
    }

    private void initComponents() {

        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.setBounds(0, 0, width, height);
        this.setLayout(new BorderLayout());
        this.add(panelLista(), BorderLayout.WEST);
        this.add(panelGestion(), BorderLayout.CENTER);
    }

    private Component panelLista() {
        JPanel pInvernaderos = new JPanel();
        pInvernaderos.setLayout(new BorderLayout());
        JScrollPane spLista = new JScrollPane();
        SingleColTableModel tmInvernderos = new SingleColTableModel();
        tmInvernderos.setHeader(Strings.INVERNADEROS);
        tmInvernderos.addElement("invernadero1");
        tmInvernderos.addElement("invernadero2");
        tmInvernderos.addElement("invernadero3");
        tInvernderos = new JTable(tmInvernderos);
        tInvernderos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tInvernderos.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tInvernderos.getSelectionModel().addListSelectionListener(this);
        spLista.setViewportView(tInvernderos);
        spLista.setPreferredSize(new Dimension(width / 5, height));
        pInvernaderos.add(spLista, BorderLayout.CENTER);
        pInvernaderos.add(new EditToolbar(tmInvernderos), BorderLayout.PAGE_START);
        return pInvernaderos;
    }

    private Component panelGestion() {
        pGestion = new JTabbedPane(JTabbedPane.TOP);
        pGestion.add(Strings.VER, new PanelVer());
        pGestion.add(Strings.MODIFICAR, new PanelModificar());
        pGestion.add(Strings.RESULTADOS, new PanelResultados());
        pGestion.add(Strings.CONTROL_MANUAL, new PanelControl());
        return pGestion;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            actualizarPanel(e.getFirstIndex());
        }
    }

    private void actualizarPanel(int firstIndex) {
        switch (pGestion.getSelectedIndex()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            default:
                break;
        }
    }

}

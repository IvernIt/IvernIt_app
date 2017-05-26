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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Pablo
 */
public class PanelGestion extends JPanel implements ListSelectionListener {

    private final int width;
    private final int height;
    private JTable tInvernderos;
    private JTabbedPane pGestion;
    private PanelModificar pModificar;
    private PanelVer pVer;
    private PanelResultados pResultado;
    private PanelControl pControl;

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
        rellenarInvernaderos(tmInvernderos);
        tInvernderos = new JTable(tmInvernderos);
        tInvernderos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tInvernderos.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try {
            tInvernderos.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
        }
        tInvernderos.getSelectionModel().addListSelectionListener(this);
        spLista.setViewportView(tInvernderos);
        spLista.setPreferredSize(new Dimension(width / 5, height));
        pInvernaderos.add(spLista, BorderLayout.CENTER);
        pInvernaderos.add(new EditToolbar(tInvernderos), BorderLayout.PAGE_START);
        return pInvernaderos;
    }

    private Component panelGestion() {
        pGestion = new JTabbedPane(JTabbedPane.TOP);
        pVer = new PanelVer();
        pModificar =  new PanelModificar();
        pResultado = new PanelResultados();
        pControl = new PanelControl();
        pGestion.add(Strings.VER, pVer);
        pGestion.add(Strings.MODIFICAR, pModificar);
        pGestion.add(Strings.RESULTADOS, pResultado);
        pGestion.add(Strings.CONTROL_MANUAL, pControl);
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

    private void rellenarInvernaderos(SingleColTableModel modelo) {
        modelo.addElement("Invernadero1");
        modelo.addElement("Invernadero2");
        modelo.addElement("Invernadero3");
    }

}

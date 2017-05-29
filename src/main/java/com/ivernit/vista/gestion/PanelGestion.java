/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.gestion;

import com.ivernit.modelo.Invernadero;
import com.ivernit.modelo.Usuario;
import com.ivernit.vista.auxiliarControls.EditToolbar;
import com.ivernit.utils.Strings;
import com.ivernit.vista.auxiliarControls.SingleColTableModel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
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

    private int width;
    private int height;
    private JTable tInvernderos;
    private JTabbedPane tpGestion;
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
        tInvernderos = new JTable(tmInvernderos);
        tInvernderos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tInvernderos.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tInvernderos.getSelectionModel().addListSelectionListener(this);
        spLista.setViewportView(tInvernderos);
        spLista.setPreferredSize(new Dimension(135, 0));
        pInvernaderos.add(spLista, BorderLayout.CENTER);
        pInvernaderos.add(new EditToolbar(tInvernderos), BorderLayout.PAGE_START);
        return pInvernaderos;
    }

    private Component panelGestion() {
        tpGestion = new JTabbedPane(JTabbedPane.TOP);
        pVer = new PanelVer();
        pModificar = new PanelModificar();
        pResultado = new PanelResultados();
        pControl = new PanelControl();
        tpGestion.add(Strings.VER, pVer);
        tpGestion.add(Strings.MODIFICAR, pModificar);
        tpGestion.add(Strings.RESULTADOS, pResultado);
        tpGestion.add(Strings.CONTROL_MANUAL, pControl);
        return tpGestion;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            actualizarPanel(e.getFirstIndex());
        }
    }

    private void actualizarPanel(int firstIndex) {
        switch (tpGestion.getSelectedIndex()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            default:
                break;
        }
    }

    private void rellenarInvernaderos(Usuario usuario) {
        SingleColTableModel modelo = (SingleColTableModel) tInvernderos.getModel();
        ArrayList<Invernadero> invernaderos = usuario.getInvernaderos();
        for (Invernadero invernadero : invernaderos) {
            modelo.addElement(invernadero.getNombre());
        }
         try {
            tInvernderos.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
        }
    }

    public PanelGestion init(Usuario usuario, int parentWidth, int parentHeight) {
        width = parentWidth;
        height = parentHeight;
        rellenarInvernaderos(usuario);
        tpGestion.setSelectedIndex(0);
        
        return this;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista;

import com.ivernit.utils.Strings;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class PanelModificar extends JPanel {

    String[] columnNames = {
        Strings.LITROS_METRO,
        Strings.HORAS_LUZ,
        Strings.TEMPERATURA,
        Strings.TIPO_TIERRA};
    Object[][] data = {{
        new Integer(3000),
        new Integer(15),
        "18ºC", "fertil"}};
    private JTable tParametros;
    private JList lVegetales;

    public PanelModificar() {
        this.setLayout(new BorderLayout());
        this.add(crearPanelListaVegetales(),BorderLayout.WEST);
        this.add(crearPanelSeleccion(),BorderLayout.CENTER);
    }

    private JPanel crearPanelSeleccion() {
        JPanel pSeleccion = new JPanel(new GridLayout(2,1));
        pSeleccion.add(crearPanelElegirEstado());
        pSeleccion.add(crearPanelParametros());
        return pSeleccion;
    }

    private JPanel crearPanelParametros() {
        JPanel pParametros = new JPanel(new BorderLayout());
        JScrollPane spParametros = new JScrollPane();
        DefaultTableModel tmParametros = new DefaultTableModel(data, columnNames);
        tParametros = new JTable(tmParametros);
        spParametros.setViewportView(tParametros);
        pParametros.add(spParametros, BorderLayout.CENTER);
        return pParametros;
    }

    private JPanel crearPanelElegirEstado() {
        JPanel pElegirFase = new JPanel(new BorderLayout());
        pElegirFase.add(crearPanelListaEstados(),BorderLayout.WEST);
        pElegirFase.add(crearPanelSeleccion(),BorderLayout.CENTER);
        return pElegirFase;
    }
    private JPanel crearPanelListaVegetales() {
        JPanel pVegetales = new JPanel(new BorderLayout());
        JScrollPane spVegetales = new JScrollPane();
        DefaultListModel lmVegetales = new DefaultListModel();
        lmVegetales.addElement("Tomates 02/012017");
        lmVegetales.addElement("Lechugas 02/012017");
        lmVegetales.addElement("Cebollas 02/012017");
        lVegetales = new JList(lmVegetales);
        spVegetales.setViewportView(lVegetales);
        pVegetales.add(spVegetales,BorderLayout.CENTER);
        pVegetales.add(new EditToolbar(lmVegetales),BorderLayout.PAGE_START);
        return pVegetales;
        
    }

    private JPanel crearPanelListaEstados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private JPanel crearPanelCultivoIdeal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

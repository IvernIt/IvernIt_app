/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.gestion;

import com.ivernit.utils.Strings;
import com.ivernit.vista.auxiliarControls.SingleColTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class PanelResultados extends JPanel implements ListSelectionListener {

    private JTable tVegetales;
    private JTextField tfResultado;
    private JTable tParametros;
    String[] columnNames = {
        Strings.ESTADO,
        Strings.RIEGO,
        Strings.HORAS_LUZ,
        Strings.TEMPERATURA,
        Strings.TIPO_TIERRA};
    Object[][] data = {
        {
            "Germinacion",
            new Integer(3000),
            new Integer(15),
            "18ºC", "fertil"
        },
        {
            "Ahijamiento",
            new Integer(3000),
            new Integer(15),
            "18ºC", "fertil"
        },
        {
            "Gran Crecimiento",
            new Integer(3000),
            new Integer(15),
            "18ºC", "fertil"
        },
        {
            "Maduracion",
            new Integer(3000),
            new Integer(15),
            "18ºC", "fertil"
        }};

    public PanelResultados() {
        this.setLayout(new BorderLayout());
        this.add(crearPanelListaVegetales(), BorderLayout.WEST);
        this.add(crearPanelResultados(), BorderLayout.CENTER);
    }

    private JPanel crearPanelListaVegetales() {
        JPanel pVegetales = new JPanel(new BorderLayout());
        JScrollPane spVegetales = new JScrollPane();
        SingleColTableModel tmVegetales = new SingleColTableModel();
        tmVegetales.setHeader(Strings.VEGETALES);
        tmVegetales.addElement("Tomates 02/012017");
        tmVegetales.addElement("Lechugas 02/012017");
        tmVegetales.addElement("Cebollas 02/012017");
        tVegetales = new JTable(tmVegetales);
        tVegetales.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try {
            tVegetales.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
        }
        tVegetales.getSelectionModel().addListSelectionListener(this);
        spVegetales.setViewportView(tVegetales);
        spVegetales.setPreferredSize(new Dimension(135, 0));
        pVegetales.add(spVegetales, BorderLayout.CENTER);
        return pVegetales;

    }

    private JPanel crearPanelResultados() {
        JPanel pSeleccion = new JPanel(new GridLayout(2, 1));
        pSeleccion.add(crearPanelParametros());
        pSeleccion.add(crearPanelNota());
        return pSeleccion;
    }

    private JPanel crearPanelNota() {
        JPanel pNota = new JPanel(new GridLayout(1, 2));
        pNota.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel lResultado = new JLabel(Strings.RESULTADO + " : ");
        lResultado.setFont(new Font(Font.SANS_SERIF, 0, 31));
        lResultado.setHorizontalAlignment(JLabel.RIGHT);
        tfResultado = new JTextField("A");
        tfResultado.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 72));
        tfResultado.setHorizontalAlignment(JTextField.CENTER);
        pNota.add(lResultado);
        pNota.add(tfResultado);
        return pNota;
    }

    private JPanel crearPanelParametros() {
        JPanel pParametros = new JPanel(new BorderLayout());
        JScrollPane spParametros = new JScrollPane();
        DefaultTableModel tmParametros = new DefaultTableModel(data, columnNames);
        tParametros = new JTable(tmParametros);
        try {
            tParametros.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
        }
        spParametros.setViewportView(tParametros);
        pParametros.add(spParametros, BorderLayout.CENTER);
        return pParametros;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

}

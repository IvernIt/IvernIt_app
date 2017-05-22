/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista;

import com.ivernit.utils.Strings;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class PanelVer extends JPanel {

    DefaultTableModel tmVer;

    public PanelVer() {
        String[] columnNames = {Strings.VEGETAL,
            Strings.ESTADO,
            Strings.LITROS_METRO,
            Strings.HORAS_LUZ,
            Strings.TEMPERATURA,
            Strings.TIPO_TIERRA};
        Object[][] data = {{"Tomates",
            "Germinacion",
            new Integer(3000),
            new Integer(15),
            "18ºC", "fertil"}};
        tmVer = new DefaultTableModel(data, columnNames);
        
        JTable tVer = new JTable(tmVer);
        JScrollPane spTabla = new JScrollPane(tVer);
        this.setLayout(new BorderLayout());
        this.add(spTabla,BorderLayout.CENTER);
    }

}

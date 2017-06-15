/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.auxiliarControls;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Crea un render que tiene dos opciones, deshabilitar filas y seleccionarlas.
 * @author Pablo
 */
public class SimpleTableRender implements TableCellRenderer {

    private ArrayList<Integer> disabledRows;
    private int activa;

    public SimpleTableRender() {
        disabledRows = new ArrayList<>();
        activa = 0;
    }

    public void setActiva(int activa) {
        this.activa = activa;
    }

    public void diableRow(int row) {
        if (!disabledRows.contains(row)) {
            disabledRows.add(row);
        }
    }

    public void enableRow(int row) {
        for (Iterator<Integer> iterator = disabledRows.iterator(); iterator.hasNext();) {
            Integer next = iterator.next();
            if (next.equals(row)) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel celda = new JLabel();
        celda.setOpaque(true);
        celda.setText(String.valueOf(value));        
        if (disabledRows.contains(row)) {
            celda.setEnabled(false);
        } else {
            if (row == activa) {
                Font f = celda.getFont();
                celda.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
            }
            if (isSelected) {
                celda.setBackground(com.jtattoo.plaf.acryl.AcrylLookAndFeel.getSelectionBackgroundColor());
                celda.setForeground(com.jtattoo.plaf.acryl.AcrylLookAndFeel.getSelectionForegroundColor());
            }
            if (hasFocus) {
                celda.setBorder(BorderFactory.createLineBorder(com.jtattoo.plaf.acryl.AcrylLookAndFeel.getFocusCellColor()));
            }
        }

        return celda;
    }

}

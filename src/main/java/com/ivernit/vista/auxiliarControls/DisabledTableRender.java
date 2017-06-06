/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.auxiliarControls;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Pablo
 */
public class DisabledTableRender implements TableCellRenderer {

    ArrayList<Integer> disabledRows;

    public DisabledTableRender() {
        disabledRows = new ArrayList<>();
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
        celda.setText((String) value);
        if (disabledRows.contains(row)) {
            celda.setEnabled(false);
        }
        return celda;
    }

}

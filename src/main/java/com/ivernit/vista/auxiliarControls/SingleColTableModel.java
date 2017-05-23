/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.auxiliarControls;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class SingleColTableModel extends DefaultTableModel {

    public void setHeader(String text) {
        if (this.getColumnCount() <= 0) {
            this.addColumn(text);
        } else {
            String[][] newIdentifiers = {{text}};
            this.setColumnIdentifiers(newIdentifiers);
        }
    }

    public void addElement(String text) {
        String[] rowData = {text};
        if (this.getColumnCount() <= 0) {
            setHeader("");
        }
        this.addRow(rowData);
    }

    public void addElement(String text, int index) {
        String[] rowData = {text};
        this.insertRow(index, rowData);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}

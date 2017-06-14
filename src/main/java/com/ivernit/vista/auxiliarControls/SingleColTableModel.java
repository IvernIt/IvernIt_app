/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.auxiliarControls;

import com.ivernit.modelo.Invernadero;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class SingleColTableModel extends DefaultTableModel {

    private ArrayList<Invernadero> invernaderos = null;

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
        if (invernaderos != null) {
            Invernadero nuevoInv = new Invernadero(text);
            addInv(nuevoInv);
        } else {
            this.addRow(rowData);
        }
    }

    public void addInv(Invernadero inv) {
        String[] rowData = {inv.getNombre()};
        if (this.getColumnCount() <= 0) {
            setHeader("");
        }
        if (invernaderos == null) {
            invernaderos = new ArrayList<>();
        }
        invernaderos.add(inv);
        this.addRow(rowData);
    }

    private void addElementAt(int index, String text) {
        String[] rowData = {text};
        if (this.getColumnCount() <= 0) {
            setHeader("");
        }
        this.insertRow(index, rowData);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public String getElement(int row) {
        String rowData = "";
        try {
            rowData = (String) getValueAt(row, 0);
        } catch (Exception e) {
        }
        return rowData;
    }

    public Invernadero getInv(int row) {
        Invernadero rowData = invernaderos.get(row);
        return rowData;
    }

    void renameElement(int row, String nuevo) {
        if (invernaderos != null) {
            invernaderos.get(row).setNombre(nuevo);
        }
        this.removeRow(row);
        this.addElementAt(row, nuevo);
    }

    void removeElement(int row) {
        if (invernaderos != null) {
            invernaderos.remove(row);
        }
        this.removeRow(row);
    }
}

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
public class NoEditableTableModel extends DefaultTableModel {

    public NoEditableTableModel(Object[][] data, Object[] columnNames) {
        super(data,columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
    
}

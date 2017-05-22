/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.ListModel;

/**
 *
 * @author Pablo
 */
public class EditToolbar extends JToolBar{
    ListModel model;
    EditToolbar(ListModel model) {
        this.model = model;
        initComponents();
    }

    private void initComponents() {
       
        this.setFloatable(false);
        this.setRollover(true);
        JButton bNuevo = new JButton(new ImageIcon("icons/add.png"));
        JButton bEdit = new JButton(new ImageIcon("icons/edit.png"));
        JButton bEliminar = new JButton(new ImageIcon("icons/delete.png"));
        this.add(bNuevo);
        this.add(Box.createHorizontalGlue());
        this.add(bEdit);
        this.add(Box.createHorizontalGlue());
        this.add(bEliminar);
    }
    
}

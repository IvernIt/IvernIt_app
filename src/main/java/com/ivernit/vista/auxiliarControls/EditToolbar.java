/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.auxiliarControls;

import com.ivernit.utils.Strings;
import com.ivernit.vista.mainFrame.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

/**
 *
 * @author Pablo
 */
public class EditToolbar extends JToolBar implements ActionListener {

    private final static String NUEVO = "nuevo";
    private final static String ELIMINAR = "eliminar";
    private final static String EDIT = "edit";
    private final static ImageIcon I_NUEVO = new ImageIcon("icons/add.png");
    private final static ImageIcon I_EDIT = new ImageIcon("icons/edit.png");
    private final static ImageIcon I_DELETE = new ImageIcon("icons/delete.png");
    SingleColTableModel model;
    JTable tabla;

    public EditToolbar(JTable tabla) {
        this.tabla = tabla;
        this.model = (SingleColTableModel) tabla.getModel();
        initComponents();
    }

    private void initComponents() {

        this.setFloatable(false);
        this.setRollover(true);
        JButton bNuevo = new JButton(I_NUEVO);
        bNuevo.addActionListener(this);
        bNuevo.setActionCommand(NUEVO);
        JButton bEdit = new JButton(I_EDIT);
        bEdit.addActionListener(this);
        bEdit.setActionCommand(EDIT);
        JButton bEliminar = new JButton(I_DELETE);
        bEliminar.addActionListener(this);
        bEliminar.setActionCommand(ELIMINAR);
        this.add(bNuevo);
        this.add(Box.createHorizontalGlue());
        this.add(bEdit);
        this.add(Box.createHorizontalGlue());
        this.add(bEliminar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int row;
        String elemento;
        switch (e.getActionCommand()) {
            case NUEVO:
                boolean correcto = false;
                String nuevo;
                do {
                    nuevo = (String)JOptionPane.showInputDialog(MainFrame.get(), Strings.NUEVO_ELEMENTO, Strings.NUEVO, JOptionPane.YES_NO_OPTION,I_NUEVO, null, "");
                    correcto = true;
                } while (correcto == false);
                if (nuevo.isEmpty() == false) {
                    model.addElement(nuevo);
                }
                break;
            case EDIT:
                row = tabla.getSelectedRow();
                elemento = (String) model.getValueAt(row, 0);
                do {
                    nuevo = (String) JOptionPane.showInputDialog(MainFrame.get(), Strings.EDITAR_ELEMENTO + elemento, Strings.EDITAR, JOptionPane.YES_NO_OPTION, I_EDIT, null, "");
                    correcto = true;
                } while (correcto == false);
                if (nuevo.isEmpty() == false) {
                    model.renameElement(row,nuevo);
                }
                break;
            case ELIMINAR:
                row = tabla.getSelectedRow();
                elemento = (String) model.getValueAt(row, 0);
                int ok = JOptionPane.showConfirmDialog(MainFrame.get(), Strings.SEGURO_ELIMINAR + elemento,Strings.ELIMINAR, JOptionPane.OK_CANCEL_OPTION,JOptionPane.OK_CANCEL_OPTION,I_DELETE);
                System.out.println(ok);
                if(ok == JOptionPane.OK_OPTION) {
                    model.removeElement(row);
                }
                break;
            default:
                break;
        }
    }

}

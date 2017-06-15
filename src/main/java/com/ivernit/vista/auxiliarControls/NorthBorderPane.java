/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.auxiliarControls;

import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * Esta clase auxiliar crea un panel que ajusta un elemento en su interior y no 
 * deja que se espanda completamente.
 * @author Pablo
 */
public class NorthBorderPane extends JPanel{
    public NorthBorderPane(JComponent c)
    {
        this.setLayout(new BorderLayout());
        this.add(c,BorderLayout.NORTH);
        
    }
}

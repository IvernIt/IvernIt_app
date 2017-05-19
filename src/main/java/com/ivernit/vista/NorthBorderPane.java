/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista;

import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class AuxPane extends JPanel{
    public AuxPane(JComponent c)
    {
        this.setLayout(new BorderLayout());
        this.add(c,BorderLayout.NORTH);
        
    }
}

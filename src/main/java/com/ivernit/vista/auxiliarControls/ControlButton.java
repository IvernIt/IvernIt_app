/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.auxiliarControls;

import com.ivernit.vista.control.IvernitActionListeners;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Pablo
 */
public class ControlButton extends JButton{

    public ControlButton(String text, String actionCommand) {
        super(text);
        this.addActionListener(IvernitActionListeners.get());
        this.setActionCommand(actionCommand);
    }
        
}

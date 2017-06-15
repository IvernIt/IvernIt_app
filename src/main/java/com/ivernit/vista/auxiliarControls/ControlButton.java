package com.ivernit.vista.auxiliarControls;

import com.ivernit.vista.control.IvernitActionListeners;
import javax.swing.JButton;

/**
 * Esta clase auxiliar relaciona los botones con las acciones que se listan en 
 * la clase IvernitActionListeners.
 * @author Pablo
 */
public class ControlButton extends JButton{

    public ControlButton(String text, String actionCommand) {
        super(text);
        this.addActionListener(IvernitActionListeners.get());
        this.setActionCommand(actionCommand);
    }
        
}

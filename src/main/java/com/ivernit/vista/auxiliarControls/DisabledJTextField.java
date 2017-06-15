package com.ivernit.vista.auxiliarControls;

import javax.swing.JTextField;

/**
 * esta clase auxiliar crea un JTextFiel desavilitado para su edición.
 * @author Pablo
 */
public class DisabledJTextField extends JTextField{

    public DisabledJTextField() {
        this.setEnabled(false);
    }
    public DisabledJTextField(String text) {
        super(text);
        this.setEnabled(false);
    }
    
}

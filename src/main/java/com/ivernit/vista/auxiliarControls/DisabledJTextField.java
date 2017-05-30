/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.auxiliarControls;

import javax.swing.JTextField;

/**
 *
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

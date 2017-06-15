package com.ivernit.ice;

import Ice.Current;
import com.ivernit.utils.Strings;
import javax.swing.JTextArea;
import soporte._ClienteDisp;

public class Cliente extends _ClienteDisp {

    JTextArea textArea;

    public Cliente(JTextArea textArea) {
        this.textArea = textArea;
    }

    /**
     * Espera Recivir un mensaje del asistente
     * @param mensaje
     * @param __current 
     */
    @Override
    public void recivirMensaje(String mensaje, Current __current) {
       textArea.setText(textArea.getText() + Strings.OPERADOR + ": " + mensaje + "\n");
    }

}

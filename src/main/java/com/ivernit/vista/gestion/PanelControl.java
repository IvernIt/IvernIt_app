/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.gestion;

import com.ivernit.IvernitActionListeners;
import com.ivernit.vista.auxiliarControls.ControlButton;
import com.ivernit.utils.Strings;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class PanelControl extends JPanel{
    public PanelControl() {
        this.setLayout(new GridLayout(4,2,20,20));
        this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        this.add(new ControlButton(Strings.INICIAR_RIEGO, IvernitActionListeners.INICIAR_RIEGO));
        this.add(new ControlButton(Strings.PARAR_RIEGO, IvernitActionListeners.PARAR_RIEGO));
        this.add(new ControlButton(Strings.ABRIR_VENTILACIONES, IvernitActionListeners.ABRIR_VENTILACIONES));
        this.add(new ControlButton(Strings.CERRAR_VENTILACIONES, IvernitActionListeners.CERRAR_VENTILACIONES));
        this.add(new ControlButton(Strings.ENCENDER_CALEFACCION, IvernitActionListeners.ENCENDER_CALEFACCION));
        this.add(new ControlButton(Strings.APAGAR_CALEFACCION, IvernitActionListeners.APAGAR_CALEFACCION));
        this.add(new ControlButton(Strings.ENCENDER_LUCES, IvernitActionListeners.ENCENDER_LUCES));
        this.add(new ControlButton(Strings.APAGAR_LUCES, IvernitActionListeners.APAGAR_LUCES));
    }
    
    
}

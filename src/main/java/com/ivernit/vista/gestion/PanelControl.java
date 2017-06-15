package com.ivernit.vista.gestion;

import com.ivernit.modelo.Invernadero;
import com.ivernit.vista.control.IvernitActionListeners;
import com.ivernit.vista.auxiliarControls.ControlButton;
import com.ivernit.utils.Strings;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * En este panel se podrán ejecutar acciones manuales en el invernadero
 * @author Pablo
 */
public class PanelControl extends JPanel{

    private Invernadero invernaderoActivo;
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

    void actualizarDatos(Invernadero inv) {
        this.invernaderoActivo = inv;
    }
    
    
}

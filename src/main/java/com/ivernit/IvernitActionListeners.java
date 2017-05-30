/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit;

import com.ivernit.vista.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pablo
 */
public class IvernitActionListeners implements ActionListener {

    private static IvernitActionListeners listener;
    public final static String ENTRAR = "entrar";
    public final static String REGISTRARSE = "registrarse";
    public final static String REGISTRO = "registro";
    public final static String REGISTRO_PREMIUM = "registroPremium";
    public final static String INICIAR_RIEGO = "iniciarRiego";
    public final static String PARAR_RIEGO = "pararRiego";
    public final static String ABRIR_VENTILACIONES = "abrirVent";
    public final static String CERRAR_VENTILACIONES = "cerrarVent";
    public final static String ENCENDER_CALEFACCION = "encenderCalef";
    public final static String APAGAR_CALEFACCION = "apagarCalef";
    public final static String ENCENDER_LUCES = "encenderLuces";
    public final static String APAGAR_LUCES = "apagarLuces";

    public static IvernitActionListeners get() {
        if (listener == null) {
            listener = new IvernitActionListeners();
        }
        return listener;
    }

    public IvernitActionListeners() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case ENTRAR:
                break;
            case REGISTRO:
                MainFrame.get().mostrarRegistro();
                break;
            case REGISTRARSE:
                break;
            case REGISTRO_PREMIUM:
                break;
            case INICIAR_RIEGO:
                break;
            case PARAR_RIEGO:
                break;
            case ABRIR_VENTILACIONES:
                break;
            case CERRAR_VENTILACIONES:
                break;
            case ENCENDER_CALEFACCION:
                break;
            case APAGAR_CALEFACCION:
                break;
            case ENCENDER_LUCES:
                break;
            case APAGAR_LUCES:
                break;
            default:
                break;
        }

    }

}

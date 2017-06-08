/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.control;

import com.ivernit.modelo.Usuario;
import com.ivernit.vista.mainFrame.MainFrame;
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
    public final static String PEDIR_AYUDA = "pedirAyuda";
    public final static String ENVIAR_AYUDA = "enviarAyuda";
    public final static String MENU_LOGIN = "login";
    public final static String CERRAR_SESION = "cerrarSesion";
    public final static String IMPORTAR_INVERNADERO = "importarInvernadero";
    public final static String VER_INVERNADEROS = "verInvernaderos";
    public final static String PERFIL = "perfil";
    public final static String ACERCA_DE = "acercaDe";
    public final static String SALIR = "salir";

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
        MainFrame mFrame = MainFrame.get();
        switch (e.getActionCommand()) {
            case ENTRAR:
                if(mFrame.doLogin())        
                    mFrame.mostrarGestion();
                else
                    mFrame.resetLogin();
                break;
            case REGISTRO:
                mFrame.mostrarRegistro();
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
            case ENVIAR_AYUDA:
                break;
            case PEDIR_AYUDA:
                mFrame.mostrarAyuda();
                break;
            case MENU_LOGIN:
                mFrame.mostrarLogin();
                break;
            case CERRAR_SESION:
                mFrame.mostrarLogin();
                break;
            case IMPORTAR_INVERNADERO:
                break;
            case VER_INVERNADEROS:
                mFrame.mostrarGestion();
                break;
            case PERFIL:
                break;
            case ACERCA_DE:
                break;
            case SALIR:
                mFrame.dispose();
                break;
            default:
                break;
        }

    }

}

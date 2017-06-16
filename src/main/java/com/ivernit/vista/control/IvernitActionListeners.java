/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.control;

import com.ivernit.cliente.ClienteAgua;
import com.ivernit.cliente.ClienteLuz;
import com.ivernit.cliente.ClienteTemperatura;
import com.ivernit.utils.Strings;
import com.ivernit.vista.ayuda.DialogoAyuda;
import com.ivernit.vista.mainFrame.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

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
  public final static String TEST_FALLO = "testFallo";
  

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
    ClienteAgua ca;
    ClienteLuz cl;
    ClienteTemperatura ct;
    switch (e.getActionCommand()) {
      case ENTRAR:
        MainFrame.get().mostrarGestion();
        break;
      case REGISTRO:
        MainFrame.get().mostrarRegistro();
        break;
      case REGISTRARSE:
        break;
      case REGISTRO_PREMIUM:
        break;
      case INICIAR_RIEGO:
        ca = new ClienteAgua("9");
        ca.putAgua(String.class);
        break;
      case PARAR_RIEGO:
        ca = new ClienteAgua("0");
        ca.putAgua(String.class);
        break;
      case ABRIR_VENTILACIONES:
        ct = new ClienteTemperatura("5");
        ct.putTemperatura(String.class);
        break;
      case CERRAR_VENTILACIONES:
        ct = new ClienteTemperatura("15");
        ct.putTemperatura(String.class);
        break;
      case ENCENDER_CALEFACCION:
        ct = new ClienteTemperatura("25");
        ct.putTemperatura(String.class);
        break;
      case APAGAR_CALEFACCION:
        ct = new ClienteTemperatura("15");
        ct.putTemperatura(String.class);
        break;
      case ENCENDER_LUCES:
        cl = new ClienteLuz("9");
        cl.putLuz(String.class);
        break;
      case APAGAR_LUCES:
        cl = new ClienteLuz("0");
        cl.putLuz(String.class);
        break;
      case ENVIAR_AYUDA:
        break;
      case PEDIR_AYUDA:
        MainFrame.get().mostrarAyuda();
        break;
      case MENU_LOGIN:
        MainFrame.get().mostrarLogin();
        break;
      case CERRAR_SESION:
        MainFrame.get().mostrarLogin();
        break;
      case IMPORTAR_INVERNADERO:
        break;
      case VER_INVERNADEROS:
        MainFrame.get().mostrarGestion();
        break;
      case PERFIL:
        break;
      case ACERCA_DE:
        break;
      case TEST_FALLO:
        DialogoAyuda da = new DialogoAyuda(MainFrame.get(), Strings.TITULO_ERROR);
        da.popUp();
      default:
        break;
    }

  }

}

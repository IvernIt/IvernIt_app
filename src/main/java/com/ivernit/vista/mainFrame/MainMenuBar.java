/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.mainFrame;

import com.ivernit.vista.control.IvernitActionListeners;
import com.ivernit.utils.Strings;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Pablo
 */
public class MainMenuBar extends JMenuBar {

    private JMenuItem miLogin;
    private JMenuItem miRegistrarse;
    private JMenuItem miCerrarSesion;
    private JMenuItem miImportartInv;
    private JMenuItem miVerInvernderos;
    private JMenuItem miVerPerfil;
    private JMenuItem miPedirAsistencia;
    private JMenuItem miAcercaDe;
    private JMenuItem miTestFallo;

    public MainMenuBar() {
        initComponents();
    }

    private void initComponents() {

        miLogin = nuevoItem(Strings.LOGIN, IvernitActionListeners.MENU_LOGIN);
        miRegistrarse = nuevoItem(Strings.REGISTRO, IvernitActionListeners.REGISTRO);
        miCerrarSesion = nuevoItem(Strings.CERRAR_SESION, IvernitActionListeners.CERRAR_SESION);
        JMenu mArchivo = new JMenu(Strings.ARCHIVO);
        JMenu mInvernadero = new JMenu(Strings.INVERNADERO);
        miImportartInv = nuevoItem(Strings.IMPORTAR_INVERNADERO, IvernitActionListeners.IMPORTAR_INVERNADERO);
        miVerInvernderos = nuevoItem(Strings.INVERNADEROS, IvernitActionListeners.VER_INVERNADEROS);
        miVerPerfil = nuevoItem(Strings.PERFIL, IvernitActionListeners.PERFIL);
        JMenu mVer = new JMenu(Strings.VER);
        JMenu mAyuda = new JMenu(Strings.AYUDA);
        miPedirAsistencia = nuevoItem(Strings.PEDIR_ASISTENCIA, IvernitActionListeners.PEDIR_AYUDA);
        miAcercaDe = nuevoItem(Strings.ACERCA_DE, IvernitActionListeners.ACERCA_DE);
        miTestFallo = nuevoItem(Strings.TEST_FALLO, IvernitActionListeners.TEST_FALLO);
        mArchivo.add(miLogin);
        mArchivo.add(miRegistrarse);
        mArchivo.add(miCerrarSesion);
        mInvernadero.add(miImportartInv);
        mVer.add(miVerInvernderos);
        mVer.add(miVerPerfil);
        mAyuda.add(miPedirAsistencia);
        mAyuda.add(miAcercaDe);
        mAyuda.add(miTestFallo);
        this.add(mArchivo);
        this.add(mInvernadero);
        this.add(mVer);
        this.add(mAyuda);

    }

    private JMenuItem nuevoItem(String texto, String actionCommand) {
        JMenuItem item = new JMenuItem(texto);
        item.addActionListener(IvernitActionListeners.get());
        item.setActionCommand(actionCommand);
        return item;
    }

    public void inicioSesion() {
        miLogin.setEnabled(true);
        miRegistrarse.setEnabled(true);
        miCerrarSesion.setEnabled(false);
        miImportartInv.setEnabled(false);
        miVerInvernderos.setEnabled(false);
        miVerPerfil.setEnabled(false);
        miPedirAsistencia.setEnabled(false);
        miAcercaDe.setEnabled(false);
    }
    
    public void sesionIniciada() {
        miLogin.setEnabled(false);
        miRegistrarse.setEnabled(false);
        miCerrarSesion.setEnabled(true);
        miImportartInv.setEnabled(true);
        miVerInvernderos.setEnabled(true);
        miVerPerfil.setEnabled(true);
        miPedirAsistencia.setEnabled(true);
        miAcercaDe.setEnabled(true);
    }

}

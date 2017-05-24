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
public class MainMenuBar extends JMenuBar{
    

    public MainMenuBar() {
        initComponents();
    }

    private void initComponents() {

        JMenuItem miLogin = nuevoItem(Strings.LOGIN, IvernitActionListeners.MENU_LOGIN);
        JMenuItem miRegistrarse = nuevoItem(Strings.REGISTRO,IvernitActionListeners.REGISTRO);
        JMenuItem miCerrarSesion = nuevoItem(Strings.CERRAR_SESION, IvernitActionListeners.CERRAR_SESION);        
        JMenu mArchivo = new JMenu(Strings.ARCHIVO);
        JMenu mInvernadero = new JMenu(Strings.INVERNADERO);
        JMenuItem miImportartInv = nuevoItem(Strings.IMPORTAR_INVERNADERO, IvernitActionListeners.IMPORTAR_INVERNADERO); 
        JMenuItem miVerInvernderos = nuevoItem(Strings.INVERNADEROS, IvernitActionListeners.VER_INVERNADEROS); 
        JMenuItem miVerPerfil = nuevoItem(Strings.PERFIL, IvernitActionListeners.PERFIL);
        JMenu mVer = new JMenu(Strings.VER); 
        JMenu mAyuda = new JMenu(Strings.AYUDA);
        JMenuItem miPedirAsistencia = nuevoItem(Strings.PEDIR_ASISTENCIA, IvernitActionListeners.PEDIR_AYUDA); 
        JMenuItem miAcercaDe = nuevoItem(Strings.ACERCA_DE, IvernitActionListeners.ACERCA_DE); 
        mArchivo.add(miLogin);
        mArchivo.add(miRegistrarse);
        mArchivo.add(miCerrarSesion);
        mInvernadero.add(miImportartInv);
        mVer.add(miVerInvernderos);
        mVer.add(miVerPerfil);
        mAyuda.add(miPedirAsistencia);
        mAyuda.add(miAcercaDe);
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
    
    
    
}

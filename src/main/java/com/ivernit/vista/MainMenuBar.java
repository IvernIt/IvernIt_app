/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista;

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

        JMenuItem miLogin = new JMenuItem(Strings.LOGIN);
        JMenuItem miRegistrarse = new JMenuItem(Strings.REGISTRARSE);
        JMenuItem miCerrarSesion = new JMenuItem(Strings.CERRAR_SESION);        
        JMenu mArchivo = new JMenu(Strings.ARCHIVO);
        JMenu mInvernadero = new JMenu(Strings.INVERNADERO);
        JMenuItem miImportartInv = new JMenuItem(Strings.IMPORTAR_INVERNADERO); 
        JMenuItem miVerInvernderos = new JMenuItem(Strings.INVERNADEROS); 
        JMenuItem miVerPerfil = new JMenuItem(Strings.PERFIL);
        JMenu mVer = new JMenu(Strings.VER); 
        JMenu mAyuda = new JMenu(Strings.AYUDA);
        JMenuItem miPedirAsistencia = new JMenuItem(Strings.PEDIR_ASISTENCIA); 
        JMenuItem miAcercaDe = new JMenuItem(Strings.ACERCA_DE); 
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
    
    
    
}

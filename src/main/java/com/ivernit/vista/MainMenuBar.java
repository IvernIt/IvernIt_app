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

        JMenuItem miLogin = new JMenuItem();
        JMenuItem miRegistrarse = new JMenuItem();
        JMenuItem miCerrarSesion = new JMenuItem();        
        JMenu mArchivo = new JMenu(Strings.ARCHIVO);
        mArchivo.add(miLogin);
        mArchivo.add(miRegistrarse);
        mArchivo.add(miCerrarSesion);
        JMenu mInvernadero = new JMenu(Strings.INVERNADERO);
        JMenu mVer = new JMenu(Strings.VER);
        JMenu mAyuda = new JMenu(Strings.AYUDA);
        this.add(mArchivo);
        this.add(mInvernadero);
        this.add(mVer);
        this.add(mAyuda);    
        
    }
    
    
    
}

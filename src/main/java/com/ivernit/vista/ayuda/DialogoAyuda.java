/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.ayuda;

import com.ivernit.utils.Strings;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sampru
 */
public class DialogoAyuda{
  JFrame main;
  String titulo;
  
  public DialogoAyuda(JFrame main, String titulo) {
    this.main = main;
    this.titulo = titulo;
  }
  
  public void popUp(){
    JOptionPane.showMessageDialog(main, Strings.SOLUCION, titulo, JOptionPane.ERROR_MESSAGE);
  }
}

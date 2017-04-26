/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.app;

import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author sampru
 */
public class App extends JFrame{

  public App(String title) throws HeadlessException {
    super(title);
    this.setSize(new Dimension(720, 480));
    this.setResizable(false);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
  }  
  
  public static void main(String[] args) {
    new App("IvernIt - Gestion de invernaderos");
  }
  
}

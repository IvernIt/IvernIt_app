package com.ivernit.vista.auxiliarControls;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Este es una panel que contiene una imagen.
 * @author Pablo
 */
public class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel(String src) {
       super(new BorderLayout());
       try {                
          image = ImageIO.read(new File(src));
       } catch (IOException ex) {}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);   
        g.drawImage(image, 0, 0, this);         
    }

}

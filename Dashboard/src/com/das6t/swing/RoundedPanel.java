/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.das6t.swing;

/**
 *
 * @author Daniel Aldana(DaS6T)
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class RoundedPanel extends JPanel {
    
    public RoundedPanel() {
        this.setOpaque(false);
    }
    
    @Override
    public void paint(Graphics graphs) {
        Graphics2D g2 = (Graphics2D) graphs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(this.getBackground());
        g2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 15, 15);
        g2.dispose();
        super.paint(graphs);
    }
    
}

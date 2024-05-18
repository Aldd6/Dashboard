package com.das6t.swing;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Rectangle2D;

public class SemiRoundedPanel extends JPanel{
    public SemiRoundedPanel() {
        this.setOpaque(false);
        this.setBackground(new Color(61,61,61));
    }
    
    @Override
    public void paint(Graphics graphs) {
        Graphics2D g2 = (Graphics2D) graphs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(this.getBackground());
        Area a = new Area(new RoundRectangle2D.Double(0,0,this.getWidth(),this.getHeight(),15,15));
        a.add(new Area(new Rectangle2D.Double(0,20,this.getWidth(),this.getHeight())));
        g2.fill(a);
        g2.dispose();
        super.paint(graphs);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.das6t.swing;

/**
 *
 * @author Daniel Aldana(DaS6T)
 */

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class ButtonMenu extends JButton {

    Font robotoPlain = new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13);
    
    /**
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public ButtonMenu() {
        this.setContentAreaFilled(false);
        this.setBorder(new EmptyBorder(8,10,8,10));
        this.setHorizontalAlignment(LEFT);
        this.setBackground(new Color(71,71,71));
        this.setForeground(new Color(153,153,153));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setFont(robotoPlain);
        this.setFocusPainted(false);
    }
    
    public int radius = 10;
    
    @Override
    public void paintComponent(Graphics graphs) {
        int width = this.getWidth();
        int height = this.getHeight();
        Graphics2D g2 = (Graphics2D)graphs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(this.getBackground());
        g2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), getRadius(), getRadius());
        g2.setColor(this.getBackground());
        g2.fillRoundRect(2, 2, this.getWidth() - 4, this.getHeight() - 4, getRadius(), getRadius());
        super.paintComponent(graphs);
    }
    
    @Override
    public void paint(Graphics graphs){
        super.paint(graphs);
    }
}


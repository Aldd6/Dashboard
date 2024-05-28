/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import com.das6t.swing.ButtonHeaderMenu;
import com.das6t.event.EventMenu;
import java.util.ArrayList;
import servicios.Observador;
import servicios.ReservacionServicio;

/**
 *
 * @author Daniel Aldana(DaS6T)
 */
public class ReservacionesVista extends javax.swing.JPanel {

    private ArrayList<ButtonHeaderMenu> buttons = new ArrayList<>();

    public ReservacionesVista() {
        initComponents();
        this.setOpaque(false);

        ReservacionesVista_Reservaciones reservaciones = new ReservacionesVista_Reservaciones(this);
        jDesktopPane.add(reservaciones);
        reservaciones.setVisible(true);
        Observador.initObservador(reservaciones);

        buttons.add(new ButtonHeaderMenu("Reservaciones"));

        EventMenu evt = new EventMenu() {
            @Override
            public void selected(int index) {
                switch (index) {
                    case 0:
                        abrirReservacion();
                        break;
                    case 1:
                        break;
                }
            }
        };
        headerMenu.initHeaderMenu(evt, buttons);
        headerMenu.setViewName("Reservaciones"); //escriba aqui el nombre de la vista por favor
    }

    public void abrirReservacion() {
        ReservacionesVista_Reservaciones reservaciones = new ReservacionesVista_Reservaciones(this);
        jDesktopPane.add(reservaciones);
        reservaciones.setVisible(true);
        Observador.initObservador(reservaciones);
    }

    public void crearReservacion() {
        ReservacionesVista_Crear crear = new ReservacionesVista_Crear(this);
        jDesktopPane.add(crear);
        crear.setVisible(true);
        Observador.initObservador(crear);

    }

    public void editarReservacion(int id) {
        ReservacionesVista_Editar editar = new ReservacionesVista_Editar(this, id);
        jDesktopPane.add(editar);
        editar.setVisible(true);
        Observador.initObservador(editar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedPanel1 = new com.das6t.swing.RoundedPanel();
        headerMenu = new com.das6t.component.HeaderMenu();
        jDesktopPane = new javax.swing.JDesktopPane();

        setMaximumSize(new java.awt.Dimension(936, 690));
        setMinimumSize(new java.awt.Dimension(936, 690));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(936, 690));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel1.setBackground(new java.awt.Color(45, 42, 46));
        roundedPanel1.setMaximumSize(new java.awt.Dimension(936, 690));
        roundedPanel1.setMinimumSize(new java.awt.Dimension(936, 690));
        roundedPanel1.setPreferredSize(new java.awt.Dimension(936, 690));

        jDesktopPane.setOpaque(false);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addComponent(headerMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jDesktopPane)
                .addContainerGap())
        );

        add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 690));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.das6t.component.HeaderMenu headerMenu;
    private javax.swing.JDesktopPane jDesktopPane;
    private com.das6t.swing.RoundedPanel roundedPanel1;
    // End of variables declaration//GEN-END:variables
}

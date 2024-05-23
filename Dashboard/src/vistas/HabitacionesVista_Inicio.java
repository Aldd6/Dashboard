/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import java.text.NumberFormat;
import javax.swing.table.DefaultTableModel;
import servicios.HabitacionServicio;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Salvador Hernández
 */
public class HabitacionesVista_Inicio extends javax.swing.JInternalFrame {

    private HabitacionesVista habitacionesVista;

    DefaultTableModel modeloTabla;

    public HabitacionesVista_Inicio(HabitacionesVista habitacionesVista) {
        initComponents();
        this.habitacionesVista = habitacionesVista;

        modeloTabla = new DefaultTableModel(new String[]{"No. Habitación", "Tipo de Habitación", "Detalle Habitación", "Precio Habitación", "Estado de Habitación"}, 0);
        jTableDatos.setModel(modeloTabla);
        llenarTabla();

    }

    private void llenarTabla() {
        modeloTabla.setRowCount(0);

        try {
            HabitacionServicio habitacionServicio = new HabitacionServicio();
            List<HabitacionServicio> habitaciones = habitacionServicio.obtenerTodasLasHabitaciones();

            NumberFormat quetzales = NumberFormat.getCurrencyInstance(new Locale("es", "GT"));

            for (HabitacionServicio habitacion : habitaciones) {
                String precioFormateado = quetzales.format(habitacion.getPrecioHabitacion());

                modeloTabla.addRow(new Object[]{
                    habitacion.getNumHabitacion(),
                    habitacion.getTipo(),
                    habitacion.getDetalleHabitacion(),
                    precioFormateado,
                    habitacion.getDetalleEstado()
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();

        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(919, 629));
        setMinimumSize(new java.awt.Dimension(919, 629));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(919, 629));

        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableDatos.setOpaque(false);
        jTableDatos.setShowGrid(false);
        jTableDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDatosMouseClicked
        int filaSeleccionada = jTableDatos.getSelectedRow();

        if (filaSeleccionada != -1) {
            String noHabitacion = jTableDatos.getValueAt(filaSeleccionada, 0).toString();
            String tipoHabitacion = jTableDatos.getValueAt(filaSeleccionada, 1).toString();
            String estadoHabitacion = jTableDatos.getValueAt(filaSeleccionada, 4).toString();

            //habitacionesVista.abrirEditar();
            //habitacionesVista.abrirEditar(this, noHabitacion, tipoHabitacion, estadoHabitacion);
            habitacionesVista.abrirEditar(noHabitacion, tipoHabitacion, estadoHabitacion);
        }
    }//GEN-LAST:event_jTableDatosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDatos;
    // End of variables declaration//GEN-END:variables
}

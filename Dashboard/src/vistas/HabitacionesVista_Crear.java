/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import java.util.List;
import javax.swing.JOptionPane;
import servicios.TipoHabitacionServicio;
import servicios.EstadoHabitacionServicio;
import servicios.HabitacionServicio;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Salvador Hernández
 */
public class HabitacionesVista_Crear extends javax.swing.JInternalFrame {

    /**
     * Creates new form HabitacionesVista_Crear
     */
    public HabitacionesVista_Crear() {
        initComponents();

        try {
            List<TipoHabitacionServicio> tiposHabitaciones = TipoHabitacionServicio.visualizarTipo();

            selectTipoHabitacion.removeAllItems();
            selectTipoHabitacion.addItem("Selecciona un tipo de habitación");

            for (TipoHabitacionServicio habitacion : tiposHabitaciones) {
                selectTipoHabitacion.addItem(habitacion.getTipoHab());
                System.out.println(habitacion.getTipoHab());
            }

        } catch (SQLException | NamingException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener los tipos de habitaciones.");
        }

        try {
            List<EstadoHabitacionServicio> estadoHabitaciones = EstadoHabitacionServicio.obtenerTodosLosEstados();

            selectEstadoDeHabitacion.removeAllItems();
            selectEstadoDeHabitacion.addItem("Selecciona un estado de habitación");

            for (EstadoHabitacionServicio estadoHabitacion : estadoHabitaciones) {
                selectEstadoDeHabitacion.addItem(estadoHabitacion.getDetalle_estado());
                System.out.println(estadoHabitacion.getDetalle_estado());
            }

        } catch (SQLException | NamingException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener los estados de habitaciones.");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        selectTipoHabitacion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        selectEstadoDeHabitacion = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(916, 629));
        setMinimumSize(new java.awt.Dimension(916, 629));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Nueva Habitación");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Tipo de Habitación");

        selectTipoHabitacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Estado de Habitación");

        selectEstadoDeHabitacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnGuardar)
                            .addGap(18, 18, 18)
                            .addComponent(btnCancelar))
                        .addComponent(selectEstadoDeHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectEstadoDeHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(350, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            int iTipoHabi = selectTipoHabitacion.getSelectedIndex();
            int iEstaHabi = selectEstadoDeHabitacion.getSelectedIndex();

            if (iTipoHabi == 0) {
                JOptionPane.showMessageDialog(this, "Selecciona un Tipo de Habitacion.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (iEstaHabi == 0) {
                JOptionPane.showMessageDialog(this, "Selecciona un Estado de Habitacion.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (HabitacionServicio.crearHabitacion(iTipoHabi, iEstaHabi)) {

                JOptionPane.showMessageDialog(this, "Habitacion creada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "No fue posible crear la habitación, consulta con tu administrador de sistemas", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error, muesta este mensaje a tu administrador de sistemas: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> selectEstadoDeHabitacion;
    private javax.swing.JComboBox<String> selectTipoHabitacion;
    // End of variables declaration//GEN-END:variables
}

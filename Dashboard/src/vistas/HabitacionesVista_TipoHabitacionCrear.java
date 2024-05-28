/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import javax.swing.JOptionPane;
import servicios.TipoHabitacionServicio;


/**
 *
 * @author Salvador Hernández
 */
public class HabitacionesVista_TipoHabitacionCrear extends javax.swing.JInternalFrame {

    private HabitacionesVista habitacionesVista;

    public HabitacionesVista_TipoHabitacionCrear(HabitacionesVista habitacionesVista) {
        initComponents();

        this.habitacionesVista = habitacionesVista;

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
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtTipoHab = new javax.swing.JTextField();
        txtPrecioHab = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalleHab = new javax.swing.JTextArea();

        setMaximumSize(new java.awt.Dimension(916, 629));
        setMinimumSize(new java.awt.Dimension(916, 629));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Nuevo Tipo de Habitación");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Tipo de Habitación");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Precio de Habitación");

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtTipoHab.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTipoHab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoHabKeyTyped(evt);
            }
        });

        txtPrecioHab.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrecioHab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioHabKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Detalle de Habitación");

        txtDetalleHab.setColumns(20);
        txtDetalleHab.setLineWrap(true);
        txtDetalleHab.setRows(5);
        jScrollPane1.setViewportView(txtDetalleHab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioHab, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoHab, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(132, 132, 132)
                            .addComponent(btnGuardar)
                            .addGap(18, 18, 18)
                            .addComponent(btnCancelar))))
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
                .addComponent(txtTipoHab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecioHab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {

            String tipoHab = txtTipoHab.getText();
            String detalleHab = txtDetalleHab.getText();
            String precioHab = txtPrecioHab.getText();

            if (tipoHab.isEmpty() || detalleHab.isEmpty() || precioHab.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);

                return;
            }
            
            double dPrecioHab = Double.parseDouble(precioHab);

            if (TipoHabitacionServicio.crearTipo(tipoHab, detalleHab, dPrecioHab)) {

                JOptionPane.showMessageDialog(this, "Tipo de Habitación creada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                habitacionesVista.abrirTipoHabitacion();

            } else {
                JOptionPane.showMessageDialog(this, "No fue posible crear el Tipo de Habitación, consulta con tu administrador de sistemas", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error, muesta este mensaje a tu administrador de sistemas: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        habitacionesVista.abrirTipoHabitacion();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtTipoHabKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoHabKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isLetter(c) && c != ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_txtTipoHabKeyTyped

    private void txtPrecioHabKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioHabKeyTyped
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9') && (c != '.' || txtPrecioHab.getText().contains("."))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioHabKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea txtDetalleHab;
    private javax.swing.JTextField txtPrecioHab;
    private javax.swing.JTextField txtTipoHab;
    // End of variables declaration//GEN-END:variables
}

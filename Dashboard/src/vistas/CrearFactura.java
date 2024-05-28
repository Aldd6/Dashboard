/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Font;
import com.das6t.component.BuscadorCliente;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import raven.datetime.component.date.DatePicker;
import javax.swing.JOptionPane;
import servicios.Factura;

/**
 *
 * @author Daniel Aldana(DaS6T)
 */
public class CrearFactura extends javax.swing.JInternalFrame {

    Font robotoPlain = new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13);
    Font robotoBold = new Font(FlatRobotoFont.FAMILY, Font.BOLD, 18);
    DatePicker dt = new DatePicker();
    Factura temp;
    private FacturasVista facturasVista;
    private long noDocBuscado;
    
    public CrearFactura(FacturasVista facturasVista) {
        initComponents();
        this.facturasVista = facturasVista;
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
        txtDoc = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblIdReservacion = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        lblTotalPagar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(916, 629));
        setMinimumSize(new java.awt.Dimension(916, 629));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel1.setFont(robotoBold);
        jLabel1.setText("Nueva Factura");

        jLabel2.setFont(robotoPlain);
        jLabel2.setText("No. Documuento de indetificación");

        txtDoc.setPreferredSize(new java.awt.Dimension(68, 30));
        txtDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocActionPerformed(evt);
            }
        });

        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.setPreferredSize(new java.awt.Dimension(109, 30));
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jLabel3.setFont(robotoPlain);
        jLabel3.setText("Fecha");

        txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        txtFecha.setMaximumSize(new java.awt.Dimension(130, 30));
        txtFecha.setMinimumSize(new java.awt.Dimension(130, 30));
        txtFecha.setPreferredSize(new java.awt.Dimension(130, 30));

        jLabel4.setFont(robotoPlain);
        jLabel4.setText("Nombre");

        txtApellido.setMaximumSize(new java.awt.Dimension(68, 30));
        txtApellido.setMinimumSize(new java.awt.Dimension(68, 30));
        txtApellido.setPreferredSize(new java.awt.Dimension(68, 30));

        jLabel5.setFont(robotoPlain);
        jLabel5.setText("Apellido");

        txtDireccion.setMaximumSize(new java.awt.Dimension(68, 30));
        txtDireccion.setMinimumSize(new java.awt.Dimension(68, 30));
        txtDireccion.setPreferredSize(new java.awt.Dimension(68, 30));

        jLabel6.setFont(robotoPlain);
        jLabel6.setText("Dirección");

        txtNombre.setMaximumSize(new java.awt.Dimension(68, 30));
        txtNombre.setMinimumSize(new java.awt.Dimension(68, 30));
        txtNombre.setPreferredSize(new java.awt.Dimension(68, 30));

        jLabel7.setFont(robotoPlain);
        jLabel7.setText("Reservación");

        lblIdReservacion.setFont(robotoPlain);

        jLabel8.setFont(robotoPlain);
        jLabel8.setText("Detalle");

        txtDetalle.setColumns(20);
        txtDetalle.setRows(5);
        jScrollPane1.setViewportView(txtDetalle);

        jLabel9.setFont(robotoPlain);
        jLabel9.setText("Total a pagar");

        lblTotalPagar.setFont(robotoBold);
        lblTotalPagar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(lblTotalPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnCancelar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnGuardar))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(171, 171, 171))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(lblIdReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lblIdReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar))
                        .addGap(70, 70, 70))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        BuscadorCliente bsc = new BuscadorCliente((JFrame)SwingUtilities.getWindowAncestor(this),true);
        bsc.setLocationRelativeTo(this);
        bsc.setVisible(true);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtDetalle.setEnabled(false);
        txtFecha.setEnabled(false);
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocActionPerformed
        if(txtDoc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el no. de documento del cliente","Alerta",JOptionPane.WARNING_MESSAGE);
            if(!txtNombre.getText().isEmpty()) {
                txtNombre.setEnabled(false);
                txtNombre.setText(null);
                txtApellido.setEnabled(false);
                txtApellido.setText(null);
                txtDireccion.setEnabled(false);
                txtDireccion.setText(null);
                txtDetalle.setEnabled(false);
                txtDetalle.setText(null);
                lblTotalPagar.setText(null);
                lblIdReservacion.setText(null);
                txtFecha.setEnabled(false);
                dt.setEditor(null);
            }
        }else {
            temp = Factura.reservacionAfacturar(Integer.valueOf(txtDoc.getText()));
            if(temp.getNombreCliente() != null){
                txtNombre.setEnabled(true);
                txtNombre.setText(temp.getNombreCliente());
                txtApellido.setEnabled(true);
                txtApellido.setText(temp.getApellidoCliente());
                txtDireccion.setEnabled(true);
                txtDireccion.setText(temp.getDireccionCliente());
                txtDetalle.setEnabled(true);
                txtDetalle.setText(temp.getDescripcion());
                lblTotalPagar.setText(String.valueOf(temp.getTotalFactura()));
                lblIdReservacion.setText(String.valueOf(temp.getIdReservacion()));
                txtFecha.setEnabled(true);
                dt.setEditor(txtFecha);
            }else {
                JOptionPane.showMessageDialog(this, "El cliente indicado no existe o no tiene una reservación activa","Alerta",JOptionPane.WARNING_MESSAGE);
                txtNombre.setEnabled(false);
                txtNombre.setText(null);
                txtApellido.setEnabled(false);
                txtApellido.setText(null);
                txtDireccion.setEnabled(false);
                txtDireccion.setText(null);
                txtDetalle.setEnabled(false);
                txtDetalle.setText(null);
                lblTotalPagar.setText(null);
                lblIdReservacion.setText(null);
                txtFecha.setEnabled(false);
                dt.setEditor(null);
            }
        }
    }//GEN-LAST:event_txtDocActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(txtNombre.isEnabled()) {
            int idCliente = Integer.valueOf(txtDoc.getText()), reservaId = Integer.valueOf(lblIdReservacion.getText());
            int idHabitacion = temp.getIdHabitacion();
            String fecha = dt.getSelectedDateAsString(), descFactura = txtDetalle.getText();
            double totalFactura = Double.valueOf(lblTotalPagar.getText());
            System.out.println(idCliente+" "+reservaId+" "+fecha+" "+descFactura+" "+totalFactura+" "+idHabitacion);
            int affectedRows = Factura.crearFactura(idCliente, reservaId, fecha, descFactura, totalFactura);
            Factura.cambiarEstadoReservacion(idCliente);
            Factura.cambiarEstadoHabitacion(idHabitacion);
            JOptionPane.showMessageDialog(this, "Se ha creado exitosamente "+affectedRows+" registro(s)","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(this, "No hay ninguna reservación indicada, por favor ingrese un cliente con una reservacion activa","Alerta",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblIdReservacion;
    private javax.swing.JLabel lblTotalPagar;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextArea txtDetalle;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDoc;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

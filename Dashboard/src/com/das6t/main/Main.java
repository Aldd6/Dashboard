/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.das6t.main;

/**
 *
 * @author Daniel Aldana(DaS6T)
 */
import Session.Session;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.IntelliJTheme;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.ImageIcon;
import com.das6t.event.EventMenu;
import java.awt.Component;
import java.awt.BorderLayout;
import vistas.UsuariosVista;
import javax.swing.UIManager;
import vistas.ClientesVista;
import vistas.FacturasVista;
import vistas.HabitacionesVista;
import vistas.ReservacionesVista;
import vistas.FacturasVista;
import vistas.DashboardVista;
import Session.Session;
import vistas.ReservacionesVista;
import vistas.IniSesionVista;

public class Main extends javax.swing.JFrame {

    Font robotoPlain = new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13);
    Font robotoBold = new Font(FlatRobotoFont.FAMILY, Font.BOLD, 18);

    Color fontColor = new Color(153, 153, 153);

    ImageIcon iconUser = new FlatSVGIcon("com/das6t/icons/account_circle.svg", 48, 48);
    ImageIcon iconDash = new FlatSVGIcon("com/das6t/icons/dashboard.svg", 48, 48);
    ImageIcon iconReserv = new FlatSVGIcon("com/das6t/icons/reservaciones.svg", 48, 48);
    ImageIcon iconCliente = new FlatSVGIcon("com/das6t/icons/clientes.svg", 48, 48);
    ImageIcon iconFactura = new FlatSVGIcon("com/das6t/icons/facturas.svg", 48, 48);
    ImageIcon iconLogout = new FlatSVGIcon("com/das6t/icons/logout.svg", 48, 48);
    ImageIcon iconHab = new FlatSVGIcon("com/das6t/icons/cama.svg", 48, 48);
    ImageIcon iconUsuario = new FlatSVGIcon("com/das6t/icons/usuarios.svg", 48, 48);

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        
        DashboardVista dashboard = new DashboardVista();
        dashboard.setSize(936,689);
        dashboard.setLocation(0, 0);
        showPanel(dashboard);
        
        EventMenu evt = new EventMenu() {
            @Override
            public void selected(int index) {
                switch (index) {
                    case 0:
                        DashboardVista dashboard = new DashboardVista();
                        dashboard.setSize(936,689);
                        dashboard.setLocation(0, 0);
                        showPanel(dashboard);
                        break;
                    case 1:
                        //[26/05/2024][Inicio][Ivan Hernández][Se agregaron los ventanas de inicio al switch principal]
                        HabitacionesVista habitaciones = new HabitacionesVista();
                        habitaciones.setSize(936, 689);
                        habitaciones.setLocation(0, 0);
                        showPanel(habitaciones);
                        break;
                    case 2:
                        ReservacionesVista reservaciones = new ReservacionesVista();
                        reservaciones.setSize(936, 689);
                        reservaciones.setLocation(0, 0);
                        showPanel(reservaciones);
                        break;
                    case 3:
                        ClientesVista clientes = new ClientesVista();
                        clientes.setSize(936, 689);
                        clientes.setLocation(0, 0);
                        showPanel(clientes);
                        break;
                    case 4:
                        FacturasVista facturas = new FacturasVista();
                        facturas.setSize(936, 689);
                        facturas.setLocation(0, 0);
                        showPanel(facturas);
                        break;
                    case 5:
                        UsuariosVista vs = new UsuariosVista();
                        vs.setSize(936, 689);
                        vs.setLocation(0, 0);
                        showPanel(vs);
                        break;
                    //[26/05/2024][Fin][Ivan Hernández]
                    case 6:
                        closeApp();
                        break;
                }

            }
        };
        menu.initMenu(evt);
        menu.setUserInfo(Session.getNombre(), Session.getRolUsuario());
    }

    private void showPanel(Component cmp) {
        contentPane.removeAll();
        contentPane.add(cmp, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
    }
    
    private void closeApp() {
        IniSesionVista iniSesion = new IniSesionVista();
        this.dispose();
        iniSesion.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new com.das6t.swing.RoundedPanel();
        header = new com.das6t.component.Header();
        btnMinimize = new com.das6t.swing.ButtonBadge();
        menu = new com.das6t.component.Menu();
        contentPane = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(21, 21, 21));
        setUndecorated(true);

        mainPanel.setBackground(new java.awt.Color(45, 42, 46));

        btnMinimize.setBackground(new java.awt.Color(255, 204, 0));
        btnMinimize.setRadius(25);
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentPane.setMaximumSize(new java.awt.Dimension(936, 689));
        contentPane.setMinimumSize(new java.awt.Dimension(936, 689));
        contentPane.setOpaque(false);
        contentPane.setPreferredSize(new java.awt.Dimension(936, 689));

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                    .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        // TODO add your handling code here:
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            IntelliJTheme.setup(Main.class.getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/Monokai_Pro.default.theme.json"));
            UIManager.put("Button.arc", 8);
            UIManager.put("Component.innerFocusWidth", 0);
            UIManager.put("Component.focusWidth", 2);
            UIManager.put("TextComponent.arc", 8);
        } catch (Exception ex) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.das6t.swing.ButtonBadge btnMinimize;
    private javax.swing.JPanel contentPane;
    private com.das6t.component.Header header;
    private com.das6t.swing.RoundedPanel mainPanel;
    private com.das6t.component.Menu menu;
    // End of variables declaration//GEN-END:variables
}

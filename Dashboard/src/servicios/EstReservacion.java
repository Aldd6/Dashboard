/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

/**
 *
 * @author Daniel Aldana (DaS6T)
 */

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

public class EstReservacion {
    private static String qry = "";
    private static Connection conn = null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;
    
    public static int crearEstadoReservacion(String estadoDetalle) {
        int affectedRows = -1;
        try{
            conn = Conexion.getInstance().getConnection();
            qry = "INSERT INTO estado_reservacion(detalle_estado) VALUES (?)";
            st = conn.prepareStatement(qry);
            st.setString(1, estadoDetalle);
            affectedRows = st.executeUpdate();
        }catch(NamingException | SQLException ex) {
            System.out.println(ex.getMessage());
        }finally {
            try {
                st.close();
                conn.close();
            }catch(SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return affectedRows;
    }
    
    public static int modificarEstadoReservacion(int id, String estadoDetalle) {
        int affectedRows = -1;
        try{
            conn = Conexion.getInstance().getConnection();
            qry = "UPDATE estado_reservacion(detalle_estado) SET detalle_estado = ? WHERE id_estado_reservacion = ?";
            st.setString(1, estadoDetalle);
            st.setInt(2, id);
            affectedRows = st.executeUpdate();
        }catch(NamingException | SQLException ex) {
            System.out.println(ex.getMessage());
        }finally {
            try {
                st.close();
                conn.close();
            }catch(SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return affectedRows;
    }
    
    public static int eliminarEstadoReservacion(int id) {
        int affectedRows = -1;
        try{
            conn = Conexion.getInstance().getConnection();
            qry = "UPDATE estado_reservacion(archivado_reservacion) SET archivado_reservacion = ? WHERE id_estado_reservacion = ?";
            st = conn.prepareStatement(qry);
            st.setBoolean(1, true);
            st.setInt(2, id);
            affectedRows = st.executeUpdate();
        }catch(NamingException | SQLException ex) {
            System.out.println(ex.getMessage());
        }finally {
            try {
                st.close();
                conn.close();
            }catch(SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return affectedRows;
    }
    
    public static ResultSet visualizarEstadoReservacion(int id) {
        try{
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT * FROM estado_reservacion WHERE id_estado_reservacion = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, id);
            rs = st.executeQuery();
        }catch(NamingException | SQLException ex) {
            System.out.println(ex.getMessage());
        }finally {
            try {
                st.close();
                conn.close();
            }catch(SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return rs;
    }
    
    public static ResultSet visualizarEstadosReservacion() {
        try{
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT * FROM estado_reservacion";
            st = conn.prepareStatement(qry);
            rs = st.executeQuery();
        }catch(NamingException | SQLException ex) {
            System.out.println(ex.getMessage());
        }finally {
            try {
                st.close();
                conn.close();
            }catch(SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return rs;
    }
}

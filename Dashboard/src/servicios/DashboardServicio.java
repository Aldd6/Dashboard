/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Daniel Aldana(DaS6T)
 */
public class DashboardServicio {
    private static String qry = "";
    private static Connection conn = null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;
    
    public static int habitacionesOcupadas() {
        int countResult= -1;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT COUNT(*) FROM habitacion WHERE estado_habitacion = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, 2);
            rs = st.executeQuery();
            while(rs.next()) {
                countResult = rs.getInt(1);
            }
        }catch(NamingException | SQLException ex) {
            ex.printStackTrace();
        }finally {
            try{
                st.close();
                conn.close();
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return countResult;
    }
    
    public static int habitacionesDisponibles() {
        int countResult= -1;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT COUNT(*) FROM habitacion WHERE estado_habitacion = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, 1);
            rs = st.executeQuery();
            while(rs.next()) {
                countResult = rs.getInt(1);
            }
        }catch(NamingException | SQLException ex) {
            ex.printStackTrace();
        }finally {
            try{
                st.close();
                conn.close();
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return countResult;
    }
    
    public static int habitacionesEnMantenimiento() {
        int countResult= -1;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT COUNT(*) FROM habitacion WHERE estado_habitacion = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, 3);
            rs = st.executeQuery();
            while(rs.next()) {
                countResult = rs.getInt(1);
            }
        }catch(NamingException | SQLException ex) {
            ex.printStackTrace();
        }finally {
            try{
                st.close();
                conn.close();
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return countResult;
    }
    
    public static List<ReservacionServicio> reservasActivas() {
        List<ReservacionServicio> reservaciones = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexion.getInstance().getConnection();
            String query = "SELECT rs.id_reservacion, hb.no_habitacion, cl.nombre_cliente, cl.apellido_cliente, er.detalle_estado, rs.fecha_ingreso, rs.fecha_salida, rs.total_pago, rs.observaciones "
                + "FROM reservacion rs "
                + "JOIN habitacion hb ON rs.habitacion_id = hb.no_habitacion "
                + "JOIN cliente cl ON rs.cliente_id = cl.documento_identificacion "
                + "JOIN estado_reservacion er ON rs.estado_reservacion_id = er.id_estado_reservacion WHERE rs.estado_reservacion_id = 1"
                + "ORDER BY no_habitacion ASC;";

            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ReservacionServicio reservacion = new ReservacionServicio();
                reservacion.setId(rs.getInt("id_reservacion"));
                reservacion.setNumHab(rs.getInt("no_habitacion"));
                reservacion.setNomCliente(rs.getString("nombre_cliente"));
                reservacion.setApeCliente(rs.getString("apellido_cliente"));
                reservacion.setDetalle(rs.getString("detalle_estado"));
                reservacion.setFechaIngreso(rs.getString("fecha_ingreso"));
                reservacion.setFechaSalida(rs.getString("fecha_salida"));
                reservacion.setTotal(rs.getDouble("total_pago"));
                reservacion.setObservaciones(rs.getString("observaciones"));

                reservaciones.add(reservacion);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
        }

        return reservaciones;
    }
}

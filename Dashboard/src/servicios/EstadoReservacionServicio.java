/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import conexion.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Salvador Hernández
 */
public class EstadoReservacionServicio {

    private int id;
    private String detalleEstado;
    private boolean archivadoReservacion;

    public EstadoReservacionServicio() {
    }

    public EstadoReservacionServicio(int id, String detalleEstado, boolean archivadoReservacion) {
        this.id = id;
        this.detalleEstado = detalleEstado;
        this.archivadoReservacion = archivadoReservacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetalleEstado() {
        return detalleEstado;
    }

    public void setDetalleEstado(String detalleEstado) {
        this.detalleEstado = detalleEstado;
    }

    public boolean isArchivadoReservacion() {
        return archivadoReservacion;
    }

    public void setArchivadoReservacion(boolean archivadoReservacion) {
        this.archivadoReservacion = archivadoReservacion;
    }

    public static List<EstadoReservacionServicio> obtenerEstadosReservacion() throws SQLException, NamingException {
        List<EstadoReservacionServicio> estados = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "SELECT id_estado_reservacion, Detalle_estado, archivado_reservacion FROM Estado_reservacion";
            stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EstadoReservacionServicio estado = new EstadoReservacionServicio();
                estado.setId(rs.getInt("id_estado_reservacion"));
                estado.setDetalleEstado(rs.getString("Detalle_estado"));
                estado.setArchivadoReservacion(rs.getBoolean("archivado_reservacion"));

                estados.add(estado);
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
        return estados;
    }

    public static boolean crearEstadoReservacion(String detalleEstado) throws SQLException, NamingException {

        Connection conn = null;
        PreparedStatement stmt = null;
        String query = "";

        try {

            conn = Conexion.getInstance().getConnection();
            query = "INSERT INTO Estado_reservacion (Detalle_estado, archivado_reservacion) VALUES (?, ?)";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, detalleEstado);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Reservación creada con éxito.");
                return true;
            } else {
                System.out.println("Error: No se pudo crear la reservación.");
                return false;
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    public static boolean actualizarEstadoReservacion(int id, String detalleEstado) throws SQLException, NamingException {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexion.getInstance().getConnection();
            String query = "UPDATE Estado_reservacion SET Detalle_estado = ? WHERE id_estado_reservacion = ?";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, detalleEstado);
            stmt.setInt(2, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Estado de reservación actualizado con éxito.");
                return true;
            } else {
                System.out.println("Error: No se pudo actualizar el estado de la reservación.");
                return false;
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    public static boolean eliminarEstadoReservacion(int idEstado) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getInstance().getConnection();
            String query = "DELETE FROM Estado_reservacion WHERE id_estado_reservacion = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, idEstado);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Estado de reservación eliminado con éxito.");
                return true;
            } else {
                System.out.println("Error: No se pudo eliminar el estado de la reservación.");
                return false;
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }
}

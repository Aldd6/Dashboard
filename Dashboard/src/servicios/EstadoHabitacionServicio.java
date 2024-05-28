/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexion.Conexion;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Salvador Hernández
 */
public class EstadoHabitacionServicio {

    private int id_estado_habitacion;
    private String detalle_estado;

    public EstadoHabitacionServicio() {
    }

    public EstadoHabitacionServicio(int id_estado_habitacion, String detalle_estado) {
        this.id_estado_habitacion = id_estado_habitacion;
        this.detalle_estado = detalle_estado;
    }

    public int getId_estado_habitacion() {
        return id_estado_habitacion;
    }

    public void setId_estado_habitacion(int id_estado_habitacion) {
        this.id_estado_habitacion = id_estado_habitacion;
    }

    public String getDetalle_estado() {
        return detalle_estado;
    }

    public void setDetalle_estado(String detalle_estado) {
        this.detalle_estado = detalle_estado;
    }

    // Método para crear un nuevo estado de habitación
    public static boolean crearEstadoHabitacion(String detalleEstado) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "INSERT INTO Estado_habitacion (Detalle_estado) VALUES (?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, detalleEstado);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Estado de habitación creado con éxito");
                return true;
            } else {
                System.out.println("Error: No se pudo crear el estado de la habitación");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: Se produjo un error durante la operación");
            return false;
        } finally {
            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    // Método para obtener todos los estados de las habitaciones
    public static List<EstadoHabitacionServicio> obtenerTodosLosEstados() throws SQLException, NamingException {
        List<EstadoHabitacionServicio> estados = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "SELECT * FROM Estado_habitacion WHERE estado = True ORDER BY id_estado_habitacion ASC";
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idEstado = rs.getInt("id_estado_habitacion");
                String detalleEstado = rs.getString("Detalle_estado");

                EstadoHabitacionServicio estado = new EstadoHabitacionServicio(idEstado, detalleEstado);
                estados.add(estado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
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

    // Método para actualizar un estado de habitación existente
    public static boolean actualizarEstadoHabitacion(int idEstadoHabitacion, String detalleEstado) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "UPDATE Estado_habitacion SET Detalle_estado = ? WHERE id_estado_habitacion = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, detalleEstado);
            stmt.setInt(2, idEstadoHabitacion);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Estado de habitación actualizado con éxito");
                return true;
            } else {
                System.out.println("Error: No se pudo actualizar el estado de la habitación");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: Se produjo un error durante la operación");
            return false;
        } finally {
            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    // Método para eliminar un estado de habitación
    public static boolean eliminarEstadoHabitacion(int idEstadoHabitacion, boolean eliminar) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "UPDATE Estado_habitacion SET estado = ? WHERE id_estado_habitacion = ?";
            stmt = conn.prepareStatement(query);
            stmt.setBoolean(1, eliminar);
            stmt.setInt(2, idEstadoHabitacion);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Estado de habitación eliminado con éxito");
                return true;
            } else {
                System.out.println("Error: No se pudo eliminar el estado de la habitación");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: Se produjo un error durante la operación");
            return false;
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
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
 * Servicio para gestionar habitaciones. Autor: Salvador Hernández
 */
public class HabitacionServicio {

    private int numHabitacion;
    private int tipoHabitacionId;
    private int estadoHabitacionId;
    private String tipo;
    private String detalleHabitacion;
    private double precioHabitacion;
    private String detalleEstado;

    public HabitacionServicio() {
    }

    public HabitacionServicio(int numHabitacion, int tipoHabitacionId, int estadoHabitacionId, String tipo, String detalleHabitacion, double precioHabitacion, String detalleEstado) {
        this.numHabitacion = numHabitacion;
        this.tipoHabitacionId = tipoHabitacionId;
        this.estadoHabitacionId = estadoHabitacionId;
        this.tipo = tipo;
        this.detalleHabitacion = detalleHabitacion;
        this.precioHabitacion = precioHabitacion;
        this.detalleEstado = detalleEstado;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public int getTipoHabitacionId() {
        return tipoHabitacionId;
    }

    public void setTipoHabitacionId(int tipoHabitacionId) {
        this.tipoHabitacionId = tipoHabitacionId;
    }

    public int getEstadoHabitacionId() {
        return estadoHabitacionId;
    }

    public void setEstadoHabitacionId(int estadoHabitacionId) {
        this.estadoHabitacionId = estadoHabitacionId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalleHabitacion() {
        return detalleHabitacion;
    }

    public void setDetalleHabitacion(String detalleHabitacion) {
        this.detalleHabitacion = detalleHabitacion;
    }

    public double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public String getDetalleEstado() {
        return detalleEstado;
    }

    public void setDetalleEstado(String detalleEstado) {
        this.detalleEstado = detalleEstado;
    }

    public static boolean crearHabitacion(int tipoHabitacionId, int estadoHabitacionId) throws SQLException, NamingException {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getInstance().getConnection();
            String query = "INSERT INTO habitacion (tipo_habitacion_id, estado_habitacion_id) VALUES (?,?)";
            stmt = conn.prepareStatement(query);

            stmt.setInt(1, tipoHabitacionId);
            stmt.setInt(2, estadoHabitacionId);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Habitación creada con éxito");
                return true;
            } else {
                System.out.println("Error: No se pudo crear la habitación");
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

    public static boolean modificarHabitacion(int numHabitacion, int tipoHabitacionId, int estadoHabitacionId) throws SQLException, NamingException {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "UPDATE habitacion SET tipo_habitacion_id=?, estado_habitacion_id=? WHERE no_habitacion=?";
            stmt = conn.prepareStatement(query);

            stmt.setInt(1, tipoHabitacionId);
            stmt.setInt(2, estadoHabitacionId);
            stmt.setInt(3, numHabitacion);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Habitación editada exitosamente");
                return true;
            } else {
                System.out.println("Error: No se pudo editar ");
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

    public static boolean eliminarHabitacion(int id) throws SQLException, NamingException {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "DELETE FROM habitacion WHERE no_habitacion=?";
            stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Habitación eliminada con exito");
                return true;
            } else {
                System.out.println("Error: No se pudo eliminar la habitacion");
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

    public List<HabitacionServicio> obtenerTodasLasHabitaciones() throws SQLException, NamingException {

        List<HabitacionServicio> habitaciones = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "SELECT h.No_habitacion, th.Tipo, th.Detalle_habitacion, th.Precio_habitacion, eh.Detalle_estado "
                + "FROM Habitacion h "
                + "JOIN Tipo_habitacion th ON h.tipo_habitacion_id = th.id_tipo_habitacion "
                + "JOIN Estado_habitacion eh ON h.estado_habitacion = eh.id_estado_habitacion;";
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                HabitacionServicio habitacion = new HabitacionServicio();
                habitacion.setNumHabitacion(rs.getInt("No_habitacion"));
                habitacion.setTipo(rs.getString("Tipo"));
                habitacion.setDetalleHabitacion(rs.getString("Detalle_habitacion"));
                habitacion.setPrecioHabitacion(rs.getDouble("Precio_habitacion"));
                habitacion.setDetalleEstado(rs.getString("Detalle_estado"));
                habitaciones.add(habitacion);
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

        return habitaciones;
    }

}

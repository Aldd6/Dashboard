package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexion.Conexion;
import javax.naming.NamingException;

/**
 *
 * @author Salvador Hernández
 */
public class HabitacionServicio {

    private int numHabitacion;
    private int tipoHabitacionId;
    private int estadoHabitacionId;

    public HabitacionServicio() {
    }

    public HabitacionServicio(int numHabitacion, int tipoHabitacionId, int estadoHabitacionId) {
        this.numHabitacion = numHabitacion;
        this.tipoHabitacionId = tipoHabitacionId;
        this.estadoHabitacionId = estadoHabitacionId;
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

    public static boolean CrearHabitacion(int tipoHabitacionId, int estadoHabitacionId) throws SQLException, NamingException {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getInstance().getConnection();
            String query = "INSERT INTO habitacion (tipo_habitacion_id, estado_habitacion_id) VALUES (?,?,?)";
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

    public static boolean modificarHabitacion(int numHabitacion, int tipoHabitacionId, int estadoHabitacionId) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "UPDATE habitacion SET tipoHabitacionId=?, estadoHabitacionId=? WHERE no_habitacion=?";
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
        } catch (SQLException | NamingException ex) {
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

    public static boolean eliminarHabitacion(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "DELETE FROM habitacion WHERE no_habitacion='";
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
        } catch (SQLException | NamingException ex) {
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

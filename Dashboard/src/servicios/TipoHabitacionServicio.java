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
public class TipoHabitacionServicio {

    private int id;
    private String tipoHab;
    private String detalleHab;
    private double precioHab;

    public TipoHabitacionServicio() {
    }

    public TipoHabitacionServicio(int id, String tipoHab, String detalleHab, double precioHab) {
        this.id = id;
        this.tipoHab = tipoHab;
        this.detalleHab = detalleHab;
        this.precioHab = precioHab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoHab() {
        return tipoHab;
    }

    public void setTipoHab(String tipoHab) {
        this.tipoHab = tipoHab;
    }

    public String getDetalleHab() {
        return detalleHab;
    }

    public void setDetalleHab(String detalleHab) {
        this.detalleHab = detalleHab;
    }

    public double getPrecioHab() {
        return precioHab;
    }

    public void setPrecioHab(double precioHab) {
        this.precioHab = precioHab;
    }

    public static boolean crearTipo(String tipoHab, String detalleHab, double precioHab) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "INSERT INTO Tipo_habitacion (Tipo, Detalle_habitacion, Precio_habitacion) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, tipoHab);
            stmt.setString(2, detalleHab);
            stmt.setDouble(3, precioHab);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Tipo de habitación creada con éxito.");
                return true;
            } else {
                System.out.println("Error: No se pudo crear el tipo de habitación");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: Se produjo un error durante la operación.");
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

    public static boolean modificarTipo(int id, String tipoHab, String detalleHab, double precioHab) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "UPDATE Tipo_habitacion SET Tipo = ?, Detalle_habitacion = ?, Precio_habitacion = ? WHERE id_tipo_habitacion = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, tipoHab);
            stmt.setString(2, detalleHab);
            stmt.setDouble(3, precioHab);
            stmt.setInt(4, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Tipo de habitación modificada con éxito.");
                return true;
            } else {
                System.out.println("Error: No se pudo modificar el tipo de habitación");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: Se produjo un error durante la operación.");
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

    public static boolean eliminarTipo(int id) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "DELETE FROM Tipo_habitacion WHERE id_tipo_habitacion = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Tipo de habitación eliminada con éxito.");
                return true;
            } else {
                System.out.println("Error: No se pudo eliminar el tipo de habitación");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: Se produjo un error durante la operación.");
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

    public static List<TipoHabitacionServicio> visualizarTipo() throws SQLException, NamingException {
        List<TipoHabitacionServicio> habitaciones = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "SELECT * FROM Tipo_habitacion ORDER BY id_tipo_habitacion ASC";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_tipo_habitacion");
                String tipoHab = rs.getString("Tipo");
                String detalleHab = rs.getString("Detalle_habitacion");
                double precioHab = rs.getDouble("Precio_habitacion");

                TipoHabitacionServicio habitacion = new TipoHabitacionServicio(id, tipoHab, detalleHab, precioHab);
                habitaciones.add(habitacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: No se han podido consultar los registros");
        } finally {
            if (rs != null) {
                rs.close();
            }
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
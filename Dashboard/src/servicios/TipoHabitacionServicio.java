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

    public static boolean crearTipo(String tipoHab, String detalleHab, double precioHab) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "INSERT INTO tpHabitacion (tipoHab, detalleHab, precioHab) VALUES (?,?,?)";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, tipoHab);
            stmt.setString(2, detalleHab);
            stmt.setDouble(3, precioHab);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Tipo de habitación creada con éxito.");
                return true;
            } else {
                System.out.println("Error: No se pudo crear el tipo de habtiación");
                return false;
            }

        } catch (SQLException | NamingException ex) {

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

    public static boolean modificarTipo(int id, String tipoHab, String detalleHab, double precioHab) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexion.getInstance().getConnection();
            String query = "UPDATE tpHabitacion SET tipoHab=?, detalleHab=?, precioHab=? WHERE id=?";
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
                System.out.println("Error: No se pudo crear el tipo de habtiación");
                return false;
            }

        } catch (SQLException | NamingException ex) {

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

    public static boolean eliminarTipo(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "DELETE FROM tpHabitacion WHERE id=?";
            stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Tipo de habitación eliminada con exito");
                return true;
            } else {
                System.out.println("Error: No se pudo eliminar el tipo de habitación");
                return false;
            }
        } catch (SQLException | NamingException ex) {

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

    public List<TipoHabitacionServicio> visualizarTipo() throws SQLException, NamingException {
        List<TipoHabitacionServicio> habitaciones = new ArrayList<>();

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "SELECT * FROM tpHabitacion ORDER BY id ASC";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            System.out.println(rs);

            while (rs.next()) {
                int id = rs.getInt("id");
                String tipoHab = rs.getString("tipoHab");
                String detalleHab = rs.getString("detalleHab");
                double precioHab = rs.getDouble("precioHab");

                TipoHabitacionServicio habitacion = new TipoHabitacionServicio(id, tipoHab, detalleHab, precioHab);
                habitaciones.add(habitacion);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
            System.out.println("Error: No se han podido consultar los registros");
        } finally {
            if (rs != null){
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
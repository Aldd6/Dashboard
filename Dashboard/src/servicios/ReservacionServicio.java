package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import conexion.Conexion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Salvador Hernández
 */
public class ReservacionServicio {

    private int id;
    private int numHab;
    private int clienteId;
    private int estadoReserva;
    private String nomCliente;
    private String apeCliente;
    private String detalle;
    private Date fechaIngreso;
    private Date fechaSalida;
    private double total;
    private String observaciones;

    public ReservacionServicio() {
    }

    public ReservacionServicio(int id, int numHab, String nomCliente, String apeCliente, String detalle, Date fechaIngreso, Date fechaSalida, double total, String observaciones) {
        this.id = id;
        this.numHab = numHab;
        this.nomCliente = nomCliente;
        this.apeCliente = apeCliente;
        this.detalle = detalle;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.total = total;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(int estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public int getNumHab() {
        return numHab;
    }

    public void setNumHab(int numHab) {
        this.numHab = numHab;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getApeCliente() {
        return apeCliente;
    }

    public void setApeCliente(String apeCliente) {
        this.apeCliente = apeCliente;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    Connection conn = null;
    PreparedStatement stmt = null;
    String query = "";

    public List<ReservacionServicio> obtenerReservaciones() throws SQLException, NamingException {

        List<ReservacionServicio> reservaciones = new ArrayList<>();

        try {

            conn = Conexion.getInstance().getConnection();
            query = "SELECT rs.id_reservacion, hb.no_habitacion, cl.nombre_cliente, cl.apellido_cliente, er.detalle_estado, rs.fecha_ingreso, rs.fecha_salida, rs.total_pago, rs.observaciones "
                + "FROM reservacion rs "
                + "JOIN habitacion hb ON rs.habitacion_id = hb.no_habitacion "
                + "JOIN cliente cl ON rs.cliente_id = cl.documento_identificacion "
                + "JOIN estado_reservacion er ON rs.estado_reservacion_id = er.id_estado_reservacion "
                + "ORDER BY no_habitacion ASC;";

            stmt = conn.prepareCall(query);
            ResultSet rs = stmt.executeQuery();
            ReservacionServicio reservacion = new ReservacionServicio();

            while (rs.next()) {
                reservacion.setId(rs.getInt("id_reservacion"));
                reservacion.setNumHab(rs.getInt("no_habitacion"));
                reservacion.setNomCliente(rs.getString("nombre_cliente"));
                reservacion.setApeCliente(rs.getString("apellido_cliente"));
                reservacion.setDetalle(rs.getString("detalle_estado"));
                reservacion.setFechaIngreso(rs.getDate("fecha_ingreso"));
                reservacion.setFechaSalida(rs.getDate("fecha_salida"));
                reservacion.setTotal(rs.getDouble("total_pago"));
                reservacion.setObservaciones(rs.getString("observaciones"));

                reservaciones.add(reservacion);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }

        return reservaciones;

    }

    public void crearReservacion(ReservacionServicio reservacion) throws SQLException, NamingException {
        String query = "INSERT INTO Reservacion (Habitacion_id, Cliente_id, Estado_reservacion_id, Fecha_ingreso, Fecha_salida, Total_pago, Observaciones) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection conn = Conexion.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, reservacion.getNumHab());
            stmt.setInt(2, reservacion.getClienteId());
            stmt.setInt(3, reservacion.getEstadoReserva());
            stmt.setDate(4, new java.sql.Date(reservacion.getFechaIngreso().getTime()));
            stmt.setDate(5, new java.sql.Date(reservacion.getFechaSalida().getTime()));
            stmt.setDouble(6, reservacion.getTotal());
            stmt.setString(7, reservacion.getObservaciones());

            stmt.executeUpdate();
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

    public void actualizarReservacion(ReservacionServicio reservacion) throws SQLException, NamingException {
        String query = "UPDATE Reservacion SET Habitacion_id = ?, Cliente_id = ?, Estado_reservacion_id = ?, Fecha_ingreso = ?, Fecha_salida = ?, Total_pago = ?, Observaciones = ? WHERE id_reservacion = ?";

        try {

            Connection conn = Conexion.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, reservacion.getNumHab());
            stmt.setInt(2, reservacion.getClienteId());
            stmt.setInt(3, reservacion.getEstadoReserva());
            stmt.setDate(4, new java.sql.Date(reservacion.getFechaIngreso().getTime()));
            stmt.setDate(5, new java.sql.Date(reservacion.getFechaSalida().getTime()));
            stmt.setDouble(6, reservacion.getTotal());
            stmt.setString(7, reservacion.getObservaciones());
            stmt.setInt(8, reservacion.getId());

            stmt.executeUpdate();
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

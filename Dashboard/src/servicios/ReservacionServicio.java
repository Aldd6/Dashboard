package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import conexion.Conexion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    private String fechaIngreso;
    private String fechaSalida;
    private double total;
    private String observaciones;
    private String tipo;

    private static LocalDate parser = null;
    private static java.sql.Date sqlDate = null;
    private static DateTimeFormatter sqlFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public ReservacionServicio() {
    }

    public ReservacionServicio(int id, int numHab, int clienteId, int estadoReserva, String nomCliente, String apeCliente, String detalle, String fechaIngreso, String fechaSalida, double total, String observaciones, String tipo) {
        this.id = id;
        this.numHab = numHab;
        this.clienteId = clienteId;
        this.estadoReserva = estadoReserva;
        this.nomCliente = nomCliente;
        this.apeCliente = apeCliente;
        this.detalle = detalle;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.total = total;
        this.observaciones = observaciones;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
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

    private static java.sql.Date convertirFechaSql(String fecha) {
        parser = LocalDate.parse(convertirFecha(fecha), sqlFormat);
        sqlDate = java.sql.Date.valueOf(parser);
        return sqlDate;
    }

    private static String convertirFecha(String fecha) {
        String convertedDate = "";

        convertedDate += fecha.substring(fecha.lastIndexOf("/") + 1, fecha.length());
        convertedDate += "-" + fecha.substring(fecha.indexOf("/") + 1, fecha.lastIndexOf("/"));
        convertedDate += "-" + fecha.substring(0, fecha.indexOf("/"));
        System.out.println(convertedDate);

        return convertedDate;
    }

    public List<ReservacionServicio> obtenerReservaciones() throws SQLException, NamingException {

        List<ReservacionServicio> reservaciones = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexion.getInstance().getConnection();
            String query = "SELECT rs.id_reservacion, hb.no_habitacion, cl.nombre_cliente, cl.apellido_cliente, er.detalle_estado, rs.fecha_ingreso, rs.fecha_salida, rs.total_pago, rs.observaciones "
                + "FROM reservacion rs "
                + "JOIN habitacion hb ON rs.habitacion_id = hb.no_habitacion "
                + "JOIN cliente cl ON rs.cliente_id = cl.documento_identificacion "
                + "JOIN estado_reservacion er ON rs.estado_reservacion_id = er.id_estado_reservacion "
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
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return reservaciones;

    }

    public static ReservacionServicio obtenerReservacion(int idReservacion) throws SQLException, NamingException {
        ReservacionServicio reservacion = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "SELECT rs.estado_reservacion_id,rs.id_reservacion, hb.no_habitacion, cl.documento_identificacion, cl.nombre_cliente, cl.apellido_cliente, er.detalle_estado, rs.fecha_ingreso, rs.fecha_salida, rs.total_pago, rs.observaciones "
                + "FROM reservacion rs "
                + "JOIN habitacion hb ON rs.habitacion_id = hb.no_habitacion "
                + "JOIN cliente cl ON rs.cliente_id = cl.documento_identificacion "
                + "JOIN estado_reservacion er ON rs.estado_reservacion_id = er.id_estado_reservacion "
                + "WHERE rs.id_reservacion = ?;";

            stmt = conn.prepareStatement(query);
            stmt.setInt(1, idReservacion);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                reservacion = new ReservacionServicio();
                reservacion.setId(rs.getInt("id_reservacion"));
                reservacion.setNumHab(rs.getInt("no_habitacion"));
                reservacion.setEstadoReserva(rs.getInt("estado_reservacion_id"));
                reservacion.setClienteId(rs.getInt("documento_identificacion"));                
                reservacion.setNomCliente(rs.getString("nombre_cliente"));
                reservacion.setApeCliente(rs.getString("apellido_cliente"));
                reservacion.setDetalle(rs.getString("detalle_estado"));
                reservacion.setFechaIngreso(rs.getString("fecha_ingreso"));
                reservacion.setFechaSalida(rs.getString("fecha_salida"));
                reservacion.setTotal(rs.getDouble("total_pago"));
                reservacion.setObservaciones(rs.getString("observaciones"));
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

        return reservacion;
    }

    public static boolean crearReservacion(int numHab, int clienteId, int estadoReserva, String fechaIngreso, String fechaSalida, double total, String observaciones) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "INSERT INTO Reservacion (Habitacion_id, Cliente_id, Estado_reservacion_id, Fecha_ingreso, Fecha_salida, Total_pago, Observaciones) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, numHab);
            stmt.setInt(2, clienteId);
            stmt.setInt(3, estadoReserva);
            stmt.setDate(4, convertirFechaSql(fechaIngreso));
            stmt.setDate(5, convertirFechaSql(fechaSalida));
            stmt.setDouble(6, total);
            stmt.setString(7, observaciones);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Reservación creada con éxito.");
                return true;
            } else {
                System.out.println("Error: No se pudo crear la reservación.");
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

    public static boolean actualizarReservacion(int idReservacion, int numHab, int clienteId, int estadoReserva, String fechaIngreso, String fechaSalida, double total, String observaciones) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "UPDATE Reservacion SET Habitacion_id = ?, Cliente_id = ?, Estado_reservacion_id = ?, Fecha_ingreso = ?, Fecha_salida = ?, Total_pago = ?, Observaciones = ? WHERE id_reservacion = ?";
            stmt = conn.prepareStatement(query);

            stmt.setInt(1, numHab);
            stmt.setInt(2, clienteId);
            stmt.setInt(3, estadoReserva);
            stmt.setDate(4, convertirFechaSql(fechaIngreso));
            stmt.setDate(5, convertirFechaSql(fechaSalida));
            stmt.setDouble(6, total);
            stmt.setString(7, observaciones);
            stmt.setInt(8, idReservacion);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Reservación actualizada con éxito.");
                return true;
            } else {
                System.out.println("Error: No se pudo actualizar la reservación.");
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

    public static List<ReservacionServicio> obtenerTipoHabitacion() throws SQLException, NamingException {
        List<ReservacionServicio> tipoHabitaciones = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getInstance().getConnection();
            String query = "SELECT hb.no_habitacion, th.tipo, th.precio_habitacion "
                + "FROM habitacion hb "
                + "JOIN tipo_habitacion th ON hb.tipo_habitacion_id = th.id_tipo_habitacion "
                + "ORDER BY hb.no_habitacion ASC;";
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ReservacionServicio tipoHabitacion = new ReservacionServicio();
                tipoHabitacion.setNumHab(rs.getInt("no_habitacion"));
                tipoHabitacion.setTipo(rs.getString("tipo"));
                tipoHabitacion.setTotal(rs.getDouble("precio_habitacion"));
                tipoHabitaciones.add(tipoHabitacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return tipoHabitaciones;
    }

}

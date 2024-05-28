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
import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import javax.naming.NamingException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Daniel Aldana(DaS6T)
 */
public class Factura {

    /**
     * @return the idHabitacion
     */
    public int getIdHabitacion() {
        return idHabitacion;
    }

    /**
     * @param idHabitacion the idHabitacion to set
     */
    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    /**
     * @return the direccionCliente
     */
    public String getDireccionCliente() {
        return direccionCliente;
    }

    /**
     * @param direccionCliente the direccionCliente to set
     */
    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    /**
     * @return the idFactura
     */
    public int getIdFactura() {
        return idFactura;
    }

    /**
     * @param aIdFactura the idFactura to set
     */
    public void setIdFactura(int aIdFactura) {
        idFactura = aIdFactura;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param aIdCliente the idCliente to set
     */
    public void setIdCliente(int aIdCliente) {
        idCliente = aIdCliente;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param aNombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String aNombreCliente) {
        nombreCliente = aNombreCliente;
    }

    /**
     * @return the apellidoCliente
     */
    public String getApellidoCliente() {
        return apellidoCliente;
    }

    /**
     * @param aApellidoCliente the apellidoCliente to set
     */
    public void setApellidoCliente(String aApellidoCliente) {
        apellidoCliente = aApellidoCliente;
    }

    /**
     * @return the idReservacion
     */
    public int getIdReservacion() {
        return idReservacion;
    }

    /**
     * @param aIdReservacion the idReservacion to set
     */
    public void setIdReservacion(int aIdReservacion) {
        idReservacion = aIdReservacion;
    }

    /**
     * @return the noFactura
     */
    public String getNoFactura() {
        return noFactura;
    }

    /**
     * @param aNoFactura the noFactura to set
     */
    public void setNoFactura(String aNoFactura) {
        noFactura = aNoFactura;
    }

    /**
     * @return the serieFactura
     */
    public String getSerieFactura() {
        return serieFactura;
    }

    /**
     * @param aSerieFactura the serieFactura to set
     */
    public void setSerieFactura(String aSerieFactura) {
        serieFactura = aSerieFactura;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param aFecha the fecha to set
     */
    public void setFecha(String aFecha) {
        fecha = aFecha;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param aDescripcion the descripcion to set
     */
    public void setDescripcion(String aDescripcion) {
        descripcion = aDescripcion;
    }

    /**
     * @return the estado_factura
     */
    public boolean isEstadoFactura() {
        return estadoFactura;
    }

    /**
     * @param aEstado_factura the estado_factura to set
     */
    public void setEstadoFactura(boolean aEstado_factura) {
        estadoFactura = aEstado_factura;
    }

    /**
     * @return the totalFactura
     */
    public double getTotalFactura() {
        return totalFactura;
    }

    /**
     * @param aTotalFactura the totalFactura to set
     */
    public void setTotalFactura(double aTotalFactura) {
        totalFactura = aTotalFactura;
    }
    private static Connection conn = null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;
    private static String qry = "";
    
    private static final int VAL_RANG_DOWN = 0;
    private static final int VAL_RANG_UP = 19;
    
    private static LocalDate parser = null;
    private static Date sqlDate = null;
    private static DateTimeFormatter sqlFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    public int idFactura;
    public int idCliente;
    public int idHabitacion;
    public String nombreCliente;
    public String apellidoCliente;
    public String direccionCliente;
    public int idReservacion;
    public String noFactura;
    public String serieFactura;
    public String fecha;
    public String descripcion;
    public boolean estadoFactura;
    public double totalFactura;
    
    public Factura() {
    }
    
    public Factura(int idFactura, int idCliente, String nombreCliente, String apellidoCliente, int idReservacion, String noFactura, String serieFactura, String fecha, String descripcion, boolean estadoFactura, double totalFactura) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.idReservacion = idReservacion;
        this.noFactura = noFactura;
        this.serieFactura = serieFactura;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.estadoFactura = estadoFactura;
        this.totalFactura = totalFactura;
    }
    
    public static int crearFactura(int clienteId, int reservaId, String fecha, String descFactura, double totalFactura) {
        int affectedRows = -1;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "INSERT INTO factura(cliente_id,reservacion_id,no_factura,serie_factura,fecha_factura,descripcion_factura,total_factura)"
                    +"VALUES (?,?,?,?,?,?,?)";
            st = conn.prepareStatement(qry);
            st.setInt(1, clienteId);
            st.setInt(2, reservaId);
            st.setString(3, generarNumero());
            st.setString(4, generarSerie());
            st.setDate(5, convertirFechaSql(fecha));
            st.setString(6, descFactura);
            st.setDouble(7, totalFactura);
            affectedRows = st.executeUpdate();
        }catch(SQLException | NamingException ex) {
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
    
    public static int modificarEstadoFactura(int id) {
        int affectedRows = -1;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "UPDATE factura SET estado_factura = ? WHERE id = ?";
            st = conn.prepareStatement(qry);
            st.setBoolean(1, false);
            st.setInt(2, id);
            affectedRows = st.executeUpdate();
        }catch(SQLException | NamingException ex){
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
    
    public static Factura visualizarFactura(int id) {
        Factura factura = new Factura();
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT id_factura,no_factura,serie_factura,reservacion_id,nombre_cliente,apellido_cliente,descripcion_factura,total_factura,estado_factura"
                    +" FROM cliente c INNER JOIN factura f ON c.id = f.cliente_id WHERE id_factura = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, id);
            rs = st.executeQuery();
            while(rs.next()) {
                factura.setIdFactura(rs.getInt("id_factura"));
                factura.setNoFactura(rs.getString("no_factura"));
                factura.setSerieFactura(rs.getString("serie_factura"));
                factura.setIdReservacion(rs.getInt("reservacion_id"));
                factura.setNombreCliente(rs.getString("nombre_cliente"));
                factura.setApellidoCliente(rs.getString("apellido_cliente"));
                factura.setDescripcion(rs.getString("descripcion_factura"));
                factura.setTotalFactura(rs.getDouble("total_factura"));
                factura.setEstadoFactura(rs.getBoolean("estado_factura"));
            }
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
        return factura;
    }
    
    public static Factura reservacionAfacturar(int documento) {
        Factura factura = new Factura();
        String detalle;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT habitacion_id,nombre_cliente,apellido_cliente,direccion_cliente,id_reservacion,fecha_ingreso,fecha_salida,detalle_habitacion,total_pago FROM"
                    + " cliente c INNER JOIN reservacion r ON r.cliente_id = c.documento_identificacion"
                    + " INNER JOIN habitacion h ON h.no_habitacion = r.habitacion_id INNER JOIN tipo_habitacion t ON t.id_tipo_habitacion = h.tipo_habitacion_id"
                    + " WHERE documento_identificacion = ? AND estado_reservacion_id = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, documento);
            st.setInt(2, 1);
            rs = st.executeQuery();
            while(rs.next()) {
                factura.setNombreCliente(rs.getString("nombre_cliente"));
                factura.setApellidoCliente(rs.getString("apellido_cliente"));
                factura.setDireccionCliente(rs.getString("direccion_cliente"));
                factura.setIdReservacion(rs.getInt("id_reservacion"));
                detalle = "Estadia en " + rs.getString("detalle_habitacion") + " del " + rs.getString("fecha_ingreso") + " al " + rs.getString("fecha_salida");
                factura.setDescripcion(detalle);
                factura.setTotalFactura(rs.getDouble("total_pago"));
                factura.setIdHabitacion(rs.getInt("habitacion_id"));
            }
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
        return factura;
    }
    
    public static List<Factura> visualizarFacturas() {
        List<Factura> facturas = new ArrayList<>();
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT id_factura,no_factura,serie_factura,reservacion_id,nombre_cliente,apellido_cliente,descripcion_factura,total_factura"
                    +" FROM cliente c INNER JOIN factura f ON c.documento_identificacion = f.cliente_id";
            st = conn.prepareStatement(qry);
            rs = st.executeQuery();
            while(rs.next()) {
                Factura factura = new Factura();
                factura.setIdFactura(rs.getInt("id_factura"));
                factura.setNoFactura(rs.getString("no_factura"));
                factura.setSerieFactura(rs.getString("serie_factura"));
                factura.setIdReservacion(rs.getInt("reservacion_id"));
                factura.setNombreCliente(rs.getString("nombre_cliente"));
                factura.setApellidoCliente(rs.getString("apellido_cliente"));
                factura.setDescripcion(rs.getString("descripcion_factura"));
                factura.setTotalFactura(rs.getDouble("total_factura"));
                facturas.add(factura);
            }
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
        return facturas;
    }
    
    public static void cambiarEstadoHabitacion(int habitacion) {
        int affectedRows = -1;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "UPDATE habitacion SET estado_habitacion = ? WHERE no_habitacion = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, 1);
            st.setInt(2, habitacion);
            affectedRows = st.executeUpdate();
            System.out.println("Habitaciones afectadas: " + affectedRows);
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
    }
    
    public static void cambiarEstadoReservacion(int documento){
        int affectedRows = -1;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "UPDATE reservacion SET estado_reservacion_id = ? WHERE cliente_id = ? AND estado_reservacion_id = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, 3);
            st.setInt(2, documento);
            st.setInt(3, 1);
            affectedRows = st.executeUpdate();
            System.out.println("Reservaciones afectadas: " + affectedRows);
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
    }
    
    private static String generarNumero() {
        Random r = new Random();
        return String.valueOf(Math.abs(r.nextInt()));
    }
    
    private static String generarSerie() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        String[] elems = {"0","A","1","B","2","C","3","D","4","E","5","F","6","G","7","H","8","I","9","J"};
        int selector;
        
        for(int i = 0; i<10; i++){
            selector = r.nextInt(VAL_RANG_DOWN, VAL_RANG_UP);
            sb.append(elems[selector]);
        }
        return sb.toString();
    }
    
    private static Date convertirFechaSql(String fecha) {
        parser = LocalDate.parse(convertirFecha(fecha), sqlFormat);
        sqlDate = Date.valueOf(parser);
        return sqlDate;
    }
    
    private static String convertirFecha(String fecha) {
        String convertedDate = "";
        
        convertedDate += fecha.substring(fecha.lastIndexOf("/")+1,fecha.length());
        convertedDate += "-"+fecha.substring(fecha.indexOf("/")+1,fecha.lastIndexOf("/"));
        convertedDate += "-"+fecha.substring(0,fecha.indexOf("/"));
        System.out.println(convertedDate);
        
        return convertedDate;
    }
    
}

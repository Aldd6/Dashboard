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

/**
 *
 * @author Daniel Aldana(DaS6T)
 */
public class Factura {
    private static Connection conn = null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;
    private static String qry = "";
    
    private static final int VAL_RANG_DOWN = 0;
    private static final int VAL_RANG_UP = 19;
    
    private static LocalDate parser = null;
    private static Date sqlDate = null;
    private static DateTimeFormatter sqlFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
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
    
    public static ResultSet visualizarFactura(int id) {
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT id_factura,no_factura,serie_factura,reservacion_id,nombre_cliente,apellido_cliente,descripcion_factura,total_factura"
                    +"FROM cliente c INNER JOIN factura f ON c.id = f.cliente_id WHERE id_factura = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, id);
            rs = st.executeQuery();
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
        return rs;
    }
    
    public static ResultSet visualizarFacturas() {
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT id_factura,no_factura,serie_factura,reservacion_id,nombre_cliente,apellido_cliente,descripcion_factura,total_factura"
                    +"FROM cliente c INNER JOIN factura f ON c.id = f.cliente_id";
            st = conn.prepareStatement(qry);
            rs = st.executeQuery();
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
        return rs;
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
        parser = LocalDate.parse(fecha, sqlFormat);
        sqlDate = Date.valueOf(parser);
        return sqlDate;
    }
    
}

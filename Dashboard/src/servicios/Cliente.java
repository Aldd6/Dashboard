/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

/**
 *
 * @author Daniel Aldana (DaS6T)
 */
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.naming.NamingException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Cliente {

    private int id;
    private int dpi;
    private String nit;
    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;
    private String telefono;
    private String fecha;

    private static String qry = "";
    private static Connection conn = null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;

    private static Pattern pt = null;
    private static Matcher mt = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public static String getQry() {
        return qry;
    }

    public static void setQry(String qry) {
        Cliente.qry = qry;
    }

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        Cliente.conn = conn;
    }

    public static PreparedStatement getSt() {
        return st;
    }

    public static void setSt(PreparedStatement st) {
        Cliente.st = st;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static void setRs(ResultSet rs) {
        Cliente.rs = rs;
    }

    public static Pattern getPt() {
        return pt;
    }

    public static void setPt(Pattern pt) {
        Cliente.pt = pt;
    }

    public static Matcher getMt() {
        return mt;
    }

    public static void setMt(Matcher mt) {
        Cliente.mt = mt;
    }

    public static int crearCliente(int docIdent, String nit, String nombre, String apellido, String direccion, String correo, String telefono) {
        int affectedRows = -1;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "INSERT INTO cliente(documento_identificacion,nit_cliente,nombre_cliente,apellido_cliente,direccion_cliente,"
                + "correo_cliente,telefono_cliente) VALUES (?,?,?,?,?,?,?)";
            st = conn.prepareStatement(qry);
            st.setInt(1, docIdent);
            st.setString(2, nit);
            st.setString(3, nombre);
            st.setString(4, apellido);
            st.setString(5, direccion);
            st.setString(6, correo);
            st.setString(7, telefono);
            affectedRows = st.executeUpdate();
        } catch (NamingException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return affectedRows;
    }

    public static int modificarCliente(int id, int docIdent, String nit, String nombre, String apellido, String direccion, String correo, String telefono) {
        int affectedRows = -1;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "UPDATE cliente(documento_identificacion,nit_cliente,nombre_cliente,apellido_cliente,direccion_cliente,"
                + "correo_cliente,telefono_cliente) SET documento_identificacion = ?, nit_cliente = ?, nombre_cliente = ?,"
                + "apellido_cliente = ?, direccion_cliente = ?, correo_cliente = ?, telefono_cliente = ? WHERE id = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, docIdent);
            st.setString(2, nit);
            st.setString(3, nombre);
            st.setString(4, apellido);
            st.setString(5, direccion);
            st.setString(6, correo);
            st.setString(7, telefono);
            st.setInt(8, id);
            affectedRows = st.executeUpdate();
        } catch (NamingException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return affectedRows;
    }

    public static ResultSet visualizarCliente(int id) {
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT * FROM cliente WHERE id = ?";
            st.setInt(1, id);
            rs = st.executeQuery();
        } catch (NamingException | SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return rs;
    }

    public List<Cliente> visualizarClientes() throws SQLException {

        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT * FROM cliente";
            st = conn.prepareStatement(qry);
            rs = st.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("documento_identificacion"));
                cliente.setNit(rs.getString("nit_cliente"));
                cliente.setNit(rs.getString("nombre_cliente"));
                cliente.setNit(rs.getString("apellido_cliente"));
                cliente.setNit(rs.getString("direccion_cliente"));
                cliente.setNit(rs.getString("correo_cliente"));
                cliente.setNit(rs.getString("telefono_cliente"));
                cliente.setNit(rs.getString("fecha_registro"));
                clientes.add(cliente);
            }

        } catch (NamingException | SQLException ex) {

            System.out.println(ex.getMessage());

        } finally {

            if (rs != null) {
                rs.close();
            }
            
            if (st != null) {
                st.close();
            }
            
            if (conn != null) {
                conn.close();
            }
        }
        return clientes;
    }

    public static boolean esNitValido(String nit) {
        pt = Pattern.compile("(\\d+)-(\\d|\\w)", Pattern.CASE_INSENSITIVE);
        mt = pt.matcher(nit);
        return mt.find();
    }

    public static boolean esCorreoValido(String correo) {
        pt = Pattern.compile("[(^\\d|^\\w)(\\w|\\d|\\D)]{1,64}\\@([a-zA-Z]|[0-9])(\\w)+\\.([a-zA-Z]){2,4}", Pattern.CASE_INSENSITIVE);
        mt = pt.matcher(correo);
        return mt.find();
    }
}

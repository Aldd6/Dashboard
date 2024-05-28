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
import javax.naming.NamingException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JComboBox;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Cliente {

    /**
     * @return the Nit
     */
    public String getNit() {
        return Nit;
    }

    /**
     * @param Nit the Nit to set
     */
    public void setNit(String Nit) {
        this.Nit = Nit;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * @return the Direccion
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /**
     * @return the Correo
     */
    public String getCorreo() {
        return Correo;
    }

    /**
     * @param Correo the Correo to set
     */
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the Fecha
     */
    public String getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    public int getIdCliente () {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public int getDocIdent (){
        return DocIdent;
    }
    public void setDocIdent(int DocIdent) {
        this.DocIdent = DocIdent;
    }
    private static String qry = "";
    private static Connection conn = null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;
    
    private static Pattern pt = null;
    private static Matcher mt = null;
    public int idCliente;
    public int DocIdent;
    private String Nit;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private String Correo;
    private String Telefono;
    private String Fecha;
    public Cliente() {
        
    }
    public Cliente (int IdCliente, int DocIdent, String Nit, String Nombre, String Apellido, String Direccion, String Correo, String Telefono, String Fecha) {
        this.idCliente = IdCliente;
        this.DocIdent = DocIdent;
        this.Nit = Nit;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Correo = Correo;
        this.Telefono = Telefono;
        this.Fecha = Fecha;
    }
    public static int crearCliente(int docIdent, String nit, String nombre, String apellido, String direccion, String correo, String telefono) {
        int affectedRows = -1;
        try{
            conn = Conexion.getInstance().getConnection();
            qry = "INSERT INTO cliente(documento_identificacion,nit_cliente,nombre_cliente,apellido_cliente,direccion_cliente,"
                    + "correo_cliente,telefono_cliente) VALUES (?,?,?,?,?,?,?)";
            st = conn.prepareStatement(qry);
            st.setInt(1, docIdent);
            st.setString(2, nit);
            st.setString(3, nombre);
            st.setString(4,  apellido);
            st.setString(5, direccion);
            st.setString(6, correo);
            st.setString(7, telefono);
            affectedRows = st.executeUpdate();
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
        return affectedRows;
    }
    
    public static int modificarCliente(int id, int docIdent, String nit, String nombre, String apellido, String direccion, String correo, String telefono) {
        int affectedRows = -1;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "UPDATE cliente SET documento_identificacion = ?, nit_cliente = ?, nombre_cliente = ?,"
                    + "apellido_cliente = ?, direccion_cliente = ?, correo_cliente = ?, telefono_cliente = ? WHERE id_cliente = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, docIdent);
            st.setString(2, nit);
            st.setString(3, nombre);
            st.setString(4,  apellido);
            st.setString(5, direccion);
            st.setString(6, correo);
            st.setString(7, telefono);
            st.setInt(8, id);
            affectedRows = st.executeUpdate();
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
        return affectedRows;
    }
    
    public static ResultSet visualizarCliente(int id) {
        List<Cliente> clientes = new ArrayList<>();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT * FROM cliente WHERE id = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, id);
            rs = st.executeQuery();
                        while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setDocIdent(rs.getInt("documento_identificacion"));
                cliente.setNit(rs.getString("nit_cliente"));
                cliente.setNombre(rs.getString("nombre_cliente"));
                cliente.setApellido(rs.getString("apellido_cliente"));
                cliente.setDireccion(rs.getString("direccion_cliente"));
                cliente.setCorreo(rs.getString("correo_cliente"));
                cliente.setTelefono(rs.getString("telefono_cliente"));
                cliente.setFecha(rs.getString("Fecha_registro"));
                clientes.add(cliente);
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
        return rs;
    }
    public static int eliminarCliente(int id) {
    int affectedRows = -1;
    Connection conn = null;
    PreparedStatement st = null;

    try {
        conn = Conexion.getInstance().getConnection();
        String qry = "DELETE FROM cliente WHERE id_cliente = ?";
        st = conn.prepareStatement(qry);
        st.setInt(1, id);
        affectedRows = st.executeUpdate();
    } catch (SQLException | NamingException ex) {
        System.out.println(ex.getMessage());
    } finally {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    return affectedRows;
}
    public static  List<Cliente> visualizarClientes() {
             List<Cliente> clientes = new ArrayList<>();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT * FROM cliente";
            st = conn.prepareStatement(qry);
            rs = st.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setDocIdent(rs.getInt("documento_identificacion"));
                cliente.setNit(rs.getString("nit_cliente"));
                cliente.setNombre(rs.getString("nombre_cliente"));
                cliente.setApellido(rs.getString("apellido_cliente"));
                cliente.setDireccion(rs.getString("direccion_cliente"));
                cliente.setCorreo(rs.getString("correo_cliente"));
                cliente.setTelefono(rs.getString("telefono_cliente"));
                cliente.setFecha(rs.getString("Fecha_registro"));
                clientes.add(cliente);
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
        return clientes;
    }
    
    public static boolean esNitValido(String nit) {
        pt = Pattern.compile("(\\d+)-(\\d|\\w)", Pattern.CASE_INSENSITIVE);
        mt = pt.matcher(nit);
        return mt.find();
    }
    
    public static boolean esCorreoValido(String correo) {
        pt = Pattern.compile("[(^\\d|^\\w)(\\w|\\d|\\D)]{1,64}\\@([a-zA-Z]|[0-9])(\\w)+\\.([a-zA-Z]){2,4}",Pattern.CASE_INSENSITIVE);
        mt = pt.matcher(correo);
        return mt.find();
    }
}

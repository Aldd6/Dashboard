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

public class Cliente {
    
    private static String qry = "";
    private static Connection conn = null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;
    
    private static Pattern pt = null;
    private static Matcher mt = null;
    
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
            qry = "UPDATE cliente(documento_identificacion,nit_cliente,nombre_cliente,apellido_cliente,direccion_cliente,"
                    + "correo_cliente,telefono_cliente) SET documento_identificacion = ?, nit_cliente = ?, nombre_cliente = ?,"
                    + "apellido_cliente = ?, direccion_cliente = ?, correo_cliente = ?, telefono_cliente = ? WHERE id = ?";
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
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT * FROM cliente WHERE id = ?";
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
    
    public static ResultSet visualizarClientes() {
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT * FROM cliente";
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

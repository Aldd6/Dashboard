/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Daniel Aldana (DaS6T)
 */
public class Usuarios {
    
    private static String qry = "";
    private static Connection conn = null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;
    
    public static int crearUsuario(int rolId, int cargoId, String usuario, String contrasenia, String nombres, String apellidos){
        int affectedRows = -1;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "INSERT INTO autenticacion(rol_usuario_id,cargo_usuario_id,usuario,contrasenia,nombre_usuario,apellido_usuario)"
                    +"VALUES (?,?,?,?,?,?)";
            st = conn.prepareStatement(qry);
            st.setInt(1, rolId);
            st.setInt(2, cargoId);
            st.setString(3,usuario);
            st.setString(4, contrasenia);
            st.setString(5, nombres);
            st.setString(6, apellidos);
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
    
    //TODO programar logica de convertir rolId y cargoId de texto en form a int
    public static int modificarUsuario(int id, int rolId, int cargoId, String usuario, String contrasenia, String nombres, String apellidos){
        int affectedRows = -1;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "UPDATE autenticacion(rol_usuario_id,cargo_usuario_id,usuario,contrasenia,nombre_usuario,apellido_usuario) SET"
                    +"rol_usuario_id = ?,cargo_usuario_id = ?,usuario = ?,contrasenia = ?, nombre_usuario = ?,apellido_usuario = ?"
                    +"WHERE id = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, rolId);
            st.setInt(2, cargoId);
            st.setString(3, usuario);
            st.setString(4, contrasenia);
            st.setString(5, nombres);
            st.setString(6, apellidos);
            st.setInt(7, id);
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
    
    public static int eliminarUsuario(int id) {
        int affectedRows = -1;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "UPDATE autenticacion(estado_usuario) SET estado_usuario = ? WHERE id_usuario = ?";
            st = conn.prepareStatement(qry);
            st.setBoolean(1, false);
            st.setInt(2, id);
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
    
    public static ResultSet visualizarUsuarios() {
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT id_usuario,rol,cargo,usuario,nombre_usuario,apellido_usuario,estado_usuario FROM rol_usuario r"
                    + "INNER JOIN autenticacion a ON r.id_rol_usuario = a.rol_usuario_id INNER JOIN cargo_empleado c ON"
                    + "c.id_cargo = a.cargo_usuario_id";
            st = conn.prepareStatement(qry);
            rs = st.executeQuery();
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
        return rs;
    }
    
    public static ResultSet visualizarUsuario(int id) {
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT * FROM autenticacion WHERE id = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, id);
            rs = st.executeQuery();
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
        return rs;
    }
    
    public static boolean usuarioUnico(String usuario) {
        boolean validationKey = false;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT COUNT(*) FROM autenticacion WHERE usuario = ?";
            st = conn.prepareStatement(qry);
            rs = st.executeQuery();
            while(rs.next()) {
                validationKey = rs.getInt(1) == 0;
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
        return validationKey;
    }
}

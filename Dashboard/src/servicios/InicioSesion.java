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
import Session.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

public class InicioSesion {
    
    private static String qry = "";
    private static Connection conn = null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;
    
    private static final boolean ACCESS_GRANTED = true;
    private static final boolean ACCESS_DENIDED = false;
    
    public static boolean validarCredenciales(String usuario, String contrasenia) {
        int validation = 0;
        boolean accessKey;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT COUNT(*) FROM autenticacion a WHERE a.usuario = ? AND a.contrasenia = ? AND a.estado_usuario = ?";
            st = conn.prepareStatement(qry);
            st.setString(1, usuario);
            st.setString(2, contrasenia);
            st.setBoolean(3, true);
            rs = st.executeQuery();
            while(rs.next()) {
                validation = rs.getInt(1);
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
        accessKey = (validation==1) ? ACCESS_GRANTED:ACCESS_DENIDED;
        return accessKey;
    }
    
    public static void cargarSesion(String usuario) {
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT nombre_usuario,cargo FROM cargo_empleado c INNER JOIN autenticacion a ON"
                    + " c.id_cargo = a.cargo_usuario_id WHERE usuario = ?";
            st = conn.prepareStatement(qry);
            st.setString(1, usuario);
            rs = st.executeQuery();
            while(rs.next()) {
                Session.setUsuario(rs.getString("nombre_usuario"), usuario, rs.getString("cargo"));
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
    }
}

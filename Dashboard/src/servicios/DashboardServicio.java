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
import javax.naming.NamingException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Daniel Aldana(DaS6T)
 */
public class DashboardServicio {
    private static String qry = "";
    private static Connection conn = null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;
    
    public static int habitacionesOcupadas() {
        int countResult= -1;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT COUNT(*) FROM habitacion WHERE estado_habitacion = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, 2);
            rs = st.executeQuery();
            while(rs.next()) {
                countResult = rs.getInt(1);
            }
        }catch(NamingException | SQLException ex) {
            ex.printStackTrace();
        }finally {
            try{
                st.close();
                conn.close();
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return countResult;
    }
    
    public static int habitacionesDisponibles() {
        int countResult= -1;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT COUNT(*) FROM habitacion WHERE estado_habitacion = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, 1);
            rs = st.executeQuery();
            while(rs.next()) {
                countResult = rs.getInt(1);
            }
        }catch(NamingException | SQLException ex) {
            ex.printStackTrace();
        }finally {
            try{
                st.close();
                conn.close();
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return countResult;
    }
    
    public static int habitacionesEnMantenimiento() {
        int countResult= -1;
        try {
            conn = Conexion.getInstance().getConnection();
            qry = "SELECT COUNT(*) FROM habitacion WHERE estado_habitacion = ?";
            st = conn.prepareStatement(qry);
            st.setInt(1, 3);
            rs = st.executeQuery();
            while(rs.next()) {
                countResult = rs.getInt(1);
            }
        }catch(NamingException | SQLException ex) {
            ex.printStackTrace();
        }finally {
            try{
                st.close();
                conn.close();
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return countResult;
    }
}

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
import javax.swing.JComboBox;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Daniel Aldana (DaS6T)
 */
public class Usuarios {

    /**
     * @return the estadoUsuario
     */
    public boolean isEstadoUsuario() {
        return estadoUsuario;
    }

    /**
     * @param estadoUsuario the estadoUsuario to set
     */
    public void setEstadoUsuario(boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the qry
     */
    public static String getQry() {
        return qry;
    }

    /**
     * @param aQry the qry to set
     */
    public static void setQry(String aQry) {
        qry = aQry;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the rolUsuario
     */
    public int getRolUsuario() {
        return rolUsuario;
    }

    /**
     * @param rolUsuario the rolUsuario to set
     */
    public void setRolUsuario(int rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    /**
     * @return the cargoUsuario
     */
    public int getCargoUsuario() {
        return cargoUsuario;
    }

    /**
     * @param cargoUsuario the cargoUsuario to set
     */
    public void setCargoUsuario(int cargoUsuario) {
        this.cargoUsuario = cargoUsuario;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public static String qry = "";
    public int idUsuario;
    public int rolUsuario;
    public String rol;
    public int cargoUsuario;
    public String cargo;
    public String usuario;
    public String contrasenia;
    public String nombres;
    public String apellidos;
    public boolean estadoUsuario;
    
    public Usuarios() {
    }
    
    public Usuarios(int idUsuario, int rolUsuario, String rol, int cargoUsuario, String cargo, String usuario, String contrasenia, String nombres, String apellidos, boolean estadoUsuario) {
        this.idUsuario = idUsuario;
        this.rolUsuario = rolUsuario;
        this.rol = rol;
        this.cargoUsuario = cargoUsuario;
        this.cargo = cargo;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.estadoUsuario = estadoUsuario;
    }
    
    public static int crearUsuario(int rolId, int cargoId, String usuario, String contrasenia, String nombres, String apellidos){
        int affectedRows = -1;
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = Conexion.getInstance().getConnection();
            setQry("INSERT INTO autenticacion(rol_usuario_id,cargo_usuario_id,usuario,contrasenia,nombre_usuario,apellido_usuario)"
                    +"VALUES (?,?,?,?,?,?)");
            st = conn.prepareStatement(getQry());
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
    
    public static int modificarUsuario(int id, int rolId, int cargoId, String usuario, String contrasenia, String nombres, String apellidos){
        int affectedRows = -1;
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = Conexion.getInstance().getConnection();
            setQry("UPDATE autenticacion SET rol_usuario_id = ?,cargo_usuario_id = ?,usuario = ?,contrasenia = ?, nombre_usuario = ?,apellido_usuario = ? WHERE id_usuario = ?");
            st = conn.prepareStatement(getQry());
            st.setInt(1, rolId);
            st.setInt(2, cargoId);
            st.setString(3, usuario);
            st.setString(4, contrasenia);
            st.setString(5, nombres);
            st.setString(6, apellidos);
            st.setInt(7, id);
            System.out.println("Consulta SQL: " + st);
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
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = Conexion.getInstance().getConnection();
            setQry("UPDATE autenticacion SET estado_usuario = ? WHERE id_usuario = ?");
            st = conn.prepareStatement(getQry());
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
    
    public static List<Usuarios> visualizarUsuarios() {
        List<Usuarios> usuarios = new ArrayList<>();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getInstance().getConnection();
            setQry("SELECT id_usuario,rol,cargo,usuario,nombre_usuario,apellido_usuario,estado_usuario FROM rol_usuario r "
                    + "INNER JOIN autenticacion a ON r.id_rol_usuario = a.rol_usuario_id INNER JOIN cargo_empleado c ON "
                    + "c.id_cargo = a.cargo_usuario_id ORDER BY id_usuario ASC");
            st = conn.prepareStatement(getQry());
            rs = st.executeQuery();
            while(rs.next()){
                Usuarios usuario = new Usuarios();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setRol(rs.getString("rol"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setNombres(rs.getString("nombre_usuario"));
                usuario.setApellidos(rs.getString("apellido_usuario"));
                usuario.setEstadoUsuario(rs.getBoolean("estado_usuario"));
                usuarios.add(usuario);
            }
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
        return usuarios;
    }
    
    public static Usuarios visualizarUsuario(int id) {
        Usuarios usuario = new Usuarios();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getInstance().getConnection();
            setQry("SELECT rol,cargo,usuario,nombre_usuario,apellido_usuario,contrasenia,estado_usuario FROM rol_usuario r "
                    + "INNER JOIN autenticacion a ON r.id_rol_usuario = a.rol_usuario_id INNER JOIN cargo_empleado c ON "
                    + "c.id_cargo = a.cargo_usuario_id WHERE id_usuario = ?");
            st = conn.prepareStatement(getQry());
            st.setInt(1, id);
            rs = st.executeQuery();
            while(rs.next()) {
                usuario.setIdUsuario(id);
                usuario.setNombres(rs.getString("nombre_usuario"));
                usuario.setApellidos(rs.getString("apellido_usuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasenia(rs.getString("contrasenia"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setRol(rs.getString("rol"));
                usuario.setEstadoUsuario(rs.getBoolean("estado_usuario"));
            }
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
        return usuario;
    }
    
    public static boolean usuarioUnico(String usuario) {
        boolean validationKey = false;
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getInstance().getConnection();
            setQry("SELECT COUNT(*) FROM autenticacion WHERE usuario = ?");
            st = conn.prepareStatement(getQry());
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
    
    public static List<String> getCargos() throws NamingException, SQLException{
        List<String> cargos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getInstance().getConnection();
            setQry("SELECT cargo FROM cargo_empleado");
            st = conn.prepareStatement(getQry());
            rs = st.executeQuery();
            while(rs.next()) {
                cargos.add(rs.getString("cargo"));
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
        return cargos;
    }
    
    public static List<String> getRoles() throws NamingException, SQLException{
        List<String> roles = new ArrayList<>();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getInstance().getConnection();
            setQry("SELECT rol FROM rol_usuario");
            st = conn.prepareStatement(getQry());
            rs = st.executeQuery();
            while(rs.next()) {
                roles.add(rs.getString("rol"));
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
        return roles;
    }
    
    public static void setCargo(int id, JComboBox bx) {
        String cargo = "";
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getInstance().getConnection();
            setQry("SELECT cargo FROM cargo_empleado c INNER JOIN autenticacion a ON"
                    + "c.id_cargo = a.cargo_usuario_id WHERE id_usuario = ?");
            st = conn.prepareStatement(getQry());
            st.setInt(1, id);
            rs = st.executeQuery();
            while(rs.next()) {
                cargo = rs.getString("cargo");
            }
            bx.setSelectedItem((Object)cargo);
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
    
    public static void setRol(int id, JComboBox bx) {
        String rol = "";
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getInstance().getConnection();
            setQry("SELECT rol FROM rol_usuario r INNER JOIN autenticacion a ON"
                    + "r.id_rol_usuario = a.rol_usuario_id WHERE id_usuario = ?");
            st = conn.prepareStatement(getQry());
            rs = st.executeQuery();
            while(rs.next()) {
                rol = rs.getString("rol");
            }
            bx.setSelectedItem((Object)rol);
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
    
    public static int crearCargo(String cargo) {
        Connection conn = null;
        PreparedStatement st = null;
        int affectedRows = -1;
        try{
            conn = Conexion.getInstance().getConnection();
            qry = "INSERT INTO cargo_empleado(cargo) VALUES (?)";
            st = conn.prepareStatement(qry);
            st.setString(1, cargo);
            affectedRows = st.executeUpdate();
        }catch(NamingException | SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                st.close();
                conn.close();
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return affectedRows;
    }
    
    public static int crearRol(String rol) {
        Connection conn = null;
        PreparedStatement st = null;
        int affectedRows = -1;
        try{
            conn = Conexion.getInstance().getConnection();
            qry = "INSERT INTO rol_usuario(rol) VALUES (?)";
            st = conn.prepareStatement(qry);
            st.setString(1, rol);
            affectedRows = st.executeUpdate();
        }catch(NamingException | SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                st.close();
                conn.close();
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return affectedRows;
    }
    
    public static String getContrasenia(int id){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String contrasenia = "";
        try{
            conn = Conexion.getInstance().getConnection();
            setQry("SELECT contrasenia FROM autenticacion WHERE id_usuario = ?");
            st = conn.prepareStatement(qry);
            st.setInt(1, id);
            rs = st.executeQuery();
            while(rs.next()) {
                contrasenia = rs.getString("contrasenia");
            }
        }catch(NamingException | SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                st.close();
                conn.close();
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return contrasenia;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Session;

/**
 *
 * @author Salvador Hernández
 */
public class Session {
    private static String usuario;
    private static String nombre;
    private static String rolUsuario;
    
    public static void setUsuario(String nombre, String usuario, String rolUsuario){
        Session.nombre = nombre;
        Session.usuario = usuario;
        Session.rolUsuario = rolUsuario;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getRolUsuario() {
        return rolUsuario;
    }
    
    
}

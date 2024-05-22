/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Salvador Hernández
 */
public class Conexion {
    
    // Clase constante para que solo haya una istancia de Conexion en toda la aplicación
   private static final Conexion INSTANCE = new Conexion();
   
   // Properties para almacenar los datos de conexion
    private Properties props = new Properties();

    /* Se define un constructor privado para limitar el acceso solo a la clase Conexion
       esto es para que solo los métodos dentro de la clase Conexion puedan acceder y manipular estas propiedades de la conexion
    */
    private Conexion() {
        cargarProperties();
    }

    // Este mmetodo sirve para obtener la unica instancia de la Conexion
    public static Conexion getInstance() {
        return INSTANCE;
    }

    // Este metodo carga las el archivo properties con la configuración
    private void cargarProperties() {
        try (InputStream in = Files.newInputStream(Path.of("D:\\Documentos del SSD\\Documents\\NetBeansProjects\\DashboardRepo\\Dashboard\\src\\conexion\\dbProp.properties"))) {
            props.load(in);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Metodo para obtener una conexion a la base de datos
    public Connection getConnection() throws SQLException, NamingException {
        String dbType = props.getProperty("dbType");

        if (dbType == null) {
            throw new IllegalArgumentException("La propiedad 'dbType' no está definida en el archivo de propiedades.");
        }

        if (dbType.equalsIgnoreCase("JDBC")) {
            return crearConexionJDBC();
        } else if (dbType.equalsIgnoreCase("DataSource")) {
            return createDSConnecion();
        } else {
            throw new IllegalArgumentException("Tipo de conexión no válido en el archivo de propiedades.");
        }
    }

    // Metodo privado para crear la conexion JDBC con la configuración del archivo properties
    private Connection crearConexionJDBC() throws SQLException {
        String hostname = props.getProperty("hostname");
        String port = props.getProperty("port");
        String database = props.getProperty("database");
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + database;
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    
    // Metodo privado para crear la conexion DataSourcer
    private Connection createDSConnecion() throws NamingException, SQLException {
        try {
            Context ctx = new InitialContext();
            String jndi = props.getProperty("jndi");
            DataSource ds = (DataSource) ctx.lookup(jndi);
            return ds.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    } 
}

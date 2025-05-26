/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concesionaria.database;

/**
 *
 * @author LENOVO
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private Connection conexion;

    private String usuario;
    private String clave;
    private String baseDatos;
    private String puerto;
    private String host;
    private String driver;
    private String zonaHoraria;
    private String cotejamiento;

    // Constructor con parámetros
    public ConexionBD(String usuario, String clave, String baseDatos, String puerto, String host) {
        this.usuario = "root";
        this.clave = "root";
        this.baseDatos = "venta_vehiculos_bd";
        this.puerto = "3306";
        this.host = "localhost";
        this.driver = "mysql";  // Driver para MySQL
        this.zonaHoraria = "America/Lima";
        this.cotejamiento = "utf-8";

        // Establecemos la conexión
        this.establecerConexion();
    }

    // Método para establecer la conexión
    private void establecerConexion() {
        String cadenaConexion = "jdbc:" + driver + "://" + host + ":" + puerto + "/" + baseDatos
                + "?serverTimezone=" + zonaHoraria + "&useUnicode=true&characterEncoding=" + cotejamiento + "&useSSL=false";

        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            this.conexion = DriverManager.getConnection(cadenaConexion, usuario, clave);
            System.out.println("Conectado correctamente a la BD");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al conectarse a la base de datos: " + ex.getMessage());
        }
    }

    // Método para obtener la conexión
    public Connection getConexion() {
        return conexion;
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada correctamente");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    // Método principal para realizar pruebas (opcional)
    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD("root", "root", "venta_vehiculos_bd", "3306", "localhost");
        // Puedes usar la conexión aquí para probar consultas
        conexionBD.cerrarConexion();
    }
}

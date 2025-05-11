/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concesionaria.dao;
import concesionaria.database.ConexionBD;
import concesionaria.entity.Proveedor;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public class ProveedorDAO {
    // Registrar un nuevo proveedor
public boolean registrar(Proveedor proveedor) {
    boolean resultado = false;
    try {
        String sql = "INSERT INTO proveedores(nombre, direccion, email, telefono) VALUES (?, ?, ?, ?)";
        ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        stmt.setString(1, proveedor.getNombre());
        stmt.setString(2, proveedor.getDireccion());
        stmt.setString(3, proveedor.getEmail());
        stmt.setString(4, proveedor.getTelefono());
        int filas = stmt.executeUpdate();
        resultado = filas > 0;
    } catch (SQLException e) {
        System.out.println("Error al registrar proveedor: " + e.getMessage());
    }
    return resultado;
}

// Actualizar un proveedor existente
public boolean actualizar(Proveedor proveedor) {
    boolean resultado = false;
    try {
        String sql = "UPDATE proveedores SET nombre=?, direccion=?, email=?, telefono=? WHERE id_proveedor=?";
        ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        stmt.setString(1, proveedor.getNombre());
        stmt.setString(2, proveedor.getDireccion());
        stmt.setString(3, proveedor.getEmail());
        stmt.setString(4, proveedor.getTelefono());
        stmt.setInt(5, proveedor.getIdProveedor());
        int filas = stmt.executeUpdate();
        resultado = filas > 0;
    } catch (SQLException e) {
        System.out.println("Error al actualizar proveedor: " + e.getMessage());
    }
    return resultado;
}

// Eliminar un proveedor
public boolean eliminar(Proveedor proveedor) {
    boolean resultado = false;
    try {
        String sql = "DELETE FROM proveedores WHERE id_proveedor=?";
        ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        stmt.setInt(1, proveedor.getIdProveedor());
        int filas = stmt.executeUpdate();
        resultado = filas > 0;
    } catch (SQLException e) {
        System.out.println("Error al eliminar proveedor: " + e.getMessage());
    }
    return resultado;
}

// Listar proveedores por nombre o email
public ArrayList<Proveedor> listar(String busqueda) {
    ArrayList<Proveedor> lista = new ArrayList<>();
    try {
        String sql = "SELECT * FROM proveedores WHERE nombre LIKE ? OR email LIKE ?";
        ConexionBD cnx = new ConexionBD(sql, sql, busqueda, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        String filtro = "%" + busqueda + "%";
        stmt.setString(1, filtro);
        stmt.setString(2, filtro);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Proveedor proveedor = new Proveedor();
            proveedor.setIdProveedor(rs.getInt("id_proveedor"));
            proveedor.setNombre(rs.getString("nombre"));
            proveedor.setDireccion(rs.getString("direccion"));
            proveedor.setEmail(rs.getString("email"));
            proveedor.setTelefono(rs.getString("telefono"));
            lista.add(proveedor);
        }
    } catch (SQLException e) {
        System.out.println("Error al listar proveedores: " + e.getMessage());
    }
    return lista;
}

// Obtener un proveedor por ID
public Proveedor obtener(int id) {
    Proveedor proveedor = null;
    try {
        String sql = "SELECT * FROM proveedores WHERE id_proveedor=?";
        ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            proveedor = new Proveedor();
            proveedor.setIdProveedor(rs.getInt("id_proveedor"));
            proveedor.setNombre(rs.getString("nombre"));
            proveedor.setDireccion(rs.getString("direccion"));
            proveedor.setEmail(rs.getString("email"));
            proveedor.setTelefono(rs.getString("telefono"));
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener proveedor: " + e.getMessage());
    }
    return proveedor;
}

}

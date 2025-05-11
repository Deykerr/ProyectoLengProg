/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concesionaria.dao;
import concesionaria.database.ConexionBD;
import concesionaria.entity.Vehiculo;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public class VehiculoDAO {
    // Registrar nuevo vehículo
public boolean registrar(Vehiculo vehiculo) {
    boolean resultado = false;
    try {
        String sql = "INSERT INTO carros(modelo, marca, precio, anio) VALUES (?, ?, ?, ?)";
        ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        stmt.setString(1, vehiculo.getModelo());
        stmt.setString(2, vehiculo.getMarca());
        stmt.setDouble(3, vehiculo.getPrecio());
        stmt.setInt(4, vehiculo.getAnio());
        resultado = stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Error al registrar vehículo: " + e.getMessage());
    }
    return resultado;
}

// Actualizar datos de vehículo
public boolean actualizar(Vehiculo vehiculo) {
    boolean resultado = false;
    try {
        String sql = "UPDATE carros SET modelo = ?, marca = ?, precio = ?, anio = ? WHERE id_carro = ?";
        ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        stmt.setString(1, vehiculo.getModelo());
        stmt.setString(2, vehiculo.getMarca());
        stmt.setDouble(3, vehiculo.getPrecio());
        stmt.setInt(4, vehiculo.getAnio());
        stmt.setInt(5, vehiculo.getIdVehiculo());
        resultado = stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Error al actualizar vehículo: " + e.getMessage());
    }
    return resultado;
}

// Listar vehículos con filtro por modelo o marca
public ArrayList<Vehiculo> listar(String busqueda) {
    ArrayList<Vehiculo> lista = new ArrayList<>();
    try {
        String sql = "SELECT * FROM carros WHERE modelo LIKE ? OR marca LIKE ?";
        ConexionBD cnx = new ConexionBD(sql, sql, busqueda, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        String filtro = "%" + busqueda + "%";
        stmt.setString(1, filtro);
        stmt.setString(2, filtro);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Vehiculo v = new Vehiculo();
            v.setIdVehiculo(rs.getInt("id_carro"));
            v.setModelo(rs.getString("modelo"));
            v.setMarca(rs.getString("marca"));
            v.setPrecio(rs.getDouble("precio"));
            v.setAnio(rs.getInt("anio"));
            lista.add(v);
        }
    } catch (SQLException e) {
        System.out.println("Error al listar vehículos: " + e.getMessage());
    }
    return lista;
}

// Obtener un vehículo por ID
public Vehiculo obtener(int id) {
    Vehiculo v = null;
    try {
        String sql = "SELECT * FROM carros WHERE id_carro = ?";
        ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            v = new Vehiculo();
            v.setIdVehiculo(rs.getInt("id_carro"));
            v.setModelo(rs.getString("modelo"));
            v.setMarca(rs.getString("marca"));
            v.setPrecio(rs.getDouble("precio"));
            v.setAnio(rs.getInt("anio"));
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener vehículo: " + e.getMessage());
    }
    return v;
}


}

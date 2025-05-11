
package concesionaria.dao;
import concesionaria.database.ConexionBD;
import concesionaria.entity.Cliente;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public class ClienteDAO {
    // Registrar un nuevo cliente
public boolean registrar(Cliente cliente) {
    boolean resultado = false;
    try {
        String sql = "INSERT INTO clientes(nombre, apellido, email, direccion, telefono) VALUES (?, ?, ?, ?, ?)";
        ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        stmt.setString(1, cliente.getNombre());
        stmt.setString(2, cliente.getApellido());
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getDireccion());
        stmt.setString(5, cliente.getTelefono());
        int filas = stmt.executeUpdate();
        resultado = filas > 0;
    } catch (SQLException e) {
        System.out.println("Error al registrar cliente: " + e.getMessage());
    }
    return resultado;
}

// Actualizar un cliente existente
public boolean actualizar(Cliente cliente) {
    boolean resultado = false;
    try {
        String sql = "UPDATE clientes SET nombre=?, apellido=?, email=?, direccion=?, telefono=? WHERE id_cliente=?";
        ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        stmt.setString(1, cliente.getNombre());
        stmt.setString(2, cliente.getApellido());
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getDireccion());
        stmt.setString(5, cliente.getTelefono());
        stmt.setInt(6, cliente.getIdCliente());
        int filas = stmt.executeUpdate();
        resultado = filas > 0;
    } catch (SQLException e) {
        System.out.println("Error al actualizar cliente: " + e.getMessage());
    }
    return resultado;
}

// Eliminar un cliente
public boolean eliminar(Cliente cliente) {
    boolean resultado = false;
    try {
        String sql = "DELETE FROM clientes WHERE id_cliente=?";
        ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        stmt.setInt(1, cliente.getIdCliente());
        int filas = stmt.executeUpdate();
        resultado = filas > 0;
    } catch (SQLException e) {
        System.out.println("Error al eliminar cliente: " + e.getMessage());
    }
    return resultado;
}

// Listar clientes por nombre, apellido o email
public ArrayList<Cliente> listar(String busqueda) {
    ArrayList<Cliente> lista = new ArrayList<>();
    try {
        String sql = "SELECT * FROM clientes WHERE nombre LIKE ? OR apellido LIKE ? OR email LIKE ?";
        ConexionBD cnx = new ConexionBD(sql, sql, busqueda, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        String filtro = "%" + busqueda + "%";
        stmt.setString(1, filtro);
        stmt.setString(2, filtro);
        stmt.setString(3, filtro);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("id_cliente"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido(rs.getString("apellido"));
            cliente.setEmail(rs.getString("email"));
            cliente.setDireccion(rs.getString("direccion"));
            cliente.setTelefono(rs.getString("telefono"));
            lista.add(cliente);
        }
    } catch (SQLException e) {
        System.out.println("Error al listar clientes: " + e.getMessage());
    }
    return lista;
}

// Obtener un cliente por ID
public Cliente obtener(int id) {
    Cliente cliente = null;
    try {
        String sql = "SELECT * FROM clientes WHERE id_cliente=?";
        ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("id_cliente"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido(rs.getString("apellido"));
            cliente.setEmail(rs.getString("email"));
            cliente.setDireccion(rs.getString("direccion"));
            cliente.setTelefono(rs.getString("telefono"));
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener cliente: " + e.getMessage());
    }
    return cliente;
}

}

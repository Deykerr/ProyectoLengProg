
package concesionaria.dao;
import concesionaria.database.ConexionBD;
import concesionaria.entity.Inventario;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public class InventarioDAO {
    // Registrar nuevo inventario
public boolean registrar(Inventario inv) {
    boolean resultado = false;
    try {
        String sql = "INSERT INTO inventario(id_vehiculo, id_proveedor, fecha_adquisicion, costo, cantidad) VALUES (?, ?, ?, ?, ?)";
        ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        stmt.setInt(1, inv.getIdVehiculo());
        stmt.setInt(2, inv.getIdProveedor());
        stmt.setDate(3, java.sql.Date.valueOf(inv.getFechaAdquisicion())); // LocalDate
        stmt.setBigDecimal(4, inv.getCosto());
        stmt.setInt(5, inv.getCantidad());
        resultado = stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Error al registrar inventario: " + e.getMessage());
    }
    return resultado;
}

// Actualizar datos del inventario (por ejemplo, cantidad o costo)
public boolean actualizar(Inventario inv) {
    boolean resultado = false;
    try {
        String sql = "UPDATE inventario SET id_carro=?, id_proveedor=?, fecha_adquisicion=?, costo=?, cantidad=? WHERE id_inventario=?";
        ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        stmt.setInt(1, inv.getIdVehiculo());
        stmt.setInt(2, inv.getIdProveedor());
        stmt.setDate(3, Date.valueOf(inv.getFechaAdquisicion()));
        stmt.setBigDecimal(4, inv.getCosto());
        stmt.setInt(5, inv.getCantidad());
        stmt.setInt(6, inv.getIdInventario());
        resultado = stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Error al actualizar inventario: " + e.getMessage());
    }
    return resultado;
}

// Obtener un inventario específico
public Inventario obtener(int idInventario) {
    Inventario inv = null;
    try {
        String sql = "SELECT * FROM inventario WHERE id_inventario = ?";
        ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        stmt.setInt(1, idInventario);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            inv = new Inventario();
            inv.setIdInventario(rs.getInt("id_inventario"));
            inv.setIdVehiculo(rs.getInt("id_carro"));
            inv.setIdProveedor(rs.getInt("id_proveedor"));
            inv.setFechaAdquisicion(rs.getDate("fecha_adquisicion").toLocalDate());
            inv.setCosto(rs.getBigDecimal("costo"));
            inv.setCantidad(rs.getInt("cantidad"));
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener inventario: " + e.getMessage());
    }
    return inv;
}

// Listar todos los inventarios o filtrados por proveedor o vehículo
public ArrayList<Inventario> listar(String filtro) {
    ArrayList<Inventario> lista = new ArrayList<>();
    try {
        String sql = "SELECT * FROM inventario i "
                   + "INNER JOIN proveedores p ON i.id_proveedor = p.id_proveedor "
                   + "INNER JOIN carros c ON i.id_carro = c.id_carro "
                   + "WHERE p.nombre LIKE ? OR c.modelo LIKE ?";
        ConexionBD cnx = new ConexionBD(filtro, sql, sql, filtro, sql);
        Connection bd = cnx.getConexion();
        PreparedStatement stmt = bd.prepareStatement(sql);
        String filtroLike = "%" + filtro + "%";
        stmt.setString(1, filtroLike);
        stmt.setString(2, filtroLike);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Inventario inv = new Inventario();
            inv.setIdInventario(rs.getInt("id_inventario"));
            inv.setIdVehiculo(rs.getInt("id_carro"));
            inv.setIdProveedor(rs.getInt("id_proveedor"));
            inv.setFechaAdquisicion(rs.getDate("fecha_adquisicion").toLocalDate());
            inv.setCosto(rs.getBigDecimal("costo"));
            inv.setCantidad(rs.getInt("cantidad"));
            lista.add(inv);
        }
    } catch (SQLException e) {
        System.out.println("Error al listar inventario: " + e.getMessage());
    }
    return lista;
}

}

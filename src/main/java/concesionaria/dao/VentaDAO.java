
package concesionaria.dao;
import concesionaria.database.ConexionBD;
import concesionaria.entity.Venta;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class VentaDAO {
    // Registrar una nueva venta

    public boolean registrar(Venta venta) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO ventas(id_cliente, id_carro, fecha_venta, metodo_pago, precio_venta) VALUES (?, ?, ?, ?, ?)";
            ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
            Connection bd = cnx.getConexion();
            PreparedStatement stmt = bd.prepareStatement(sql);
            stmt.setInt(1, venta.getIdCliente());
            stmt.setInt(2, venta.getIdVehiculo());
            stmt.setDate(3, Date.valueOf(venta.getFechaVenta())); // java.time.LocalDate
            stmt.setString(4, venta.getMetodoPago());
            stmt.setBigDecimal(5, venta.getPrecioVenta());
            resultado = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar venta: " + e.getMessage());
        }
        return resultado;
    }

// Obtener una venta por su ID
    public Venta obtener(int idVenta) {
        Venta venta = null;
        try {
            String sql = "SELECT * FROM ventas WHERE id_venta = ?";
            ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
            Connection bd = cnx.getConexion();
            PreparedStatement stmt = bd.prepareStatement(sql);
            stmt.setInt(1, idVenta);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                venta = new Venta();
                venta.setIdVenta(rs.getInt("id_venta"));
                venta.setIdCliente(rs.getInt("id_cliente"));
                venta.setIdVehiculo(rs.getInt("id_carro"));
                venta.setFechaVenta(rs.getDate("fecha_venta").toLocalDate());
                venta.setMetodoPago(rs.getString("metodo_pago"));
                venta.setPrecioVenta(rs.getBigDecimal("precio_venta"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener venta: " + e.getMessage());
        }
        return venta;
    }

// Listar ventas con búsqueda por nombre de cliente o método de pago (requiere JOIN si se busca por cliente)
    public ArrayList<Venta> listarPorMetodoPago(String metodo) {
        ArrayList<Venta> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ventas WHERE metodo_pago LIKE ?";
            ConexionBD cnx = new ConexionBD(sql, sql, metodo, metodo, sql);
            Connection bd = cnx.getConexion();
            PreparedStatement stmt = bd.prepareStatement(sql);
            stmt.setString(1, "%" + metodo + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getInt("id_venta"));
                venta.setIdCliente(rs.getInt("id_cliente"));
                venta.setIdVehiculo(rs.getInt("id_carro"));
                venta.setFechaVenta(rs.getDate("fecha_venta").toLocalDate());
                venta.setMetodoPago(rs.getString("metodo_pago"));
                venta.setPrecioVenta(rs.getBigDecimal("precio_venta"));
                lista.add(venta);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar ventas: " + e.getMessage());
        }
        return lista;
    }

}

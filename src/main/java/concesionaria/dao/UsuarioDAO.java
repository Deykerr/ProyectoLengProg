
package concesionaria.dao;

/**
 *
 * @author LENOVO
 */
import concesionaria.database.ConexionBD;
import concesionaria.entity.Usuario;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {

    // Método para registrar un usuario
    public boolean registrar(Usuario oUsuario) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO usuarios(username, password_hash, rol) VALUES(?, ?, ?)";
            ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
            Connection bd = cnx.getConexion();
            PreparedStatement prepararSql = bd.prepareStatement(sql);
            prepararSql.setString(1, oUsuario.getUsername());
            prepararSql.setString(2, oUsuario.getPassword());
            prepararSql.setString(3, oUsuario.getRol());
            Integer filasAfectadas = prepararSql.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario");
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    // Método para actualizar un usuario
    public boolean actualizar(Usuario oUsuario) {
        boolean resultado = false;
        try {
            String sql = "UPDATE usuarios SET username=?, password_hash=?, rol=? WHERE id_usuario=?";
            ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
            Connection bd = cnx.getConexion();
            PreparedStatement prepararSQL = bd.prepareStatement(sql);
            prepararSQL.setString(1, oUsuario.getUsername());
            prepararSQL.setString(2, oUsuario.getPassword());
            prepararSQL.setString(3, oUsuario.getRol());
            prepararSQL.setInt(4, oUsuario.getIdUsuario());
            Integer filasAfectadas = prepararSQL.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario");
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    // Método para eliminar un usuario
    public boolean eliminar(Usuario oUsuario) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM usuarios WHERE id_usuario=?";
            ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
            Connection bd = cnx.getConexion();
            PreparedStatement prepararSQL = bd.prepareStatement(sql);
            prepararSQL.setInt(1, oUsuario.getIdUsuario());
            Integer filasAfectadas = prepararSQL.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario");
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    // Listado/filtro de usuarios
    public ArrayList<Usuario> listar(String busqueda) {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            String sql = "SELECT id_usuario, username, password_hash, rol FROM usuarios WHERE username LIKE ? OR rol LIKE ?";
            ConexionBD cnx = new ConexionBD(sql, sql, busqueda, sql, sql);
            Connection db = cnx.getConexion();
            PreparedStatement prepararSQL = db.prepareStatement(sql);
            prepararSQL.setString(1, "%" + busqueda + "%");
            prepararSQL.setString(2, "%" + busqueda + "%");
            ResultSet resultado = prepararSQL.executeQuery();
            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultado.getInt("id_usuario"));
                usuario.setUsername(resultado.getString("username"));
                usuario.setPassword(resultado.getString("password_hash"));
                usuario.setRol(resultado.getString("rol"));
                lista.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar usuarios");
            System.out.println(e.getMessage());
        }
        return lista;
    }

    // Obtener un usuario específico
    public Usuario obtener(int id) {
        Usuario registro = null;
        try {
            String sql = "SELECT id_usuario, username, password_hash, rol FROM usuarios WHERE id_usuario=?";
            ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
            Connection bd = cnx.getConexion();
            PreparedStatement prepararSQL = bd.prepareStatement(sql);
            prepararSQL.setInt(1, id);
            ResultSet resultado = prepararSQL.executeQuery();
            while (resultado.next()) {
                registro = new Usuario();
                registro.setIdUsuario(resultado.getInt("id_usuario"));
                registro.setUsername(resultado.getString("username"));
                registro.setPassword(resultado.getString("password_hash"));
                registro.setRol(resultado.getString("rol"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener usuario");
            System.out.println(e.getMessage());
        }
        return registro;
    }
}


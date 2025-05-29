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
            //generar consulta 
            String sql = "INSERT INTO usuario(nombre_completo,email,password)" + "VALUES(?,?,?)"; //conectarnos
            ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
            Connection bd = cnx.getConexion();
            PreparedStatement prepararSql = bd.prepareStatement(sql);
            prepararSql.setString(1, oUsuario.getNombre_completo());
            prepararSql.setString(2, oUsuario.getEmail());
            prepararSql.setString(3, oUsuario.getPassword());
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

    //Metodo para actualizar usuario 
    public boolean actualizar(Usuario oUsuario) {
        boolean resultado = false;
        try {
            String sql = "UPDATE usuario SET nombre_completo=?,email=?,password=? WHERE id=?";
            ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
            Connection bd = cnx.getConexion();

            PreparedStatement prepararSQL = bd.prepareCall(sql);
            prepararSQL.setString(1, oUsuario.getNombre_completo());
            prepararSQL.setString(2, oUsuario.getEmail());
            prepararSQL.setString(3, oUsuario.getPassword());
            prepararSQL.setInt(4, oUsuario.getId());
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
            String sql = "DELETE FROM usuario WHERE id=?";
            ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
            Connection bd = cnx.getConexion();
            PreparedStatement prepararSQL = bd.prepareStatement(sql);
            prepararSQL.setInt(1, oUsuario.getId());
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
            String sql = "SELECT id,nombre_completo,email,password FROM usuario WHERE nombre_completo LIKE ?" + " OR email=?";
            ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
            Connection db = cnx.getConexion();
            PreparedStatement prepararSQL = db.prepareStatement(sql);
            prepararSQL.setString(1, "%" + busqueda + "%");
            prepararSQL.setString(2, "%" + busqueda + "%");
            ResultSet resultado = prepararSQL.executeQuery();
            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getInt("id"));
                usuario.setNombre_completo(resultado.getString("nombre_completo"));
                usuario.setPassword(resultado.getString("password"));
                usuario.setEmail(resultado.getString("email"));
                lista.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error al listar");
            System.out.println(e.getMessage());
        }
        return lista;
    }

    // Obtener un usuario específico
    public Usuario obtener(int id) {
        Usuario registro = null;
        try {
            String sql = "SELECT id, nombre_completo, email, password FROM usuario WHERE id=?";
            ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
            Connection bd = cnx.getConexion();
            PreparedStatement prepararSQL = bd.prepareStatement(sql);
            prepararSQL.setInt(1, id);
            ResultSet resultado = prepararSQL.executeQuery();
            while (resultado.next()) {
                registro = new Usuario();
                registro.setId(resultado.getInt("id"));
                registro.setNombre_completo(resultado.getString("nombre_completo"));
                registro.setEmail(resultado.getString("email"));
                registro.setPassword(resultado.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener usuario");
            System.out.println(e.getMessage());
        }
        return registro;
        //usuaruio login
    }

    /*public Usuario login(String email) {
        Usuario registro = null;
        try {
            String sql = "SELECT id, nombre_completo, email, password FROM usuario WHERE LOWER(email)=LOWER(?)";
            ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
            Connection bd = cnx.getConexion();
            PreparedStatement prepararSQL = bd.prepareStatement(sql);
            System.out.println("Email recibido para login: " + email); // Depuración
            prepararSQL.setString(1, email);
            ResultSet resultado = prepararSQL.executeQuery();
            while (resultado.next()) {
                registro = new Usuario();
                registro.setId(resultado.getInt("id"));
                registro.setNombre_completo(resultado.getString("nombre_completo"));
                registro.setEmail(resultado.getString("email"));
                registro.setPassword(resultado.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener usuario");
            System.out.println(e.getMessage());
            e.printStackTrace(); // 
        }
        return registro;
    }*/
    public Usuario verificarEmail(String email) {
        Usuario registro = null;
        try {
            String sql = "SELECT id,nombre_completo,email,password "
                    + "FROM usuario WHERE email=?";
            ConexionBD cnx = new ConexionBD(sql, sql, sql, sql, sql);
            Connection bd = cnx.getConexion();
            PreparedStatement prepararSQL = bd.prepareStatement(sql);
            prepararSQL.setString(1, email);
            ResultSet resultado = prepararSQL.executeQuery();
            //nos devuelve 0 o al menos 1
            while (resultado.next()) {
                registro = new Usuario();
                registro.setId(resultado.getInt("id"));
                registro.setNombre_completo(resultado.getString("nombre_completo"));
                registro.setEmail(resultado.getString("email"));
                registro.setPassword(resultado.getString("password"));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener usuario");
            System.out.println(e.getMessage());
        }
        return registro;
    }
}

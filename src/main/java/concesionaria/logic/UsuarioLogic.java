
package concesionaria.logic;

import concesionaria.dao.UsuarioDAO;
import concesionaria.entity.Usuario;
import java.util.ArrayList;
import org.jasypt.util.password.StrongPasswordEncryptor;
/**
 *
 * @author Lenovo
 */
public class UsuarioLogic {
    
    // Registrar usuario
    public boolean registrar(Usuario oUsuario) {
        String passwordSinEncriptar = oUsuario.getPassword();
        StrongPasswordEncryptor encriptador = new StrongPasswordEncryptor();
        String passwordEncriptada = encriptador.encryptPassword(passwordSinEncriptar);
        oUsuario.setPassword(passwordEncriptada);
        UsuarioDAO oUsuarioDao = new UsuarioDAO();
        return oUsuarioDao.registrar(oUsuario);
    }
    // Actualizar usuario

    public boolean actualizar(Usuario oUsuario) {
        String passwordSinEncriptar = oUsuario.getPassword();
        StrongPasswordEncryptor encriptador = new StrongPasswordEncryptor();
        String passwordEncriptada = encriptador.encryptPassword(passwordSinEncriptar);
        oUsuario.setPassword(passwordEncriptada);
        UsuarioDAO oUsuarioDao = new UsuarioDAO();
        return oUsuarioDao.actualizar(oUsuario);
    }
    // Eliminar usuario

    public boolean eliminar(Usuario oUsuario) {
        UsuarioDAO oUsuarioDao = new UsuarioDAO();
        return oUsuarioDao.eliminar(oUsuario);
    }
    // Listar usuarios

    public ArrayList<Usuario> listar(String busqueda) {
        UsuarioDAO oUsuarioDAO = new UsuarioDAO();
        return oUsuarioDAO.listar(busqueda);
    }
    // Obtener usuario por ID

    public Usuario obtener(Integer id) {
        UsuarioDAO oUsuarioDAO = new UsuarioDAO();
        return oUsuarioDAO.obtener(id);
    }
}

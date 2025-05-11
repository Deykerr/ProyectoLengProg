
package concesionaria.database;

import concesionaria.dao.UsuarioDAO;
import concesionaria.entity.Usuario;
public class Prueba {
    public static void main(String[] args) {
          UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario oUsuario = new Usuario();
        oUsuario.setUsername("Jhon@elp.edu");
        oUsuario.setPassword("12345");
        oUsuario.setRol("vendedor");
        boolean registrado = usuarioDAO.registrar(oUsuario);
        if (registrado) {
            System.out.println("Se registro correctamente");
        } else {
            System.out.println("No se pudo registrar");
        }
    }
    
    
 /*UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario oUsuario = new Usuario();
        oUsuario.setUsername("Manuel Garcia");
        oUsuario.setPassword("1111");
        oUsuario.setRol("gerente");
        oUsuario.setId(1);
        boolean actualizado = usuarioDAO.actualizar(oUsuario);
        if (actualizado) {
            System.out.println("Actualizado correctamente");
        } else {
            System.out.println("Error al actualizar");
        }*/
 /*
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario oUsuario = new Usuario();
        oUsuario.setId(1);
        boolean eliminado = usuarioDAO.eliminar(oUsuario);
        if (eliminado) {
            System.out.println("Eliminado correctamente");
        } else {
            System.out.println("Error al eliminar");
        }*/
}

package concesionaria.database;

import concesionaria.dao.ClienteDAO;
import concesionaria.dao.ProveedorDAO;
import concesionaria.dao.UsuarioDAO;
import concesionaria.dao.VehiculoDAO;
import concesionaria.entity.Cliente;
import concesionaria.entity.Proveedor;
import concesionaria.entity.Usuario;
import concesionaria.entity.Vehiculo;

public class Prueba {

    public static void main(String[] args) {

        /*//Registrar Usuario
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
        }*/

        /*//Registrar cliente
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente oCliente = new Cliente();
        oCliente.setNombre("Carlos");
        oCliente.setApellido("Ramírez");
        oCliente.setEmail("carlos.ramirez@example.com");
        oCliente.setDireccion("Jr. Ayacucho 123");
        oCliente.setTelefono("987654321");

        boolean registrado = clienteDAO.registrar(oCliente);
        if (registrado) {
            System.out.println("Se registró correctamente el cliente");
        } else {
            System.out.println("No se pudo registrar el cliente");
        }*/

        /*//Registrar proveedor
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        Proveedor oProveedor = new Proveedor();
        oProveedor.setNombre("Distribuidora San Pedro");
        oProveedor.setDireccion("Av. Los Andes 456");
        oProveedor.setEmail("contacto@sanpedro.com");
        oProveedor.setTelefono("912345678");

        boolean registrado = proveedorDAO.registrar(oProveedor);
        if (registrado) {
            System.out.println("Se registró correctamente el proveedor");
        } else {
            System.out.println("No se pudo registrar el proveedor");
        }*/

        /*
        //Registrar vehiculo
        VehiculoDAO vehiculoDAO = new VehiculoDAO();
        Vehiculo oVehiculo = new Vehiculo();
        oVehiculo.setModelo("Corolla");
        oVehiculo.setMarca("Toyota");
        oVehiculo.setPrecio(18500.00);
        oVehiculo.setAnio(2022);

        boolean registrado = vehiculoDAO.registrar(oVehiculo);
        if (registrado) {
            System.out.println("Se registró correctamente el vehículo");
        } else {
            System.out.println("No se pudo registrar el vehículo");
        }*/

 /*//Actualizar Usuario
        UsuarioDAO usuarioDAO = new UsuarioDAO();
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
 /*//Eliminar Usuario
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
}

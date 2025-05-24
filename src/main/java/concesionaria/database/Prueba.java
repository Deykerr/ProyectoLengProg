package concesionaria.database;

import concesionaria.dao.ClienteDAO;
import concesionaria.dao.InventarioDAO;
import concesionaria.dao.ProveedorDAO;
import concesionaria.dao.UsuarioDAO;
import concesionaria.dao.VehiculoDAO;
import concesionaria.dao.VentaDAO;
import concesionaria.entity.Cliente;
import concesionaria.entity.Inventario;
import concesionaria.entity.Proveedor;
import concesionaria.entity.Usuario;
import concesionaria.entity.Vehiculo;
import concesionaria.entity.Venta;
import concesionaria.logic.UsuarioLogic;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Prueba {

    public static void main(String[] args) {
        
        UsuarioDAO dao = new UsuarioDAO();

        // --- Prueba 1: Usuario Existente ---
        String emailExistente = "deyker2@elp"; // Asegúrate de que este email exista en tu BD
        System.out.println("\n--- Probando con un usuario existente ---");
        Usuario usuarioEncontrado = dao.login(emailExistente);

        if (usuarioEncontrado != null) {
            System.out.println("¡Login exitoso!");
            System.out.println("Detalles del usuario: " + usuarioEncontrado.toString());
        } else {
            System.out.println("Login fallido para: " + emailExistente + ". Usuario no encontrado.");
        }

        // --- Prueba 2: Usuario No Existente ---
        String emailNoExistente = "noexiste@example.com";
        System.out.println("\n--- Probando con un usuario NO existente ---");
        Usuario usuarioNoEncontrado = dao.login(emailNoExistente);

        if (usuarioNoEncontrado != null) {
            System.out.println("¡Login exitoso (INESPERADO)!");
            System.out.println("Detalles del usuario: " + usuarioNoEncontrado.toString());
        } else {
            System.out.println("Login fallido para: " + emailNoExistente + ". Usuario no encontrado (ESPERADO).");
        }

        // --- Prueba 3: Email con mayúsculas/minúsculas ---
        String emailMixto = "deyKer2@elp"; // Un email existente pero con mayúsculas/minúsculas
        System.out.println("\n--- Probando con email en mayúsculas/minúsculas ---");
        Usuario usuarioMixto = dao.login(emailMixto);

        if (usuarioMixto != null) {
            System.out.println("¡Login exitoso con email mixto!");
            System.out.println("Detalles del usuario: " + usuarioMixto.toString());
        } else {
            System.out.println("Login fallido para: " + emailMixto + ". Usuario no encontrado.");
        }
        
       /*//Registrar Usuario
        UsuarioLogic oUusuarioLogic = new UsuarioLogic();
        Usuario oUsuario = new Usuario();
        oUsuario.setNombre_completo("deyker2");
        oUsuario.setEmail("deyker2@elp");
        oUsuario.setPassword("12345");
        boolean registrado = oUusuarioLogic.registrar(oUsuario);
        if (registrado) {
            System.out.println("Se registro correctamente");
        } else {
            System.out.println("No se pudo registrar");
        }*/
 /*//Registrarcliente
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

 /*//Registro de nuevo inventario

        InventarioDAO inventarioDAO = new InventarioDAO();
        Inventario oInventario = new Inventario();

        oInventario.setIdVehiculo(1);       // ID existente en la tabla vehículos
        oInventario.setIdProveedor(1);      // ID existente en la tabla proveedores

        oInventario.setFechaAdquisicion(LocalDate.of(2025, 5, 11));  // Usando LocalDate
        oInventario.setCosto(new BigDecimal("15000.00"));           // Usando BigDecimal
        oInventario.setCantidad(3);         // Unidades adquiridas

        boolean registrado = inventarioDAO.registrar(oInventario);
        if (registrado) {
            System.out.println("Se registró correctamente el inventario");
        } else {
            System.out.println("No se pudo registrar el inventario");
        }*/
 /*
        //Registrar Ventas
        VentaDAO ventaDAO = new VentaDAO();
        Venta oVenta = new Venta();

//  estos ID ya existen en la base de datos
        oVenta.setIdCliente(1);
        oVenta.setIdVehiculo(1);

        oVenta.setFechaVenta(LocalDate.of(2024, 5, 11)); // Fecha de la venta
        oVenta.setMetodoPago("Tarjeta");                 // Método de pago: efectivo, tarjeta, etc.
        oVenta.setPrecioVenta(new BigDecimal("18500.00")); // Precio de venta

        boolean registrado = ventaDAO.registrar(oVenta);
        if (registrado) {
            System.out.println("Venta registrada correctamente");
        } else {
            System.out.println("No se pudo registrar la venta");
        }*/

/*
        //Actualizar Usuario
        UsuarioLogic usuarioLogic = new UsuarioLogic();
        Usuario oUsuario = new Usuario();
        oUsuario.setNombre_completo("Cristian");
        oUsuario.setEmail("dani@elp");
        oUsuario.setPassword("12345");
        oUsuario.setId(3);
        boolean actualizado = usuarioLogic.actualizar(oUsuario);
        if (actualizado) {
            System.out.println("Actualizado correctamente");
        } else {
            System.out.println("Error al actualizar");
        }*/
       /* //Eliminar Usuario
        UsuarioLogic usuarioLogic = new UsuarioLogic();
        Usuario oUsuario = new Usuario();
        oUsuario.setId(2);
        boolean eliminado = usuarioLogic.eliminar(oUsuario);
        if (eliminado) {
            System.out.println("Eliminado correctamente");
        } else {
            System.out.println("Error al eliminar");
        }*/
    }
}

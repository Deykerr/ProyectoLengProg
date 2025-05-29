/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package concesionaria.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/admin/usuario/*"})
public class UsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /*
        
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
            doGet GET /admin/usuario/            -> cargar la vista principal del modulo de usuario
            doGet GET /admin/usuario/buscar      -> Realizar busqueda en la BD
            doGet GET /admin/usuario/crear       -> Cargar el formulario de creacion de usuario
            doGet GET /admin/usuario/editar/1005 ->cargar el formulario de edicion con los datos actuales
         */
                
        String url = request.getPathInfo();
        System.out.println(url);
        if (url == null || url.equals("/")) {
            //cargar la vista principal del modulo de usuario
            System.out.println("cargar pantalla inicial modulo de usuario");
        } else {
            String[] url_en_partes = url.split("/");
            String accion = url_en_partes[1];
            switch (accion) {
                case "buscar":
                    System.out.println("Realizar busqueda en la base de datos");
                    break;
                case "crear":
                    System.out.println("Cargar formulario de creacion de usuario");
                    break;
                case "editar":
                    Integer id=Integer.parseInt(url_en_partes[2]);
                    System.out.println("Cargar formulario de edicion del usuario con el ID "+url_en_partes);
                    break;
                default:
                    System.out.println("No existe la acción requerida");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

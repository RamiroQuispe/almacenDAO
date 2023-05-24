package com.emergentes.controlador;

import com.emergentes.dao.Producto_dao_implementacion;
import com.emergentes.modelo.DProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.Producto_dao;

/**
 *
 * @author Ramiro
 */
@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            int id;
            DProducto avi = new DProducto();
            Producto_dao dao = new Producto_dao_implementacion();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("productos", avi);
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                    break;

                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    avi = dao.getByid(id);
                    request.setAttribute("productos", avi);
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Inicio");

                    break;
                case "view":
                    List<DProducto> lista = dao.getAll();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("error :" + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Producto_dao dao = new Producto_dao_implementacion();
        
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        String cantidad = request.getParameter("cantidad");
        int precio = Integer.parseInt(request.getParameter("precio"));
        String categoria = request.getParameter("categoria");

        DProducto avi = new DProducto();

        avi.setId(id);
        avi.setDescripcion(descripcion);
        avi.setCantidad(cantidad);
        avi.setPrecio(precio);
        avi.setCategoria(categoria);

        try {
            if (id == 0) {
                dao.insert(avi);

            } else {
                dao.update(avi);
            }
        } catch (Exception ex) {
            System.out.println("ERROR AL GUARDAR DATOS" + ex.getMessage());
        }
        response.sendRedirect("Inicio");
    }
}

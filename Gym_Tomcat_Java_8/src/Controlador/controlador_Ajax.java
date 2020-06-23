package Controlador;

import Modelo.Constructor_recuperar;
import ModeloDAO.Operaciones_recuperar;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "controlador_Ajax", urlPatterns = {"/controlador_Ajax"})
public class controlador_Ajax extends HttpServlet {
    
    Constructor_recuperar rec = new Constructor_recuperar();
    Operaciones_recuperar dao_rec = new Operaciones_recuperar();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        response.setContentType("text/html; charset=iso-8859-1");
        PrintWriter out = response.getWriter();

        String correo = request.getParameter("CorreoAjax");

        rec.setCorreo(correo);

        if (dao_rec.enviar(rec)) {

            dao_rec.cambiar(rec);

            out.println("<div class='alert alert-success alert-dismissible fade show' role='alert'>");
            out.println("La contraseña de recuperación se ha enviado satisfactoriamente al correo " + correo);


        } else {

            out.println("<div class='alert alert-danger alert-dismissible fade show' role='alert'>");
            out.println("La cuenta de correo " + correo + " no es correcta");


        }
        out.print("<button type='button' class='close' data-dismiss='alert' aria-label='Close'>");
        out.print("<span aria-hidden='true'>&times;</span>");
        out.print("</button>");
        out.print("</div>");
    }

}

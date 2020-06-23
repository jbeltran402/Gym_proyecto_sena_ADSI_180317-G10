package Controlador;

import Modelo.Constructor_Login;
import ModeloDAO.Operaciones_login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Controlador_Login")
public class Controlador_Login extends HttpServlet {

    Constructor_Login log = new Constructor_Login();
    Operaciones_login oper_log = new Operaciones_login();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesion = request.getSession();

        response.setContentType("text/html; charset=iso-8859-1");
        PrintWriter out = response.getWriter();

        int nivel = 0;
        int Doc = Integer.parseInt(request.getParameter("txtusuario"));
        String con = request.getParameter("txtcontra");

        log.setUsuario(Doc);
        log.setContrasena(con);

        nivel = oper_log.validar(log);

        if (nivel == 1) {

            sesion.setAttribute("nivel", nivel);
            sesion.setAttribute("nombre", log.getNombre());
            sesion.setAttribute("documento", Doc);
            out.println("<script>$(window).attr('location','../usuario.jsp');</script>");

        } else if (nivel == 2) {

            sesion.setAttribute("nivel", nivel);
            sesion.setAttribute("nombre", log.getNombre());
            sesion.setAttribute("documento", Doc);
            out.println("<script>$(window).attr('location','../administrador.jsp');</script>");

        } else if (nivel == 3) {

            sesion.setAttribute("nivel", nivel);
            sesion.setAttribute("nombre", log.getNombre());
            sesion.setAttribute("documento", Doc);
            out.println("<script>$(window).attr('location','../super_admin.jsp');</script>");

        }else {

            out.println("<div class='alert alert-danger' role='alert'>");
            out.println("El usuario o la contraseña son incorrectos");
            out.print("</div>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

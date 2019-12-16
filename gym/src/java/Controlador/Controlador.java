
package Controlador;

import Modelo.Constructor_Login;
import Modelo.Constructor_Usuarios;
import Modelo.Constructor_recuperar;
import ModeloDAO.Operaciones;
import ModeloDAO.Operaciones_login;
import ModeloDAO.Operaciones_recuperar;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    //MODIFICAR RUTAS.........................
    String listar = "vistas/listar.jsp";
    String listar_admin = "vistas/listar_admin.jsp";
    String add = "vistas/add.jsp";
    String add_admin = "vistas/add_admin.jsp";
    String edit = "vistas/edit.jsp";
    String edit_admin = "vistas/edit_admin.jsp";
    String Login = "vistas/Login.jsp";
    String Recuperar = "vistas/Recuperar_contrasena.jsp";

    //Unificar Constructores..................  
    Constructor_Usuarios p = new Constructor_Usuarios();
    Operaciones dao = new Operaciones();
    Constructor_Login log = new Constructor_Login();
    Operaciones_login oper_log = new Operaciones_login();
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

        String acceso = "";
        String action = request.getParameter("accion");

//___________________Operaciones Super Administrador____________________________//

        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        }else if (action.equalsIgnoreCase("add")) {
            acceso = add;

        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idper", request.getParameter("id"));
            acceso = edit;

        } else if (action.equalsIgnoreCase("eliminar")) {

            int id = Integer.parseInt(request.getParameter("id"));
            p.setDoc(id);
            dao.eliminar(id);
            acceso = listar;
            
        } 
//___________________Operaciones Administrador___________________________________//     
        
        else if (action.equalsIgnoreCase("listar_admin")) {
            acceso = listar_admin;
        
        }else if (action.equalsIgnoreCase("add_admin")) {
            acceso = add_admin;
            
        } else if (action.equalsIgnoreCase("editar_admin")) {
            request.setAttribute("idper", request.getParameter("id"));
            acceso = edit_admin;
        } else if (action.equalsIgnoreCase("eliminar_admin")) {

            int id = Integer.parseInt(request.getParameter("id"));
            p.setDoc(id);
            dao.eliminar_admin(id);
            acceso = listar_admin;
        }
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
            
        }

        @Override
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String acceso = "";
            String action = request.getParameter("accion");

//________________________Operaciones Super Administrador_________________________//        
            if (action.equalsIgnoreCase("Agregar")) {

                int Doc = Integer.parseInt(request.getParameter("txtDocumento"));
                int Rol = Integer.parseInt(request.getParameter("txtRol"));
                String Tipo_Doc = request.getParameter("txtTipo_doc");
                String Nomb_1 = request.getParameter("txtNom1");
                String Nomb_2 = request.getParameter("txtNom2");
                String Apel_1 = request.getParameter("txtApellido");
                String Apel_2 = request.getParameter("txtApe2");
                int Tel = Integer.parseInt(request.getParameter("txtTel"));
                String Correo = request.getParameter("txtCorreo");

                p.setDoc(Doc);
                p.setRol(Rol);
                p.setTipo_doc(Tipo_Doc);
                p.setNomb_1(Nomb_1);
                p.setNomb_2(Nomb_2);
                p.setApel_1(Apel_1);
                p.setApel_2(Apel_2);
                p.setTel(Tel);
                p.setCorreo(Correo);

                dao.add(p);

                acceso = listar;
            } else if (action.equalsIgnoreCase("Actualizar")) {

                int Doc = Integer.parseInt(request.getParameter("txtDocumento"));
                int Rol = Integer.parseInt(request.getParameter("txtRol"));
                String Tipo_Doc = request.getParameter("txtTipo_doc");
                String Nomb_1 = request.getParameter("txtNom1");
                String Nomb_2 = request.getParameter("txtNom2");
                String Apel_1 = request.getParameter("txtApellido");
                String Apel_2 = request.getParameter("txtApe2");
                int Tel = Integer.parseInt(request.getParameter("txtTel"));
                String Correo = request.getParameter("txtCorreo");
                

                int id = Integer.parseInt(request.getParameter("txtId"));

                p.setCambio_doc(Doc);
                p.setRol(Rol);
                p.setTipo_doc(Tipo_Doc);
                p.setNomb_1(Nomb_1);
                p.setNomb_2(Nomb_2);
                p.setApel_1(Apel_1);
                p.setApel_2(Apel_2);
                p.setTel(Tel);
                p.setCorreo(Correo);

                p.setDoc(id);

                dao.edit(p);
                acceso = listar;

            } else if (action.equalsIgnoreCase("Ingresar") && action != null) {

                int nivel = 0;
                int Doc = Integer.parseInt(request.getParameter("txtusuario"));
                String con = request.getParameter("txtcontra");

                log.setUsuario(Doc);
                log.setContrasena(con);

                nivel = oper_log.validar(log);

                request.setAttribute("nivel", nivel);
                request.setAttribute("nombre", Doc);

                acceso = Login;
            }
//_______________________Operaciones Administrador______________________________//            

            if (action.equalsIgnoreCase("Agregar Usuario")) {

                int Doc = Integer.parseInt(request.getParameter("txtDocumento"));
                String Tipo_Doc = request.getParameter("txtTipo_doc");
                String Nomb_1 = request.getParameter("txtNom1");
                String Nomb_2 = request.getParameter("txtNom2");
                String Apel_1 = request.getParameter("txtApellido");
                String Apel_2 = request.getParameter("txtApe2");
                int Tel = Integer.parseInt(request.getParameter("txtTel"));
                String Correo = request.getParameter("txtCorreo");

                p.setDoc(Doc);
                p.setTipo_doc(Tipo_Doc);
                p.setNomb_1(Nomb_1);
                p.setNomb_2(Nomb_2);
                p.setApel_1(Apel_1);
                p.setApel_2(Apel_2);
                p.setTel(Tel);
                p.setCorreo(Correo);

                dao.add_admin(p);

                acceso = listar_admin;
                
            } else if (action.equalsIgnoreCase("Actualizar Usuario")) {

                int Doc = Integer.parseInt(request.getParameter("txtDocumento"));
                String Tipo_Doc = request.getParameter("txtTipo_doc");
                String Nomb_1 = request.getParameter("txtNom1");
                String Nomb_2 = request.getParameter("txtNom2");
                String Apel_1 = request.getParameter("txtApellido");
                String Apel_2 = request.getParameter("txtApe2");
                int Tel = Integer.parseInt(request.getParameter("txtTel"));
                String Correo = request.getParameter("txtCorreo");
                String Contra = request.getParameter("txtContra");

                int id = Integer.parseInt(request.getParameter("txtId"));

                p.setCambio_doc(Doc);
                p.setTipo_doc(Tipo_Doc);
                p.setNomb_1(Nomb_1);
                p.setNomb_2(Nomb_2);
                p.setApel_1(Apel_1);
                p.setApel_2(Apel_2);
                p.setTel(Tel);
                p.setCorreo(Correo);
                p.setContra(Contra);
                p.setDoc(id);

                dao.edit_admin(p);
                acceso = listar_admin;
                
            }
            
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
        }

        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }

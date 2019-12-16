package org.apache.jsp.vistas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Constructor_Usuarios;
import ModeloDAO.Operaciones;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

HttpSession sesion= request.getSession();

if (sesion.getAttribute("nivel")==null) {
    response.sendRedirect("vistas/Login.jsp");
     }else{   
    String nivel = sesion.getAttribute("nivel").toString();
    if (!nivel.equals("3")) {
        response.sendRedirect("vistas/Login.jsp");            
        }
}

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <!--<link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <!-------------------------menú WILMER----------------------------------->\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\" navbar-toggler-icon\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">Planes</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"Controlador?accion=listar\">Usuarios</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">Modificar Info</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">crear administrador</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">...</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">...</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">...</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">...</a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">Mi perfil</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("                <div class=\"dropdown\">\n");
      out.write("\n");
      out.write("                    <a  style=\"color:white\" href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\">Cerrar Sesion</a>    \n");
      out.write("\n");
      out.write("                    <div class=\"dropdown-menu text-center\">\n");
      out.write("                        <a><img src=\"../imagenes/avatar.png\"  heidht=\"80\" width=\"80\"/></a><br>\n");
      out.write("                        <a>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Nombres}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                        <a>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Correo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                        <a href=\"vistas/Login.jsp?cerrar=true\" class=\"dropdown-item\">Salir</a>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>       \n");
      out.write("            </div>\n");
      out.write("        </nav>        \n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"col-lg-6\" style=\"padding-top:2%; margin-bottom: 5%;\">\n");
      out.write("                ");

                    Operaciones dao = new Operaciones();
                    int doc = Integer.parseInt((String) request.getAttribute("idper"));
                    Constructor_Usuarios p = (Constructor_Usuarios) dao.list(doc);
                
      out.write("\n");
      out.write("                <h1> Editar Usuario </h1>\n");
      out.write("                <form method=\"post\" action=\"Controlador\">\n");
      out.write("                    Documento<br>\n");
      out.write("                    <input class=\"form-control\" type=\"text\" name=\"txtDocumento\" value=\"");
      out.print( p.getDoc());
      out.write("\"><br>\n");
      out.write("                    Rol<br>\n");
      out.write("                    <select class=\"form-control\" id=\"exampleFormControlSelect1\"name=\"txtRol\">\n");
      out.write("                        <option value=\"1\">Usuario</option>\n");
      out.write("                        <option value=\"2\">Administrador</option>\n");
      out.write("                    </select><br>\n");
      out.write("                    Tipo de documento<br>\n");
      out.write("                    <select class=\"form-control\" id=\"exampleFormControlSelect1\" name=\"txtTipo_doc\">\n");
      out.write("                        <option value=\"C.C\">Cedula</option>\n");
      out.write("                        <option value=\"T.I\">Tarjeta de identidad</option>\n");
      out.write("                        <option value=\"P.A\">Pasaporte</option>\n");
      out.write("                        <option value=\"C.E\">Cedula de extranjeria</option>\n");
      out.write("                    </select><br>\n");
      out.write("                    Primer nombre<br>\n");
      out.write("                    <input class=\"form-control\" type=\"text\" name=\"txtNom1\" value=\"");
      out.print( p.getNomb_1());
      out.write("\"><br>\n");
      out.write("                    Segundo nombre<br>\n");
      out.write("                    <input class=\"form-control\" type=\"text\" name=\"txtNom2\" value=\"");
      out.print( p.getNomb_2());
      out.write("\"><br>\n");
      out.write("                    Primer apellido<br>\n");
      out.write("                    <input class=\"form-control\" type=\"text\" name=\"txtApellido\" value=\"");
      out.print( p.getApel_1());
      out.write("\"><br>\n");
      out.write("                    Segundo apellido<br>\n");
      out.write("                    <input class=\"form-control\" type=\"text\" name=\"txtApe2\" value=\"");
      out.print( p.getApel_2());
      out.write("\"><br>\n");
      out.write("                    Telefono<br>\n");
      out.write("                    <input class=\"form-control\" type=\"text\" name=\"txtTel\" value=\"");
      out.print( p.getTel());
      out.write("\"><br>\n");
      out.write("                    Correo electronico<br>\n");
      out.write("                    <input class=\"form-control\" type=\"text\" name=\"txtCorreo\" value=\"");
      out.print( p.getCorreo());
      out.write("\"><br>\n");
      out.write("                    <div class=\"alert alert-primary\" role=\"alert\">\n");
      out.write("                        \n");
      out.write("                    <input type=\"checkbox\" name=\"contra\">\n");
      out.write("                    ¿Desea restablecer la contraseña?\n");
      out.write("                    \n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <input class=\"btn btn-primary\" type=\"submit\" name=\"accion\" value=\"Actualizar\">\n");
      out.write("                    <a class=\"btn btn-danger\" href=\"Controlador?accion=listar\" >Regresar</a>                  \n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>                    \n");
      out.write("    </body>\n");
      out.write("       <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("    \n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

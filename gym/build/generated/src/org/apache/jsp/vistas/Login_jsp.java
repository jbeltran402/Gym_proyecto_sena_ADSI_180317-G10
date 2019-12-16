package org.apache.jsp.vistas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Constructor_recuperar;
import Controlador.Controlador;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("\n");

    HttpSession sesion = request.getSession();
    int nivel = 0;
    if (request.getAttribute("nivel") != null) {
        nivel = (Integer) request.getAttribute("nivel");

        if (nivel == 1) {
            sesion.setAttribute("nombre", request.getAttribute("nombre"));
            sesion.setAttribute("nivel", nivel);
            response.sendRedirect("usuario.jsp");
        } else if (nivel == 2) {
            sesion.setAttribute("nombre", request.getAttribute("nombre"));
            sesion.setAttribute("nivel", nivel);
            response.sendRedirect("administrador.jsp");
        } else if (nivel == 3) {
            int doc = (Integer) request.getAttribute("nombre");
            sesion.setAttribute("nombre", doc);
            sesion.setAttribute("nivel", nivel);
            response.sendRedirect("super_admin.jsp");
        }
    }
    if (request.getParameter("cerrar") != null) {

        session.invalidate();
        System.out.println(nivel);
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-latest.js\"></script>\n");
      out.write("\n");
      out.write("        <!--..................................Recuperar contraseña............................-->       \n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('#submit').click(function (event) {\n");
      out.write("\n");
      out.write("                    var correo_rec = $('#correo').val();\n");
      out.write("\n");
      out.write("                    // Si en vez de por post lo queremos \n");
      out.write("                    // hacer por get, cambiamos el $.post por $.get\n");
      out.write("\n");
      out.write("                    $.post('../controlador_Ajax', {\n");
      out.write("\n");
      out.write("                        CorreoAjax: correo_rec\n");
      out.write("\n");
      out.write("                    }, function (responseText) {\n");
      out.write("                        $('#Alert').html(responseText);\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <link href=\"http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <link href=\"../css/Estilos.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700,200\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"https://use.fontawesome.com/releases/v5.0.6/css/all.css\" rel=\"stylesheet\">\n");
      out.write("    <body class=\"login-page sidebar-collapse\">\n");
      out.write("        <nav class=\"navbar navbar-expand-lg bg-primary fixed-top navbar-transparent \" color-on-scroll=\"400\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <ul class=\"navbar-nav\">\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" rel=\"tooltip\" title=\"Pagina de inicio\" data-placement=\"bottom\" href=\"../index.html\" target=\"_blank\">\n");
      out.write("                            <i class=\"fas fa-home\"></i>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    </a>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"page-header clear-filter\" filter-color=\"orange\">\n");
      out.write("            <div class=\"page-header-image\" style=\"background-image:url('https://images4.alphacoders.com/608/608034.jpg')\"></div>\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"col-md-4 ml-auto mr-auto\">\n");
      out.write("                        <div class=\"card card-login card-plain\">\n");
      out.write("                            <!-- formulario -->\n");
      out.write("                            <form class=\"form\" method=\"post\" action=\"../Controlador\">\n");
      out.write("                                <div class=\"card-header text-center\">\n");
      out.write("                                    <div class=\"logo-container\">\n");
      out.write("                                        <img src=\"../img/logo.png\" alt=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"input-group no-border input-lg\">\n");
      out.write("                                        <div class=\"input-group-prepend\">\n");
      out.write("                                            <span class=\"input-group-text\">\n");
      out.write("                                                <i class=\"now-ui-icons users_circle-08\"></i>\n");
      out.write("                                            </span>\n");
      out.write("                                        </div>\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"Documento\" name=\"txtusuario\" required/>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"input-group no-border input-lg\">\n");
      out.write("                                        <div class=\"input-group-prepend\">\n");
      out.write("                                            <span class=\"input-group-text\">\n");
      out.write("                                                <i class=\"now-ui-icons text_caps-small\"></i>\n");
      out.write("                                            </span>\n");
      out.write("                                        </div>\n");
      out.write("                                        <input type=\"password\" placeholder=\"contraseña\" class=\"form-control\" name=\"txtcontra\" required/>\n");
      out.write("                                    </div>\n");
      out.write("                                    <a href=\"javascript:;\" class=\"forget\" data-toggle=\"modal\" data-target=\".forget-modal\">¿Olvidaste tu contraseña?</a>  <!-- recuperar contraseña -->\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"card-footer text-center\">\n");
      out.write("                                    <input type=\"submit\" class=\"btn btn-primary btn-round btn-lg btn-block\" name=\"accion\" value=\"Ingresar\" >\n");
      out.write("                                    </form> \n");
      out.write("                                </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <style type=\"text/css\">\n");
      out.write("                    /*    --------------------------------------------------\n");
      out.write("                        :: Inputs & Buttons\n");
      out.write("                        -------------------------------------------------- */\n");
      out.write("                    .form-control {\n");
      out.write("                        color: #212121;\n");
      out.write("                    }\n");
      out.write("                    .btn-custom {\n");
      out.write("                        color: #fff;\n");
      out.write("                        background-color: rgb(74,92,247);;\n");
      out.write("                    }\n");
      out.write("                    .btn-custom:hover,\n");
      out.write("                    .btn-custom:focus {\n");
      out.write("                        color: #fff;\n");
      out.write("                    }\n");
      out.write("                </style>    \n");
      out.write("\n");
      out.write("                <!--......................formulario recuperar contraseña.................................-->\n");
      out.write("\n");
      out.write("                <div class=\"modal fade forget-modal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myForgetModalLabel\" aria-hidden=\"true\">\n");
      out.write("                    <div class=\"modal-dialog modal-md\">\n");
      out.write("                        <div class=\"modal-content\">\n");
      out.write("                            <div class=\"modal-header\">\n");
      out.write("                                <h4 class=\"modal-title\">Recuperar contraseña</h4>\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\n");
      out.write("                                    <span aria-hidden=\"true\">×</span>\n");
      out.write("                                    <span class=\"sr-only\">Cerrar</span>\n");
      out.write("                                </button>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <form id=\"alert\">\n");
      out.write("                                <div class=\"modal-body\">\n");
      out.write("                                    <p>Ingrese el correo electronico asosiado a la cuenta que desea recuperar la contraseña </p>\n");
      out.write("                                    <input type=\"email\" name=\"Correo\" id=\"correo\" class=\"form-control\" autocomplete=\"off\">\n");
      out.write("                                    <br>\n");
      out.write("                                    <div id=\"Alert\">\n");
      out.write("\n");
      out.write("                                        <!--..... Retorna datos de Ajax .....-->\n");
      out.write("\n");
      out.write("                                    </div>    \n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-footer\">\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cerrar</button>\n");
      out.write("                                    <input type=\"button\" class=\"btn btn-custom\" value=\"Recuperar\" id=\"submit\">\n");
      out.write("                                </div>  \n");
      out.write("                            </form>  \n");
      out.write("                        </div>\n");
      out.write("                    </div> \n");
      out.write("                </div>\n");
      out.write("                </footer>\n");
      out.write("            </div>\n");
      out.write("            <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("            function showPassword() {\n");
      out.write("                var key_attr = $('#key').attr('type');\n");
      out.write("                if (key_attr !== 'text') {\n");
      out.write("                    $('.checkbox').addClass('show');\n");
      out.write("                    $('#key').attr('type', 'text');\n");
      out.write("                } else {\n");
      out.write("                    $('.checkbox').removeClass('show');\n");
      out.write("                    $('#key').attr('type', 'password');\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("</html>");
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

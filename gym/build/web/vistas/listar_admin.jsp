<%@page import="Modelo.Constructor_Usuarios"%>
<%@page import="ModeloDAO.Operaciones"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession sesion = request.getSession();

    if (sesion.getAttribute("nivel") == null) {
        response.sendRedirect("vistas/Login.jsp");
    } else {
        String nivel = sesion.getAttribute("nivel").toString();
        if (!nivel.equals("2")) {
            response.sendRedirect("vistas/Login.jsp");
        }
    }
%>

<!DOCTYPE html>

<html lang="en">
    <head>
        
        <title>Listar</title>
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
          
        <!--<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>-->
        <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>  

        <!-------------------------menú WILMER----------------------------------->



        <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->

       <style type="text/css">
    /*
        Color fondo: #632432;
        Color header: 246355;
        Color borde: 0F362D;
        Color iluminado: 369681;
*/
body{
    background-color: #0069d9;                
    font-family: Arial;
}

#main-container{
    margin: 150px auto;
    width: 600px;
}

table{
    background-color: white;
    text-align: left;
    border-collapse: collapse;
    width: 100%;
}

th, td{
    padding: 20px;
}

thead{
    background-color: #585858;
    border-bottom: solid 5px #0F362D;
    color: white;
}

tr:nth-child(even){
    background-color: #ddd;
}

tr:hover td{
    background-color: #2E64FE;
    color: white;
}




        </style>
    </head>
    <body>
        <br><br>
        <div class="navbar-wrapper">
            <div class="container">
                <div class="navbar navbar-inverse navbar-static-top">

                    <div class="navbar-header">

                        <a class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </a>
                        <a class="navbar-brand" href="#"><img src="img/logo.png" style="width: 83px; position: relative; top:-19px; "/></a>
                    </div>
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="administrador.jsp">Home</a></li>
                            <li><a href="Controlador?accion=listar_admin" target="ext">Usuarios</a></li>

                            <li><a href="">Planes</a></li>

                            <li class="dropdown">
                                <a href="#" class="dropdown-menu-left" data-toggle="dropdown">Opciones<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Modificar Info</a></li>
                                    <li><a href="#">.........</a></li>
                                    <li class="divider"></li>
                                    <li><a href="vistas/Login.jsp?cerrar=true">Cerrar sesion</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>

                </div>
            </div><!-- /container -->
        </div>
        <!------------------------Listar Juan David------------------------------------->

        <div class="container-fluid" style="padding-top: 0.5%; padding-left: 10%; padding-right: 10% ">
            <h1>Personas</h1>
            <a class="btn btn-success " href="Controlador?accion=add_admin">Agregar Nuevo</a>
            <br>
            <br>


            <table>
                <thead>
                    <tr>
                        <th>Documento</th>
                        <th>Tipo Documento</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Telefono</th>
                        <th>Correo</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                    Operaciones dao = new Operaciones();
                    List<Constructor_Usuarios> list = dao.listar_Admin();
                    Iterator<Constructor_Usuarios> iter = list.iterator();
                    Constructor_Usuarios per = null;
                    while (iter.hasNext()) {
                        per = iter.next();
                %>

                <tr>
                    <td ><%= per.getDoc()%></td>
                    <td><%= per.getTipo_doc()%></td>
                    <td><%= per.getNomb_1()%> <%=per.getNomb_2()%></td>
                    <td><%= per.getApel_1()%> <%= per.getApel_2()%></td>
                    <td><%= per.getTel()%></td>
                    <td><%= per.getCorreo()%></td>                        

                    <td>
                        <a class="btn btn-warning" href="Controlador?accion=editar_admin&id=<%= per.getDoc()%>">Editar</a>
                        <a class="btn btn-danger" href="Controlador?accion=eliminar_admin&id=<%= per.getDoc()%>">Eliminar</a>
                    </td>
                </tr>
                <%}%>

            </table>
        </div>

    </body>
</html>

<%@page import="Modelo.Constructor_Servicios"%>
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
        if (!nivel.equals("3")) {
            response.sendRedirect("vistas/Login.jsp");
        }
    }
%>

<!DOCTYPE html>

<html lang="es">
    <head>

        <title>Listar Promociones</title>
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
                            <li class="active"><a href="super_admin.jsp">Home</a></li>                            
                            <li><a href="Controlador?accion=listar" target="ext">Usuarios</a></li>
                            <li><a href="Controlador?accion=servicios" target="ext">Planes</a></li>
                            <li><a href="Controlador?accion=listar_factura" target="ext">Factura</a></li>
                            <li><a href="Controlador?accion=sedes">Sedes</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-menu-left" data-toggle="dropdown">Opciones<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="Controlador?accion=actualizar_SuperAdmin">Mi Perfil</a></li>
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

        <div class="container-fluid" style="padding-top: 0%; padding-left: 10%; padding-right: 10%; padding-bottom: 5%;">
            <center><h1>Promociones</h1></center>

            <form method="post" action="Controlador">
                <div class="form-row">
                    <div class="form-group col-md-9">
                        <a class="btn btn-success " href="Controlador?accion=agregar_promocion" title="Agregar Promoción"><img src="imagenes/add.png" width='65%' height='65%'></a>
                    </div>
                </div>
            </form>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRE</th>
                        <th>PRECIO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                    Operaciones dao = new Operaciones();
                    List<Constructor_Servicios> list = dao.select_combos();
                    Iterator<Constructor_Servicios> iter = list.iterator();
                    Constructor_Servicios ser = null;
                    while (iter.hasNext()) {
                        ser = iter.next();
                        if (ser.getPrecio_combo() != 0) {

                %>
                <tbody>
                    <tr>
                        <td><%= ser.getId_combo() %></td>
                        <td><%= ser.getNombre_combo() %></td>
                        <td><%= ser.getPrecio_combo() %></td>                        

                        <td>
                            <a class="btn btn-warning" href="Controlador?accion=editar_promocion&id=<%= ser.getId_combo() %>"> <img src="imagenes/edit.png" width="80%" height="80%"> </a>                           
                            <a href="Controlador?accion=eliminar_promocion&id=<%= ser.getId_combo() %>" class="btn btn-danger" > <img src='imagenes/drop.png' width='80%' height='80%'> </a>                       
                        </td>
                    </tr>
                    <%}}%>
                </tbody>
            </table>

        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>

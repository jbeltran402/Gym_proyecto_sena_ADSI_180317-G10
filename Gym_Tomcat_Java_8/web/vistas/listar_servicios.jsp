<%@page import="Modelo.Constructor_Servicios"%>
<%@page import="ModeloDAO.Operaciones"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.addHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
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

        <title>Listar Servicios</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <style type="text/css">
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
    <!------------------------ Menu --------------------------------------->

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="padding: 0% 5% 0%;">
        <a class="navbar-brand" href="super_admin.jsp"><img src="img/logo.png" style="width: 83px;"/></a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="Controlador?accion=listar"> Usuarios </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="Controlador?accion=servicios"> Planes </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="Controlador?accion=listar_factura"> Factura </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="Controlador?accion=sedes"> Sedes </a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <svg class="bi bi-person-circle" width="2.5em" height="2.5em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z"/>
                            <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                            <path fill-rule="evenodd" d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z"/>
                        </svg>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                        <center>
                            <h1 class="dropdown-header"><%= sesion.getAttribute("nombre") %></h1>
                            <h1 class="dropdown-header">Super Administrador</h1>
                        </center>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="Controlador?accion=actualizar_SuperAdmin">Mi Perfil</a>
                        <a class="dropdown-item" href="vistas/Login.jsp?cerrar=true">Cerrar Sesión</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
    <!------------------------ Listar ------------------------------------->
    <div style="padding: 2% 5% 5%;">
            <center><h1>Servicios</h1></center>

            <form method="post" action="Controlador">
                <div class="form-row">
                    <div class="form-group col-md-9">
                        <a class="btn btn-success " href="Controlador?accion=agregar_servicio" title="Agregar Promoción"><img src="imagenes/add.png" width='65%' height='65%'></a>
                    </div>
                </div>
            </form>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRE</th>
                        <th>PRECIO</th>
                        <th>DESCRIPCIÓN</th>
                        <th class="col-lg-2"><center>ACCIONES</center></th>
                </tr>
                </thead>
                <%
                    Operaciones dao = new Operaciones();
                    List<Constructor_Servicios> listar = dao.select_servicios();
                    Iterator<Constructor_Servicios> iter_2 = listar.iterator();
                    Constructor_Servicios ser_2 = null;
                    while (iter_2.hasNext()) {
                        ser_2 = iter_2.next();

                %>
                <tbody>
                    <tr>
                        <td><%= ser_2.getId_servicio()%></td>
                        <td><%= ser_2.getServicios()%></td>
                        <td><%= ser_2.getPrecio_servicio()%></td>
                        <td><%= ser_2.getDescripcion()%></td>
                        <td>
                <center>
                    <a class="btn btn-warning" href="Controlador?accion=editar_servicio&id=<%= ser_2.getId_servicio()%>"> <img src="imagenes/edit.png" width="80%" height="80%"> </a>                           
                    <a href="Controlador?accion=eliminar_servicio&id=<%= ser_2.getId_servicio()%>" class="btn btn-danger" > <img src='imagenes/drop.png' width='80%' height='80%'> </a>                       
                </center>        
                </td>
                </tr>
                <%}%>
                </tbody>
            </table>

        </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

    </body>
</html>

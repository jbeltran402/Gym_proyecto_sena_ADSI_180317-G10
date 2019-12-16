<%@page import="Modelo.Constructor_Usuarios"%>
<%@page import="ModeloDAO.Operaciones"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
HttpSession sesion= request.getSession();

if (sesion.getAttribute("nivel")== null) {
    response.sendRedirect("Login.jsp");
     }else{   
    String nivel = sesion.getAttribute("nivel").toString();
    if (!nivel.equals("3")) {
        response.sendRedirect("vistas/Login.jsp");            
        }
}
%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar</title>
        <!--<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body>
        <!-------------------------menú WILMER----------------------------------->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">


                    <li class="nav-item dropdown">
                        <a class=" navbar-toggler-icon" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Planes</a>
                            <a class="dropdown-item" href="Controlador?accion=listar">Usuarios</a>
                            <a class="dropdown-item" href="#">Modificar Info</a>
                            <a class="dropdown-item" href="#">crear administrador</a>
                            <a class="dropdown-item" href="#">...</a>
                            <a class="dropdown-item" href="#">...</a>
                            <a class="dropdown-item" href="#">...</a>
                            <a class="dropdown-item" href="#">...</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Mi perfil</a>
                        </div>
                    </li>

                </ul>
                <div class="dropdown">

                    <a  style="color:white" href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Cerrar Sesion</a>    

                    <div class="dropdown-menu text-center">
                        <a><img src="../imagenes/avatar.png"  heidht="80" width="80"/></a><br>
                        <a><%= session.getAttribute("nombre") %></a>
                        <a>${Correo}</a>
                        <div class="dropdown-divider"></div>
                        <a href="vistas/Login.jsp?cerrar=true" class="dropdown-item">Salir</a>

                    </div>
                </div>       
            </div>
        </nav>

        <!------------------------Listar Juan David------------------------------------->

        <div class="container-fluid" style="padding-top: 2%; padding-left: 10%; padding-right: 10% ">
            <h1><center>Usuarios </center></h1>
            <a class="btn btn-success " href="Controlador?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th class="text-center">Documento</th>
                        <th class="text-center">Tipo Documento</th>
                        <th class="text-center">Rol</th>
                        <th class="text-center">Nombres</th>
                        <th class="text-center">Apellidos</th>
                        <th class="text-center">Telefono</th>
                        <th class="text-center">Correo</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    Operaciones dao = new Operaciones();
                    List<Constructor_Usuarios> list = dao.listar();
                    Iterator<Constructor_Usuarios> iter = list.iterator();
                    Constructor_Usuarios per = null;
                    while (iter.hasNext()) {
                        per = iter.next();
                        String roles = "";
                        if (per.getRol() == 1) {
                            roles = "Usuario";
                        } else if (per.getRol() == 2) {
                            roles = "Administrador";
                        } else if (per.getRol() == 3) {
                            roles = "Super administrador";
                        }
                %>
                <tbody>
                    <tr>
                        <td class="table-secondary text-center"><%= per.getDoc()%></td>
                        <td class="table-secondary text-center"><%= per.getTipo_doc()%></td>
                        <td class="table-secondary text-center"><%= roles%></td>
                        <td class="table-secondary text-center"><%= per.getNomb_1()%> <%=per.getNomb_2()%></td>
                        <td class="table-secondary text-center"><%= per.getApel_1()%> <%= per.getApel_2()%></td>
                        <td class="table-secondary text-center"><%= per.getTel()%></td>
                        <td class="table-secondary text-center"><%= per.getCorreo()%></td>                        

                        <td class="table-secondary text-center">
                            <a class="btn btn-warning" href="Controlador?accion=editar&id=<%= per.getDoc()%>">Editar</a>                           
                            
                            <a class="btn btn-danger" href="Controlador?accion=eliminar&id=<%= per.getDoc()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>

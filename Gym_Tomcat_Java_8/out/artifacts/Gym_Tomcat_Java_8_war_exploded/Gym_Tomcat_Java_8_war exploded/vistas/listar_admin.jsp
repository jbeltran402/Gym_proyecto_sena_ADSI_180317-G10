<%@page import="Modelo.Constructor_Usuarios"%>
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
        if (!nivel.equals("2")) {
            response.sendRedirect("vistas/Login.jsp");
        }
    }
%>

<!DOCTYPE html>

<html lang="es">
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <title>Listar</title>
       
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
          
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
     <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#"><img src="img/logo.png" style="width: 90px; position: "/></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
          <a class="nav-link" href="administrador.jsp" style="font-size: 23px;">Home<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Controlador?accion=listar_admin" style="font-size: 23px;">Usuarios</a>
      </li>
      <li class="nav-item">
      <a class="nav-link" href="Controlador?accion=Listar_Factura_Admin">Factura</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="font-size: 23px;">
          Opciones
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Perfil</a>
          <a class="dropdown-item" href="Controlador?accion=Listar_Factura_Admin">Factura</a>
          <a class="dropdown-item" href="vistas/Login.jsp?cerrar=true">Cerrar sesion</a>
        </div>
      </li>
    </ul>
  </div>
        </nav>
        <!------------------------Listar Juan David------------------------------------->
        <br><br>
        <div class="container-fluid" style="padding-top: 0.5%; padding-left: 10%; padding-right: 10%; padding-bottom: 5%;">
            <center> <h1>Usuarios</h1> </center>
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

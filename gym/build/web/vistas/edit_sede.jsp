<%@page import="Modelo.Constructor_Sedes"%>
<%@page import="ModeloDAO.Operaciones"%>
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

<!--..................................... Revisar cambiar documento no mayor a 10 digitos.................................................-->
<!--..................................... 27/11/2019 .................................................-->
<!--..................................... 27/11/2019 Funcionamiento Aceptable .................................................-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/style.css">
        <style>
            .colrr {

                background-color: #0069d9;                
            }
        </style>
    </head>
    <body  class="colrr">
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
                        <a>${Nombres}</a>
                        <a>${Correo}</a>
                        <div class="dropdown-divider"></div>
                        <a href="vistas/Login.jsp?cerrar=true" class="dropdown-item">Salir</a>

                    </div>
                </div>       
            </div>
        </nav>        

        <!-------------------------menú WILMER----------------------------------->                
                        
        <div class="container">
            <div class="container">
                <div class="col-lg-6" style="padding-top:2%; margin-bottom: 5%;">
                    <%
                        Operaciones dao = new Operaciones();
                        int id = Integer.parseInt((String) request.getAttribute("idsede"));
                        Constructor_Sedes sed = (Constructor_Sedes) dao.list_sedes(id);
                    %>

                <h1>Agregar sede</h1>
                
                <form method="post" action="Controlador">
                    
                    <input type="hidden" value="<%= sed.getId()%>" name="Id">
                    Nombre de la sede<br>
                    <input class="form-control" type="text" name="nombre" value="<%= sed.getNombre() %>" required><br>
                    Dirección de la sede<br>
                    <input class="form-control" type="text" name="Direccion" value="<%= sed.getDireccion() %>" required><br>
                    Barrio<br>
                    <select class="form-control" id="exampleFormControlSelect1" name="barrio">
                        <option value="20">Bosa piamonte</option>
                        <option value="30">Carvajal</option>
                        <option value="40">Los Olivos</option>
                    </select><br>
                    
                    <input class="btn btn-success" type="submit" name="accion" value="Editar Sede">
                    <a class="btn btn-danger" href="Controlador?accion=sedes">Regresar</a>
                </form>
            </div>
        </div>
        <img src="img/logo.png" width="400" height="300" style="position: relative; left: 60%; bottom: 300px;">
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</html>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Constructor_Servicios"%>
<%@page import="java.util.List"%>
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

<!--..................................... Revisar funcionamiento .................................................-->
<!--..................................... Revisar enlaces.........................................................-->
<!--..................................... 27/11/2019 .............................................................-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Promociones y servicios </title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/style.css">
        <style>
            .colrr {
                color: white;
                background-color: #0069d9;                
            }
        </style>
    </head>
    <body  class="colrr">
        <!-------------------------Menú WILMER----------------------------------->

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">


                    <li class="nav-item dropdown">
                        <a class=" navbar-toggler-icon" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="super_admin.jsp">Home</a>
                            <a class="dropdown-item" href="Controlador?accion=listar">Usuarios</a>
                            <a class="dropdown-item" href="#">Planes</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">crear administrador</a>
                        </div>
                    </li>

                </ul>
                <div class="dropdown">

                    <a  style="color:white" href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Cerrar Sesion</a>    

                    <div class="dropdown-menu text-center">
                        <a><img src="../imagenes/avatar.png"  heidht="80" width="80"/></a><br>
                        <a> <%= sesion.getAttribute("nombre")%> </a>
                        <a>${Correo}</a>
                        <div class="dropdown-divider"></div>
                        <a href="vistas/Login.jsp?cerrar=true" class="dropdown-item">Salir</a>

                    </div>
                </div>       
            </div>
        </nav>

        <!------------------------Agregar Juan David------------------------------------->        
        <div class="container">
            <div class="col-lg-7">
                <br>
                <h1>Promociones y servicios</h1>

                <form method="post" action="Controlador">

                    Nombre promoción<br>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <a href="Controlador?accion=listar_promociones" class="btn btn-warning" title="Listar Promociones"><img src="imagenes/lista.png" width="90%" height="90%" ></a>
                        </div>
                        <select class="form-control" name="txtPromociones">
                            <%
                                Operaciones dao = new Operaciones();
                                List<Constructor_Servicios> list = dao.select_combos();
                                Iterator<Constructor_Servicios> iter = list.iterator();
                                Constructor_Servicios ser = null;
                                while (iter.hasNext()) {
                                    ser = iter.next();
                                    if(ser.getPrecio_combo()!= 0){
                            %>
                                    
                                    <option value="<%= ser.getId_combo() %>"> <%= ser.getNombre_combo() %></option>
                            <%}}%>
                        </select>

                    </div>

                    Precio del combo<br>
                    <input class="form-control" class="colrr" type="number" name="txtNom1" disabled=""><br>        

                    Nombre servicio <br>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <a href="Controlador?accion=listar_servicios" class="btn btn-warning" title="Listar Servicios"><img src="imagenes/lista.png" width="90%" height="90%" ></a>
                        </div>
                        <select class="form-control" name="txtServicio">
                            <%
                                List<Constructor_Servicios> listar = dao.select_servicios();
                                Iterator<Constructor_Servicios> iter_2 = listar.iterator();
                                Constructor_Servicios ser_2 = null;
                                
                                while (iter_2.hasNext()) {
                                    ser_2 = iter_2.next();
                            %>
                                    
                            <option value="<%= ser_2.getId_servicio()%>" title="<%= ser_2.getDescripcion()%>"> <%= ser_2.getServicios()%> </option>
                            
                            <%}%>
                        </select>
                    </div>        

                    Precio del combo<br>
                    <input class="form-control" class="colrr" type="number" name="txtNom1" disabled=""><br>

                    <input class="btn btn-success" type="submit" name="accion" value="Agregar Paquete">
                    <a class="btn btn-danger" href="Controlador?accion=servicios">Regresar</a>
                </form>            
            </div>
        </div>
        <img src="img/logo.png" width="400" height="300" style="position: relative; left: 60%; bottom: 300px;">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
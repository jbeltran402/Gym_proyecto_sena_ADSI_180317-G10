<%@page import="Modelo.Constructor_Sedes"%>
<%@page import="Modelo.Constructor_factura"%>
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
        if (!nivel.equals("2")) {
            response.sendRedirect("vistas/Login.jsp");
        }
    }

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Factura</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <style type="text/css">
            body{
                background-color: #0069d9;
                font-family: Arial;
            }
        </style>
    </head>
    <body>

    <!------------------------ Menu --------------------------------------->

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="padding: 0% 5% 0%;">
        <a class="navbar-brand" href="administrador.jsp"><img src="img/logo.png" style="width: 83px;"/></a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="Controlador?accion=listar_admin"> Usuarios </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="Controlador?accion=Listar_Factura_Admin"> Factura </a>
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
                            <h1 class="dropdown-header">Administrador</h1>
                        </center>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="Controlador?accion=actualizar_datos_admin">Mi Perfil</a>
                        <a class="dropdown-item" href="vistas/Login.jsp?cerrar=true">Cerrar Sesión</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>

    <!------------------------ Formulario ------------------------------------->

    <div class="container" style="padding-bottom: 2%">
        <div class="col-lg-6">
            <br>
            <h1>Agregar Factura</h1>

            <form method="post" action="Controlador">

                <br>Documento Usuario<br>
                <input class="form-control" type="number" name="docuusu" required><br>
                Nombre Sede<br>
                <select class="form-control" id="exampleFormControlSelect1" name="idsede" id="sede">
                    <%
                        Operaciones daoo = new Operaciones();
                        List<Constructor_Sedes> lista = daoo.select_Sedes();
                        Iterator<Constructor_Sedes> itera = lista.iterator();
                        Constructor_Sedes sed = null;
                        while (itera.hasNext()) {
                            sed = itera.next();
                    %>
                    <option value="<%= sed.getId() %>"><%= sed.getNombre() %></option>
                    <%}%>
                </select><br>
                Documento Del vendedor<br>
                <input type="number" class="form-control" value="<%= sesion.getAttribute("documento")%>" name="docuvend" readonly=""><br>
                Compra combo<br>
                <select class="form-control" name="txtPromociones" id="Combos" onchange="habilitar(this.value);">

                    <option value="0" title="Solo seleccione esta opción si escoge un servicio."> Sin combo </option>

                    <%
                        Operaciones dao = new Operaciones();
                        List<Constructor_Servicios> list = dao.select_combos();
                        Iterator<Constructor_Servicios> iter = list.iterator();
                        Constructor_Servicios ser = null;
                        while (iter.hasNext()) {
                            ser = iter.next();
                            if (ser.getPrecio_combo() != 0) {
                    %>

                    <option value="<%= ser.getId_combo()%>"> <%= ser.getNombre_combo()%></option>
                    <%}
                    }%>
                </select><br>
                Compra servicio<br>
                <select class="form-control" name="txtServicio" id="Servicios" onchange="habilitar_combos(this.value)">

                    <option value="0" title="Solo seleccione esta opción si escoge un combo."> Sin servicio </option>

                    <%
                        List<Constructor_Servicios> listar = dao.select_servicios();
                        Iterator<Constructor_Servicios> iter_2 = listar.iterator();
                        Constructor_Servicios ser_2 = null;

                        while (iter_2.hasNext()) {
                            ser_2 = iter_2.next();
                    %>

                    <option value="<%= ser_2.getId_servicio()%>" title="<%= ser_2.getDescripcion()%>"> <%= ser_2.getServicios()%> </option>

                    <%}%>
                </select><br>
                Forma De Pago<br>
                <select class="form-control" name="formapago">
                    <option value="tarjeta">tarjeta</option>
                    <option value="efectivo">efectivo</option>
                </select><br>
                Meses A Pagar<br>
                <input class="form-control" class="colrr" type="number" name="mespago"><br>

                <input class="btn btn-success" type="submit" name="accion" value="Agregar factura">
          <a class="btn btn-danger" href="Controlador?accion=listar_factura_admin">Regresar</a>
            </form>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <script>
        function habilitar(value)
        {
            if(value === "0" || value === true)
            {
                document.getElementById("Servicios").disabled=false;
            }
            else if (value !== "0" || value === false)
            {
                document.getElementById("Servicios").disabled=true;
            }
        }

        function habilitar_combos(value)
        {
            var a;
            if(value === "0" || value === true) {
                document.getElementById("Combos").disabled=false;
                a = "false";
            }else if (value !== "0" || value === false)
            {
                document.getElementById("Combos").disabled=true;
                a = "true";
            }
        }
    </script>
    </body>

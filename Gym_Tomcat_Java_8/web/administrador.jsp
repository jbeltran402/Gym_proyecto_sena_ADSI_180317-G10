
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.addHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%
HttpSession sesion= request.getSession();

if (sesion.getAttribute("nivel")==null) {
    response.sendRedirect("vistas/Login.jsp");
     }else{

    String nivel = sesion.getAttribute("nivel").toString();
    if (!nivel.equals("2")) {
        response.sendRedirect("vistas/Login.jsp");
        }
}
%>

<!DOCTYPE html>

<html lang="es">
<head>
    <meta charset="utf-8">
    <title>Inicio-Administrador</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
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
<!------------------------ carrusel --------------------------------------->

<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
        <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="img/breadcrumb-bg.jpg" class="d-block w-100">
            <div class="carousel-caption d-none d-md-block">
                <h1>Bienvenido Administrador</h1>
                <p></p><br><br>
            </div>
        </div>
        <div class="carousel-item">
            <img src="img/footer-bg.jpg" style="height: 370px" class="d-block w-100">
            <div class="carousel-caption d-none d-md-block">
                <h1>Bienvenido Administrador</h1>
                <p></p><br><br>
            </div>
        </div>
        <div class="carousel-item">
            <img src="img/elements/element-bg.jpg" class="d-block w-100">
            <div class="carousel-caption d-none d-md-block">
                <h1>Bienvenido Administrador</h1>
                <p></p><br><br>
            </div>
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<!------------------------ texto e imagenes --------------------------------------->

<div class="container marketing" style="margin-top: 2%;">
    <div class="row">
        <div class="col-md-4 text-center">
            <img class="img-circle" src="img/features/feature-1.jpg">
            <h2>AMBIENTES AGRADABLES</h2>
            <p>El ambiente de nuestras son muy agradables para realizar varias actividades fisicas.</p>
        </div>
        <div class="col-md-4 text-center">
            <img class="img-circle" src="img/features/feature-2.jpg">
            <h2>ENTRENADORES CALIFICADOS</h2>
            <p>Los entrenadores que se encuentran en nuestras sedes son calificados y saben que entrenamiento es idoneo para cada cliente.
            </p>
        </div>
        <div class="col-md-4 text-center">
            <img class="img-circle" src="img/features/feature-3.jpg">
            <h2>NUTRICION</h2>
            <p>En cada sede se encuentran instructores con conocimientos en nutricion. Esto para brindar al usuario un mejor resultado en sus entrenamientos.</p>

        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</body>
</html>
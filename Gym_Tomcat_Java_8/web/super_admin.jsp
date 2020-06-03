<%-- 
    Document   : usuario
    Created on : 13/11/2019, 08:32:16 AM
    Author     : APRENDIZ
--%>

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
    if (!nivel.equals("3")) {
        response.sendRedirect("vistas/Login.jsp");            
        }
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>Inicio-Super-Administrador</title>
     <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/estilos_logeado.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">

    </style>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
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
</div><!-- /navbar wrapper -->


<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-interval="false">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="item active">
        <img src="img/breadcrumb-bg.jpg"  class="img-responsive" >
      <div class="container">
        <div class="carousel-caption">
          <h1>Bienvenido Super Administrador</h1>
        
  <!--        <p><a class="btn btn-lg btn-primary" href="http://getbootstrap.com">Learn More</a>        </p>
-->
<p></p><br><br>
        </div>
      </div>
    </div>
    <div class="item">
        <img src="img/footer-bg.jpg" class="img-responsive" >
      <div class="container">
        <div class="carousel-caption">
            <h1>Bienvenido Super Administrador</h1>
        
  <!--        <p><a class="btn btn-lg btn-primary" href="http://getbootstrap.com">Learn More</a>        </p>
--><p></p><br><br>
        </div>
      </div>
    </div>
    <div class="item">
        <img src="img/elements/element-bg.jpg" class="img-responsive">
      <div class="container">
        <div class="carousel-caption">
           <h1>Bienvenido Super Administrador</h1>
        
  <!--        <p><a class="btn btn-lg btn-primary" href="http://getbootstrap.com">Learn More</a>        </p>
--><p></p><br><br>
        </div>
      </div>
    </div>
  </div>
  <!-- Controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="icon-prev"></span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="icon-next"></span>
  </a>  
</div>
<!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

  <!-- Three columns of text below the carousel -->
  <div class="row">
    <div class="col-md-4 text-center">
      <img class="img-circle" src="img/features/feature-1.jpg">
      <h2>AMBIENTES AGRADABLES</h2>
      <p>El ambiente de nuestras son muy agradables para realizar varias actividades fisicas.</p>
    <!--   <p><a class="btn btn-default" href="#">Ver detalles</a></p>-->
    </div>
    <div class="col-md-4 text-center">
      <img class="img-circle" src="img/features/feature-2.jpg">
      <h2>ENTRENADORES CALIFICADOS</h2>
      <p>Los entrenadores que se encuentran en nuestras sedes son calificados y saben que entrenamiento es idoneo para cada cliente.
</p>
  <!--    <p><a class="btn btn-default" href="#">Ver detalles</a></p>-->
    </div>
    <div class="col-md-4 text-center">
      <img class="img-circle" src="img/features/feature-3.jpg">
      <h2>NUTRICION</h2>
      <p>En cada sede se encuentran instructores con conocimientos en nutricion. Esto para brindar al usuario un mejor resultado en sus entrenamientos.</p>
 <!--      <p><a class="btn btn-default" href="#">Ver detalles</a></p>-->       
    </div>
  </div><!-- /.row -->


  


  <!-- FOOTER -->
 

</div><!-- /.container -->
<script type="text/javascript">

</script>
</body>
</html>

<%@page import="Modelo.Constructor_recuperar"%>
<%@page import="Controlador.Controlador"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>

<%
response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.addHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>

<%
    HttpSession sesion = request.getSession();
    if (request.getParameter("cerrar") != null) {
        sesion.invalidate();
    }
%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login</title>
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/Estilos.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    </head>
    <body class="login-page sidebar-collapse">
        <nav class="navbar navbar-expand-lg bg-primary fixed-top navbar-transparent " color-on-scroll="400">
            <div class="container">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" rel="tooltip" title="Pagina de inicio" data-placement="bottom" href="../index.html" target="_blank">
                            <i class="fas fa-home"></i>
                        </a>
                    </li>
                    </a>
                </ul>
            </div>
        </nav>
        <div class="page-header clear-filter" filter-color="orange">
            <div class="page-header-image" style="background-image:url('../imagenes/Login.jpg')"></div>
            <div class="content">
                <div class="container">
                    <div class="col-md-4 ml-auto mr-auto">
                        <div class="card card-login card-plain">

                            <!---------------------------------- formulario Login-------------------------------------->
                                <div class="card-header text-center">
                                    <div class="logo-container">
                                        <img src="../img/logo.png" alt="">
                                    </div>
                                </div>

                                <div class="card-body">
                                    <div id="Error">

                                    </div>
                                    <div class="input-group no-border input-lg">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="now-ui-icons users_circle-08"></i>
                                            </span>
                                        </div>
                                        <input type="text" class="form-control" placeholder="Documento" id="txtusuario" required/>
                                    </div>
                                    <div class="input-group no-border input-lg">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="now-ui-icons text_caps-small"></i>
                                            </span>
                                        </div>
                                        <input type="password" placeholder="contraseña" class="form-control" id="txtcontra" required/>
                                    </div>
                                    <a href="javascript:;" class="forget" data-toggle="modal" data-target=".forget-modal">¿Olvidaste tu contraseña?</a>  <!-- recuperar contraseña -->
                                </div>
                                <div class="card-footer text-center">
                                    <input type="submit" class="btn btn-primary btn-round btn-lg btn-block" id="ingresar" value="Ingresar">
                                </div>

                            <!--------------------------------- /formulario Login-------------------------------------->

                        </div>
                    </div>
                </div>

                <style type="text/css">
                    /*    --------------------------------------------------
                        :: Inputs & Buttons
                        -------------------------------------------------- */
                    .form-control {
                        color: #212121;
                    }
                    .btn-custom {
                        color: #fff;
                        background-color: rgb(74,92,247);;
                    }
                    .btn-custom:hover,
                    .btn-custom:focus {
                        color: #fff;
                    }
                </style>    

                <!--......................formulario recuperar contraseña.................................-->

                <div class="modal fade forget-modal" tabindex="-1" role="dialog" aria-labelledby="myForgetModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-md">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Recuperar contraseña</h4>
                                <button type="button" class="close" data-dismiss="modal">
                                    <span aria-hidden="true">×</span>
                                    <span class="sr-only">Cerrar</span>
                                </button>
                            </div>

                            <form>
                                <div class="modal-body">
                                    <p>Ingrese el correo electronico asosiado a la cuenta que desea recuperar la contraseña </p>
                                    <input type="email" name="Correo" id="correo" class="form-control" autocomplete="off">
                                    <br>
                                    <div id="Alert">

                                        <!--..... Retorna datos de Ajax .....-->

                                    </div>    
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                    <input type="button" class="btn btn-custom" value="Recuperar" id="submit">
                                </div>  
                            </form>  
                        </div>
                    </div> 
                </div>
                </footer>
            </div>
        </div>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="../js/Login.js"></script>

    </body>
</html>

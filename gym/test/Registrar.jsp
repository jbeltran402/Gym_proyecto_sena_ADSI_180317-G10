<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>Login Page - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
    
    <link href="../css/Estilos.css" rel="stylesheet" type="text/css"/>
    
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>
<body>
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
<body class="login-page sidebar-collapse">
    <div id="preloder">
        <div class="loader"></div>
    </div>
  <nav class="navbar navbar-expand-lg bg-primary fixed-top navbar-transparent " color-on-scroll="400">
    <div class="container">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" rel="tooltip" title="Pagina de inicio" data-placement="bottom" href="inicio.php" target="_blank">
              <i class="fas fa-home"></i>
            </a>
          </li>
         </a>
        </ul>
    </div>
  </nav>
  <div class="page-header clear-filter" filter-color="orange">
    <div class="page-header-image" style="background-image:url('https://images4.alphacoders.com/608/608034.jpg')"></div>
    <div class="content">
      <div class="container">
        <div class="col-md-4 ml-auto mr-auto">
          <div class="card card-login card-plain" style="margin-top: -30%;">
            <form class="form" method="post" action="registrar.php">
              <div class="card-header text-center">
                <div class="logo-container">
                  <img src="img/logo.png" alt="">
                </div>
              </div>
                <div class="card-body">
                              <!-- -->
                  <div class="form-group">
                        <select class="form-control" name="rol" required/>
                          <option value="" style="background: black;" disabled selected>Rol</option>
                          <option value="2" style="background: black;">Usuario</option>
                          <option value="1" style="background: black;">Administrador</option>
                          <option value="3" style="background: black;">Super Administrador</option>
                        </select>
                  </div>
                <!-- -->
                  <div class="form-group">
                        <select class="form-control" id="exampleFormControlSelect1" name="tipodoc" required/>  
                          <option value="" style="background: black;" disabled selected>Tipo de documento</option>
                          <option value="c.c" style="background: black;">Cedula de ciudadania</option>
                          <option value="t.i" style="background: black;">Targeta de identidad</option>
                          <option value="c.e" style="background: black;">Cédula de Extranjería</option>
                          <option value="p.a" style="background: black;">Pasaporte</option>
                        </select>
                  </div>
              
                <div class="input-group no-border input-lg">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="now-ui-icons users_circle-08"></i>
                    </span>
                  </div>
                  <input type="text" class="form-control" placeholder="Documento" name="documento" required/>
                </div>
                <div class="input-group no-border input-lg">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="now-ui-icons users_circle-08"></i>
                    </span>
                  </div>
                  <input type="text" class="form-control" placeholder="Primer nombre" name="nombre1" required/>
                </div>
                <div class="input-group no-border input-lg">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="now-ui-icons users_circle-08"></i>
                    </span>
                  </div>
                  <input type="text" placeholder="Segundo nombre" class="form-control" name="nombre2" required/>
                </div>
                <div class="input-group no-border input-lg">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="now-ui-icons users_circle-08"></i>
                    </span>
                  </div>
                  <input type="text" class="form-control" placeholder="Primer apellido" name="apellido1" required/>
                </div>
                <div class="input-group no-border input-lg">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="now-ui-icons users_circle-08"></i>
                    </span>
                  </div>
                  <input type="text" class="form-control" placeholder="Segundo apellido" name="apellido2" required/>
                </div>
                <div class="input-group no-border input-lg">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="now-ui-icons users_circle-08"></i>
                    </span>
                  </div>
                  <input type="text" class="form-control" placeholder="Telefono" name="telefono" required/>
                </div>
                <div class="input-group no-border input-lg">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="now-ui-icons users_circle-08"></i>
                    </span>
                  </div>
                  <input type="text" class="form-control" placeholder="Correo" name="correo" required/>
                </div>
                <div class="input-group no-border input-lg">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="now-ui-icons text_caps-small"></i>
                    </span>
                  </div>
                  <input type="password" class="form-control" placeholder="Contraseña" name="contrasena" required/>
                </div>
              </div>
              <div class="card-footer text-center">
                <input type="submit" class="btn btn-primary btn-round btn-lg btn-block" value="Registrar">
             
                <div class="pull-left">
                  <br>  
            </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <footer class="footer">

    </footer>
  </div>
  <!--   Core JS Files   -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>


</body>


<script type="text/javascript">

</script>
</body>
</html>

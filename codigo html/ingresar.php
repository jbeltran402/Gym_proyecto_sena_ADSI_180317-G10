<?php 
  include "operaciones.php";

   $usu=$_POST["usuario"];
   $con=$_POST["contrasena"];
   $rol=$_POST["rol"];
     
      $log = new BaseDatos();
      	$log->setRegistrar($usu,$con,$rol); 
      	$log->conectar();  
      	$log->Consultar();


?>
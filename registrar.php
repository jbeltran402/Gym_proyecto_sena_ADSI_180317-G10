<?php 

include "operaciones.php";

$documento=$_POST["documento"];
$rol=$_POST["rol"];
$tipodoc=$_POST["tipodoc"];
$nombre1=$_POST["nombre1"];
$nombre2=$_POST["nombre2"];
$apellido1=$_POST["apellido1"];
$apellido2=$_POST["apellido2"];
$telefono=$_POST["telefono"];
$correo=$_POST["correo"];
$contrasena=$_POST["contrasena"];
     
$log = new BaseDatos();
$log->setRegistrarUsuarios($documento, $rol, $tipodoc, $nombre1, $nombre2, $apellido1, $apellido2, $telefono, $correo, $contrasena); 
$log->conectar();  
$log->Registrar();
      	
?>
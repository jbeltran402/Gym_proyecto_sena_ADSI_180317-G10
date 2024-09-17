<?php 
class BaseDatos
  {
    /* LOGEO */
    public $usuario;
    public $contrasena;
    public $rol;
  	public $conexion;
  	public $db;
    public $usu;
    public $pas;
    /* REGISTRAR */
    public $rdocumento;
    public $rrol;
    public $rtipodoc;
    public $rnombreuno;
    public $rnombredos;
    public $rapellidouno;
    public $rapellidodos;
    public $rtelefono;
    public $rcorreo;
    public $rcontrasena;

    /* RECIBIR E INICIALIZAR LOGUEO */
    public function setRegistrar($usu,$con,$rol)
    {
      $this->usuario=$usu;
      $this->contrasena=$con;
      $this->rol=$rol;
    }
    /* CONECTAR A BASE DE DATOS */
    public function conectar()
  	{
  	  $this->conexion=mysqli_connect("localhost","root","");
  	    if ($this->conexion) {
  	    	$this->db=mysqli_select_db($this->conexion,"proyecto");
  	    	if ($this->db) {
  	    		//echo "conexion a base de datos OK"."<br>";
  	    		return $this->db;
  	    	}else{
  	    		//echo "Error en BD"."<br>";
  	    	}
  	    //echo "Error en conexion Mysql"."<br>";
  	    }

  	}
    /* LOGEAR */
  	public function Consultar()
  	{
  	  $consultar="select * from usuario where contrasena= '$this->contrasena'  and  doc_usuario='$this->usuario'";   
        $ingreso=mysqli_query($this->conexion,$consultar);
          $res=mysqli_fetch_assoc($ingreso);
      $this->usu=$res['doc_usuario'];
      $this->pas=$res['contrasena'];

      if ($res) {
        echo "<h1>Ingreso Exitoso</h1>";
        echo "<hr>";
        echo "<h5><strong>USUARIO: </strong></h5>".$this->usu;
        echo "<h5><strong>CONTRASEÑA: </strong></h5>".$this->pas;
        echo "<hr>";
        echo "<h4><strong>Usuarios Registrados</strong></h4>";
        /*if ($this->usuario==$this->usu and $this->contrasena==$this->pas) {
          echo "bienvenido";
        } else {
          echo'<script type="text/javascript">
          alert("no te conozco");
          window.location.href="login.html";
          </script>';
        }*/
      } else {
        echo'<script type="text/javascript">
          alert("Datos erroneos");
          window.location.href="login.html";
          </script>';
      }

    }
    /* RECIBIR E INICIALIZAR REGISTRAR */
    public function setRegistrarUsuarios($documento, $rol, $tipodoc, $nombreuno, $nombredos, $apellidouno, $apellidodos, $telefono, $correo, $contrasena)
    {
      $this->rdocumento=$documento;
      $this->rrol=$rol;
      $this->rtipodoc=$tipodoc;
      $this->rnombreuno=$nombreuno;
      $this->rnombredos=$nombredos;
      $this->rapellidouno=$apellidouno;
      $this->rapellidodos=$apellidodos;
      $this->rtelefono=$telefono;
      $this->rcorreo=$correo;
      $this->rcontrasena=$contrasena;
    }
    /* REGISTRAR */
    public function Registrar()
    {
      $passencript=md5($this->rcontrasena);
        echo $passencript."<br>";
      $query="INSERT into usuario values ($this->rdocumento, $this->rrol, '$this->rtipodoc', '$this->rnombreuno', '$this->rnombredos', '$this->rapellidouno', '$this->rapellidodos', $this->rtelefono, '$this->rcorreo', '$passencript')";
      $resultado=mysqli_query($this->conexion, $query);

      if ($resultado) {
        echo "se han guardado los datos correctamente";
      } else {
        echo "no se han podido guardar los datos correctamente, porfavor intente de nuevo";
      }

    }

}
?>
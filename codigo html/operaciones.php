<?php 
class BaseDatos
  {
    public $usuario;
    public $contrasena;
    public $rol;
  	public $conexion;
  	public $db;
  	public $bandera=1;
    public $ingreso;
    public $usu;
    public $pas;

    public function setRegistrar($usu,$con,$rol)
    {
      $this->usuario=$usu;
      $this->contrasena=$con;
      $this->rol=$rol;
    }
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
  	public function Consultar()
  	{
  		   // echo $this->usuario."<br>";
           // echo $this->contrasena."<br>";
           // echo $this->rol."<br>";

  	 //8$consultar="select * from usuario where contrasena= '$this->contrasena'  and  doc_usuario=$this->usuario;";   
         //echo $consultar;

        $this->ingreso=mysqli_query($this->conexion,"select * from usuario where doc_usuario=$this->usuario and contrasena='$this->contrasena';");
	        #$res=mysqli_fetch_assoc($ingreso);

        $fila=mysqli_fetch_assoc($this->ingreso);
        $this->usu=$fila['doc_usuario'];
        $this->pas=$fila['contrasena'];
        
    if ($this->usuario==$this->usu  and $this->contrasena==$this->pas)
    {

    echo "<h1>Ingreso Exitoso</h1>";
          echo "<hr>";
          echo "<h5><strong>USUARIO: </strong></h5>".$usu;
          echo "<h5><strong>CONTRASEÑA: </strong></h5>".$pas;
          echo "<hr>";
          echo "<h4><strong>Usuarios Registrados</strong></h4>";
    } else {
      /*echo'<script type="text/javascript">
        alert("Tarea Guardada");
        window.location.href="login.html";
        </script>';*/
    }


	        /*if ($res) {

	        	echo "consulta exitosa";
	        	#header('Location: productos.php');
	        	
	        }else{
	        	echo "no se pudo realizar la consulta";
	        }*/
	    
	     /*   
	        while ($res=mysqli_fetch_assoc($ingreso)) {

        if ($this->bandera==1) {  

            //echo $res['doc_usu']."<br>";
            //echo $res['clave']."<br>";
            //echo $res['id_rol_id']."<br>";

  		if ($this->rol==1) {

	  		if($res['doc_usu']==$this->usuario and $res['clave']==$this->contrasena and $res['id_rol_id']==$this->rol)
	      {
	         	echo "El ingreso fue sasticfatorio"."<br>";
		        echo $res['doc_usu']."<br>";
	            echo $res['clave']."<br>";
	            echo $res['id_rol_id']."<br>";
	              $this->bandera=0;
	        //header('Location: productos.php');
	      } else 
	      {
	           echo "Datos erroneos vuelva a ingresar"."<br>"; 
	      }
  			
  		}elseif ($this->rol==2) {

  			if($res['doc_usu']==$this->usuario and $res['clave']==$this->contrasena and $res['id_rol_id']==$this->rol)
	      {
	         echo "El ingreso fue sasticfatorio"."<br>";
	         	echo $res['doc_usu']."<br>";
	            echo $res['clave']."<br>";
	            echo $res['id_rol_id']."<br>";
	              $this->bandera=0;
	          //header('Location: productos.php');
	      } else 
	      {
	           echo "Datos erroneos vuelva a ingresar"."<br>"; 
	      }
  			
  		}elseif ($this->rol==3) {

  			if($res['doc_usu']==$this->usuario and $res['clave']==$this->contrasena and $res['id_rol_id']==$this->rol)
	      {
	         echo "El ingreso fue sasticfatorio"."<br>";
	         	echo $res['doc_usu']."<br>";
	            echo $res['clave']."<br>";
	            echo $res['id_rol_id']."<br>";
	              $this->bandera=0;
	          //header('Location: productos.php');
	      } else 
	      {
	           echo "Datos erroneos vuelva a ingresar"."<br>"; 
	      }

          }
  			
  		}
	  }    
          */
    }
}
?>
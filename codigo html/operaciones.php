<?php 
class BaseDatos
  {
    public $usuario;
    public $contrasena;
    public $rol;
  	public $conexion;
  	public $db;
  	public $bandera=1;

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
  	    	$this->db=mysqli_select_db($this->conexion,"gimnasio");
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

  	  $consultar="select * from usuario where doc_usu = '$this->usuario' and clave = '$this->contrasena' and id_rol_id = '$this->rol';";   
         //echo $consultar;
        $ingreso=mysqli_query($this->conexion,$consultar);
	        $res=mysqli_fetch_assoc($ingreso);

	        if ($res) {

	        	echo "consulta exitosa";
	        	header('Location: productos.php');
	        	
	        }else{
	        	echo "no se pudo realizar la consulta";
	        }
	    
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
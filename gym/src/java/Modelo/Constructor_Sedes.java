
package Modelo;

public class Constructor_Sedes {

    String nombre="";
    String direccion="";
    String barrio="";
    String localidad="";    
    int id= 0;
    
    public Constructor_Sedes() {
    
    }
    public Constructor_Sedes(String nombre , String direccion , String barrio , String localidad , int id) {
    
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.barrio = barrio;
        this.localidad = localidad;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }   
}

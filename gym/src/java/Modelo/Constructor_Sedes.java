
package Modelo;

public class Constructor_Sedes {

    String nombre="";
    String direccion="";
    String barrio="";
    String localidad="";
    int cod_barrio = 0;
    int cod_localidad = 0;    
    int id= 0;
    
    public Constructor_Sedes() {
    
    }
    public Constructor_Sedes(int cod_barrio , int cod_localidad , String nombre , String direccion , String barrio , String localidad , int id) {
    
        this.cod_barrio = cod_barrio;
        this.cod_localidad = cod_localidad;
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.barrio = barrio;
        this.localidad = localidad;
        
    }

    public int getCod_barrio() {
        return cod_barrio;
    }

    public void setCod_barrio(int cod_barrio) {
        this.cod_barrio = cod_barrio;
    }

    public int getCod_localidad() {
        return cod_localidad;
    }

    public void setCod_localidad(int cod_localidad) {
        this.cod_localidad = cod_localidad;
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

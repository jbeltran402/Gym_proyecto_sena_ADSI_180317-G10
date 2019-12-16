package Modelo;

public class Constructor_Servicios {

    int id = 0;
    int precio_combinado = 0;
    int precio_combo = 0;
    int precio_servicio = 0;
    int id_combo = 0;
    int id_servicio = 0;
    String nombre_combo = "";
    String servicios = "";
    String descripcion = "";

    public Constructor_Servicios() {

    }

    public Constructor_Servicios(String descripcion , int id, int id_combo, int id_servicio, int precio_combinado, int precio_combo, int precio_servicio, String nombre_combo, String servicios) {

        this.id = id;
        this.nombre_combo = nombre_combo;
        this.precio_combinado = precio_combinado;
        this.precio_combo = precio_combo;
        this.precio_servicio = precio_servicio;
        this.servicios = servicios;
        this.id_combo = id_combo;
        this.id_servicio = id_servicio;
        this.descripcion = descripcion;

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_combo() {
        return id_combo;
    }

    public void setId_combo(int id_combo) {
        this.id_combo = id_combo;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio_combinado() {
        return precio_combinado;
    }

    public void setPrecio_combinado(int precio_combinado) {
        this.precio_combinado = precio_combinado;
    }

    public int getPrecio_combo() {
        return precio_combo;
    }

    public void setPrecio_combo(int precio_combo) {
        this.precio_combo = precio_combo;
    }

    public int getPrecio_servicio() {
        return precio_servicio;
    }

    public void setPrecio_servicio(int precio_servicio) {
        this.precio_servicio = precio_servicio;
    }

    public String getNombre_combo() {
        return nombre_combo;
    }

    public void setNombre_combo(String nombre_combo) {
        this.nombre_combo = nombre_combo;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

}

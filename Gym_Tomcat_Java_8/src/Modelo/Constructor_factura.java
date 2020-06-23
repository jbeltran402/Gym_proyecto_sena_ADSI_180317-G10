package Modelo;

public class Constructor_factura {

    int id;
    String nom_usuario;
    int sede;
    String nom_sede;
    int doc_vendedor;
    int doc_usuario;
    String nom_vendedor;
    String compra;
    int codigo_compra;
    String fechafactura;
    String horafactura;
    String formapago;
    String proxpago;
    int mespago;
    int total;
    
    int combo = 0;
    int precio_compra = 0;
    int servicio = 0;
    int toprecio_servicio = 0;
    

    public Constructor_factura() {
    }

    public Constructor_factura(int id, String nom_usuario, int sede, String nom_sede, int doc_vendedor, int doc_usuario, String nom_vendedor, String compra, int codigo_compra, String fechafactura, String horafactura, String formapago, String proxpago, int mespago, int total, int combo, int precio_compra, int servicio, int toprecio_servicio) {
        this.id = id;
        this.nom_usuario = nom_usuario;
        this.sede = sede;
        this.nom_sede = nom_sede;
        this.doc_vendedor = doc_vendedor;
        this.doc_usuario = doc_usuario;
        this.nom_vendedor = nom_vendedor;
        this.compra = compra;
        this.codigo_compra = codigo_compra;
        this.fechafactura = fechafactura;
        this.horafactura = horafactura;
        this.formapago = formapago;
        this.proxpago = proxpago;
        this.mespago = mespago;
        this.total = total;
        this.combo = combo;
        this.precio_compra = precio_compra;
        this.servicio = servicio;
        this.toprecio_servicio = toprecio_servicio;
    }

    public int getCombo() {
        return combo;
    }

    public void setCombo(int combo) {
        this.combo = combo;
    }

    public int getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(int precio_compra) {
        this.precio_compra = precio_compra;
    }

    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }

    public int getToprecio_servicio() {
        return toprecio_servicio;
    }

    public void setToprecio_servicio(int toprecio_servicio) {
        this.toprecio_servicio = toprecio_servicio;
    }
    
    public int getCodigo_compra() {
        return codigo_compra;
    }

    public void setCodigo_compra(int codigo_compra) {
        this.codigo_compra = codigo_compra;
    }

    public int getDoc_usuario() {
        return doc_usuario;
    }

    public void setDoc_usuario(int doc_usuario) {
        this.doc_usuario = doc_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_usuario() {
        return nom_usuario;
    }

    public void setNom_usuario(String nom_usuario) {
        this.nom_usuario = nom_usuario;
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    public String getNom_sede() {
        return nom_sede;
    }

    public void setNom_sede(String nom_sede) {
        this.nom_sede = nom_sede;
    }

    public int getDoc_vendedor() {
        return doc_vendedor;
    }

    public void setDoc_vendedor(int doc_vendedor) {
        this.doc_vendedor = doc_vendedor;
    }

    public String getNom_vendedor() {
        return nom_vendedor;
    }

    public void setNom_vendedor(String nom_vendedor) {
        this.nom_vendedor = nom_vendedor;
    }

    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }

    public String getFechafactura() {
        return fechafactura;
    }

    public void setFechafactura(String fechafactura) {
        this.fechafactura = fechafactura;
    }

    public String getHorafactura() {
        return horafactura;
    }

    public void setHorafactura(String horafactura) {
        this.horafactura = horafactura;
    }

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }

    public String getProxpago() {
        return proxpago;
    }

    public void setProxpago(String proxpago) {
        this.proxpago = proxpago;
    }

    public int getMespago() {
        return mespago;
    }

    public void setMespago(int mespago) {
        this.mespago = mespago;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}

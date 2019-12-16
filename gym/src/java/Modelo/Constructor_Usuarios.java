package Modelo;

public class Constructor_Usuarios {
    int doc;
    int cambio_doc;
    int rol;
    int tel;    
    int estado;
    String tipo_doc;
    String nomb_1;
    String nomb_2;
    String apel_1;
    String apel_2;
    String correo;
    String contra;
    String con;
    

    public Constructor_Usuarios() {

    }

    public Constructor_Usuarios(int doc, int cambio_doc, int rol, String tipo_doc, String nomb_1, String nomb_2, String apel_1, String apel_2, int tel, String correo, String contra, int estado, String restablecer) {
        this.doc = doc;
        this.cambio_doc = cambio_doc;
        this.rol = rol;
        this.tipo_doc = tipo_doc;
        this.nomb_1 = nomb_1;
        this.nomb_2 = nomb_2;
        this.apel_1 = apel_1;
        this.apel_2 = apel_2;
        this.tel = tel;
        this.correo = correo;
        this.contra = contra;
        this.estado = estado;
        this.con = restablecer;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public int getDoc() {
        return doc;
    }

    public void setDoc(int doc) {
        this.doc = doc;
    }

    public int getCambio_doc() {
        return cambio_doc;
    }

    public void setCambio_doc(int cambio_doc) {
        this.cambio_doc = cambio_doc;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public String getNomb_1() {
        return nomb_1;
    }

    public void setNomb_1(String nomb_1) {
        this.nomb_1 = nomb_1;
    }

    public String getNomb_2() {
        return nomb_2;
    }

    public void setNomb_2(String nomb_2) {
        this.nomb_2 = nomb_2;
    }

    public String getApel_1() {
        return apel_1;
    }

    public void setApel_1(String apel_1) {
        this.apel_1 = apel_1;
    }

    public String getApel_2() {
        return apel_2;
    }

    public void setApel_2(String apel_2) {
        this.apel_2 = apel_2;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}

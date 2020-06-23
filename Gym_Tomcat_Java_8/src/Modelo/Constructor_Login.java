package Modelo;

public class Constructor_Login {
    int usuario = 0;
    String nombre = "";
    String contrasena = "";
    int nivel = 0;

    public Constructor_Login() {
    }

    public Constructor_Login(int usuario, String nombre, String contrasena, int nivel) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.nivel = nivel;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
package Modelo;

public class Constructor_Login {
    int usuario=0;
    String contrasena="";
    int nivel=0;

    public Constructor_Login() {
    }
    
    public Constructor_Login(int usuario, String Contrasena, int nivel) {
        
        this.usuario = usuario;
        this.contrasena = Contrasena;   
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.contrasena = Contrasena;
    }       
}

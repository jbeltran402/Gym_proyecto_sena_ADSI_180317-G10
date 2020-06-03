
package Modelo;

public class Constructor_recuperar {
    
    String Correo = "";
    String Correo_rec = "";

    
    public Constructor_recuperar() {
    
    }

    public Constructor_recuperar( String correo , String Correo_rec) {
        
        this.Correo = correo;
        this.Correo_rec = Correo_rec;
    
    }

    public String getCorreo_rec() {
        return Correo_rec;
    }

    public void setCorreo_rec(String Correo_rec) {
        this.Correo_rec = Correo_rec;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }


    
    


    
    
    
    
}

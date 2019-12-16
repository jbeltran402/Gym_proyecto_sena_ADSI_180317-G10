
package Interfaces;

import Modelo.Constructor_Usuarios;
import java.util.List;


public interface Interfaz {
    
    //__________________Operaciones Super Administrador___________________//
    
    public List listar();
    public List buscar(int doc);
    public Constructor_Usuarios list(int doc);
    public boolean add(Constructor_Usuarios per);
    public boolean edit(Constructor_Usuarios per);
    public boolean eliminar(int doc);
    
    //___________________Operaciones Administrador________________________//
    
    public List listar_Admin();
    //public Constructor_Usuarios list(int doc);
    public boolean add_admin(Constructor_Usuarios per);
    public boolean edit_admin(Constructor_Usuarios per);
    public boolean eliminar_admin(int doc); 
    
    //___________________ Operaciones Usuario ________________________//
    
    public boolean edit_usu(Constructor_Usuarios per);
    
    //___________________ Operaciones sedes ________________________//

    public List sedes();

}

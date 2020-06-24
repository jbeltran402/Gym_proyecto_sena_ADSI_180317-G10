
package Interfaces;

import Modelo.Constructor_Sedes;
import Modelo.Constructor_Servicios;
import Modelo.Constructor_Usuarios;
import Modelo.Constructor_factura;
import java.util.List;


public interface Interfaz {
    
    //__________________Operaciones Busquedas___________________//
    
    public List buscar(int doc);
    public List buscar_factura(int doc);
    
    //__________________Operaciones Super Administrador___________________//
    
    public List listar();
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
    public boolean add_sede(Constructor_Sedes sed);
    public Constructor_Sedes list_sedes(int id);
    public boolean actualizar_sede (Constructor_Sedes sed);
    public boolean eliminar_sede(int id); 
    
    
    //___________________ Operaciones factura ________________________//    

    public List listar_factura();
    public boolean add_factura(Constructor_factura fac);
    public boolean eliminar_factura(int id);
    
    //___________________ Operaciones servicios ________________________// 
    
    public List listar_servicios();
    public Constructor_Servicios list_servicios(int id_servicio);
    public Constructor_Servicios list_promocion(int id_combo);
    public boolean add_servicio(Constructor_Servicios ser);
    public boolean add_combo(Constructor_Servicios ser);
    public boolean edit_servicio(Constructor_Servicios ser);
    public boolean edit_promocion(Constructor_Servicios ser);
    public boolean eliminar_combo(int id);
    public boolean eliminar_servicio(int id);
    
    public boolean add_paquete(Constructor_Servicios ser);
    public boolean eliminar_paquete(int id);
    
    //___________________ Select's________________________// 
    public List select_servicios();
    public List select_combos();
    public List select_Sedes();
    
}

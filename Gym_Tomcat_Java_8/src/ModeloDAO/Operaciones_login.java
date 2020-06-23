package ModeloDAO;

import Config.Conexion;
import Config.Encriptado;
import Interfaces.Interfaz_Login;
import Modelo.Constructor_Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Operaciones_login implements Interfaz_Login{

    Encriptado md5 = new Encriptado();
    Conexion cn = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public int validar(Constructor_Login log) {
        
        String con = log.getContrasena();
        int nivel = 0;
        String nombre_1 = "";
        String apellido_1 = "";
        String usuario = "";

        String contrasena_encriptada = md5.getEncriptado(con);
        
        try {
            
            String sql = "SELECT Roles_id_roles , nombre_1 , apellido_1 FROM usuario WHERE doc_usuario ="
                    + log.getUsuario() + " AND contrasena = '" + contrasena_encriptada 
                    + "' AND estado = '1'";
            
            //Prueba de inyeccion sql
            //SELECT Roles_id_roles FROM usuario WHERE doc_usuario ='or''='  AND contrasena = ''or''='' AND estado = '1';
            
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                nivel = rs.getInt(1);
                nombre_1 = rs.getString("nombre_1");
                apellido_1 = rs.getString("apellido_1");
                
            }

            usuario = nombre_1 + " " + apellido_1;
            log.setNombre(usuario);

            conn.close();
            rs.close();
            return nivel;

        } catch (SQLException e) {
            return nivel;
        }
    }
}

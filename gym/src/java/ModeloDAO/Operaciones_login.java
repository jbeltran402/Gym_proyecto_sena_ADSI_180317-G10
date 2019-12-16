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
        String contrasena_encriptada = md5.getEncriptado(con);
        
        try {
            
            String sql = "SELECT Roles_id_roles FROM usuario WHERE doc_usuario =" 
                    + log.getUsuario() + " AND contrasena = '" + contrasena_encriptada 
                    + "' AND estado = '1'";
            
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                nivel = rs.getInt(1);
                
            }
            conn.close();
            rs.close();
            return nivel;

        } catch (SQLException e) {
            return nivel;
        }
    }
}

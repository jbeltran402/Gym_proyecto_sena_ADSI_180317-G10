package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection conn;
   
    public Connection conectar() {
        
        conn = null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto","root","");
            
            //System.out.println("conexion satisfactoria");
                
        } catch (ClassNotFoundException | SQLException e) {
        
            //System.err.println("Conexion erronea");
            
        }
     return conn;
    }    
}

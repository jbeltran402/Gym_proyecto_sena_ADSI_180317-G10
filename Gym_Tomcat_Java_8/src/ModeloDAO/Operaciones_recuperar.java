package ModeloDAO;

import Config.Conexion;
import Config.Encriptado;
import java.sql.*;
import Modelo.Constructor_recuperar;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Operaciones_recuperar implements Interfaces.Interfaz_Recuperar {

    Conexion con = new Conexion();
    Encriptado md5 = new Encriptado();
    Constructor_recuperar rec = new Constructor_recuperar();

    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public boolean enviar(Constructor_recuperar rec) {
        try{

            String sql = "select correo from usuario where correo = '"+ rec.getCorreo() +"'";
            String consulta = "";
            conn = con.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                consulta = rs.getString("correo");
            }
            if (consulta.equals(rec.getCorreo())){
                return true;
            }else{
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean cambiar(Constructor_recuperar rec) {
        try {

            String va = "";
            Random numletra = new Random();
            String letras = "a1bc3d4f5g6h7i8j9k0lmnopqrstuvwxyz";

            byte posletra = (byte) numletra.nextInt(letras.length() - 1);
            char ra = letras.charAt(posletra);
            byte posletra1 = (byte) numletra.nextInt(letras.length() - 1);
            char ra1 = letras.charAt(posletra1);
            byte posletra2 = (byte) numletra.nextInt(letras.length() - 1);
            char ra2 = letras.charAt(posletra2);
            byte posletra3 = (byte) numletra.nextInt(letras.length() - 1);
            char ra3 = letras.charAt(posletra3);
            byte posletra4 = (byte) numletra.nextInt(letras.length() - 1);
            char ra4 = letras.charAt(posletra4);
            byte posletra5 = (byte) numletra.nextInt(letras.length() - 1);
            char ra5 = letras.charAt(posletra5);
            byte posletra6 = (byte) numletra.nextInt(letras.length() - 1);
            char ra6 = letras.charAt(posletra6);
            byte posletra7 = (byte) numletra.nextInt(letras.length() - 1);
            char ra7 = letras.charAt(posletra7);
            byte posletra8 = (byte) numletra.nextInt(letras.length() - 1);
            char ra8 = letras.charAt(posletra8);

            va = ra + "" + ra1 + ra2 + ra3 + ra4 + ra5 + ra6 + ra7 + ra8;

            String Con_encrip = "";
            
                Con_encrip = md5.getEncriptado(va);
            
//------------------------ENVIAR CORREO------------------------//

            Properties propiedad = new Properties();
            propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
            propiedad.setProperty("mail.smtp.starttls.enable", "true");
            propiedad.setProperty("mail.smtp.port", "587");
            propiedad.setProperty("mail.smtp.auth", "true");

            Session sesion = Session.getDefaultInstance(propiedad);

            String correoEnvia = "gimnasiogym04@gmail.com";
            String contrasena = "adsisenagym12345";
            String destinatario = rec.getCorreo();
            String asunto = "Recuperacion de contraseña";
            String mensaje = "La solicitud de cambio de contraseña a sido satisfactoria. \nTu nueva contraseña es: " + va;

            MimeMessage mail = new MimeMessage(sesion);

            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mail.setSubject(asunto);
            mail.setText(mensaje);

            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia, contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();

//-----------------------------------------------------------//

            String sql = "update usuario set contrasena = '" + Con_encrip + "' where correo = '" + rec.getCorreo() + "'";

            conn = con.conectar();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

            if (ps.executeUpdate() == 1) {

                return true;

            }

        } catch (Exception e) {
        }

        return false;
    }
}

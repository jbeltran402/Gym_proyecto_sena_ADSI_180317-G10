package ModeloDAO;

import Config.Conexion;
import Config.Encriptado;
import Interfaces.Interfaz;
import Modelo.Constructor_Sedes;
import Modelo.Constructor_Usuarios;
import Modelo.Constructor_factura;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Operaciones implements Interfaz {

    Encriptado md5 = new Encriptado();
    String contrasena = "";
    Conexion cn = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Constructor_Usuarios p = new Constructor_Usuarios();
    Constructor_Sedes sedes = new Constructor_Sedes();
    
    //_______________________________FECHAS__________________________________________//
        java.util.Date date = new java.util.Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        
            //_______________________VARIABLES___________________________________________//
        
            String hora = hourFormat.format(date);
            String fecha=formato.format(date);
            
           //_______________________VARIABLES PROXIMA FECHA_____________________________// 
            
            Calendar c1 = Calendar.getInstance();
            //SUMAR MES
            //c1.add(Calendar.MONTH, 6);            
           
           //_________________________________________________________________ 
            
            //codigo para llamar fecha modifiada
            //String fecha1 = formato.format(c1.getTime());

    public void operaciones() {

    }

//_____________________Operaciones de Super Administrador________________________________//    
    @Override
    public List buscar(int doc) {

        ArrayList<Constructor_Usuarios> list = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE estado = '1' and Roles_id_roles != 3 and doc_usuario = " + doc + " ORDER BY Roles_id_roles";
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Constructor_Usuarios per = new Constructor_Usuarios();
                per.setDoc(rs.getInt("doc_usuario"));
                per.setRol(rs.getInt("Roles_id_roles"));
                per.setTipo_doc(rs.getString("tipo_documeto"));
                per.setNomb_1(rs.getString("nombre_1"));
                per.setNomb_2(rs.getString("nombre_2"));
                per.setApel_1(rs.getString("apellido_1"));
                per.setApel_2(rs.getString("apellido_2"));
                per.setTel(rs.getInt("tel_cliente"));
                per.setCorreo(rs.getString("correo"));
                per.setEstado(rs.getInt("estado"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public List listar() {

        ArrayList<Constructor_Usuarios> list = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE estado = '1' and Roles_id_roles = 1 or Roles_id_roles = 2 ORDER BY Roles_id_roles";
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Constructor_Usuarios per = new Constructor_Usuarios();
                per.setDoc(rs.getInt("doc_usuario"));
                per.setRol(rs.getInt("Roles_id_roles"));
                per.setTipo_doc(rs.getString("tipo_documeto"));
                per.setNomb_1(rs.getString("nombre_1"));
                per.setNomb_2(rs.getString("nombre_2"));
                per.setApel_1(rs.getString("apellido_1"));
                per.setApel_2(rs.getString("apellido_2"));
                per.setTel(rs.getInt("tel_cliente"));
                per.setCorreo(rs.getString("correo"));
                per.setEstado(rs.getInt("estado"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Constructor_Usuarios list(int doc) {

        String sql = "SELECT * FROM usuario WHERE doc_usuario =" + doc;
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                p.setDoc(rs.getInt("doc_usuario"));
                p.setRol(rs.getInt("Roles_id_roles"));
                p.setTipo_doc(rs.getString("tipo_documeto"));
                p.setNomb_1(rs.getString("nombre_1"));
                p.setNomb_2(rs.getString("nombre_2"));
                p.setApel_1(rs.getString("apellido_1"));
                p.setApel_2(rs.getString("apellido_2"));
                p.setTel(rs.getInt("tel_cliente"));
                p.setCorreo(rs.getString("correo"));
                p.setEstado(rs.getInt("estado"));

            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Constructor_Usuarios per) {

        contrasena = md5.getEncriptado(String.valueOf(per.getDoc()));

        String sql = "INSERT INTO usuario VALUES ( " + per.getDoc() + ","
                + per.getRol() + ",'" + per.getTipo_doc() + "','" + per.getNomb_1()
                + "','" + per.getNomb_2() + "','" + per.getApel_1() + "','"
                + per.getApel_2() + "'," + per.getTel() + ",'" + per.getCorreo()
                + "','" + contrasena + "','1')";

        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean edit(Constructor_Usuarios per) {

        String sql = "";

        if (per.getCon().equals("si")) {

            contrasena = md5.getEncriptado(String.valueOf(per.getCambio_doc()));

            sql = "UPDATE usuario SET doc_usuario = " + per.getCambio_doc()
                    + ", Roles_id_roles = " + per.getRol() + ", tipo_documeto = '"
                    + per.getTipo_doc() + "', nombre_1 = '" + per.getNomb_1()
                    + "', nombre_2 = '" + per.getNomb_2() + "', apellido_1 = '"
                    + per.getApel_1() + "', apellido_2 = '" + per.getApel_2()
                    + "', tel_cliente = " + per.getTel() + ", correo = '" + per.getCorreo()
                    + "', contrasena = '" + contrasena + "', estado ='" + 1
                    + "' WHERE doc_usuario=" + per.getDoc();

        } else if (per.getCon().equals("no")) {

            sql = "UPDATE usuario SET doc_usuario = " + per.getCambio_doc()
                    + " , Roles_id_roles = " + per.getRol() + " , tipo_documeto = '"
                    + per.getTipo_doc() + "', nombre_1 = '" + per.getNomb_1()
                    + "' , nombre_2 = '" + per.getNomb_2() + "', apellido_1 = '"
                    + per.getApel_1() + "', apellido_2 = '" + per.getApel_2()
                    + "' , tel_cliente = " + per.getTel() + ", correo = '" + per.getCorreo()
                    + "' , estado = '1' WHERE doc_usuario=" + per.getDoc();

        }

        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

            contrasena = "";
            sql = "";
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int doc) {

        String sql = "UPDATE usuario SET estado = '0' WHERE doc_usuario = " + doc;
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return false;
    }

//__________________________Operaciones Administrador___________________________________//
    @Override
    public List listar_Admin() {

        ArrayList<Constructor_Usuarios> list = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE estado = '1' AND Roles_id_roles = 1 ORDER BY Roles_id_roles";
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Constructor_Usuarios per = new Constructor_Usuarios();
                per.setDoc(rs.getInt("doc_usuario"));
                per.setTipo_doc(rs.getString("tipo_documeto"));
                per.setNomb_1(rs.getString("nombre_1"));
                per.setNomb_2(rs.getString("nombre_2"));
                per.setApel_1(rs.getString("apellido_1"));
                per.setApel_2(rs.getString("apellido_2"));
                per.setTel(rs.getInt("tel_cliente"));
                per.setCorreo(rs.getString("correo"));
                per.setEstado(rs.getInt("estado"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public boolean add_admin(Constructor_Usuarios per) {

        contrasena = md5.getEncriptado(String.valueOf(per.getDoc()));

        String sql = "INSERT INTO usuario VALUES ( " + per.getDoc() + ",1,'"
                + per.getTipo_doc() + "','" + per.getNomb_1()
                + "','" + per.getNomb_2() + "','" + per.getApel_1() + "','"
                + per.getApel_2() + "'," + per.getTel() + ",'" + per.getCorreo()
                + "','" + contrasena + "','1')";

        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean edit_admin(Constructor_Usuarios per) {

        String sql = "";

        if (per.getCon().equals("si")) {

            contrasena = md5.getEncriptado(String.valueOf(per.getCambio_doc()));

            sql = "UPDATE usuario SET doc_usuario = " + per.getCambio_doc() + ", tipo_documeto = '"
                    + per.getTipo_doc() + "', nombre_1 = '" + per.getNomb_1()
                    + "', nombre_2 = '" + per.getNomb_2() + "', apellido_1 = '"
                    + per.getApel_1() + "', apellido_2 = '" + per.getApel_2()
                    + "', tel_cliente = " + per.getTel() + ", correo = '" + per.getCorreo()
                    + "', contrasena = '" + contrasena + "', estado ='" + 1
                    + "' WHERE doc_usuario=" + per.getDoc();

        } else if (per.getCon().equals("no")) {

            sql = "UPDATE usuario SET doc_usuario = " + per.getCambio_doc() + per.getRol() + " , tipo_documeto = '"
                    + per.getTipo_doc() + "', nombre_1 = '" + per.getNomb_1()
                    + "' , nombre_2 = '" + per.getNomb_2() + "', apellido_1 = '"
                    + per.getApel_1() + "', apellido_2 = '" + per.getApel_2()
                    + "' , tel_cliente = " + per.getTel() + ", correo = '" + per.getCorreo()
                    + "' , estado = '1' WHERE doc_usuario=" + per.getDoc();

        }
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

            contrasena = "";

        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar_admin(int doc) {

        String sql = "UPDATE usuario SET estado = '0' WHERE doc_usuario = " + doc;

        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return false;
    }

//__________________________Operaciones Administrador___________________________________//
    @Override
    public boolean edit_usu(Constructor_Usuarios per) {

        String sql = "";

        int Documento = per.getDoc();

        if (per.getCon().equals("si")) {

            contrasena = md5.getEncriptado(per.getContra());

            sql = "UPDATE usuario SET tipo_documeto = '"
                    + per.getTipo_doc() + "', nombre_1 = '" + per.getNomb_1()
                    + "', nombre_2 = '" + per.getNomb_2() + "', apellido_1 = '"
                    + per.getApel_1() + "', apellido_2 = '" + per.getApel_2()
                    + "', tel_cliente = " + per.getTel() + ", correo = '" + per.getCorreo()
                    + "', contrasena = '" + contrasena + "', estado ='" + 1
                    + "' WHERE doc_usuario=" + Documento;

        } else if (per.getCon().equals("no")) {

            sql = "UPDATE usuario SET tipo_documeto = '" + per.getTipo_doc() + "' , nombre_1 = '"
                    + per.getNomb_1() + "', nombre_2 = '" + per.getNomb_2()
                    + "', apellido_1 = '" + per.getApel_1() + "', apellido_2 = '"
                    + per.getApel_2() + "', tel_cliente = " + per.getTel()
                    + ", correo = '" + per.getCorreo() + "', estado ='" + 1
                    + "' WHERE doc_usuario=" + Documento;
        }

        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

            contrasena = "";

        } catch (SQLException e) {
        }
        return false;
    }
//__________________________Operaciones Sedes___________________________________//

    @Override
    public List sedes() {

        ArrayList<Constructor_Sedes> list = new ArrayList<>();
        String sql = "select id_sedes , nombre , direccion , nom_barrio , nom_localidad  from sedes , barrio , localidad  WHERE barrio_id_barrio = id_barrio and localidad_id_localidad = id_localidad AND estado = '1'";
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                Constructor_Sedes sedes = new Constructor_Sedes();

                sedes.setId(rs.getInt("id_sedes"));
                sedes.setNombre(rs.getString("nombre"));
                sedes.setDireccion(rs.getString("direccion"));
                sedes.setBarrio(rs.getString("nom_barrio"));
                sedes.setLocalidad(rs.getString("nom_localidad"));
                list.add(sedes);

            }
        } catch (SQLException e) {
        }
        return list;
    }
    

    @Override
    public Constructor_Sedes list_sedes(int id) {
        
        String sql = "select id_sedes , nombre , direccion , nom_barrio , "
                + "nom_localidad  from sedes , barrio , localidad  "
                + "where barrio_id_barrio = id_barrio and "
                + "localidad_id_localidad = id_localidad and id_sedes = "+ id +";";
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                sedes.setId(rs.getInt("id_sedes"));
                sedes.setNombre(rs.getString("nombre"));
                sedes.setDireccion(rs.getString("direccion"));
                sedes.setBarrio(rs.getString("nom_barrio"));
                sedes.setLocalidad(rs.getString("nom_localidad"));
            }
        } catch (SQLException e) {
            
        }
        return sedes;
        
    }
    
    @Override
    public boolean actualizar_sede(Constructor_Sedes sed) {
        
        String sql = "UPDATE sedes SET barrio_id_barrio = "+ sed.getCod_barrio() +" , nombre = '"+sed.getNombre()+"' , direccion = '"+ sed.getDireccion() +"' WHERE id_sedes = "+ sed.getId();
                
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
        return false;
    }
    
    @Override
    public boolean add_sede(Constructor_Sedes sed) {
        
        String sql = "INSERT INTO sedes VALUES ( default , " + sed.getCod_barrio() + " , '"
                + sed.getNombre() + "' , '" + sed.getDireccion() + "' , estado = '1' )";

        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return false;
    }
    
    @Override
    public boolean eliminar_sede(int id) {

        String sql = "UPDATE sedes SET estado = '0' WHERE  = id_sedes" + id;

        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return false;
    }

    
    
//__________________________Operaciones factura___________________________________//
    @Override
    public List listar_factura() {
        
        ArrayList<Constructor_factura> list = new ArrayList<>();
        String sql = "select f.id_factura, u.nombre_1, s.nombre, uu.nombre_1, "
                + "c.nom_combos, f.fecha_factura, f.hora_factura, f.forma_pago, "
                + "f.proxima_fecha_pago, f.meses_pagos, f.total_pago from factura "
                + "f inner join usuario u on f.usuario_doc_usuario=u.doc_usuario "
                + "inner join sedes s on f.sedes_id_sedes=s.id_sedes inner join "
                + "usuario uu on f.usuario_documento_vendedor=uu.doc_usuario "
                + "inner join paquetes p on f.paquetes_id_paquetes=p.id_paquetes  "
                + "inner join combos c on c.id_paquetes_de_servicios=p.combos_id_paquetes_de_servicios";
        try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Constructor_factura fac = new Constructor_factura();
                fac.setId(rs.getInt("f.id_factura"));
                fac.setNom_usuario(rs.getString("u.nombre_1"));
                fac.setNom_sede(rs.getString("s.nombre"));
                fac.setNom_vendedor(rs.getString("uu.nombre_1"));
                //fac.setDoc_vendedor(rs.getString("nombre_1"));
                fac.setCompra(rs.getString("c.nom_combos"));
                fac.setHorafactura(rs.getString("f.hora_factura"));
                fac.setFechafactura(rs.getString("f.fecha_factura"));
                fac.setFormapago(rs.getString("f.forma_pago"));
                fac.setProxpago(rs.getString("f.proxima_fecha_pago"));
                fac.setMespago(rs.getInt("f.meses_pagos"));
                fac.setTotal(rs.getInt("f.total_pago"));
                list.add(fac);
            }
        } catch (SQLException e) {
        } 
        return list;
    }

    @Override
    public boolean add_factura(Constructor_factura fac) {
    
                 String sql ="insert into factura values (default,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         try {
            conn = cn.conectar();
            ps = conn.prepareStatement(sql);
            
             
             ps.setInt(1, fac.getDoc_usuario());
             ps.setInt(2, fac.getSede());
             ps.setInt(3, fac.getDoc_vendedor());
             ps.setString(4, fac.getCompra());
             ps.setString(5, fac.getFechafactura());
             ps.setString(6, fac.getHorafactura());
             ps.setString(7, fac.getHorafactura());
             ps.setString(8, fac.getProxpago());
             ps.setInt(9, fac.getMespago());
             ps.setInt(10, fac.getTotal());
             
            rs = ps.executeQuery(); 
         } catch (SQLException e) { 
             
        }
         return false;
    }

}
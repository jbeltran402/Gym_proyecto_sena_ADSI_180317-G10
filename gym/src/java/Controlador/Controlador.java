package Controlador;

import Modelo.Constructor_Login;
import Modelo.Constructor_Sedes;
import Modelo.Constructor_Servicios;
import Modelo.Constructor_Usuarios;
import Modelo.Constructor_factura;
import Modelo.Constructor_recuperar;
import ModeloDAO.Operaciones;
import ModeloDAO.Operaciones_login;
import ModeloDAO.Operaciones_recuperar;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    //MODIFICAR RUTAS.........................
    String listar = "vistas/listar.jsp";
    String listar_admin = "vistas/listar_admin.jsp";
    String add = "vistas/add.jsp";
    String add_admin = "vistas/add_admin.jsp";
    String edit = "vistas/edit.jsp";
    String edit_admin = "vistas/edit_admin.jsp";
    String Login = "vistas/Login.jsp";
    String Recuperar = "vistas/Recuperar_contrasena.jsp";
    String Usuario = "usuario.jsp";
    String Buscar = "vistas/buscar.jsp";
    String Info_admin = "vistas/actualizar_datos.jsp";
    String sedes = "vistas/sedes.jsp";
    String add_sede = "vistas/add_sede.jsp";
    String edit_sede = "vistas/edit_sede.jsp";
    String listar_factura = "vistas/listar_facturas.jsp";
    String Agregar_Factura = "vistas/add_factura.jsp";
    
    String servicios = "vistas/servicios.jsp";
    String add_servicio = "vistas/add_servicio.jsp";
    String agregar_servicio = "vistas/agregar_servicio.jsp";
    String Editar_servicio = "vistas/editar_servicio.jsp";
    String add_promocion = "vistas/add_promocion.jsp";
    String edit_promocion = "vistas/edit_promocion.jsp";  
    String Listar_promociones = "vistas/listar_promociones.jsp";
    String Listar_servicios = "vistas/listar_servicios.jsp";
    
    //Unificar Constructores..................  
    Constructor_Usuarios p = new Constructor_Usuarios();
    Operaciones dao = new Operaciones();
    Constructor_Login log = new Constructor_Login();
    Operaciones_login oper_log = new Operaciones_login();
    Constructor_recuperar rec = new Constructor_recuperar();
    Operaciones_recuperar dao_rec = new Operaciones_recuperar();
    Constructor_factura fac = new Constructor_factura();
    Constructor_Sedes sed = new Constructor_Sedes();
    Constructor_Servicios ser = new Constructor_Servicios();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String acceso = "";
        String action = request.getParameter("accion");

        //___________________Operaciones planes y servicios__________________________________________//
        
        if (action.equalsIgnoreCase("servicios")) {

            acceso = servicios;
            
        } else if (action.equalsIgnoreCase("listar_promociones")) {
            
            acceso = Listar_promociones;
            
        } else if (action.equalsIgnoreCase("listar_servicios")) {
            
            acceso = Listar_servicios;
        
        } else if (action.equalsIgnoreCase("add_servicio")) {
            
            acceso = add_servicio;        
            
        } else if (action.equalsIgnoreCase("editar_promocion")) {
            
            request.setAttribute("id_promociones", request.getParameter("id"));
            acceso = edit_promocion;             
            
        } else if (action.equalsIgnoreCase("agregar_promocion")) {

           acceso = add_promocion;  
                
        } else if (action.equalsIgnoreCase("editar_servicio")) {
            
            request.setAttribute("idservicios", request.getParameter("id"));
            acceso = Editar_servicio;    
                            
        } else if (action.equalsIgnoreCase("agregar_servicio")) {

            acceso = agregar_servicio; 
        } else if (action.equalsIgnoreCase("eliminar_servicio")) {

            int id = Integer.parseInt(request.getParameter("id"));
            ser.setId_servicio(id);
            dao.eliminar_servicio(id);
            acceso = Listar_servicios;
            
        } else if (action.equalsIgnoreCase("eliminar_promocion")) {

            int id = Integer.parseInt(request.getParameter("id"));
            
            ser.setId_servicio(id);
            dao.eliminar_combo(id);
            acceso = Listar_promociones;    
        
        //___________________Operaciones Super Administrador____________________________//
        } else if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;

        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idper", request.getParameter("id"));
            acceso = edit;

        } else if (action.equalsIgnoreCase("eliminar")) {

            int id = Integer.parseInt(request.getParameter("id"));
            p.setDoc(id);
            dao.eliminar(id);
            acceso = listar;

        } else if (action.equalsIgnoreCase("actualizar_SuperAdmin")) {
            acceso = Info_admin;
            
        //___________________Operaciones Sedes___________________________________//  
        
        } else if (action.equalsIgnoreCase("sedes")) {

            acceso = sedes;
            
        } else if (action.equalsIgnoreCase("add_sede")) {

           acceso = add_sede;  
           
        } else if (action.equalsIgnoreCase("editar_sede")) {
            request.setAttribute("idsede", request.getParameter("id"));
            acceso = edit_sede; 
                
        } else if (action.equalsIgnoreCase("eliminar_sede")) {

            int id = Integer.parseInt(request.getParameter("id"));
            sed.setId(id);
            dao.eliminar_sede(id);
            acceso = sedes;    
            
        //___________________Operaciones factura_________________________________//    

        } else if (action.equalsIgnoreCase("add_factura")) {
            
            acceso = Agregar_Factura;
        
        } else if (action.equalsIgnoreCase("listar_factura")) {
            acceso = listar_factura;
            
        //___________________Operaciones Administrador___________________________//
        
        }else if (action.equalsIgnoreCase("listar_admin")) {
            acceso = listar_admin;

        } else if (action.equalsIgnoreCase("add_admin")) {
            acceso = add_admin;

        } else if (action.equalsIgnoreCase("editar_admin")) {
            request.setAttribute("idper", request.getParameter("id"));
            acceso = edit_admin;
        } else if (action.equalsIgnoreCase("eliminar_admin")) {

            int id = Integer.parseInt(request.getParameter("id"));
            p.setDoc(id);
            dao.eliminar_admin(id);
            acceso = listar_admin;

        } 
        //___________________Operaciones Administrador___________________________//
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acceso = "";
        String action = request.getParameter("accion");

//________________________Operaciones Super Administrador_________________________// 
        if (action.equalsIgnoreCase("Buscar")) {

            int Doc = Integer.parseInt(request.getParameter("buscar"));
            request.setAttribute("idper", request.getParameter("buscar"));
            p.setDoc(Doc);
            dao.buscar(Doc);
            acceso = Buscar;

        } else if (action.equalsIgnoreCase("Agregar")) {

            int Doc = Integer.parseInt(request.getParameter("txtDocumento"));
            int Rol = Integer.parseInt(request.getParameter("txtRol"));
            String Tipo_Doc = request.getParameter("txtTipo_doc");
            String Nomb_1 = request.getParameter("txtNom1");
            String Nomb_2 = request.getParameter("txtNom2");
            String Apel_1 = request.getParameter("txtApellido");
            String Apel_2 = request.getParameter("txtApe2");
            int Tel = Integer.parseInt(request.getParameter("txtTel"));
            String Correo = request.getParameter("txtCorreo");

            p.setDoc(Doc);
            p.setRol(Rol);
            p.setTipo_doc(Tipo_Doc);
            p.setNomb_1(Nomb_1);
            p.setNomb_2(Nomb_2);
            p.setApel_1(Apel_1);
            p.setApel_2(Apel_2);
            p.setTel(Tel);
            p.setCorreo(Correo);

            dao.add(p);

            acceso = listar;
        } else if (action.equalsIgnoreCase("Actualizar")) {

            int Doc = Integer.parseInt(request.getParameter("txtDocumento"));
            String Tipo_Doc = request.getParameter("txtTipo_doc");
            int Rol = Integer.parseInt(request.getParameter("txtRol"));
            String Nomb_1 = request.getParameter("txtNom1");
            String Nomb_2 = request.getParameter("txtNom2");
            String Apel_1 = request.getParameter("txtApellido");
            String Apel_2 = request.getParameter("txtApe2");
            int Tel = Integer.parseInt(request.getParameter("txtTel"));
            String Correo = request.getParameter("txtCorreo");

            String restablecer = "";

            if (request.getParameter("contra") != null) {
                restablecer = "si";
            } else {
                restablecer = "no";
            }

            int id = Integer.parseInt(request.getParameter("txtId"));

            p.setCambio_doc(Doc);
            p.setRol(Rol);
            p.setTipo_doc(Tipo_Doc);
            p.setNomb_1(Nomb_1);
            p.setNomb_2(Nomb_2);
            p.setApel_1(Apel_1);
            p.setApel_2(Apel_2);
            p.setTel(Tel);
            p.setCorreo(Correo);

            p.setCon(restablecer);

            p.setDoc(id);

            dao.edit(p);
            acceso = listar;

        } else if (action.equalsIgnoreCase("Ingresar") && action != null) {

            int nivel = 0;
            int Doc = Integer.parseInt(request.getParameter("txtusuario"));
            String con = request.getParameter("txtcontra");

            log.setUsuario(Doc);
            log.setContrasena(con);

            nivel = oper_log.validar(log);

            request.setAttribute("nivel", nivel);
            request.setAttribute("nombre", Doc);

            acceso = Login;
        }
//_______________________Operaciones Administrador______________________________//            

        if (action.equalsIgnoreCase("Agregar Usuario")) {

            int Doc = Integer.parseInt(request.getParameter("txtDocumento"));
            String Tipo_Doc = request.getParameter("txtTipo_doc");
            String Nomb_1 = request.getParameter("txtNom1");
            String Nomb_2 = request.getParameter("txtNom2");
            String Apel_1 = request.getParameter("txtApellido");
            String Apel_2 = request.getParameter("txtApe2");
            int Tel = Integer.parseInt(request.getParameter("txtTel"));
            String Correo = request.getParameter("txtCorreo");

            p.setDoc(Doc);
            p.setTipo_doc(Tipo_Doc);
            p.setNomb_1(Nomb_1);
            p.setNomb_2(Nomb_2);
            p.setApel_1(Apel_1);
            p.setApel_2(Apel_2);
            p.setTel(Tel);
            p.setCorreo(Correo);

            dao.add_admin(p);

            acceso = listar_admin;

        } else if (action.equalsIgnoreCase("Actualizar Usuario")) {

            int Doc = Integer.parseInt(request.getParameter("txtDocumento"));
            String Tipo_Doc = request.getParameter("txtTipo_doc");
            String Nomb_1 = request.getParameter("txtNom1");
            String Nomb_2 = request.getParameter("txtNom2");
            String Apel_1 = request.getParameter("txtApellido");
            String Apel_2 = request.getParameter("txtApe2");
            int Tel = Integer.parseInt(request.getParameter("txtTel"));
            String Correo = request.getParameter("txtCorreo");

            String restablecer = "";

            if (request.getParameter("contra") != null) {
                restablecer = "si";
            } else {
                restablecer = "no";
            }

            int id = Integer.parseInt(request.getParameter("txtId"));

            p.setCambio_doc(Doc);
            p.setTipo_doc(Tipo_Doc);
            p.setNomb_1(Nomb_1);
            p.setNomb_2(Nomb_2);
            p.setApel_1(Apel_1);
            p.setApel_2(Apel_2);
            p.setTel(Tel);
            p.setCorreo(Correo);

            p.setCon(restablecer);

            p.setDoc(id);

            dao.edit_admin(p);
            acceso = listar_admin;

        } 
        
//.............................. Actualizar Datos ....................................//     
        
        else if (action.equalsIgnoreCase("Actualizar Datos")) {

            int Doc = Integer.parseInt(request.getParameter("Id"));
            String Tipo_Doc = request.getParameter("txtTipo_doc");
            String Nomb_1 = request.getParameter("txtNom1");
            String Nomb_2 = request.getParameter("txtNom2");
            String Apel_1 = request.getParameter("txtApellido");
            String Apel_2 = request.getParameter("txtApe2");
            int Tel = Integer.parseInt(request.getParameter("txtTel"));
            String Correo = request.getParameter("txtCorreo");
            String Contra = request.getParameter("txtContra");

            String con;

            if (!"".equals(Contra)) {
                con = "si";
            } else {
                con = "no";
            }

            p.setCon(con);
            p.setTipo_doc(Tipo_Doc);
            p.setNomb_1(Nomb_1);
            p.setNomb_2(Nomb_2);
            p.setApel_1(Apel_1);
            p.setApel_2(Apel_2);
            p.setTel(Tel);
            p.setCorreo(Correo);
            p.setContra(Contra);

            p.setDoc(Doc);

            dao.edit_usu(p);

            if (request.getParameter("tipo").equals("1")) {
                acceso = Info_admin;
            } else if (request.getParameter("tipo").equals("2")) {
                //--pendiente acceso = Info_admin;
            } else {
                acceso = Usuario;
            }
            
//________________________Agregar sedes________________________________________//            
            
            } else if (action.equalsIgnoreCase("Agregar Sede")) {

            String nombre = request.getParameter("nombre");
            String direccion = request.getParameter("Direccion");
            int barrio  = Integer.parseInt(request.getParameter("barrio"));

            sed.setNombre(nombre);
            sed.setDireccion(direccion);
            sed.setCod_barrio(barrio);

            dao.add_sede(sed);

            acceso = sedes;      
            
            } else if (action.equalsIgnoreCase("Editar Sede")) {

            String nombre = request.getParameter("nombre");
            String direccion = request.getParameter("Direccion");
            int barrio  = Integer.parseInt(request.getParameter("barrio"));
            int Id  = Integer.parseInt(request.getParameter("Id"));

            sed.setNombre(nombre);
            sed.setDireccion(direccion);
            sed.setCod_barrio(barrio);
            sed.setId(Id);

            dao.actualizar_sede(sed);

            acceso = sedes;            
            

//----------------- Agregar factura---------------------------------------//
            
            }else if (action.equalsIgnoreCase("Agregar factura")) {
                
                int usuario = Integer.parseInt(request.getParameter("docuusu")); 
                int sede = Integer.parseInt(request.getParameter("idsede")); 
                int vendedor =Integer.parseInt(request.getParameter("docuvend"));
                
                int combo = Integer.parseInt(request.getParameter("txtPromociones"));
                int servicio = Integer.parseInt(request.getParameter("txtServicio"));
                
                String formapago= request.getParameter("formapago");
                int mespago = Integer.parseInt(request.getParameter("mespago"));   

                fac.setDoc_usuario(usuario);
                fac.setSede(sede);
                fac.setDoc_vendedor(vendedor);
                fac.setCombo(combo);
                fac.setServicio(servicio);
                fac.setFormapago(formapago);
                fac.setMespago(mespago);
                //fac.setTotal(total);

                dao.add_factura(fac);
                acceso = listar_factura; 
    
    //----------------- OPERACIONES SERVICIOS ---------------------------------------//               
                 
                }else if (action.equalsIgnoreCase("Agregar Servicio")) {

                String servicio = request.getParameter("txtnombre"); 
                int precio_servicio = Integer.parseInt(request.getParameter("txtprecio")); 
                String descripcion_servicio = request.getParameter("txtdescripcion");
                
                    ser.setServicios(servicio);
                    ser.setPrecio_servicio(precio_servicio);
                    ser.setDescripcion(descripcion_servicio);
                    
                    dao.add_servicio(ser);
                    acceso = Listar_servicios;
                
                }else if (action.equalsIgnoreCase("Agregar Campo")) {

                String promocion = request.getParameter("txtnombre"); 
                int precio_promocion = Integer.parseInt(request.getParameter("txtprecio")); 
                
                    ser.setNombre_combo(promocion);
                    ser.setPrecio_combo(precio_promocion);
                    
                    dao.add_combo(ser);
                    acceso = Listar_promociones;
                    
                 
                }else if (action.equalsIgnoreCase("Editar Servicio")) {
                
                int id = Integer.parseInt(request.getParameter("id"));     
                String servicio = request.getParameter("txtnombre"); 
                int precio_servicio = Integer.parseInt(request.getParameter("txtprecio")); 
                String descripcion_servicio = request.getParameter("txtdescripcion");
                
                    ser.setId_servicio(id);
                    ser.setServicios(servicio);
                    ser.setPrecio_servicio(precio_servicio);
                    ser.setDescripcion(descripcion_servicio);
                    
                    dao.edit_servicio(ser);
                    acceso = Listar_servicios;  
                    
                }else if (action.equalsIgnoreCase("Editar Promocion")) {
                
                int id = Integer.parseInt(request.getParameter("id"));     
                String combo = request.getParameter("txtnombre"); 
                int precio_combo = Integer.parseInt(request.getParameter("txtprecio")); 
                
                    ser.setId_combo(id);
                    ser.setNombre_combo(combo);
                    ser.setPrecio_combo(precio_combo);
                    
                    dao.edit_promocion(ser);
                    acceso = Listar_promociones; 
  
                }else if (action.equalsIgnoreCase("Agregar Paquete")) {

                int id_combo = Integer.parseInt(request.getParameter("txtPromociones"));
                int id_servicio = Integer.parseInt(request.getParameter("txtServicio")); 
                
                    ser.setId_combo(id_combo);
                    ser.setId_servicio(id_servicio);
                    
                    dao.add_paquete(ser);
                    acceso = servicios;
                                
                            
                    
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

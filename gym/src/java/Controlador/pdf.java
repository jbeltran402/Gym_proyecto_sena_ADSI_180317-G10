package Controlador;

import Config.Conexion;
import Config.Encriptado;
import Modelo.Constructor_Sedes;
import Modelo.Constructor_Usuarios;
import Modelo.Constructor_factura;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "pdf", urlPatterns = {"/pdf"})
public class pdf extends HttpServlet {


    Conexion cn = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    
        response.setContentType("application/pdf");

        int id = Integer.parseInt(request.getParameter("id"));
        
        try (OutputStream out = response.getOutputStream()) {

                try {
                    
                    String sql = "select f.id_factura, u.doc_usuario ,u.nombre_1, s.id_sedes ,s.nombre, uu.doc_usuario ,uu.nombre_1, c.id_paquetes_de_servicios ,c.nom_combos, f.fecha_factura, f.hora_factura, f.forma_pago,f.proxima_fecha_pago, f.meses_pagos, f.total_pago from factura f inner join usuario u on f.usuario_doc_usuario=u.doc_usuario inner join sedes s on f.sedes_id_sedes=s.id_sedes inner join usuario uu on f.usuario_documento_vendedor=uu.doc_usuario inner join paquetes p on f.paquetes_id_paquetes=p.id_paquetes inner join combos c on c.id_paquetes_de_servicios=p.combos_id_paquetes_de_servicios where id_factura="+ id;
                    conn = cn.conectar();
                    ps = conn.prepareStatement(sql);
                    rs = ps.executeQuery();
                    
                    if (conn != null) {
                        
                        try {
                            
                            Document documento = new Document();
                            PdfWriter.getInstance(documento, out);

                            documento.open();
                            LineSeparator separador = new LineSeparator();

                            Paragraph par1 = new Paragraph();
                            Font fonttitulo = new Font(Font.FontFamily.HELVETICA,16,Font.BOLDITALIC,BaseColor.BLACK);
                            par1.add(new Phrase("FACTURA \n",fonttitulo));
                            par1.setAlignment(Element.ALIGN_LEFT);
                            par1.add(new Phrase(Chunk.NEWLINE));
                            documento.add(par1);

                            documento.add(separador);
                            Paragraph salto = new Paragraph();
                            Font fontsalto= new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLUE);
                            salto.add(new Phrase("\n",fontsalto));              
                            documento.add(salto);

                                while (rs.next()) {
                                    documento.add(new Paragraph("Factura Nº: "+rs.getString(1)+"\n"));
                                    documento.add(new Paragraph("Documento Del Usuario: "+rs.getString(2)+"\n"));
                                    documento.add(new Paragraph("Nombre Del Usuario: "+rs.getString(3)+"\n"));
                                    documento.add(new Paragraph("Sede Nº: "+rs.getString(4)+"\n"));
                                    documento.add(new Paragraph("Nombre de la Sede: "+rs.getString(5)+"\n"));
                                    documento.add(new Paragraph("Documento Del Vendedor: "+rs.getString(6)+"\n"));
                                    documento.add(new Paragraph("Nombre Del Vendedor: "+rs.getString(7)+"\n"));
                                    documento.add(new Paragraph("Compra Nº: "+rs.getString(8)+"\n"));
                                    documento.add(new Paragraph("Servicio: "+rs.getString(9)+"\n"));
                                    documento.add(new Paragraph("Fecha De Facturacion: "+rs.getString(10)+"\n"));
                                    documento.add(new Paragraph("Hora De Facturacion: "+rs.getString(11)+"\n"));
                                    documento.add(new Paragraph("Forma De Pago: "+rs.getString(12)+"\n"));
                                    documento.add(new Paragraph("Proxima Fecha De Pago: "+rs.getString(13)+"\n"));
                                    documento.add(new Paragraph("Meses Pagos: "+rs.getString(14)+"\n"));
                                    documento.add(new Paragraph("Total: "+rs.getString(15)+"\n"));
                                    }

                            documento.close();

                        } catch (DocumentException ex) {
                            ex.getMessage();
                        }
                    }
                    
                } catch (SQLException e) {
                    e.getMessage();
                }                          
            
        }
        
    }   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

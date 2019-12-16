package Controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        try {
            
            try {
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from factura;");
                
                if (con!=null) {
                    try {
                        
                        Document documento = new Document();
                        PdfWriter.getInstance(documento, out);
                        documento.open();

                        Paragraph par1 = new Paragraph();
                        Font fonttitulo = new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLACK);
                        par1.add(new Phrase("Factura \n",fonttitulo));
                        par1.setAlignment(Element.ALIGN_LEFT);
                        par1.add(new Phrase(Chunk.NEWLINE));
                        documento.add(par1);
                        
                      /*  PdfPTable tabla = new PdfPTable(9);
                        PdfPCell celda1= new PdfPCell(new Paragraph("id", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.RED))); 
                        PdfPCell celda2= new PdfPCell(new Paragraph("docu usu", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.RED))); 
                        PdfPCell celda3= new PdfPCell(new Paragraph("sede", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.RED))); 
                        PdfPCell celda4= new PdfPCell(new Paragraph("doc vendedor", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.RED))); 
                        PdfPCell celda5= new PdfPCell(new Paragraph("compra id", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.RED))); 
                        PdfPCell celda6= new PdfPCell(new Paragraph("fecha fact", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.RED))); 
                        PdfPCell celda7= new PdfPCell(new Paragraph("hora fac", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.RED))); 
                        PdfPCell celda8= new PdfPCell(new Paragraph("forma pago", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.RED))); 
                        PdfPCell celda9= new PdfPCell(new Paragraph("prox pago", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.RED))); 
                        PdfPCell celda10= new PdfPCell(new Paragraph("mes pago", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.RED))); 
                        PdfPCell celda11= new PdfPCell(new Paragraph("total", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.RED))); 
                        tabla.addCell(celda1);
                        tabla.addCell(celda2);
                        tabla.addCell(celda3); 
                        tabla.addCell(celda4);
                        tabla.addCell(celda5); 
                        tabla.addCell(celda6); 
                        tabla.addCell(celda7); 
                        tabla.addCell(celda8); 
                        tabla.addCell(celda9); 
                        tabla.addCell(celda10); 
                        tabla.addCell(celda11); 
                        while (rs.next()) {                            
                            tabla.addCell(rs.getString(1)); 
                            tabla.addCell(rs.getString(2)); 
                            tabla.addCell(rs.getString(3)); 
                            tabla.addCell(rs.getString(4)); 
                            tabla.addCell(rs.getString(5)); 
                            tabla.addCell(rs.getString(6)); 
                            tabla.addCell(rs.getString(7)); 
                            tabla.addCell(rs.getString(8)); 
                            tabla.addCell(rs.getString(9)); 
                            tabla.addCell(rs.getString(10)); 
                            tabla.addCell(rs.getString(11)); 
                        }
                        documento.add(tabla);*/

                        documento.close();
                        
                    } catch (DocumentException e) { e.getMessage(); } 
                }
                
            } catch (ClassNotFoundException | SQLException e) { e.getMessage(); }
            
            
        } finally { out.close(); }
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

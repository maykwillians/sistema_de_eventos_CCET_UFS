/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author mayk-
 */
@WebServlet(name = "ServletTestUpload", urlPatterns = {"/ServletTestUpload"})
public class ServletTestUploadMod extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (ServletFileUpload.isMultipartContent(request)) {
            
            try {
                List<FileItem> multParts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                for (FileItem item : multParts) {
                    if (item.isFormField()) {
                        
                        System.out.println(item.getString());
//                        item.write(new File(request.getServletContext().getRealPath("img/teste") + File.separator + "imagem.png"));
                    } else {
                        
                        System.out.println(item.getContentType());
                        
                    }
                }
            } catch (Exception ex) {
            }
        } else {
        }
        
        response.sendRedirect("testes.jsp");
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Colaborador;
import business_rules.EventoRules;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author mayk-
 */
@WebServlet(name = "ServletUploadImagem", urlPatterns = {"/ServletUploadImagem"})
public class ServletUploadImagem extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Colaborador colaborador = (Colaborador) session.getAttribute("user");
        EventoRules eventoRules = new EventoRules();
        int qtdEvt = eventoRules.listByIdColaborador(colaborador.getId()).size();
        
        System.out.println("1");
        
        if (ServletFileUpload.isMultipartContent(request)) {
            System.out.println("2");
            try {
                List<FileItem> multParts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                
                for (FileItem item : multParts) {
                    
                    if (!item.isFormField()) {
                        
                        if (!item.getContentType().equals("image/png") && !item.getContentType().equals("image/jpeg")) {
                            
                            session.setAttribute("message", "0");
                        } else {
                            
                            item.write(new File(request.getServletContext().getRealPath("img/folders_eventos") + File.separator + colaborador.getId() + "_" + qtdEvt + ".png"));
                            session.setAttribute("message", "1");
                        }
                    }
                }
            } catch (Exception ex) {
                session.setAttribute("message", "2");
            }
        } else {
            session.setAttribute("message", "3");
        }
        
        response.sendRedirect("index.jsp");
    }
}
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
import java.util.ArrayList;
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
@WebServlet(name = "AddEvento", urlPatterns = {"/AddEvento"})
public class ServletAddEvento extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Para saber se o usuário adicionou uma imagem ao evento
        boolean imagem = false;

        HttpSession session = request.getSession();

        Colaborador colaborador = (Colaborador) session.getAttribute("user");

        EventoRules eventoRules = new EventoRules();

        int qtdEvt = eventoRules.listByIdColaborador(colaborador.getId()).size();

        List<String> listString = new ArrayList();

        String urlImg = "img/folders_eventos/" + colaborador.getId() + "_" + qtdEvt + ".png";

        if (ServletFileUpload.isMultipartContent(request)) {

            try {
                List<FileItem> multParts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                for (FileItem item : multParts) {

                    if (item.isFormField()) { // Se for apenas campo de texto

                        if (session.getAttribute("user") != null) {

                            listString.add(item.getString());
                        }
                    } else {  // Se for um campo file

                        if (item.getContentType().equals("image/jpeg") || item.getContentType().equals("image/png")) {
                            
                            imagem = true;
                            item.write(new File(request.getServletContext().getRealPath("img/folders_eventos/") + colaborador.getId() + "_" + qtdEvt + ".png"));
                        }
                    }
                }
                
                if (imagem) {
                    
                    eventoRules.addEvento(listString.get(0), listString.get(1), listString.get(2), listString.get(3), listString.get(4), listString.get(5), colaborador.getNome(), colaborador.getEmail(), listString.get(6), listString.get(7), colaborador.getDpt(), colaborador.getNomeDpt(), listString.get(8), urlImg, colaborador.getId(), "");
                } else { // Se o usuário não add nenhuma imagem, pega uma dessas imagens por default
                    
                    int tipo = Integer.parseInt(listString.get(1).substring(0, listString.get(1).indexOf(" ")));
                    
                    String urlImgDefault = "";
                    
                    switch (tipo) {
                        case 1:
                            urlImgDefault = "img/img_eventos/1.png";
                            break;
                        case 2:
                            urlImgDefault = "img/img_eventos/2.png";
                            break;
                        case 3:
                            urlImgDefault = "img/img_eventos/3.png";
                            break;
                        case 4:
                            urlImgDefault = "img/img_eventos/4.png";
                            break;
                        case 5:
                            urlImgDefault = "img/img_eventos/5.png";
                            break;
                        case 6:
                            urlImgDefault = "img/img_eventos/6.png";
                            break;
                        case 7:
                            urlImgDefault = "img/img_eventos/7.png";
                            break;
                        case 8:
                            urlImgDefault = "img/img_eventos/8.png";
                            break;
                        case 9:
                            urlImgDefault = "img/img_eventos/9.png";
                            break;
                        case 10:
                            urlImgDefault = "img/img_eventos/10.png";
                            break;
                    }
                    
                    eventoRules.addEvento(listString.get(0), listString.get(1), listString.get(2), listString.get(3), listString.get(4), listString.get(5), colaborador.getNome(), colaborador.getEmail(), listString.get(6), listString.get(7), colaborador.getDpt(), colaborador.getNomeDpt(), listString.get(8), urlImgDefault, colaborador.getId(), "");
                }
                
            } catch (Exception ex) {
            }
        } else {
        }

        response.sendRedirect("index.jsp");
    }
}
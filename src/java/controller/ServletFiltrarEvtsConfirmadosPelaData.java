/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Evento;
import business_rules.EventoRules;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mayk-
 */
@WebServlet(name = "ServletFiltrarEvtsConfirmadosPelaData", urlPatterns = {"/ServletFiltrarEvtsConfirmadosPelaData"})
public class ServletFiltrarEvtsConfirmadosPelaData extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        EventoRules eventoRules = new EventoRules();
        
        String data = request.getParameter("inpDataEvento");
        
        List<Evento> listEvtsConfirmsIminentes = eventoRules.listByData(1, data); // Lista todos os eventos confirmados desta data
        List<Evento> listEvtsConfirmsAnteriores = eventoRules.listByData(-1, data); // Lista todos os eventos confirmados desta data
        
        List<Evento> listEvtsConfirms = new ArrayList();
        
        for (int i = 0; i < listEvtsConfirmsIminentes.size(); i++) {
            
            listEvtsConfirms.add(listEvtsConfirmsIminentes.get(i));
        }
        for (int i = 0; i < listEvtsConfirmsAnteriores.size(); i++) {
            
            listEvtsConfirms.add(listEvtsConfirmsAnteriores.get(i));
        }
        
        session.removeAttribute("listEvtsConfirm");
        session.setAttribute("listEvtsConfirm", listEvtsConfirms);
        
        response.sendRedirect("list_eventos.jsp");
    }
}
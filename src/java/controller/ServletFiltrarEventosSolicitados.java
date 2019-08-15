/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Evento;
import business_rules.EventoRules;
import java.io.IOException;
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
@WebServlet(name = "ServletFiltrarEventosDpt", urlPatterns = {"/ServletFiltrarEventosDpt"})
public class ServletFiltrarEventosSolicitados extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        EventoRules eventoRules = new EventoRules();
        
        List<Evento> listEvtsSolicit;
        
        String numDptStr = request.getParameter("dpt");
        
        int numDptInt = Integer.parseInt(numDptStr);
        
        if (numDptInt == 0) {
            
            listEvtsSolicit = eventoRules.listByStatus(0); // Lista todos os eventos solicitados
        } else {
            
            listEvtsSolicit = eventoRules.listByStatusAndDpt(0, numDptInt); // Lista todos os eventos solicitados deste dpt
        }
        
        session.removeAttribute("listEvtsSolicit");
        session.setAttribute("listEvtsSolicit", listEvtsSolicit);
        
        response.sendRedirect("controle_eventos.jsp");
    }
}
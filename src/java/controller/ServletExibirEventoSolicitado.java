/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Evento;
import business_rules.EventoRules;
import java.io.IOException;
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
@WebServlet(name = "ServletGetValidarEvento", urlPatterns = {"/ServletGetValidarEvento"})
public class ServletExibirEventoSolicitado extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        EventoRules eventoRules = new EventoRules();
        
        String idStr = request.getParameter("idValidar");
        int id = Integer.parseInt(idStr);
        Evento evento = eventoRules.getOneForID(id);
        
        session.removeAttribute("evtParaValidar");
        session.setAttribute("evtParaValidar", evento);
        
        response.sendRedirect("validar_evento.jsp");
    }
}
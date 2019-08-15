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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author mayk-
 */
@WebServlet(name = "ServletValidarEvento", urlPatterns = {"/ServletValidarEvento"})
public class ServletValidarEvento extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        EventoRules eventoRules = new EventoRules();

        if (request.getParameter("aprovar") != null) {

            int id = Integer.parseInt(request.getParameter("aprovar"));
            
            try {
                eventoRules.updateStatus(1, id);
            } catch (EmailException ex) {
                Logger.getLogger(ServletValidarEvento.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Remove o atributo da sessão para não ficar um evento que
            // já foi aprovado na sessão
            session.removeAttribute("evtParaValidar");
            
            List<Evento> listaEvtDpt = eventoRules.listByStatus(0);
            
            // Coloca alista atualizada na sessão
            session.removeAttribute("listEvtsSolicit");
            session.setAttribute("listEvtsSolicit", listaEvtDpt);

            response.sendRedirect("controle_eventos.jsp");
        }

        if (request.getParameter("reprovar") != null) {

            int id = Integer.parseInt(request.getParameter("reprovar"));
            
            try {
                eventoRules.updateStatus(2, id);
            } catch (EmailException ex) {
                Logger.getLogger(ServletValidarEvento.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Remove o atributo da sessão para não ficar um evento que
            // já foi reprovado na sessão
            session.removeAttribute("evtParaValidar");
            
            List<Evento> listaEvtDpt = eventoRules.listByStatus(0);
            
            // Coloca alista atualizada na sessão
            session.removeAttribute("listEvtsSolicit");
            session.setAttribute("listEvtsSolicit", listaEvtDpt);

            response.sendRedirect("controle_eventos.jsp");
        }
    }
}
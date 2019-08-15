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
@WebServlet(name = "ServletUpdateStatusEvt", urlPatterns = {"/ServletUpdateStatusEvt"})
public class ServletUpdateStatusEvt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        EventoRules eventoRules = new EventoRules();
        
        // Aqui está atualizando para o caso do evento for cancelado
        // Mas a ideia é para atualizar para todos os casos
        int id = Integer.parseInt(request.getParameter("idEvtUpdateStatus"));
        eventoRules.updateStatus2(3, id);
        
        // Atualiza o objeto "Lista de Eventos Confirmados" na sessão
        List<Evento> listaEvtDpt = eventoRules.listByStatus(1); // Lista todos os eventos confirmados
        session.removeAttribute("listEvtsConfirm");
        session.setAttribute("listEvtsConfirm", listaEvtDpt);
        
        response.sendRedirect("list_eventos.jsp");
    }
}
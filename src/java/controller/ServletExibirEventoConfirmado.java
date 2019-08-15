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
@WebServlet(name = "ServletTratarExibirEvento", urlPatterns = {"/ServletTratarExibirEvento"})
public class ServletExibirEventoConfirmado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        EventoRules eventoRules = new EventoRules();
        
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        Evento evento = eventoRules.getOneForID(id);
        
        int acessosAux = evento.getAcessos();
        int acessos = acessosAux + 1;

        evento.setAcessos(acessos);
        eventoRules.updateAcessos(acessos, id);
        
        session.removeAttribute("evtConfirm");
        session.setAttribute("evtConfirm", evento);
        
        // Atualiza o objeto "Lista de Eventos Confirmados" na sessão
        // para atualizar algum atributo do evento quando ele for visualizado pelo
        // usuário, como o número de acessos
        List<Evento> listaEvtDpt = eventoRules.listByStatus(1); // Lista todos os eventos confirmados
        session.removeAttribute("listEvtsConfirm");
        session.setAttribute("listEvtsConfirm", listaEvtDpt);
        
        response.sendRedirect("evento.jsp");
    }
}
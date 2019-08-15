/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Evento;
import business_rules.EventoRules;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletFiltrarEvtsSolicitadosPeloTipoEvt", urlPatterns = {"/ServletFiltrarEvtsSolicitadosPeloTipoEvt"})
public class ServletFiltrarEvtsSolicitadosPeloTipoEvt extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        EventoRules eventoRules = new EventoRules();

        int tipo = Integer.parseInt(request.getParameter("tipoEvtSolict"));

        List<Evento> listEvtsConfirms = eventoRules.listByTipo(0, tipo); // Lista todos os eventos solicitados deste tipo

        session.removeAttribute("listEvtsSolicit");
        session.setAttribute("listEvtsSolicit", listEvtsConfirms);

        response.sendRedirect("controle_eventos.jsp");
    }
}

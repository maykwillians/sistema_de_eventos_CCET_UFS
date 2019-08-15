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
@WebServlet(name = "ServletFiltrarEvtsConfirmadosPeloTipoEvt", urlPatterns = {"/ServletFiltrarEvtsConfirmadosPeloTipoEvt"})
public class ServletFiltrarEvtsConfirmadosPeloTipoEvt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        EventoRules eventoRules = new EventoRules();

        int tipo = Integer.parseInt(request.getParameter("tipoEvtConfirm"));

        List<Evento> listEvtsConfirms = eventoRules.listByTipo(1, tipo); // Lista todos os eventos confirmados deste tipo

        session.removeAttribute("listEvtsConfirm");
        session.setAttribute("listEvtsConfirm", listEvtsConfirms);

        response.sendRedirect("list_eventos.jsp");
    }
}
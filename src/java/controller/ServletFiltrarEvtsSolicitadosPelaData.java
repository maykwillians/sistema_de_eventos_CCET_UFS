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
@WebServlet(name = "ServletFiltrarEvtsSolicitadosPelaData", urlPatterns = {"/ServletFiltrarEvtsSolicitadosPelaData"})
public class ServletFiltrarEvtsSolicitadosPelaData extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        EventoRules eventoRules = new EventoRules();

        String data = request.getParameter("inpDataEvento");

        List<Evento> listEvtsSolicit = eventoRules.listByData(0, data); // Lista todos os eventos solicitados desta data

        session.removeAttribute("listEvtsSolicit");
        session.setAttribute("listEvtsSolicit", listEvtsSolicit);

        response.sendRedirect("controle_eventos.jsp");
    }
}
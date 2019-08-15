/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Colaborador;
import business_rules.ColaboradorRules;
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
@WebServlet(name = "ServletDeleteColaborador", urlPatterns = {"/ServletDeleteColaborador"})
public class ServletDeleteColaborador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        int id = Integer.parseInt(request.getParameter("colaborador"));
        
        ColaboradorRules colaboradorRules = new ColaboradorRules();
        colaboradorRules.deleteOne(id);
        
        List<Colaborador> listColaboradores = colaboradorRules.listAll();
        
        session.removeAttribute("listColaboradores");
        session.setAttribute("listColaboradores", listColaboradores);
       
        response.sendRedirect("list_colaborador.jsp");
    }
}
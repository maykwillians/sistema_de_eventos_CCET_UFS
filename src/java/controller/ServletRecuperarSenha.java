/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.ADM;
import Model.Colaborador;
import business_rules.ADMRules;
import business_rules.ColaboradorRules;
import java.io.IOException;
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
@WebServlet(name = "ServletRecuperarSenha", urlPatterns = {"/ServletRecuperarSenha"})

public class ServletRecuperarSenha extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String email = request.getParameter("email");
        
        ADMRules admRules = new ADMRules();
        ADM adm = admRules.getOneForEmail(email);
        
        if (adm != null) {
            
            new Thread() {
                @Override
                public void run() {
                    try {
                        admRules.emailRecuperarSenha(adm);
                    } catch (EmailException ex) {
                        Logger.getLogger(ServletRecuperarSenha.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
            
            session = request.getSession();
            
            session.removeAttribute("msg");
            session.setAttribute("msg", "sim");
            
            response.sendRedirect("recuperar_senha.jsp");
            
            return;
        }
        
        ColaboradorRules colaboradorRules = new ColaboradorRules();
        Colaborador colaborador = colaboradorRules.getOneForEmail(email);
        
        if (colaborador != null) {
            
            new Thread() {
                @Override
                public void run() {
                    try {
                        colaboradorRules.emailRecuperarSenha(colaborador);
                    } catch (EmailException ex) {
                        Logger.getLogger(ServletRecuperarSenha.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
            
            session = request.getSession();
            
            session.removeAttribute("msg");
            session.setAttribute("msg", "sim");
            
            response.sendRedirect("recuperar_senha.jsp");
            
            return;
        }
        
        session.removeAttribute("msg");
        session.setAttribute("msg", "nao");

        response.sendRedirect("recuperar_senha.jsp");
    }
}
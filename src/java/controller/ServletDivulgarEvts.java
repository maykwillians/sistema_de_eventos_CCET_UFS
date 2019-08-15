/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business_rules.ADMRules;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author mayk-
 */
@WebServlet(name = "ServletDivulgarEvts", urlPatterns = {"/ServletDivulgarEvts"})
public class ServletDivulgarEvts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        new Thread() {
            @Override
            public void run() {
                try {
                    new ADMRules().emailDivulgacao();
                } catch (EmailException ex) {
                    Logger.getLogger(ServletDivulgarEvts.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();

        response.sendRedirect("index.jsp");
    }
}
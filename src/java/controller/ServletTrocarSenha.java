/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.ADM;
import Model.Colaborador;
import Model.Usuario;
import business_rules.ADMRules;
import business_rules.ColaboradorRules;
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
@WebServlet(name = "ServletTrocarSenha", urlPatterns = {"/ServletTrocarSenha"})
public class ServletTrocarSenha extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Usuario usuario = (Usuario) session.getAttribute("user");

        String senhaAtual = request.getParameter("senhaAtual");
        String senhaNova = request.getParameter("senhaNova");

        // Só troca a senha se alguém estiver logado
        if (session.getAttribute("user") != null) {

            // No caso de ser o ADM logado
            if (usuario.getTipoUsuario() == 0) {

                ADM admAux = (ADM) session.getAttribute("user");
                ADMRules admRules = new ADMRules();
                ADM adm = admRules.getOneForEmail(admAux.getEmail());

                if (adm.getSenha().equals(senhaAtual)) {

                    if (senhaNova.contains(" ") || senhaNova.length() < 6 || senhaNova.length() > 10) {

                        session.removeAttribute("msgTrocarSenha");
                        session.setAttribute("msgTrocarSenha", "senhaInvalida");
                        response.sendRedirect("trocar_senha.jsp");
                        return;
                    }

                    if (senhaAtual.equals(senhaNova)) {

                        session.removeAttribute("msgTrocarSenha");
                        session.setAttribute("msgTrocarSenha", "senhasIguais");
                        response.sendRedirect("trocar_senha.jsp");
                        return;
                    }

                    admRules.alterarSenha(adm, senhaNova);
                    session.removeAttribute("msgTrocarSenha");
                    session.setAttribute("msgTrocarSenha", "ok");
                    response.sendRedirect("trocar_senha.jsp");
                } else {

                    session.removeAttribute("msgTrocarSenha");
                    session.setAttribute("msgTrocarSenha", "nao");
                    response.sendRedirect("trocar_senha.jsp");
                }
            }

            // No caso de ser um colaborador logado
            if (usuario.getTipoUsuario() == 1) {

                Colaborador colaboradorAux = (Colaborador) session.getAttribute("user");
                ColaboradorRules colaboradorRules = new ColaboradorRules();
                Colaborador colaborador = colaboradorRules.getOneForEmail(colaboradorAux.getEmail());

                if (colaborador.getSenha().equals(senhaAtual)) {

                    if (senhaNova.contains(" ") || senhaNova.length() < 6 || senhaNova.length() > 10) {

                        session.removeAttribute("msgTrocarSenha");
                        session.setAttribute("msgTrocarSenha", "senhaInvalida");
                        response.sendRedirect("trocar_senha.jsp");
                        return;
                    }

                    if (senhaAtual.equals(senhaNova)) {

                        session.removeAttribute("msgTrocarSenha");
                        session.setAttribute("msgTrocarSenha", "senhasIguais");
                        response.sendRedirect("trocar_senha.jsp");
                        return;
                    }

                    colaboradorRules.alterarSenha(colaborador, senhaNova);
                    session.removeAttribute("msgTrocarSenha");
                    session.setAttribute("msgTrocarSenha", "ok");
                    response.sendRedirect("trocar_senha.jsp");
                } else {

                    session.removeAttribute("msgTrocarSenha");
                    session.setAttribute("msgTrocarSenha", "nao");
                    response.sendRedirect("trocar_senha.jsp");
                }
            }
        }
    }
}
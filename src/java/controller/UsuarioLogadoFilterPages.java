/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mayk-
 */
@WebFilter(urlPatterns = {"/trocar_senha.jsp"})
public class UsuarioLogadoFilterPages implements Filter {

    // Executa alguma coisa quando a aplicação é INICIADA
    @Override
    public void init(FilterConfig fc) throws ServletException {

    }

    // Intercepta todas as REQUISIÇÕES
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        Usuario usuario = (Usuario) session.getAttribute("user");

        if (usuario == null) {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        } else {

            chain.doFilter(request, response);
        }

    }

    // Executa alguma coisa quando a aplicação é DERRUBADA
    @Override
    public void destroy() {

    }
}
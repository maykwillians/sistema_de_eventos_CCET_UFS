/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.LoginDAO;
import Model.ADM;
import Model.Colaborador;
import Model.Usuario;
import business_rules.ADMRules;
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
@WebServlet(name = "ServletAutentication", urlPatterns = {"/ServletAutentication"})
public class ServletAutenticationLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        // ADMs por default
        ADM adm0 = new ADM();
        adm0.setTipoUsuario(0);
        adm0.setNome("MAYK_ADM");
        adm0.setEmail("mayk-menezes@hotmail.com");
        adm0.setSenha("123456");
        adm0.setObs("");
        
        ADM adm1 = new ADM();
        adm1.setTipoUsuario(0);
        adm1.setNome("Diretor_CCET");
        adm1.setEmail("direcao.ccet@ufs.br");
        adm1.setSenha("123456");
        adm1.setObs("");
        
        ADM adm2 = new ADM();
        adm2.setTipoUsuario(0);
        adm2.setNome("Vice_Diretor_CCET");
        adm2.setEmail("edwdavid@gmail.com");
        adm2.setSenha("123456");
        adm2.setObs("");
        
        ADM adm3 = new ADM();
        adm3.setTipoUsuario(0);
        adm3.setNome("Secretaria_CCET");
        adm3.setEmail("secretaria.ccet@ufs.br");
        adm3.setSenha("123456");
        adm3.setObs("");

        ADM adm4 = new ADM();
        adm4.setTipoUsuario(0);
        adm4.setNome("Prof_Roberto_CCET");
        adm4.setEmail("rrsouza@ufs.br");
        adm4.setSenha("123456");
        adm4.setObs("");
        
        // Para verificar se é o primeiro acesso de uma ADM no sistema
        ADMRules admRules = new ADMRules();
        ADM admAux = admRules.getOneForEmail(email);
        
        // Se não existir no BD (no caso de ser o primeiro acesso)
        if (admAux == null) {
            
            if (email.equals(adm0.getEmail()) && senha.equals(adm0.getSenha())) {
                
                admRules.addADM(adm0.getTipoUsuario(), adm0.getNome(), adm0.getEmail(), adm0.getSenha(), adm0.getObs());
                
                session.removeAttribute("user"); // Retira qualquer usuário que estiver na Sessão
                session.setAttribute("user", adm0); // Coloca o usuário adm na Sessão
                response.sendRedirect("index.jsp");
                
                return;
            }
            
            if (email.equals(adm1.getEmail()) && senha.equals(adm1.getSenha())) {
                
                admRules.addADM(adm1.getTipoUsuario(), adm1.getNome(), adm1.getEmail(), adm1.getSenha(), adm1.getObs());
                
                session.removeAttribute("user"); // Retira qualquer usuário que estiver na Sessão
                session.setAttribute("user", adm1); // Coloca o usuário adm na Sessão
                response.sendRedirect("index.jsp");
                
                return;
            }
            
            if (email.equals(adm2.getEmail()) && senha.equals(adm2.getSenha())) {
                
                admRules.addADM(adm2.getTipoUsuario(), adm2.getNome(), adm2.getEmail(), adm2.getSenha(), adm2.getObs());
                
                session.removeAttribute("user"); // Retira qualquer usuário que estiver na Sessão
                session.setAttribute("user", adm2); // Coloca o usuário adm na Sessão
                response.sendRedirect("index.jsp");
                
                return;
            }
            
            if (email.equals(adm3.getEmail()) && senha.equals(adm3.getSenha())) {
                
                admRules.addADM(adm3.getTipoUsuario(), adm3.getNome(), adm3.getEmail(), adm3.getSenha(), adm3.getObs());
                
                session.removeAttribute("user"); // Retira qualquer usuário que estiver na Sessão
                session.setAttribute("user", adm3); // Coloca o usuário adm na Sessão
                response.sendRedirect("index.jsp");
                
                return;
            }
            
            if (email.equals(adm4.getEmail()) && senha.equals(adm4.getSenha())) {
                
                admRules.addADM(adm4.getTipoUsuario(), adm4.getNome(), adm4.getEmail(), adm4.getSenha(), adm4.getObs());
                
                session.removeAttribute("user"); // Retira qualquer usuário que estiver na Sessão
                session.setAttribute("user", adm4); // Coloca o usuário adm na Sessão
                response.sendRedirect("index.jsp");
                
                return;
            }
        }
        
        Usuario usuario = new LoginDAO().getUsuarioForLogin(email, senha);

        if (usuario != null) {

            Object object = usuario;

            if (usuario.getTipoUsuario() == 0) {

                ADM adm = (ADM) object;

                session.removeAttribute("user"); // Retira qualquer usuário que estiver na Sessão
                session.setAttribute("user", adm); // Coloca o usuário adm na Sessão
                response.sendRedirect("index.jsp");
                
                return;
            }

            if (usuario.getTipoUsuario() == 1) {

                Colaborador colaborador = (Colaborador) object;
                
                session.removeAttribute("user"); // Retira qualquer usuário que estiver na Sessão
                session.setAttribute("user", colaborador); // Coloca o usuário colaborador na Sessão
                response.sendRedirect("index.jsp");
                
                return;
            }

            return;
        }
        response.sendRedirect("login.jsp");
    }
}
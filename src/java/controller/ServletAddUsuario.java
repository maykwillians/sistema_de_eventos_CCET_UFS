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
@WebServlet(name = "ServletAddUsuario", urlPatterns = {"/ServletAddUsuario"})
public class ServletAddUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String nome = request.getParameter("inpNomeUser");
        
        String tipoStr = request.getParameter("opTipoUser");
        int tipo = Integer.parseInt(tipoStr.substring(0, tipoStr.indexOf(" "))) - 1;
        
        String dptStr = request.getParameter("opDptUser");
        int dpt = Integer.parseInt(dptStr.substring(0, dptStr.indexOf(" ")));
        
        String nomeDpt = "";
        switch (dpt) {
            case 1:
                nomeDpt = "DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS";
                break;
            case 2:
                nomeDpt = "DEPARTAMENTO DE COMPUTAÇÃO";
                break;
            case 3:
                nomeDpt = "DEPARTAMENTO DE ENGENHARIA AMBIENTAL";
                break;
            case 4:
                nomeDpt = "DEPARTAMENTO DE ENGENHARIA CIVIL";
                break;
            case 5:
                nomeDpt = "DEPARTAMENTO DE ENGENHARIA DE PRODUÇÃO";
                break;
            case 6:
                nomeDpt = "DEPARTAMENTO DE ENGENHARIA ELÉTRICA";
                break;
            case 7:
                nomeDpt = "DEPARTAMENTO DE ENGENHARIA MECÂNICA";
                break;
            case 8:
                nomeDpt = "DEPARTAMENTO DE ENGENHARIA QUÍMICA";
                break;
            case 9:
                nomeDpt = "DEPARTAMENTO DE ESTATÍSTICA E CIÊNCIAS ATUARIAIS";
                break;
            case 10:
                nomeDpt = "DEPARTAMENTO DE FÍSICA";
                break;
            case 11:
                nomeDpt = "DEPARTAMENTO DE GEOLOGIA";
                break;
            case 12:
                nomeDpt = "DEPARTAMENTO DE MATEMÁTICA";
                break;
            case 13:
                nomeDpt = "DEPARTAMENTO DE QUÍMICA";
                break;
            case 14:
                nomeDpt = "DEPARTAMENTO DE TECNOLOGIA DE ALIMENTOS";
                break;
            case 15:
                nomeDpt = "NÚCLEO DE ENGENHARIA DE PETRÓLEO";
                break;
            case 16:
                nomeDpt = "DIREÇÃO DO CCET";
                break;
         }
        
        String email = request.getParameter("inpEmailUser");
        
        ColaboradorRules colaboradorRules = new ColaboradorRules();
        Colaborador colaborador = colaboradorRules.getOneForEmail(email);
        
        ADMRules admRules = new ADMRules();
        ADM adm = admRules.getOneForEmail(email);
        
        // Para não poder cadastrar um colaborador que é um ADM cadastrado no código
        String emailAdm0 = "mayk-menezes@hotmail.com";
        String emailAdm1 = "edwdavid@gmail.com";
        String emailAdm2 = "secretaria.ccet@ufs.br";
        String emailAdm3 = "direcao.ccet@ufs.br";
        String emailAdm4 = "rrsouza@ufs.br";
        
        if (colaborador != null || adm != null || email.equals(emailAdm0) || email.equals(emailAdm1) || email.equals(emailAdm2) || email.equals(emailAdm3) || email.equals(emailAdm4)) {
            
            session.removeAttribute("msgErroEmailUser");
            session.setAttribute("msgErroEmailUser", "0");
            
            response.sendRedirect("add_colaborador.jsp");
        } else {
        
            colaboradorRules.addColaborador(1, tipo, nome, dpt, nomeDpt, email, senha(), "");

            session.removeAttribute("msgErroEmailUser");
            session.setAttribute("msgErroEmailUser", "1");

            response.sendRedirect("add_colaborador.jsp");
        }
    }
    
    public String senha() {
        
        String[] carct = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String senha = "";

        for (int x = 0; x < 6; x++) {
            
            int j = (int) (Math.random() * carct.length);
            senha += carct[j];
        }
        
        return senha;
    }
}
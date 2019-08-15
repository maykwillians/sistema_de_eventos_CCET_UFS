/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Evento;
import business_rules.EventoRules;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ServletFiltrarEvtsConfirmadosPorPalavra", urlPatterns = {"/ServletFiltrarEvtsConfirmadosPorPalavra"})
public class ServletFiltrarEvtsConfirmadosPorPalavra extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        EventoRules eventoRules = new EventoRules();
        
        String pesquisa = request.getParameter("inpPalavra");
        
        List<Evento> listEvtsConfirmsIminentes = eventoRules.listByStatus(1); // Lista todos o eventos iminentes
//        List<Evento> listEvtsConfirmsAnteriores = eventoRules.listByStatus(-1); // Lista todos o eventos anteriores
        
        List<Evento> listEvtsConfirms = new ArrayList();
        
        for (int i = 0; i < listEvtsConfirmsIminentes.size(); i++) {
            
            listEvtsConfirms.add(listEvtsConfirmsIminentes.get(i));
        }
//        for (int i = 0; i < listEvtsConfirmsAnteriores.size(); i++) {
//            
//            listEvtsConfirms.add(listEvtsConfirmsAnteriores.get(i));
//        }
        
        // Lógica para exibir por default a lista de eventos ordenada pela data
        Comparator<Evento> order = new Comparator<Evento>() {

            public int compare(Evento obj1, Evento obj2) {

                String a = obj1.getData();
                String b = obj2.getData();

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                Date data1 = null;
                try {
                    data1 = new Date(format.parse(a).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ServletFiltrarEvtsConfirmadosPorPalavra.class.getName()).log(Level.SEVERE, null, ex);
                }
                Date data2 = null;
                try {
                    data2 = new Date(format.parse(b).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ServletFiltrarEvtsConfirmadosPorPalavra.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (data1.after(data2)) {

                    return 1;
                } else {

                    if (data1.before(data2)) {

                        return -1;
                    }
                }

                return 0;
            }
        };
        
        List<Evento> listEvtsPesquisa = new ArrayList();
        
        // Aplica o filtro pela palavra chave da pesquisa
        for (int i = 0; i < listEvtsConfirms.size(); i++) {
            
            if (procuraPalavra(listEvtsConfirms.get(i).getNome(), pesquisa)) {
                
                listEvtsPesquisa.add(listEvtsConfirms.get(i));
            }
        }
        
        // Ordena pela data
        Collections.sort(listEvtsConfirms, order);
        
        session.removeAttribute("listEvtsConfirm");
        session.setAttribute("listEvtsConfirm", listEvtsPesquisa);
        
        response.sendRedirect("list_eventos.jsp");
    }
    
    public boolean procuraPalavra (String textoAux, String palavraAux) {
        
        String texto = textoAux.toLowerCase();
        String pesquisa = palavraAux.toLowerCase();
        
        if (texto.contains(pesquisa)) {
        
            if (pesquisa.length() == texto.length()) {

                return true;
            } else {

                int ocorrencia = texto.indexOf(pesquisa);

                if ((ocorrencia == 0)) {

                    if (texto.substring(pesquisa.length(), pesquisa.length() + 1).equals(" ")) {
                        
                        return true;
                    }
                } else {

                    int parte = ocorrencia + pesquisa.length();
                    
                    if (parte == texto.length()) {
                        
                        if (texto.substring(ocorrencia - 1, ocorrencia).equals(" ")) {

                            return true;
                        }
                    } else {
                        
                        if ((texto.substring(ocorrencia - 1, ocorrencia).equals(" ")) && (texto.substring(ocorrencia + pesquisa.length(), (ocorrencia + pesquisa.length()) + 1).equals(" "))) {

                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
}
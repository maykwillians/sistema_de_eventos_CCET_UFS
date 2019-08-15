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
import java.util.Calendar;
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
@WebServlet(name = "ServletFiltrarEventosDptConfirmados", urlPatterns = {"/ServletFiltrarEventosDptConfirmados"})
public class ServletFiltrarEventosConfirmados extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        EventoRules eventoRules = new EventoRules();
        
        List<Evento> listEvtsConfirms = eventoRules.listByStatus(1); // Lista todos os eventos confirmados

        String numDptStr = request.getParameter("dptConfirm");

        int opcaoFiltro = Integer.parseInt(numDptStr);
        
        // Lógica para atualizar o status para os eventos anteriores
        for (Evento evento : listEvtsConfirms) {

            if (eventoPassou(evento.getData())) {

                eventoRules.updateStatus2(-1, evento.getId());
            }
        }
        
        listEvtsConfirms = eventoRules.listByStatus(1); // Lista todos os eventos confirmados

        if (opcaoFiltro == -1000000) { // Para exibir apenas os eventos anteriores
            
            listEvtsConfirms = eventoRules.listByStatus(-1); // Lista todos os eventos anteriores
        } else {
            
            if (opcaoFiltro == 0) { // Para exibir todos os eventos confirmados

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
                            Logger.getLogger(ServletFiltrarEventosConfirmados.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Date data2 = null;
                        try {
                            data2 = new Date(format.parse(b).getTime());
                        } catch (ParseException ex) {
                            Logger.getLogger(ServletFiltrarEventosConfirmados.class.getName()).log(Level.SEVERE, null, ex);
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
                Collections.sort(listEvtsConfirms, order); // pronto agora sua lista esta ordenada
            } else {

                if (opcaoFiltro == 1000000) { // Para ordenar os eventos pelo número de acessos

                    // Faz a ordenação pelo número de acessos
                    Collections.sort(listEvtsConfirms);
                } else {  // Para exibir apenas os eventos deste dpt

                    listEvtsConfirms = eventoRules.listByStatusAndDpt(1, opcaoFiltro); // Lista todos os eventos confirmados deste dpt
                }
            }
        }

        session.removeAttribute("listEvtsConfirm");
        session.setAttribute("listEvtsConfirm", listEvtsConfirms);

        response.sendRedirect("list_eventos.jsp");
    }
    
    public boolean eventoPassou(String dataAux) {
        
        String data = dataAux;
        
        Calendar dataHojeAux = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataHoje = sdf.format(dataHojeAux.getTime());
        String hoje = dataHoje;

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Date dataDoEvt = null;
        try {
            dataDoEvt = new Date(format.parse(data).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(ServletFiltrarEventosConfirmados.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date dataDeHoje = null;
        try {
            dataDeHoje = new Date(format.parse(hoje).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(ServletFiltrarEventosConfirmados.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (dataDoEvt.after(dataDeHoje)) {

            return false;
        } else {

            if (dataDoEvt.before(dataDeHoje)) {

                return true;
            }
        }

        return false;
    }
}
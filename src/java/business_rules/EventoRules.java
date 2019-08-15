/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_rules;

import DAO.EventoDAO;
import Model.Evento;
import Model.MyEmail;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author mayk-
 */
public class EventoRules {

    private final Evento evento = new Evento();
    private final EventoDAO eventoDAO = new EventoDAO();

    public void addEvento(String nome, String tipoAux, String dataAux, String horaInicioAux, String duracaoAux, String local, String nomeCriador, String emailCriador, String nomeResponsavel, String emailResponsavel, int tipoDpt, String nomeDpt, String resusmo, String urlImg, int idColaborador, String obs) {

        // Tratamento do tipo do evento
        int tipo = Integer.parseInt(tipoAux.substring(0, tipoAux.indexOf(" ")));

        // Tratamento da data do evento
        String dia = dataAux.substring(8, 10);
        String mes = dataAux.substring(5, 7);
        String ano = dataAux.substring(0, 4);
        String data = dia + "/" + mes + "/" + ano;
        
        // Tratamento da hora de início
        int inicioHorasEmMinutos = Integer.parseInt(horaInicioAux.substring(0, 2)) * 60;
        int inicioMinutos = Integer.parseInt(horaInicioAux.substring(3, horaInicioAux.length()));
        int horaInicio = inicioHorasEmMinutos + inicioMinutos;
        
        // Tratamento da duração
        int duracaoHorasEmMinutos = Integer.parseInt(duracaoAux.substring(0, 2)) * 60;
        int duracaoMinutos = Integer.parseInt(duracaoAux.substring(3, duracaoAux.length()));
        int duracao = duracaoHorasEmMinutos + duracaoMinutos;

        this.evento.setStatus(0);  // Adiciona como status 0 (Solicitado) por default
        this.evento.setNome(nome);
        this.evento.setTipo(tipo);
        this.evento.setData(data);
        this.evento.setHoraInicio(horaInicio);
        this.evento.setDuracao(duracao);
        this.evento.setLocal(local);
        this.evento.setNomeCriador(nomeCriador);
        this.evento.setEmailCriador(emailCriador);
        this.evento.setNomeResponsavel(nomeResponsavel);
        this.evento.setEmailResponsavel(emailResponsavel);
        this.evento.setTipoDpt(tipoDpt);
        this.evento.setNomeDpt(nomeDpt);
        this.evento.setResusmo(resusmo);
        this.evento.setUrlImg(urlImg);
        this.evento.setIdColaborador(idColaborador);
        this.evento.setAcessos(0); // Incialmente o evento não tem nenhum acesso
        this.evento.setObs(obs);

        this.eventoDAO.addEvento(this.evento);
    }

    public void updateStatus(int resp, int id) throws EmailException {

        if (resp == 1) {
            
            this.eventoDAO.updateStatus(resp, id);
            
            new Thread() {
                @Override
                public void run() {
                    try {
                        emailEventoAprovado(getOneForID(id));
                    } catch (EmailException ex) {
                        Logger.getLogger(EventoRules.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
        if (resp == 2) {
            
            this.eventoDAO.updateStatus(resp, id);
            
            new Thread() {
                @Override
                public void run() {
                    try {
                        emailEventoReprovado(getOneForID(id));
                    } catch (EmailException ex) {
                        Logger.getLogger(EventoRules.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
    
    public void updateStatus2(int status, int id) {

        this.eventoDAO.updateStatus(status, id);
    }
    
    public void updateAcessos(int acessos, int id) {

        this.eventoDAO.updateAcessos(acessos, id);
    }

//    public void enviarEmailEventoConfirmado(int id) throws EmailException {
//
//        List<Colaborador> listaColaboradores = new ColaboradorRules().listAll();
//        List<Visitante> listaVisitantes = new VisitanteRules().listAll();
//        
//        List<String> emails = new ArrayList<String>();
//        
//        for (int i = 0; i < listaColaboradores.size(); i++) {
//            
//            emails.add(listaColaboradores.get(i).getEmail());
//        }
//        
//        for (int i = 0; i < listaVisitantes.size(); i++) {
//            
//            emails.add(listaVisitantes.get(i).getEmail());
//        }
//    }

    public void emailConfirmacaoSeguranca(Evento evento) {

    }

    public void emailEventoReprovado(Evento evento) throws EmailException {

        emailRespostaSolicitacao("CCET - UFS: Sua solicitação de evento foi REPROVADA", evento);
    }
    
    public void emailEventoAprovado(Evento evento) throws EmailException {

        emailRespostaSolicitacao("CCET - UFS: Sua solicitação de evento foi APROVADA", evento);
    }
    
    public void emailRespostaSolicitacao(String resposta, Evento evento) throws EmailException {
        
        String tipoEvento = "";
        switch (evento.getTipo()) {
            case 1:
                tipoEvento = "Palestra";
                break;
            case 2:
                tipoEvento = "Seminário";
                break;
            case 3:
                tipoEvento = "Congresso";
                break;
            case 4:
                tipoEvento = "Simpósio";
                break;
            case 5:
                tipoEvento = "Minicurso";
                break;
            case 6:
                tipoEvento = "Apresentação de Projeto ou Estágio";
                break;
            case 7:
                tipoEvento = "Apresentação de TCC";
                break;
            case 8:
                tipoEvento = "Defesa de Mestrado";
                break;
            case 9:
                tipoEvento = "Defesa de Doutorado";
                break;
            case 10:
                tipoEvento = "Outro";
                break;
        }
        
        String aux = calculaTempo(evento.getDuracao());
        String duracao = aux.substring(0, 2) + "h" + aux.substring(3, aux.length()) + "m";
        
        String htmlText = "<div class=\"media-body\">\n"
                + "                        <h3><b>" + resposta + "</b></h3>\n"
                + "                        <br>\n"
                + "                        <h3 class=\"media-heading\"><b>Evento: " + evento.getNome() + "</b></h3>\n"
                + "                        <b>Tipo do Evento: </b> " + tipoEvento + "\n"
                + "                        <br>\n"
                + "                        <b>Data do Evento: </b> " + evento.getData() + "\n"
                + "                        <br>\n"
                + "                        <b>Horário de início do Evento: </b> " + calculaTempo(evento.getHoraInicio()) +  "hs\n"
                + "                        <br>\n"
                + "                        <b>Duração: </b> " + duracao + "\n"
                + "                        <br>\n"
                + "                        <b>Local do Evento: </b> " + evento.getLocal() + "\n"
                + "                        <br>\n"
                + "                        <b>Organizador(a) do Evento: </b> " + evento.getNomeResponsavel() + "\n"
                + "                        <br>\n"
                + "                        <b>Resumo do Evento: </b> " + evento.getResusmo() + "\n"
                + "                        <br>\n"
                + "                        <br>\n"
                + "                        <b>Agradeço pela compreensão e qualquer dúvida e/ou esclarecimento entre em contato.</b>\n"
                + "                        <br>\n"
                + "                        <b>Direção do CCET: secretaria.ccet@ufs.br / direcao.ccet@ufs.br</b>\n"
                + "                        <br>\n"
                + "                    </div>";

        MyEmail myEmail = new MyEmail();
        myEmail.setRemetente("cceteventosufs@gmail.com");
        myEmail.setSenha("cceteventos");
        myEmail.setDestinatario(evento.getEmailCriador());
        myEmail.setTitulo(resposta);
        myEmail.setConteudo(htmlText);

        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
        email.addTo(myEmail.getDestinatario()); //destinatário
        email.setFrom(myEmail.getRemetente()); // remetente
        email.setSubject(myEmail.getTitulo()); // assunto do e-mail
        email.setHtmlMsg(myEmail.getConteudo()); //conteudo do e-mail
        email.setAuthentication(myEmail.getRemetente(), myEmail.getSenha()); // Autenticação
        email.setSmtpPort(465);
        email.setSSL(true);
        email.setTLS(true);
        email.send();
    }
    
    public String calculaTempo(int minutos) {
        
        int a = minutos % 60;
        int b = minutos / 60;
        
        String x = a + "";
        String y = b + "";
        
        String k = x;
        String l = y;
        
        if (x.length() == 1) {
            
            k = "0" + x;
        }
        
        if (y.length() == 1) {
            
            l = "0" + y;
        }
        
        return l + ":" + k;
    }

    public void printEvento(Evento evento) {

        String status = "";
        switch (evento.getStatus()) {
            case 0:
                status = "Solicitado";
                break;
            case 1:
                status = "Aprovado";
                break;
            case 2:
                status = "Em execução";
                break;
            case 3:
                status = "Cancelado";
                break;
            case 4:
                status = "Adiado";
                break;
            case 5:
                status = "Encerrado";
                break;
            case 6:
                status = "Indeferido";
                break;
        }

        String tipo = "";
        switch (evento.getTipo()) {
            case 1:
                tipo = "Palestra";
                break;
            case 2:
                tipo = "Seminário";
                break;
            case 3:
                tipo = "Congresso";
                break;
            case 4:
                tipo = "Simpósio";
                break;
            case 5:
                tipo = "Minicurso";
                break;
            case 6:
                tipo = "Apresentação de Projeto ou Estágio";
                break;
            case 7:
                tipo = "Apresentação de TCC";
                break;
            case 8:
                tipo = "Defesa de Mestrado";
                break;
            case 9:
                tipo = "Defesa de Doutorado";
                break;
            case 10:
                tipo = "Outro";
                break;
        }

        System.out.println("Status do evento: " + status);
        System.out.println("Nome do evento: " + evento.getNome());
        System.out.println("Tipo do evento: " + tipo);
        System.out.println("Data do evento: " + evento.getData());
        System.out.println("Horario de início do evento: " + evento.getHoraInicio());
        System.out.println("Horario de fim do evento: " + evento.getDuracao());
        System.out.println("Local do evento: " + evento.getLocal());
        System.out.println("Nome do criador do evento: " + evento.getNomeCriador());
        System.out.println("E-mail do criador do evento: " + evento.getEmailCriador());
        System.out.println("Nome do responsável pelo evento: " + evento.getNomeResponsavel());
        System.out.println("E-mail do responsável pelo evento: " + evento.getEmailResponsavel());
        System.out.println("Tipo do Dpt: " + evento.getTipoDpt());
        System.out.println("Nome do Dpt: " + evento.getNomeDpt());
        System.out.println("Resumo do evento: " + evento.getResusmo());
        System.out.println("Url Img: " + evento.getUrlImg());
        System.out.println("ID Colaborador: " + evento.getIdColaborador());
        System.out.println("Acessos: " + evento.getAcessos());
        System.out.println("Obs: " + evento.getObs());
    }

    public Evento getOneForID(int id) {

        return this.eventoDAO.getOneForID(id);
    }

    public List<Evento> listAll() {

        return this.eventoDAO.listAll();
    }
    
    public List<Evento> listByStatus(int status) {

        return this.eventoDAO.listByStatus(status);
    }
    
    public List<Evento> listByStatusAndDpt(int status, int dpt) {

        return this.eventoDAO.listByStatusAndDpt(status, dpt);
    }
    
    public List<Evento> listByColaborador(String emailColaborador) {

        return this.eventoDAO.listByColaborador(emailColaborador);
    }
    
    public List<Evento> listByIdColaborador(int id) {

        return this.eventoDAO.listByIdColaborador(id);
    }
    
    public List<Evento> listByDpt(int dpt) {

        return this.eventoDAO.listByDpt(dpt);
    }
    
    public List<Evento> listByData(int status, String dataAux) {

        // Tratamento da data do evento
        String dia = dataAux.substring(8, 10);
        String mes = dataAux.substring(5, 7);
        String ano = dataAux.substring(0, 4);
        String data = dia + "/" + mes + "/" + ano;
        
        return this.eventoDAO.listByData(status, data);
    }
    
    public List<Evento> listByTipo(int status, int tipo) {

        return this.eventoDAO.listByTipo(status, tipo);
    }
}